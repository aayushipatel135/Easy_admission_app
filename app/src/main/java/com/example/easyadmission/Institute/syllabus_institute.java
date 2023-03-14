package com.example.easyadmission.Institute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easyadmission.R;
import com.example.easyadmission.Institute.Database.syllabus_database_institute;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class syllabus_institute extends AppCompatActivity {
    EditText course_id,course_name,course_information,course_branch,institute_name;
    Button submit;
    private FirebaseDatabase firebasedatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus_institute);

        course_id = findViewById(R.id.course_id_institute);
        course_name = findViewById(R.id.course_name_institute);
        course_information = findViewById(R.id.introduction_course_institute);
        course_branch = findViewById(R.id.branch_course_institute);
        institute_name = findViewById(R.id.institute_name_upload_course);
        submit = findViewById(R.id.institute_syllabus_btn);

        firebasedatabase = FirebaseDatabase.getInstance();
        databaseReference = firebasedatabase.getReference("Institute");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDatabase();
                startActivity(new Intent(syllabus_institute.this, Update_course_institute.class));
            }
        });
    }


    private void createDatabase() {
        String courseid = course_id.getText().toString();
        String coursename = course_name.getText().toString();
        String courseinformation = course_information.getText().toString();
        String coursebranch = course_branch.getText().toString();
        String institutename = institute_name.getText().toString();

        syllabus_database_institute input = new syllabus_database_institute(courseid,coursename,courseinformation,coursebranch);
        if(courseid.isEmpty() || coursename.isEmpty() || courseinformation.isEmpty() || coursebranch.isEmpty() || institutename.isEmpty())
        {
            Toast.makeText(syllabus_institute.this,"Fill the data" ,Toast.LENGTH_SHORT).show();
        }
        else
        {
            databaseReference.child(institutename).child("Course").push().setValue(input).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(syllabus_institute.this,"Data Added" ,Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}