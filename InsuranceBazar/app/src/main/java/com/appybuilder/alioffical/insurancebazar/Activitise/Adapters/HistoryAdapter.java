package com.appybuilder.alioffical.insurancebazar.Activitise.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appybuilder.alioffical.insurancebazar.Activitise.Models.HistoryModel;
import com.appybuilder.alioffical.insurancebazar.Activitise.Models.HomItemsModel;
import com.appybuilder.alioffical.insurancebazar.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyviewHolder> {
    List<HomItemsModel>historyModelList;
    Context context;

    public HistoryAdapter(List<HomItemsModel> historyModelList, Context context) {
        this.historyModelList = historyModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newsfeed_post= LayoutInflater.from(parent.getContext()).inflate(R.layout.historyresourcefile,parent,false);
        return new MyviewHolder(newsfeed_post);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.MyviewHolder holder, int position) {
        HomItemsModel historyModel=historyModelList.get(position);
        holder.txt_name.setText(historyModel.getName());
        Glide.with(context).load(historyModel.getImage_url()).into(holder.imgP);

    }

    @Override
    public int getItemCount() {
        return historyModelList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView txt_name;
        ImageView imgP;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name=itemView.findViewById(R.id.title_txtp);
            imgP=itemView.findViewById(R.id.image);
        }
    }
}
