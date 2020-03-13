package com.example.crime_report_management_system_miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.crime_report_management_system_miniproject.Java_Classes.PostCrimeHelper;
import com.example.crime_report_management_system_miniproject.Java_Classes.YourCrimeReportAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class YourCrimeReport extends AppCompatActivity {
    RecyclerView recyclerView;
    private FirebaseAuth mAuth;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    private YourCrimeReportAdapter adapter;
    private List<PostCrimeHelper> yourCrimeList;

    private FirebaseAuth fireAuth;
    private String TAG="tagkori";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_crime_report);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user1 = mAuth.getCurrentUser();

        recyclerView = this.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        yourCrimeList = new ArrayList<>();

        adapter = new YourCrimeReportAdapter(this, yourCrimeList);
        recyclerView.setAdapter(adapter);
        //send Query to FirebaseDatabase
        mFirebaseDatabase = FirebaseDatabase.getInstance();


        FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentuser == null) {
            sendtoLogin();
        }
        else
        {
            mRef = mFirebaseDatabase.getReference().child("Crime");
            mRef.addListenerForSingleValueEvent(valueEventListener);
        }

    }
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            yourCrimeList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    PostCrimeHelper crimeRecord = snapshot.getValue(PostCrimeHelper.class);
                    if (crimeRecord.getUid().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())){
                        yourCrimeList.add(crimeRecord);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    private void sendtoLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
