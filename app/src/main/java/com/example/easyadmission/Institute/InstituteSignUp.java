package com.example.easyadmission.Institute;

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

import com.example.easyadmission.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class InstituteSignUp extends AppCompatActivity {

    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private EditText instituteEmail,institutePassword,confirm_password;
    private TextView mTextView;
    private Button institutesignupbtn,phone;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_sign_up);



        instituteEmail = findViewById(R.id.institute_email_reg);
        institutePassword = findViewById(R.id.institute_passreg);
        confirm_password = findViewById(R.id.signup_confirmpassword);
        mTextView = findViewById(R.id.institute_textView);
        institutesignupbtn = findViewById(R.id.institute_registration_btn);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        phone = findViewById(R.id.signin_phone);

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(InstituteSignUp.this, InstituteLogin.class));
            }
        });
        institutesignupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InstituteSignUp.this, SendOTPActivity1.class));
            }
        });
    }

    private void createUser(){
        String email = instituteEmail.getText().toString();
        String pass = institutePassword.getText().toString();
        String cpass = confirm_password.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            instituteEmail.setError("Email can not be empty");
        }
        else if(TextUtils.isEmpty(pass))
        {
            instituteEmail.setError("Password can not be empty");
        }
        else
        {
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(InstituteSignUp.this,"Registration done successfully",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(InstituteSignUp.this,"Registration Error" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}