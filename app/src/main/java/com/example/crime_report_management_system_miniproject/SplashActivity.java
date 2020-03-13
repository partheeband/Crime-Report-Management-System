package com.example.crime_report_management_system_miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {
Handler handler;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                firebaseAuth=FirebaseAuth.getInstance();

                if (firebaseAuth.getCurrentUser()!=null && !firebaseAuth.getCurrentUser().getEmail().equals("police@police.in"))
                {
                        //start user dashboard activity
                        startActivity(new Intent(getApplicationContext(),UIActivity.class));
                        finish();
                }
                else if (firebaseAuth.getCurrentUser()!=null && firebaseAuth.getCurrentUser().getEmail().equals("police@police.in"))
                {
                    //start police dashboard activity
                    startActivity(new Intent(getApplicationContext(),AdminDashboardActivity.class));
                    finish();
                }
                else
                {
                    Intent intent = new Intent(SplashActivity.this, FirstActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },3000);
    }
}
