package com.appybuilder.alioffical.insurancebazar.Activitise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appybuilder.alioffical.insurancebazar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnsubmit;
    FirebaseAuth auth;
    EditText et_email;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        intit_views();
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btnsubmit){
            sendEmail();
        }

    }
    public void intit_views(){
        auth=FirebaseAuth.getInstance();
        btnsubmit=findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(this);
        et_email=findViewById(R.id.emailET_reset);
    }
    public void sendEmail(){
        if (et_email.getText().toString().trim().isEmpty()){
            et_email.setError("Please Enter Email Address");
            et_email.requestFocus();
        }
        else if (!et_email.getText().toString().trim().matches(emailPattern)){
            et_email.setError("Please Enter the Valid Email");
            et_email.requestFocus();
        }
        else{
            emailsentcall();
        }

    }
    public void emailsentcall(){
        auth.sendPasswordResetEmail(et_email.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Email HAS Been Sent",Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}