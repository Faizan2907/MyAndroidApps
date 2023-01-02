package com.example.mygalleryapp2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<DataModel> arrayList;

    public MyAdapter(ArrayList<DataModel> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataModel dataModel = arrayList.get(position);
        holder.mimageView.setImageResource(dataModel.getImageResource());
        holder.mtextView.setText(dataModel.getImageName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mimageView;
        TextView mtextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mimageView = itemView.findViewById(R.id.imageView);
            mtextView = itemView.findViewById(R.id.textView);

        }
    }
}
