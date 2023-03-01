package com.appybuilder.alioffical.insurancebazar.Activitise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.appybuilder.alioffical.insurancebazar.Activitise.Models.Constant;
import com.appybuilder.alioffical.insurancebazar.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PoliciesCategoryActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnone,btntwo,btnthree,btnfour;
    FirebaseAuth auth;
    FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policies_category);
        setIntlization();
    }

    private void setIntlization() {
        auth=FirebaseAuth.getInstance();
        firebaseUser=auth.getCurrentUser();
        btnone=findViewById(R.id.one_id);
        btnone.setOnClickListener(this);
        btntwo=findViewById(R.id.two_id);
        btntwo.setOnClickListener(this);
        btnthree=findViewById(R.id.three_id);
        btnthree.setOnClickListener(this);
        btnfour=findViewById(R.id.four_id);
        btnfour.setOnClickListener(this);
    }
    void saveChekOne(boolean chek_one) {
        SharedPreferences sharedPref = getSharedPreferences("application", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("chek_one", chek_one);
        editor.apply();
        editor.commit();
    }
    void saveChekTwo(boolean chek_two) {
        SharedPreferences sharedPref = getSharedPreferences("application", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("chek_two", chek_two);
        editor.apply();
        editor.commit();
    }
    void saveChekThree(boolean chek_three) {
        SharedPreferences sharedPref = getSharedPreferences("application", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("chek_three", chek_three);
        editor.apply();
        editor.commit();
    }
    void saveChekFour(boolean chek_four) {
        SharedPreferences sharedPref = getSharedPreferences("application", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("chek_four", chek_four);
        editor.apply();
        editor.commit();
    }


    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.one_id){
            Constant.chek_one=true;
            saveChekOne(Constant.chek_one);
            saveChekTwo(false);
            saveChekThree(false);
            saveChekFour(false);
            gotoLogin();
        } if (view.getId()==R.id.two_id){
            Constant.chek_two=true;
            saveChekTwo(Constant.chek_two);
            saveChekOne(false);
            saveChekThree(false);
            saveChekFour(false);
            gotoLogin();
        } if (view.getId()==R.id.three_id){
            Constant.chek_three=true;
            saveChekThree(Constant.chek_three);
            saveChekOne(false);
            saveChekTwo(false);
            saveChekFour(false);
            gotoLogin();
        } if (view.getId()==R.id.four_id){
            Constant.chek_four=true;
            saveChekFour(Constant.chek_four);
            saveChekOne(false);
            saveChekTwo(false);
            saveChekThree(false);
            gotoLogin();
        }

    }
    public void gotoLogin(){
        if (firebaseUser==null){
            startActivity(new Intent(PoliciesCategoryActivity.this,LoginActivity.class));
        }
        else {
            startActivity(new Intent(PoliciesCategoryActivity.this,HomeActivity.class));
        }


    }
}