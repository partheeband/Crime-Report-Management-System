package com.example.crime_report_management_system_miniproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText emailText;
    private EditText passwordText;
    private Button loginBtn;
    private Button mregbtn;
    private FirebaseAuth fireAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fireAuth = FirebaseAuth.getInstance();
        emailText = (EditText) findViewById(R.id.loginemail);
        passwordText = (EditText) findViewById(R.id.loginpassword);
        loginBtn = (Button) findViewById(R.id.loginbtn);
        mregbtn = (Button) findViewById(R.id.loginregbtn);
        progressDialog = new ProgressDialog(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                progressDialog.setCanceledOnTouchOutside(false);
                String email_login = emailText.getText().toString();
                String pass_login = passwordText.getText().toString();
                if(!TextUtils.isEmpty(email_login) && !TextUtils.isEmpty(pass_login)){         //checking if elements are empty
                    fireAuth.signInWithEmailAndPassword(email_login, pass_login).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                progressDialog.dismiss();
                                sendToUI();
                            }else {
                                progressDialog.dismiss();
                                toastmessage("Can't Login. TRY AGAIN WITH CORRECT INFORMATION");
                            }
                        }
                    });
                }
                else{
                    toastmessage("Please Enter Email and Password");
                }

            }
        });
        mregbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendtoRegister();
            }
        });
    }

    private void sendToUI() {

        Intent mainIntent = new Intent(LoginActivity.this, UIActivity.class);
        startActivity(mainIntent);
        finish();
    }
    public void sendtoRegister(){
        Intent regIntent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(regIntent);
    }

    //toastin message
    public  void toastmessage(String message){
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
