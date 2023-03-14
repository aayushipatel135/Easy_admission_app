package com.example.easyadmission.Institute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easyadmission.Institute.Database.Faculty_details_institute_database;
import com.example.easyadmission.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Faculty_details_institute extends AppCompatActivity {

    EditText name,email,qualification,institute_name,experience,id;
    Button submit;
    private FirebaseDatabase firebasedatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details_institute);

        name = findViewById(R.id.institute_faculty_name_upload);
        email = findViewById(R.id.institute_faculty_email_upload);
        qualification = findViewById(R.id.qualification_faculty_Institute_upload);
        submit = findViewById(R.id.institute_faculty_details_btn);
        institute_name = findViewById(R.id.institute_name_upload_faculty);
        experience = findViewById(R.id.experience_year_upload_faculty);
        id = findViewById(R.id.id);


        firebasedatabase = FirebaseDatabase.getInstance();
        databaseReference = firebasedatabase.getReference("Institute");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createDatabase();
                startActivity(new Intent(Faculty_details_institute.this, Update_faculty_list_institute.class));
            }
        });

    }


    private void createDatabase() {
        String fname = name.getText().toString();
        String femail = email.getText().toString();
        String fqualification = qualification.getText().toString();
        String institutename = institute_name.getText().toString();
        String experienceyear = experience.getText().toString();
        String fid = id.getText().toString();

        Faculty_details_institute_database input = new Faculty_details_institute_database(fname,femail,fqualification,experienceyear,fid);
        if(fname.isEmpty() || femail.isEmpty() || fqualification.isEmpty() || institutename.isEmpty() || experienceyear.isEmpty())
        {
            Toast.makeText(Faculty_details_institute.this,"Fill the data" ,Toast.LENGTH_SHORT).show();
        }
        else
        {
            databaseReference.child(institutename).child("Faculty").push().setValue(input).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(Faculty_details_institute.this,"Data Added" ,Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


}