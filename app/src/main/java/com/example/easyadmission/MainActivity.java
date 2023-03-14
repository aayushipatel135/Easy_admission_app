package com.example.easyadmission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.easyadmission.Institute.InstituteLogin;
import com.example.easyadmission.Student.StudentLogin;

public class MainActivity extends AppCompatActivity {

    CardView hostel;
    CardView institute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hostel = findViewById(R.id.student);
        institute = findViewById(R.id.institute);
        hostel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StudentLogin.class));
            }
        });
        institute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InstituteLogin.class));
            }
        });
    }
}