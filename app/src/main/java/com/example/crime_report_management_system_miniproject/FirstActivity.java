package com.example.crime_report_management_system_miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

    }
    //specified the indent in xml with respective functions.
    public void sendtoMain(View view) {
        Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void sendtoMain2(View view) {
        Intent intent = new Intent(FirstActivity.this, AdminLoginActivity.class);
        startActivity(intent);
    }
}
