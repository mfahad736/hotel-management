package com.appybuilder.alioffical.insurancebazar.Activitise.Adapters;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appybuilder.alioffical.insurancebazar.Activitise.InsurancFormActivity;
import com.appybuilder.alioffical.insurancebazar.Activitise.Models.HomItemsModel;
import com.appybuilder.alioffical.insurancebazar.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MYviewHolder> {
    List<HomItemsModel> list;
    Context context;

    public HomeAdapter(List<HomItemsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeAdapter.MYviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newsfeed_post= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemresourcefile,parent,false);
        return new MYviewHolder(newsfeed_post);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.MYviewHolder holder, int position) {
        HomItemsModel model=list.get(position);
        holder.txt_title.setText(model.getName());
        Glide.with(context).load(model.getImage_url()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MYviewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt_title;
        public MYviewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.image);
            txt_title=itemView.findViewById(R.id.name_id);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context,InsurancFormActivity.class);
                    SharedPreferences.Editor editor = context.getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE).edit();
                    editor.putString("name",list.get(getAdapterPosition()).getName());
                    editor.putString("url",list.get(getAdapterPosition()).getImage_url());
                    editor.putString("policy",list.get(getAdapterPosition()).getPolicy());
                    editor.apply();
                    intent.putExtra("name",list.get(getAdapterPosition()).getName());
                    intent.putExtra("image_url",list.get(getAdapterPosition()).getImage_url());
                    //intent.putExtra("des",list.get(getAdapterPosition()).getName());
                    context.startActivity(intent);
                }
            });
        }
    }
}
