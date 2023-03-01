package com.appybuilder.alioffical.insurancebazar.Activitise.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.appybuilder.alioffical.insurancebazar.Activitise.Adapters.HomeAdapter;
import com.appybuilder.alioffical.insurancebazar.Activitise.Adapters.PolicyAdapter;
import com.appybuilder.alioffical.insurancebazar.Activitise.Adapters.ProductAdapter;
import com.appybuilder.alioffical.insurancebazar.Activitise.Models.HomItemsModel;
import com.appybuilder.alioffical.insurancebazar.Activitise.Models.InsuranceProductModel;
import com.appybuilder.alioffical.insurancebazar.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PolicyFragment extends Fragment {
    View view;
    RecyclerView policyRec;
    List<HomItemsModel>policyModelList ;
    PolicyAdapter policyAdapter;
    HomItemsModel policyModel;
    LinearLayoutManager linearLayoutManager;
    //fIREBASE IS HARE...
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseRefrence = database.getReference();;
    HomItemsModel model=new HomItemsModel();
    RecyclerView.LayoutManager mLayoutManager;
    FirebaseAuth auth;
    String p_name,policy,url;
    public PolicyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_map, container, false);
        init_views();
        return view;
    }
    public void init_views() {
        policyModel=new HomItemsModel();
        auth=FirebaseAuth.getInstance();
        policyRec=view.findViewById(R.id.policy_reclerview);
        policyModelList=new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        //  auth=FirebaseAuth.getInstance().getCurrentUser().getUid();
        getDatafun();//post fun
        policyAdapter=new PolicyAdapter(policyModelList,getContext());
//        mLayoutManager = new GridLayoutManager(getContext(),2);
//        itemRecler.setLayoutManager(mLayoutManager);
//        itemRecler.setItemAnimator(new DefaultItemAnimator());
//        //  recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
//        itemRecler.setAdapter(adapter);



    }

    private void getDatafun() {
        databaseRefrence.child("SelectProducts").child(auth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                HashMap<String,String>hashMap= (HashMap<String, String>) dataSnapshot.getValue();
                 p_name=hashMap.get("str_product_name");
                 policy=hashMap.get("policy");
                 url=hashMap.get("product_img_url");
                 policyModel.setName(p_name);
                 policyModel.setPolicy(policy);
                 policyModel.setImage_url(hashMap.get(url));
                 policyModelList.add(policyModel);
                // filing the adapter is here
                policyRec.setLayoutManager(linearLayoutManager);
                policyRec.setAdapter(policyAdapter);
                policyAdapter.notifyDataSetChanged();
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