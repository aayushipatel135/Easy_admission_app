package com.example.easyadmission.Student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easyadmission.Institute.SendOTPActivity1;
import com.example.easyadmission.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class StudentSignUp extends AppCompatActivity {

    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private EditText studentEmail,studentPassword,confirmPassword;
    private TextView mTextView;
    private Button studentsignupbtn,phone;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);



        studentEmail = findViewById(R.id.student_email_reg);
        studentPassword = findViewById(R.id.student_passreg);
        confirmPassword = findViewById(R.id.signup_confirmpassword);
        mTextView = findViewById(R.id.student_textView);
        studentsignupbtn = findViewById(R.id.student_registration_btn);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        phone = findViewById(R.id.signin_phone);


        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(StudentSignUp.this,StudentLogin.class));
            }
        });
        studentsignupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentSignUp.this, SendOTPActivity1.class));
            }
        });
    }

    private void createUser(){
        String email = studentEmail.getText().toString();
        String pass = studentPassword.getText().toString();
        String cpass = confirmPassword.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            studentEmail.setError("Email can not be empty");
        }
        else if(TextUtils.isEmpty(pass))
        {
            studentEmail.setError("Password can not be empty");
        }

        else
        {
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(StudentSignUp.this,"Registration done successfully",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(StudentSignUp.this,"Registration Error" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}