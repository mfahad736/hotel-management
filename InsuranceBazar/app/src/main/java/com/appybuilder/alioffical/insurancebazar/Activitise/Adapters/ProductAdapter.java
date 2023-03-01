package com.appybuilder.alioffical.insurancebazar.Activitise.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appybuilder.alioffical.insurancebazar.Activitise.Models.InsuranceProductModel;
import com.appybuilder.alioffical.insurancebazar.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyVIEWhOLDER> {
    List<InsuranceProductModel> list;
    Context context;

    public ProductAdapter(List<InsuranceProductModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductAdapter.MyVIEWhOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newsfeed_post= LayoutInflater.from(parent.getContext()).inflate(R.layout.productresourcefile,parent,false);
        return new MyVIEWhOLDER(newsfeed_post);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyVIEWhOLDER holder, int position) {
        InsuranceProductModel model=list.get(position);
        holder.tx_name.setText(model.getStr_productname());
        holder.tx_name.setText(model.getCompanyName());
        Glide.with(context).load(model.getProduct_img_url()).into(holder.imgview);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVIEWhOLDER extends RecyclerView.ViewHolder {
        TextView tx_name,txtcname;
        ImageView imgview;
        public MyVIEWhOLDER(@NonNull View itemView) {
            super(itemView);
            tx_name=itemView.findViewById(R.id.name_id);
            txtcname=itemView.findViewById(R.id.cname);
            imgview=itemView.findViewById(R.id.image);
        }
    }
}
