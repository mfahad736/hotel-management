package com.appybuilder.alioffical.insurancebazar.Activitise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.appybuilder.alioffical.insurancebazar.Activitise.Adapters.HistoryAdapter;
import com.appybuilder.alioffical.insurancebazar.Activitise.Adapters.ProductAdapter;
import com.appybuilder.alioffical.insurancebazar.Activitise.Models.HistoryModel;
import com.appybuilder.alioffical.insurancebazar.Activitise.Models.HomItemsModel;
import com.appybuilder.alioffical.insurancebazar.Activitise.Models.InsuranceProductModel;
import com.appybuilder.alioffical.insurancebazar.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    FirebaseAuth auth;
    // public PostClass obj;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseRefrence = database.getReference();
    FirebaseStorage storage;
    List<HomItemsModel> listItems = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    HistoryAdapter adapter;
    View view;
    HomItemsModel obj;
    String p_name,policy,url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        init_views();
    }
    public void init_views(){
        obj=new HomItemsModel();
        auth=FirebaseAuth.getInstance();
        auth.getCurrentUser().getUid();
        recyclerView=findViewById(R.id.historyrecler);
        layoutManager = new GridLayoutManager(getApplicationContext(),2);
        //  auth=FirebaseAuth.getInstance().getCurrentUser().getUid();
        post_DataFun();//post fun
        adapter=new HistoryAdapter(listItems,this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void post_DataFun() {
        databaseRefrence.child("SelectProducts").child(auth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HashMap<String,String> hashMap= (HashMap<String, String>) dataSnapshot.getValue();
                p_name=hashMap.get("str_product_name");
                policy=hashMap.get("policy");
                url=hashMap.get("product_img_url");
                obj.setName(p_name);
                obj.setPolicy(policy);
                obj.setImage_url(hashMap.get(url));
                listItems.add(obj);

                // filing the adapter is here
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                databaseRefrence.child("SelectProducts").child(auth.getUid()).removeEventListener(this);
                // listItems.clear();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("tag",databaseError.getMessage());

            }
        });
    }
}