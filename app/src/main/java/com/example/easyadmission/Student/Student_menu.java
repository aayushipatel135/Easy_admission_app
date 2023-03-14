package com.example.easyadmission.Student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.easyadmission.R;

public class Student_menu extends AppCompatActivity {

    CardView student_information;
    CardView Institutes;
    CardView applynow;
    CardView merit_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_menu);
        student_information = findViewById(R.id.student_basic_information);
        student_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Student_menu.this, Student_Basic_information.class));
            }
        });

        Institutes = findViewById(R.id.Visit_institute_student);
        Institutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Student_menu.this, Institutes_student.class));
            }
        });


        applynow = findViewById(R.id.Apply_for_institute_student);
        applynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Student_menu.this, apply_now_student.class));
            }
        });


        merit_list = findViewById(R.id.Merit_list_student);
        merit_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Student_menu.this, Student_Basic_information.class));
            }
        });
    }

}