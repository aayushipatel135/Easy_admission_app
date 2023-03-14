package com.example.easyadmission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_screen extends Activity {

    ImageView logo;
    TextView distributor,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        distributor = findViewById(R.id.distributor);
        name = findViewById(R.id.name);
        logo = findViewById(R.id.logo);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startEnterAnimation();
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();

            }
        }, 5000);
    }

    private void startEnterAnimation() {

        logo.setVisibility(View.VISIBLE);
        distributor.setVisibility(View.VISIBLE);
        name.setVisibility(View.VISIBLE);
    }
}

