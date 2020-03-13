package com.example.crime_report_management_system_miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UIActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentuser == null) {
            sendtoLogin();
        }

        //  fireAuth = FirebaseAuth.getInstance();
    }

    //missing report
    public void yourMissingReports(View view) {
       Intent intent = new Intent(UIActivity.this, YourMissingReport.class);//main2activity
        startActivity(intent);
    }

    //your crime report
    public void yourCrimeReports(View view) {
        Intent intent = new Intent(UIActivity.this, YourCrimeReport.class);//mainactivity
        startActivity(intent);
    }

    //report a crime
    public void reportCrime(View view) {
        Intent intent = new Intent(UIActivity.this, PostActivity.class);
        startActivity(intent);
    }

    //file a missing report
    public void fileMissingReport(View view) {
        Intent intent = new Intent(UIActivity.this, PostMissingReportActivity.class);

        startActivity(intent);
    }

    //your profile
    public void yourProfile(View view) {
       Intent intent = new Intent(UIActivity.this, ProfileActivity.class);

        startActivity(intent);
    }
    //your profile
    public void Logout(View view) {
        Intent intent = new Intent(UIActivity.this, FirstActivity.class);
        startActivity(intent);
        firebaseAuth.signOut();
        finish();
    }



    private void sendtoLogin() {
        Intent intent = new Intent(UIActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
