package com.example.crime_report_management_system_miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static java.lang.Math.round;

public class AdminAddCriminalDetailsActivity extends AppCompatActivity {
EditText editTextName,editTextAge,editTextCriminalId,editTextCriminalIdentificationMark,editTextCrimeType,editTextArrestedDate,editTextImprisionedYears,editTextPrisionCellId;
RatingBar ratingBar;
Button buttonAddCriminalDetails;
    private ProgressDialog Progress;

    private FirebaseAuth mAuth;

    private DatabaseReference databaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_criminal_details);

        mAuth = FirebaseAuth.getInstance();
        Progress = new ProgressDialog(this);
        databaseRef = FirebaseDatabase.getInstance().getReference();

        editTextName=(EditText)findViewById(R.id.editTextName);
        editTextAge=(EditText)findViewById(R.id.editTextAge);
        editTextCriminalIdentificationMark=(EditText)findViewById(R.id.editTextCriminalIdentificationMark);
        editTextCriminalId=(EditText)findViewById(R.id.editTextCriminalId);
        editTextCrimeType=(EditText)findViewById(R.id.editTextCrimeType);
        editTextArrestedDate=(EditText)findViewById(R.id.editTextArrestedDate);
        editTextImprisionedYears=(EditText)findViewById(R.id.editTextImprisionYears);
        editTextPrisionCellId=(EditText)findViewById(R.id.editTextprisonCellId);
        ratingBar = findViewById(R.id.ratingBar);
        buttonAddCriminalDetails=(Button)findViewById(R.id.buttonAdd);

        buttonAddCriminalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = editTextName.getText().toString().trim();
                final String age = editTextAge.getText().toString().trim();
                final String criminalId = editTextCriminalId.getText().toString().trim();
                final String criminalIdentificatinMark = editTextCriminalIdentificationMark.getText().toString().trim();
                final String crimeType = editTextCrimeType.getText().toString().trim();
                final String crimeRating=String.valueOf(round(ratingBar.getRating()));
                final String arrestedDate = editTextArrestedDate.getText().toString().trim();
                final String imprisonedYears = editTextImprisionedYears.getText().toString().trim();
                final String prisonCellId = editTextPrisionCellId.getText().toString().trim();

                if (TextUtils.isEmpty(name)||TextUtils.isEmpty(age)||TextUtils.isEmpty(criminalId)||TextUtils.isEmpty(criminalIdentificatinMark)||TextUtils.isEmpty(crimeType)||TextUtils.isEmpty(crimeRating)||TextUtils.isEmpty(arrestedDate)||TextUtils.isEmpty(imprisonedYears)||TextUtils.isEmpty(prisonCellId)) {
                    Toast.makeText(getApplicationContext(), "Enter all criminal details!", Toast.LENGTH_SHORT).show();
                    return;
                }//Toast.makeText(AdminAddCriminalDetailsActivity.this,name+" "+age+" "+criminalId+" "+criminalIdentificatinMark+" "+crimeType+" "+crimeRating+" "+arrestedDate+" "+imprisionedYears+" "+prisonCellId, Toast.LENGTH_SHORT).show();
                else
                {
                    CriminalDetailsHelper criminalDetails=new CriminalDetailsHelper(name,age,criminalId,criminalIdentificatinMark,crimeType,crimeRating,arrestedDate,imprisonedYears,prisonCellId);
                    databaseRef.child("CriminalDetails").push().setValue(criminalDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(AdminAddCriminalDetailsActivity.this, "Criminal Details Added Successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
                }
            }
        });
    }
}
