package com.example.easyadmission.Institute;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easyadmission.Institute.Database.Basic_information_database_institute;
import com.example.easyadmission.MainActivity;
import com.example.easyadmission.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class Basic_information extends AppCompatActivity {

    EditText name_upload,email_upload,About_upload;
    Button upload_logo,submit;
    private FirebaseDatabase firebasedatabase;
    private DatabaseReference databaseReference;
    FirebaseStorage storage;
    StorageReference storageReference;
    private Uri filePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_information);

        name_upload = findViewById(R.id.institute_name);
        email_upload = findViewById(R.id.institute_email);
        About_upload = findViewById(R.id.About_Institute_upload);

        upload_logo = findViewById(R.id.upload_logo);
        submit = findViewById(R.id.institute_basic_information_btn);




        storage = FirebaseStorage.getInstance();
        firebasedatabase = FirebaseDatabase.getInstance();
        databaseReference = firebasedatabase.getReference("Institute");
        storageReference = storage.getReference();


        upload_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,33);
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createDatabase();
                startActivity(new Intent(Basic_information.this, Institute_menu.class));
            }
        });


    }

    private void createDatabase() {
        String institutename = name_upload.getText().toString();
        String email = email_upload.getText().toString();
        String About = About_upload.getText().toString();


        if(institutename.isEmpty() || email.isEmpty() || About.isEmpty())
        {
            Toast.makeText(Basic_information.this,"Fill the data" ,Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(filePath!=null)
            {
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Uploading....");



                StorageReference ref = storageReference.child(institutename);
                ref.putFile(filePath)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                progressDialog.dismiss();
                                ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                            @Override
                                            public void onSuccess(Uri uri) {
                                                databaseReference.child(institutename).child("imgurl").setValue(uri.toString());
                                            }
                                        });
                                    }
                                });
                                Toast.makeText(Basic_information.this, "Uploaded", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.dismiss();
                                Toast.makeText(Basic_information.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                                double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                        .getTotalByteCount());
                                progressDialog.setMessage("Uploaded "+(int)progress+"%");
                            }
                        });

            }
            else {
                Toast.makeText(Basic_information.this, "Error ", Toast.LENGTH_SHORT).show();
            }




            Basic_information_database_institute input = new Basic_information_database_institute(institutename,email,About);
            databaseReference.child(institutename).setValue(input).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(Basic_information.this,"Data Added" ,Toast.LENGTH_SHORT).show();
                }
            });
        }

    }




    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }




}