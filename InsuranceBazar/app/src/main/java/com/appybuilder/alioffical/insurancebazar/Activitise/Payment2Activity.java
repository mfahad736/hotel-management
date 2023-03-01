package com.appybuilder.alioffical.insurancebazar.Activitise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.appybuilder.alioffical.insurancebazar.Activitise.Models.InsuranceProductModel;
import com.appybuilder.alioffical.insurancebazar.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Payment2Activity extends AppCompatActivity implements View.OnClickListener {
    Button btnPayment;
    FirebaseDatabase database;
    DatabaseReference databaseRefrence;
    String strname,strurl,policy;
    FirebaseUser firebaseUser;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment2);
        btnPayment = findViewById(R.id.paybtn);
        btnPayment.setOnClickListener(this::onClick);
        prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        database = FirebaseDatabase.getInstance();
        databaseRefrence = database.getReference();
        strname = prefs.getString("name", "No name defined");//"No name defined" is the default value.
        strurl = prefs.getString("url", "");
        policy=prefs.getString("policy","");
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.paybtn) {
            signData();
        }

    }
    public void signData(){
        InsuranceProductModel insuranceProductModel=new InsuranceProductModel();
        insuranceProductModel.setStr_productname(strname);
        insuranceProductModel.setProduct_img_url(strurl);
        insuranceProductModel.setPolicy(policy);
        databaseRefrence.child("SelectProducts").child(firebaseUser.getUid()).push().setValue(insuranceProductModel);
        Toast.makeText(getApplicationContext(),"Products Submited Sucessfuly",Toast.LENGTH_SHORT).show();
        //  finish();
        startActivity(new Intent(Payment2Activity.this,ThankYouActivity.class));
    }
}