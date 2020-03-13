package com.example.crime_report_management_system_miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.crime_report_management_system_miniproject.Java_Classes.MissingReportHelper;
import com.example.crime_report_management_system_miniproject.Java_Classes.PostCrimeHelper;
import com.example.crime_report_management_system_miniproject.Java_Classes.YourCrimeReportAdapter;
import com.example.crime_report_management_system_miniproject.Java_Classes.YourMissingReportAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class YourMissingReport extends AppCompatActivity {
    RecyclerView recyclerView;
    private FirebaseAuth mAuth;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private YourMissingReportAdapter adapter;
    private List<MissingReportHelper> yourMissingList;

    private FirebaseAuth fireAuth;
    private String TAG="tagkori";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_missing_report);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user1 = mAuth.getCurrentUser();

        recyclerView = this.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        yourMissingList = new ArrayList<>();

        adapter = new YourMissingReportAdapter(this, yourMissingList);
        recyclerView.setAdapter(adapter);
        //send Query to FirebaseDatabase
        mFirebaseDatabase = FirebaseDatabase.getInstance();


        FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentuser == null) {
            sendtoLogin();
        }
        else
        {
            mRef = mFirebaseDatabase.getReference().child("Missing");
            mRef.addListenerForSingleValueEvent(valueEventListener);
        }
    }
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            yourMissingList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    MissingReportHelper MissingReport = snapshot.getValue(MissingReportHelper.class);
                    if (MissingReport.getUid().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())){
                        yourMissingList.add(MissingReport);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
        private void sendtoLogin() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
