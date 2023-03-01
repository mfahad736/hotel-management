package com.appybuilder.alioffical.insurancebazar.Activitise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.appybuilder.alioffical.insurancebazar.R;

public class InsurancePackageDetailActivity extends AppCompatActivity {
//    SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
//    String name;
//    int url ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_package_detail);
       // intitviews();

        findViewById(R.id.accptbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(InsurancePackageDetailActivity.this,Payment2Activity.class));
            }
        });
    }
    public void intitviews(){
//        name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
//        url = prefs.getInt("idName", 0);

    }
}