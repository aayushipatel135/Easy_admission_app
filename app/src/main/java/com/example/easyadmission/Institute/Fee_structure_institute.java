package com.example.easyadmission.Institute;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.easyadmission.MainActivity;
import com.example.easyadmission.R;
import com.example.easyadmission.Student.StudentLogin;

public class Fee_structure_institute extends AppCompatActivity {

    CardView hostel;
    CardView institute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_structure_institute);


        hostel = findViewById(R.id.hostel);
        institute = findViewById(R.id.institute);
        hostel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Fee_structure_institute.this, hostel_fee_structure.class));
            }
        });
        institute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Fee_structure_institute.this, institute_fee_structure.class));
            }
        });
    }
}