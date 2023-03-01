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
import android.widget.Toast;

import com.appybuilder.alioffical.insurancebazar.Activitise.Adapters.ProductAdapter;
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
import java.util.List;

public class ProductFragment extends Fragment {
    FirebaseAuth auth;
    // public PostClass obj;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseRefrence = database.getReference();
    FirebaseStorage storage;
    List<InsuranceProductModel> listItems = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ProductAdapter adapter;
    View view;
    InsuranceProductModel obj=new InsuranceProductModel();

    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_about, container, false);
        recyclerView=view.findViewById(R.id.p_recler);
        layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
        //  auth=FirebaseAuth.getInstance().getCurrentUser().getUid();
        post_DataFun();//post fun
        adapter=new ProductAdapter(listItems,getContext());
        return view;
    }

    private void post_DataFun() {
        databaseRefrence.child("SelectProducts").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    obj = postSnapshot.getValue(InsuranceProductModel.class);
                    listItems.add(obj);

                }
                // filing the adapter is here
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                databaseRefrence.child("SelectProducts").removeEventListener(this);
                // listItems.clear();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("tag",databaseError.getMessage());

            }
        });

    }
}