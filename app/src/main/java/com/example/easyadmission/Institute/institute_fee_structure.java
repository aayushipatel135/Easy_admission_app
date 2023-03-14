package com.example.easyadmission.Institute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easyadmission.Institute.Database.Faculty_details_institute_database;
import com.example.easyadmission.Institute.Database.Institute_fee_structure_database;
import com.example.easyadmission.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class institute_fee_structure extends AppCompatActivity {

    EditText tuition_fee,registration_fee,caution_deposit,institute_name;
    Button submit;
    private FirebaseDatabase firebasedatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_fee_structure);

        tuition_fee = findViewById(R.id.tuition_fee);
        registration_fee = findViewById(R.id.registration_fee);
        caution_deposit = findViewById(R.id.caution_deposit);
        institute_name = findViewById(R.id.institute_name);

        submit = findViewById(R.id.institute_fee_submit_btn);


        firebasedatabase = FirebaseDatabase.getInstance();
        databaseReference = firebasedatabase.getReference("Institute");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createDatabase();
                startActivity(new Intent(institute_fee_structure.this, Fee_structure_institute.class));
            }
        });

    }

    private void createDatabase() {
        String ftuition_fee = tuition_fee.getText().toString();
        String fregistration_fee = registration_fee.getText().toString();
        String fcaution_deposit = caution_deposit.getText().toString();
        String institutename = institute_name.getText().toString();


        Institute_fee_structure_database input = new Institute_fee_structure_database(ftuition_fee,fregistration_fee,fcaution_deposit);
        if(ftuition_fee.isEmpty() || fregistration_fee.isEmpty() || fcaution_deposit.isEmpty() )
        {
            Toast.makeText(institute_fee_structure.this,"Fill the data" ,Toast.LENGTH_SHORT).show();
        }
        else
        {
            databaseReference.child(institutename).child("Fee_structure_institute").push().setValue(input).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(institute_fee_structure.this,"Data Added" ,Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


}