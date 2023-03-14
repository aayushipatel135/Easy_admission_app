package com.example.easyadmission.Institute;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.easyadmission.R;

public class Institute_menu extends AppCompatActivity {

    CardView basic_information;
    CardView Faculty;
    CardView Syllabus;
    CardView Campus;
    CardView Hostel;
    CardView Fee_structure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_menu);
        basic_information = findViewById(R.id.basic_information);
        basic_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Institute_menu.this, Basic_information.class));
            }
        });


        Faculty = findViewById(R.id.Faculty);
        Faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Institute_menu.this, Update_faculty_list_institute.class));
            }
        });


        Syllabus = findViewById(R.id.Syllabus);
        Syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Institute_menu.this, Update_course_institute.class));
            }
        });

        Campus = findViewById(R.id.Campus);
        Campus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Institute_menu.this, Campus_information_institute.class));
            }
        });


        Hostel = findViewById(R.id.Hostel);
        Hostel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Institute_menu.this, Hostel_Institute.class));
            }
        });


        Fee_structure = findViewById(R.id.Fee_structure);
        Fee_structure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Institute_menu.this, Fee_structure_institute.class));
            }
        });
    }
}