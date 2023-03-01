package com.appybuilder.alioffical.insurancebazar.Activitise.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appybuilder.alioffical.insurancebazar.Activitise.Fragments.PolicyModel;
import com.appybuilder.alioffical.insurancebazar.Activitise.Models.HomItemsModel;
import com.appybuilder.alioffical.insurancebazar.R;

import java.util.List;

public class PolicyAdapter extends RecyclerView.Adapter<PolicyAdapter.MyPolicyHolder> {
    List<HomItemsModel>policyModels;
    Context context;

    public PolicyAdapter(List<HomItemsModel> policyModels, Context context) {
        this.policyModels = policyModels;
        this.context = context;
    }

    @NonNull
    @Override
    public PolicyAdapter.MyPolicyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View policyview= LayoutInflater.from(parent.getContext()).inflate(R.layout.policyresourcefile,parent,false);
        return new MyPolicyHolder(policyview);
    }

    @Override
    public void onBindViewHolder(@NonNull PolicyAdapter.MyPolicyHolder holder, int position) {
        HomItemsModel model=policyModels.get(position);
        holder.txt_title.setText(model.getName());
        holder.txt_des.setText(model.getPolicy());
    }

    @Override
    public int getItemCount() {
        return policyModels.size();
    }

    public class MyPolicyHolder extends RecyclerView.ViewHolder {
        TextView txt_title,txt_des;
        public MyPolicyHolder(@NonNull View itemView) {
            super(itemView);
            txt_title=itemView.findViewById(R.id.title_txt);
            txt_des=itemView.findViewById(R.id.destextp);
        }
    }
}
