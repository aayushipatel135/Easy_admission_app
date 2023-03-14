package com.example.easyadmission.Student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easyadmission.Institute.SendOTPActivity1;
import com.example.easyadmission.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StudentLogin extends AppCompatActivity {

    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private EditText studentEmail,studentPassword;
    private TextView mTextView;
    private Button studentLogInBtn,phone;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        studentEmail = findViewById(R.id.student_email);
        studentPassword = findViewById(R.id.student_pasword);
        mTextView = findViewById(R.id.student_textView);
        studentLogInBtn = findViewById(R.id.student_log_in_btn);
        mAuth = FirebaseAuth.getInstance();
        phone = findViewById(R.id.signin_phone);

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(StudentLogin.this,StudentSignUp.class));
            }
        });
        studentLogInBtn.setOnClickListener((v)->{loginUser();});

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentLogin.this, SendOTPActivity1.class));
            }
        });
    }

    private void loginUser(){

        String email = studentEmail.getText().toString();
        String pass = studentPassword.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            if(!pass.isEmpty()){
                mAuth.signInWithEmailAndPassword(email,pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(StudentLogin.this,"Login Succesfully",Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(SignIn.this, Profile.class));
                                startActivity(new Intent(StudentLogin.this, Student_menu.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(StudentLogin.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                studentPassword.setError("Empty Fields are not allowed");
            }

        }else if(email.isEmpty()){
            studentEmail.setError("Empty Fields are not allowed");
        }else{
            studentEmail.setError("Please Enter Correct Email");
        }


    }
}