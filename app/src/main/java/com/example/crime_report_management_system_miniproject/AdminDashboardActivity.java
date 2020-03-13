package com.example.crime_report_management_system_miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminDashboardActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentuser == null) {
            sendtoLogin();
        }

        //  fireAuth = FirebaseAuth.getInstance();
    }

    //missing report
    public void yourMissingReports(View view) {
        Intent intent = new Intent(AdminDashboardActivity.this, AdminMissingReportsActivity.class);//main2activity
        startActivity(intent);
    }

    //your crime report
    public void yourCrimeReports(View view) {
        Intent intent = new Intent(AdminDashboardActivity.this, AdminCrimeReportsActivity.class);//mainactivity
        startActivity(intent);
    }

    //Crime Map
    public void crimeMap(View view) {
        //Toast.makeText(this, "Crime Map will be available soon...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AdminDashboardActivity.this, ShowCrimeMapsActivity.class);
        startActivity(intent);
    }
    //your profile
    public void Logout(View view) {
        firebaseAuth.signOut();
        Intent intent = new Intent(AdminDashboardActivity.this, FirstActivity.class);
        startActivity(intent);
        finish();
    }



    private void sendtoLogin() {
        Intent intent = new Intent(AdminDashboardActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void ViewCriminalDetails(View view) {
        Intent intent = new Intent(AdminDashboardActivity.this, AdminViewCriminalDetailsActivity.class);
        startActivity(intent);
    }

    public void addCriminalDetails(View view) {
        Intent intent = new Intent(AdminDashboardActivity.this, AdminAddCriminalDetailsActivity.class);
        startActivity(intent);

    }
}
