package com.example.easyadmission.Institute;

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

import com.example.easyadmission.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class InstituteLogin extends AppCompatActivity {

    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private EditText instituteEmail,institutePassword;
    private TextView mTextView;
    private Button instituteLogInBtn,phone;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute_login);

        instituteEmail = findViewById(R.id.institute_email);
        institutePassword = findViewById(R.id.institute_pasword);
        mTextView = findViewById(R.id.institute_textView);
        instituteLogInBtn = findViewById(R.id.institute_log_in_btn);
        mAuth = FirebaseAuth.getInstance();
        phone = findViewById(R.id.signin_phone);

        instituteLogInBtn.setOnClickListener((v)->{loginUser();});
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(InstituteLogin.this, InstituteSignUp.class));
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InstituteLogin.this, SendOTPActivity1.class));
            }
        });
    }

    private void loginUser(){

        String email = instituteEmail.getText().toString();
        String pass = institutePassword.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            if(!pass.isEmpty()){
                mAuth.signInWithEmailAndPassword(email,pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(InstituteLogin.this,"Login Succesfully",Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(SignIn.this, Profile.class));
                                startActivity(new Intent(InstituteLogin.this, Institute_menu.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(InstituteLogin.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                institutePassword.setError("Empty Fields are not allowed");
            }

        }else if(email.isEmpty()){
            instituteEmail.setError("Empty Fields are not allowed");
        }else{
            instituteEmail.setError("Please Enter Correct Email");
        }


    }
}