package com.example.easyadmission.Institute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.easyadmission.R;

public class Update_course_institute extends AppCompatActivity {

    Button Add,Remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course_institute);
        Add = findViewById(R.id.add_course);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Update_course_institute.this, syllabus_institute.class));
            }
        });

        Remove = findViewById(R.id.remove_course);
    }
}