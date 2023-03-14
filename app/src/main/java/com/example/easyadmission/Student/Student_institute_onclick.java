package com.example.easyadmission.Student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.easyadmission.R;
import com.example.easyadmission.Student.Database.StudentCourseInstituteData;
import com.example.easyadmission.Student.Adaptor.Student_Course_Adaptor;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Student_institute_onclick extends AppCompatActivity {

    TextView display_institute_name,display_institute_email,display_institute_about;
    RecyclerView display_institute_courses;
    ArrayList<StudentCourseInstituteData> list;
    Student_Course_Adaptor student_course_adaptor;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_institute_onclick);

        display_institute_name = findViewById(R.id.display_institute_name);
        display_institute_email = findViewById(R.id.display_institute_email);
        display_institute_about = findViewById(R.id.display_institute_about);

        display_institute_name.setText(getIntent().getStringExtra("institute_name"));
        display_institute_email.setText(getIntent().getStringExtra("institute_email"));
        display_institute_about.setText(getIntent().getStringExtra("institute_about"));

        display_institute_courses = findViewById(R.id.display_institute_courses);
        display_institute_courses.setHasFixedSize(true);

        database = FirebaseDatabase.getInstance().getReference("Institute").child(getIntent().getStringExtra("institute_name")).child("Course");
        display_institute_courses.setHasFixedSize(true);
        display_institute_courses.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        student_course_adaptor = new Student_Course_Adaptor(this,list);
        display_institute_courses.setAdapter(student_course_adaptor);


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    StudentCourseInstituteData  studentInstituteData = dataSnapshot.getValue(StudentCourseInstituteData.class);
                    list.add(studentInstituteData);
                }
                student_course_adaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






    }
}