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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class InsurancFormActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_fname,et_email,et_address,etphone,etcninc;
    FirebaseDatabase database;
    DatabaseReference databaseRefrence;
    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    Button submitform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insuranc_form);
        init_views();
        findViewById(R.id.submitbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               datafun();
            }
        });
    }
    public void init_views(){
        database = FirebaseDatabase.getInstance();
        databaseRefrence = database.getReference();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        et_fname=findViewById(R.id.fullname_id);
        et_email=findViewById(R.id.email_id);
        et_address=findViewById(R.id.address);
        etphone=findViewById(R.id.phone_id);
        etcninc=findViewById(R.id.nic);
        submitform=findViewById(R.id.submitbtn);
        submitform.setOnClickListener(this);
    }
    public void datafun(){
        auth= FirebaseAuth.getInstance();
        if (et_fname.getText().toString().isEmpty()){
            et_fname.setError("Enter First Name");
        }if (et_email.getText().toString().isEmpty()){
            et_email.setError("Enter Email Address");
        }
        if(et_address.getText().toString().isEmpty()){
            et_address.setError("Enter Permanent Address");
            et_address.requestFocus();
        }
        if(etphone.getText().toString().isEmpty()){
            etphone.setError("Enter Phone NO");
            etphone.requestFocus();
        }
        else{
            submitformdata();
        }
    }
    public void submitformdata(){
        UserRegistration userRegistration=new UserRegistration();
        userRegistration.setFname(et_fname.getText().toString().trim());
        userRegistration.setEmail(et_email.getText().toString().trim());
        userRegistration.setPass(et_email.getText().toString().trim());
        userRegistration.setPass(et_address.getText().toString().trim());
        userRegistration.setPass(et_address.getText().toString().trim());
        databaseRefrence.child("InsuranceForm").child(firebaseUser.getUid()).setValue(userRegistration);
        Toast.makeText(getApplicationContext(),"Form Submitted Sucessfully",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(InsurancFormActivity.this,InsurancePackageDetailActivity.class));
        //finish();
        //startActivity(new Intent(UserRegisterActivity.this,LoginActivity.class));
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btnsubmit){
           // datafun();
        }
    }
}