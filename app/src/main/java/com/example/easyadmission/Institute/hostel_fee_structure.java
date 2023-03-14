package com.example.easyadmission.Institute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easyadmission.Institute.Database.Institute_fee_structure_database;
import com.example.easyadmission.Institute.Database.hostel_fee_structure_database;
import com.example.easyadmission.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class hostel_fee_structure extends AppCompatActivity {

    EditText institute_name,hostel_fee,electricity_bill;
    Button submit;
    private FirebaseDatabase firebasedatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel_fee_structure);

        institute_name = findViewById(R.id.institute_name);
        hostel_fee = findViewById(R.id.hostel_fee);
        electricity_bill = findViewById(R.id.electricity_bill);

        submit = findViewById(R.id.hostel_fee_btn);

        firebasedatabase = FirebaseDatabase.getInstance();
        databaseReference = firebasedatabase.getReference("Institute");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createDatabase();
                startActivity(new Intent(hostel_fee_structure.this, Fee_structure_institute.class));
            }
        });

    }

    private void createDatabase() {
        String fhostel_fee = hostel_fee.getText().toString();
        String felectricity_bill = electricity_bill.getText().toString();
        String institutename = institute_name.getText().toString();

        hostel_fee_structure_database input = new hostel_fee_structure_database(fhostel_fee,felectricity_bill);
        if(fhostel_fee.isEmpty() || felectricity_bill.isEmpty() || institutename.isEmpty() )
        {
            Toast.makeText(hostel_fee_structure.this,"Fill the data" ,Toast.LENGTH_SHORT).show();
        }
        else
        {
            databaseReference.child(institutename).child("Fee_structure_hostel").push().setValue(input).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(hostel_fee_structure.this,"Data Added" ,Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


}