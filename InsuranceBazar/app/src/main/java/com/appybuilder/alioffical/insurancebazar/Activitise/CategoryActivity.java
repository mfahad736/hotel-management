package com.appybuilder.alioffical.insurancebazar.Activitise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.appybuilder.alioffical.insurancebazar.R;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnEfu,btn_lifeinsurance,btn_joble;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        intlizeControls();
    }




    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.efu_id){
            Intent intent=new Intent(CategoryActivity.this,PoliciesCategoryActivity.class);
            intent.putExtra("cname","EFU");

            editor.putString("cname","EFU");
            editor.apply();
            startActivity(intent);
           // startActivity(new Intent(CategoryActivity.this,PoliciesCategoryActivity.class));

        } if (view.getId()==R.id.lfein_id){
            Intent intent=new Intent(CategoryActivity.this,PoliciesCategoryActivity.class);
            intent.putExtra("cname","LIFE INSURANCE");

            editor.putString("cname","LIFE INSURANCE");
            editor.apply();
            startActivity(intent);

        } if (view.getId()==R.id.healthjub_id){
            Intent intent=new Intent(CategoryActivity.this,PoliciesCategoryActivity.class);
            intent.putExtra("cname","HEALTH INSURANCE");
            editor.putString("cname","HEALTH INSURANCE");
            editor.apply();
            startActivity(intent);

        }

    }
    private void intlizeControls() {
        editor = getApplicationContext().getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE).edit();
        btnEfu=findViewById(R.id.efu_id);
        btnEfu.setOnClickListener(this);
        btn_lifeinsurance=findViewById(R.id.lfein_id);
        btn_lifeinsurance.setOnClickListener(this);
        btn_joble=findViewById(R.id.healthjub_id);
        btn_joble.setOnClickListener(this);

    }
}