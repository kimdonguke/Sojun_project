package com.example.sojun_project;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.ViewHolder> {
    TextView food_name,food_kalori,food_howmuch;
    ImageView food_imageView;
    public  class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(final View itemView){
            super(itemView);
            food_name=itemView.findViewById(R.id.fooditem_foodname);
            food_kalori=itemView.findViewById(R.id.fooditem_kalori);
            food_imageView=itemView.findViewById(R.id.fooditem_foodimg);
            food_howmuch=itemView.findViewById(R.id.fooditem_howmuch);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int howmany=Integer.parseInt(food_howmuch.getText().toString());
                    if(howmany==1){

                    }
                    else {
                        howmany--;
                        food_howmuch.setText(String.valueOf(howmany));
                    }
                }
            });
        }
    }
    private ArrayList<Data> mData=null;
    SimpleTextAdapter(ArrayList<Data> list){
        mData=list;
    }

    @Override
    public SimpleTextAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View  view=LayoutInflater.from(parent.getContext()).inflate(R.layout.fooditem, parent, false);
        return new SimpleTextAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleTextAdapter.ViewHolder viewHolder, int i) {
        Data item =mData.get(i);
    }

    @Override// 그거 아니야 형 ㅅㅂ
    public int getItemCount() {
        return mData.size();
    }
}


