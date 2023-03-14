package com.example.easyadmission.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.easyadmission.R;
import com.example.easyadmission.Student.Database.Student_Basic_information_database;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Student_Basic_information extends AppCompatActivity {

    EditText first_name,last_name,middle_name,dob,email,phone_number,marks_10th,marks_12th;
    Button submit;
    private FirebaseDatabase firebasedatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__basic_information);

        first_name = findViewById(R.id.student_first_name);
        last_name = findViewById(R.id.student_last_name);
        middle_name = findViewById(R.id.student_middle_name);
        dob = findViewById(R.id.student_dob);
        email = findViewById(R.id.student_email_upload);
        phone_number = findViewById(R.id.student_phone_number);
        marks_10th = findViewById(R.id.student_10th_marks);
        marks_12th = findViewById(R.id.student_12th_marks);

        submit = findViewById(R.id.student_basic_information_btn);

        firebasedatabase = FirebaseDatabase.getInstance();
        databaseReference = firebasedatabase.getReference("Student");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDatabase();
            }
        });
    }

    private void createDatabase() {
        String firstname = first_name.getText().toString();
        String lastname = last_name.getText().toString();
        String middlename = middle_name.getText().toString();
        String fdob = dob.getText().toString();
        String mail = email.getText().toString();
        String phonenumber = phone_number.getText().toString();
        String mark10th = marks_10th.getText().toString();
        String mark12th = marks_12th.getText().toString();

        Student_Basic_information_database input = new Student_Basic_information_database(firstname,lastname,middlename,fdob,mail,phonenumber,mark10th,mark12th);

        if(firstname.isEmpty() || lastname.isEmpty() || middlename.isEmpty() || fdob.isEmpty() || mail.isEmpty() || phonenumber.isEmpty() || mark10th.isEmpty()|| mark12th.isEmpty())
        {
            Toast.makeText(Student_Basic_information.this,"Fill the data",Toast.LENGTH_SHORT).show();
        }
        else
        {
            databaseReference.child(phonenumber).setValue(input).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(Student_Basic_information.this,"Data Added" ,Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}