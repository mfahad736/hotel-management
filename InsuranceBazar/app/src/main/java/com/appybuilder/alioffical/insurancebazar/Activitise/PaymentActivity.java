package com.appybuilder.alioffical.insurancebazar.Activitise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.appybuilder.alioffical.insurancebazar.Activitise.Models.InsuranceProductModel;
import com.appybuilder.alioffical.insurancebazar.Activitise.Models.UserRegistration;
import com.appybuilder.alioffical.insurancebazar.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPayment;
    FirebaseDatabase database;
    DatabaseReference databaseRefrence;
    String strname,strurl,strdes,cname;
    FirebaseUser firebaseUser;
    SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        btnPayment = findViewById(R.id.paybtn);
        btnPayment.setOnClickListener(this::onClick);
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        database = FirebaseDatabase.getInstance();
        databaseRefrence = database.getReference();

       // strdes = prefs.getString("idName", "");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.paybtn) {
            signData();
        }

    }
    public void signData(){
        strname = prefs.getString("name", "No name defined");//"No name defined" is the default value.
        strurl = prefs.getString("url", "");
        cname = prefs.getString("cname", "");

        InsuranceProductModel insuranceProductModel=new InsuranceProductModel();
        insuranceProductModel.setStr_productname(strname);
        insuranceProductModel.setProduct_img_url(strurl);
        insuranceProductModel.setCompanyName(cname);
        databaseRefrence.child("SelectProducts").child(firebaseUser.getUid()).push().setValue(insuranceProductModel);
        Toast.makeText(getApplicationContext(),"Products Submited Sucessfuly",Toast.LENGTH_SHORT).show();
      //  finish();
        startActivity(new Intent(PaymentActivity.this,ThankYouActivity.class));
    }
}