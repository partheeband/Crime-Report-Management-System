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

public class AdminLoginActivity extends AppCompatActivity {
    private EditText emailText;
    private EditText passwordText;
    private Button loginBtn;
    private FirebaseAuth fireAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        fireAuth = FirebaseAuth.getInstance();
        emailText = (EditText) findViewById(R.id.loginemail);
        passwordText = (EditText) findViewById(R.id.loginpassword);
        loginBtn = (Button) findViewById(R.id.loginbtn);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        // mregbtn = (Button) findViewById(R.id.loginregbtn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                progressDialog.setCanceledOnTouchOutside(false);
                String email_login = emailText.getText().toString();
                email_login=email_login.concat("@police.in");
                String pass_login = passwordText.getText().toString();

                if(!TextUtils.isEmpty(email_login) && !TextUtils.isEmpty(pass_login)){         //checking if elements are empty


                    // signin credintial for police login is
                    //username-police
                    //password-9176235066
                    fireAuth.signInWithEmailAndPassword(email_login, pass_login).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                progressDialog.dismiss();
                                sendToAdmin();
                            }else {
                                progressDialog.dismiss();
                                toastmessage("Can't Login. TRY AGAIN WITH CORRECT INFORMATION");
                            }
                        }
                    });
                }
                else{
                    toastmessage("Please Enter  Admin Email and Password");
                }

            }
        });
    }
    //sending to main
    public void sendToAdmin(){
        Intent mainIntent = new Intent(AdminLoginActivity.this, AdminDashboardActivity.class);
        startActivity(mainIntent);
        finish();
    }


    //toastin message
    public  void toastmessage(String message){
        Toast.makeText(AdminLoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
