package com.appybuilder.alioffical.insurancebazar.Activitise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.appybuilder.alioffical.insurancebazar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenu;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView btn_signup;
    TextView txt_forgot;
    EditText et_email,et_pass;
    Button btnSignIn;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth auth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inti_views();
        findViewById(R.id.signinbtnid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignInfun();
            }
        });
        findViewById(R.id.gotosignup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        findViewById(R.id.btnforgotpass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ForgotPassActivity.class));
            }
        });

    }
    public void inti_views(){
        auth=FirebaseAuth.getInstance();
        btn_signup=findViewById(R.id.signinbtnid);
        btn_signup.setOnClickListener(this);
        et_email=findViewById(R.id.email_signi_id);
        et_pass=findViewById(R.id.password_signin_id);
        progressBar=findViewById(R.id.loading);


    }
    public void SignInfun(){
        if(et_email.getText().toString().trim().isEmpty()){
            et_email.setError("Please Enter the Email Address");
            et_email.requestFocus();
        }if(!et_email.getText().toString().trim().matches(emailPattern)){
            et_email.setError("Please Enter Valid Email Address");
            et_email.requestFocus();
        }
        if(et_pass.getText().toString().trim().isEmpty()){
            et_pass.setError("Please Enter the Email Address");
            et_pass.requestFocus();
        }
        else{
            singInMethod();
        }
    }
    public void singInMethod(){
        progressBar.setVisibility(View.VISIBLE);
        auth.signInWithEmailAndPassword(et_email.getText().toString().trim(),et_pass.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                    progressBar.setVisibility(View.INVISIBLE);

                }
                else{
                    Toast.makeText(getApplicationContext(),"SometHING WENT WRONG",Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {


    }
}