package com.example.sojun_project.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sojun_project.Datas.ItemData;
import com.example.sojun_project.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.ViewHolder> {


    private ArrayList<ItemData> mData=null;

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView food_name,food_kalori,food_howmuch;
        ImageView food_imageView;
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
                        int pos = getAdapterPosition() ;
                        if (pos != RecyclerView.NO_POSITION) {

                        }
                    }
                    else {  int pos = getAdapterPosition() ;
                        if (pos != RecyclerView.NO_POSITION) {
                            // TODO : use pos.
                            howmany--;
                            food_howmuch.setText(String.valueOf(howmany));
                        }
                    }
                }
            });
    }
    }

    SimpleTextAdapter(ArrayList<ItemData> list){
        mData=list;
    }

    @Override
    public SimpleTextAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View  view=LayoutInflater.from(parent.getContext()).inflate(R.layout.fooditem, parent, false);
        return new SimpleTextAdapter.ViewHolder(view);
    }
    //형 시발 난 진짜 개 병신인가봐 병신이냐?어댑터 좆같이 짜놓고 아니 내가 이거 set하는걸 처 안짜놯네 지금보니깐
    //이샛기 진짜 대가리 박고 자살이 답인듯 진짜 시발 좆같노 ㅇㅇㅇ ㅂㅂㅂ
    @Override
    public void onBindViewHolder(@NonNull SimpleTextAdapter.ViewHolder viewHolder, int i) {
        ItemData item =mData.get(i);
        viewHolder.food_name.setText(item.getFoodname());
        viewHolder.food_kalori.setText(item.getFoodkalori());
        viewHolder.food_howmuch.setText(item.getFoodhowmuch());
        viewHolder.food_imageView.setImageDrawable(item.getFoodimg());
    }
    @Override// 그거 아니야 형 ㅅㅂ
    public int getItemCount() {
        return mData.size();
    }
}


