package com.example.easyadmission.Institute;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.easyadmission.Institute.Adaptor.Faculty_Adaptor;
import com.example.easyadmission.Institute.Database.Faculty_details_institute_database;
import com.example.easyadmission.R;
import com.example.easyadmission.Student.Adaptor.institute_student_Adaptor;
import com.example.easyadmission.Student.Database.StudentInstituteData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Update_faculty_list_institute extends AppCompatActivity {

    Button Add,Remove;
    RecyclerView recyclerView;
    DatabaseReference database;
    ArrayList<Faculty_details_institute_database> list;
    Faculty_Adaptor faculty_adaptor;
    FirebaseDatabase firebaseDatabase;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    String email = mAuth.getCurrentUser().getEmail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty_list_institute);

        Add = findViewById(R.id.add_faculty);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Update_faculty_list_institute.this, Faculty_details_institute.class));
            }
        });

        Remove = findViewById(R.id.remove_faculty);


        recyclerView = findViewById(R.id.faculties_list);
        recyclerView.setHasFixedSize(true);

        database = FirebaseDatabase.getInstance().getReference("Institute");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        faculty_adaptor = new Faculty_Adaptor(this,list);
        recyclerView.setAdapter(faculty_adaptor);

        FirebaseUser currentUser = database.getAuth().getUid();


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        Faculty_details_institute_database faculty_details_institute_database = dataSnapshot.getValue(Faculty_details_institute_database.class);
                        list.add(faculty_details_institute_database);

                }
                faculty_adaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}