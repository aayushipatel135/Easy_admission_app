package com.example.easyadmission.Student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.easyadmission.R;
import com.example.easyadmission.Student.Database.StudentInstituteData;
import com.example.easyadmission.Student.Adaptor.institute_student_Adaptor;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Institutes_student extends AppCompatActivity {

    RecyclerView display_institute;
    DatabaseReference database;
    ArrayList<StudentInstituteData> list;
    institute_student_Adaptor institute_student_adaptor;
    FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institutes_student);


        display_institute = findViewById(R.id.display_institutes);
        display_institute.setHasFixedSize(true);

        database = FirebaseDatabase.getInstance().getReference("Institute");
        display_institute.setHasFixedSize(true);
        display_institute.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        institute_student_adaptor = new institute_student_Adaptor(this,list);
        display_institute.setAdapter(institute_student_adaptor);


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String name = dataSnapshot.child("institute_name").getValue(String.class);
                    String url = dataSnapshot.child("imgurl").getValue(String.class);
                    StudentInstituteData studentInstituteData = new StudentInstituteData(name,url);
                    list.add(studentInstituteData);
                }
                institute_student_adaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        firebaseDatabase = FirebaseDatabase.getInstance();
        
    }
}