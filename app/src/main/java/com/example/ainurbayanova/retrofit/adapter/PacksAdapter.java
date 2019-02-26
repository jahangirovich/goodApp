package com.example.ainurbayanova.retrofit.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ainurbayanova.retrofit.R;
import com.example.ainurbayanova.retrofit.mvp.model.Categories;
import com.example.ainurbayanova.retrofit.mvp.model.Packs;
import com.example.ainurbayanova.retrofit.mvp.view.interfaces.interfaces.ClickItemInterface;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PacksAdapter extends RecyclerView.Adapter<PacksAdapter.EmployeeViewHolder> {
    ClickItemInterface clickItemInterface;
    private ArrayList<Packs> dataList;


    public PacksAdapter(ArrayList<Packs> dataList) {
        this.dataList = dataList;
    }

    public void setClickListener(ClickItemInterface clickItemInterface){
        this.clickItemInterface = clickItemInterface;
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.design_of_packs, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.title.setText(dataList.get(position).getTitle());
        Glide.with(holder.itemView)
                .load(dataList.get(position).getIcon())
                .into(holder.circleImageView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        TextView title;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.circleImageView);
            title = itemView.findViewById(R.id.title);

        }
    }
}
