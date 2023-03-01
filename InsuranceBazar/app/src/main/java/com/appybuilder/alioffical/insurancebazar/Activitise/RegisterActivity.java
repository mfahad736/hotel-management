package com.appybuilder.alioffical.insurancebazar.Activitise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appybuilder.alioffical.insurancebazar.Activitise.Models.UserRegistration;
import com.appybuilder.alioffical.insurancebazar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_fname,et_email,et_address,et_pass,etconfirmpass;
    FirebaseDatabase database;
    DatabaseReference databaseRefrence;
    FirebaseAuth auth;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init_views();
    }
    public void init_views(){
        database = FirebaseDatabase.getInstance();
        databaseRefrence = database.getReference();
        et_fname=findViewById(R.id.fullname_id);
        et_email=findViewById(R.id.email_id);
        et_pass=findViewById(R.id.pass);
        etconfirmpass=findViewById(R.id.etcpass);
        btnRegister=findViewById(R.id.btnsignup_id);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       if (view.getId()==R.id.btnsignup_id){
           SignUpfun();
       }
    }
    public void SignUpfun(){
        auth= FirebaseAuth.getInstance();
        if (et_fname.getText().toString().isEmpty()){
            et_fname.setError("Enter First Name");
        }if (et_email.getText().toString().isEmpty()){
            et_email.setError("Enter Email Address");
        }
        if(et_pass.getText().toString().isEmpty()){
            et_pass.setError("Enter Password");
            et_pass.requestFocus();
        }
        if(etconfirmpass.getText().toString().isEmpty()){
            etconfirmpass.setError("Enter Confirm Password");
            etconfirmpass.requestFocus();
        }
        else{
            auth.createUserWithEmailAndPassword(et_email.getText().toString().trim(),et_pass.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        signData();
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
    public void signData(){
        UserRegistration userRegistration=new UserRegistration();
        userRegistration.setFname(et_fname.getText().toString().trim());
        userRegistration.setEmail(et_email.getText().toString().trim());
        userRegistration.setPass(et_email.getText().toString().trim());
        userRegistration.setPass(et_pass.getText().toString().trim());
        databaseRefrence.child("Users").child(auth.getUid()).setValue(userRegistration);
        Toast.makeText(getApplicationContext(),"SignInSucessfULLY",Toast.LENGTH_SHORT).show();
        finish();
        //startActivity(new Intent(UserRegisterActivity.this,LoginActivity.class));
    }
}