package com.example.crime_report_management_system_miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminViewCriminalDetailsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdminViewCriminalDetailsAdapter adapter;
    private List<CriminalDetailsHelper> CriminalDetailsList= new ArrayList<>();
    DatabaseReference dbCriminalDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_criminal_details);

        recyclerView= findViewById(R.id.recyclerViewViewCriminalDetails);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbCriminalDetail = FirebaseDatabase.getInstance().getReference("CriminalDetails");
        dbCriminalDetail.addListenerForSingleValueEvent(valueEventListener);

        adapter = new AdminViewCriminalDetailsAdapter(this, CriminalDetailsList);
        recyclerView.setAdapter(adapter);
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            CriminalDetailsList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Log.d("CriminalDetails", String.valueOf(snapshot));
                    CriminalDetailsHelper criminalDetailsHelper=snapshot.getValue(CriminalDetailsHelper.class);
                    CriminalDetailsList.add(criminalDetailsHelper);
                }
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

}
