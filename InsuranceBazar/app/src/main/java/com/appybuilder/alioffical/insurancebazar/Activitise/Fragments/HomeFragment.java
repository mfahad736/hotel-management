package com.appybuilder.alioffical.insurancebazar.Activitise.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appybuilder.alioffical.insurancebazar.Activitise.Adapters.HomeAdapter;
import com.appybuilder.alioffical.insurancebazar.Activitise.Models.Constant;
import com.appybuilder.alioffical.insurancebazar.Activitise.Models.HomItemsModel;
import com.appybuilder.alioffical.insurancebazar.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    int[] ImageInsuranceItems = {R.drawable.vehicle, R.drawable.lifeinsurance, R.drawable.bikeimage};
    int[] HealthItems = {R.drawable.individual_health, R.drawable.lifeinsurance, R.drawable.critical_illenes};
    int[] EducationItems = {R.drawable.child_education, R.drawable.undergradute, R.drawable.postgraduate};
    int[] BusinesItems = {R.drawable.property, R.drawable.comercial_auto, R.drawable.business_interption};
    String[] nameItems = {"Vehicle", "Life Insurance ", "Bike"};
    String[] HealthArray = {"Individual Health", "Family Health", "Critical Illness Insurance"};
    String[] EducaionhArray = {"Child Education", "UnderGraduate", "POST Graduate"};
    String[] BusinessArray = {"Property Insurance", "Commercial Auto Insurance", "Business Interaption"};
    View view;
    RecyclerView itemRecler;
    List<HomItemsModel>homItemsModelList;
    HomeAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    //fIREBASE IS HARE...
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseRefrence = database.getReference();;
    HomItemsModel model=new HomItemsModel();
    RecyclerView.LayoutManager mLayoutManager;
    boolean chek_one,chek_two,chek_three,chek_four;
    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view= inflater.inflate(R.layout.fragment_home, container, false);
         getChekOne();
         getChekTwo();
         getChekThree();
         getChekfour();
         init_views();
         return view;
    }
    public void init_views() {
        itemRecler=view.findViewById(R.id.itemrecler);
        homItemsModelList=new ArrayList<>();
        getDatafun();

//        mLayoutManager = new GridLayoutManager(getContext(),2);
//        itemRecler.setLayoutManager(mLayoutManager);
//        itemRecler.setItemAnimator(new DefaultItemAnimator());
//        //  recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
//        itemRecler.setAdapter(adapter);



    }

    private void getDatafun() {
        Constant.chek_one=chek_one;
        Constant.chek_two=chek_two;
        Constant.chek_three=chek_three;
        Constant.chek_four=chek_four;
        if (Constant.chek_one){
             homItemsModelList.clear();
//            HomItemsModel model;
//            for (int i=0;i<3;i++){
//                model=new HomItemsModel();
//                model.setStrTitle(nameItems[i]);
//                model.setStrThumbnail(ImageInsuranceItems[i]);
//                homItemsModelList.add(model);
//            }
            post_DataFun(Constant.MotorsIns);
            adapter=new HomeAdapter(homItemsModelList,getContext());
            Constant.chek_one=false;
          //  saveChekOne(Constant.chek_one);
        }
        if (Constant.chek_two){
            homItemsModelList.clear();
            HomItemsModel model;
//            for (int i=0;i<3;i++){
//                model=new HomItemsModel();
//                model.setStrTitle(HealthArray[i]);
//                model.setStrThumbnail(HealthItems[i]);
//                homItemsModelList.add(model);
//            }
            post_DataFun(Constant.HealthIns);
            adapter=new HomeAdapter(homItemsModelList,getContext());
            Constant.chek_two=false;
            //saveChekTwo(Constant.chek_two);
        }
        if (Constant.chek_three){
            homItemsModelList.clear();
            HomItemsModel model;
//            for (int i=0;i<3;i++){
//                model=new HomItemsModel();
//                model.setStrTitle(EducaionhArray[i]);
//                model.setStrThumbnail(EducationItems[i]);
//                homItemsModelList.add(model);
//            }
            post_DataFun(Constant.EducationIns);
            adapter=new HomeAdapter(homItemsModelList,getContext());
            Constant.chek_three=false;
          //  saveChekThree(Constant.chek_three);
        }
        if (Constant.chek_four){
          homItemsModelList.clear();
            HomItemsModel model;
//            for (int i=0;i<3;i++){
//                model=new HomItemsModel();
//                model.setStrTitle(BusinessArray[i]);
//                model.setStrThumbnail(BusinesItems[i]);
//                homItemsModelList.add(model);
//            }
            post_DataFun(Constant.str_BusinessIns);
            adapter=new HomeAdapter(homItemsModelList,getContext());
            Constant.chek_four=false;
          //  saveChekFour(Constant.chek_four);
        }

    }
    public void post_DataFun(String key) {
        databaseRefrence.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    model = postSnapshot.getValue(HomItemsModel.class);
                    homItemsModelList.add(model);
                    Log.d("Tag",homItemsModelList.get(0).getName());

                }
                // filing the adapter is here
                mLayoutManager = new GridLayoutManager(getContext(),2);
                itemRecler.setLayoutManager(mLayoutManager);
                itemRecler.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                databaseRefrence.child(key).removeEventListener(this);
                // listItems.clear();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Tag",databaseError.getMessage());

            }
        });
    }
    void getChekOne() {
        SharedPreferences sharedPref = getContext().getSharedPreferences("application", Context.MODE_PRIVATE);
        chek_one=sharedPref.getBoolean("chek_one", false);
    }
    void getChekTwo() {
        SharedPreferences sharedPref = getContext().getSharedPreferences("application", Context.MODE_PRIVATE);
        chek_two=sharedPref.getBoolean("chek_two", false);
    }void getChekThree() {
        SharedPreferences sharedPref = getContext().getSharedPreferences("application", Context.MODE_PRIVATE);
        chek_three=sharedPref.getBoolean("chek_three", false);
    }void getChekfour() {
        SharedPreferences sharedPref = getContext().getSharedPreferences("application", Context.MODE_PRIVATE);
        chek_four=sharedPref.getBoolean("chek_four", false);
    }
    void saveChekOne(boolean chek_one) {
        SharedPreferences sharedPref = getContext().getSharedPreferences("application", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("chek_one", chek_one);
        editor.apply();
        editor.commit();
    }
    void saveChekTwo(boolean chek_two) {
        SharedPreferences sharedPref = getContext().getSharedPreferences("application", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("chek_two", chek_two);
        editor.apply();
        editor.commit();
    }
    void saveChekThree(boolean chek_three) {
        SharedPreferences sharedPref = getContext().getSharedPreferences("application", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("chek_three", chek_three);
        editor.apply();
        editor.commit();
    }
    void saveChekFour(boolean chek_four) {
        SharedPreferences sharedPref =getContext().getSharedPreferences("application", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("chek_four", chek_four);
        editor.apply();
        editor.commit();
    }
}