package com.example.sojun_project.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sojun_project.Datas.ItemData;
import com.example.sojun_project.R;
import com.example.sojun_project.fragments.SimpleTextAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GimoringAdapter extends RecyclerView.Adapter<GimoringAdapter.ViewHolder> {

    private ArrayList<ItemData> mData=null;

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, kalori, howmuch;
        ImageView profile;
        public ViewHolder(final View itemView){
            super(itemView);
            name=itemView.findViewById(R.id.fooditem_foodname);
            kalori=itemView.findViewById(R.id.fooditem_kalori);
            howmuch=itemView.findViewById(R.id.fooditem_howmuch);
            profile=itemView.findViewById(R.id.fooditem_foodimg);
        }
    }

    GimoringAdapter(ArrayList<ItemData> list){
        mData=list;
    }

    @Override
    public GimoringAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fooditem, parent, false);
        return new GimoringAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull GimoringAdapter.ViewHolder viewHolder, int i) {
        ItemData item =mData.get(i);
        viewHolder.name.setText(item.getFoodname());
        viewHolder.kalori.setText(item.getFoodkalori());
        viewHolder.howmuch.setText(item.getFoodhowmuch());
        viewHolder.profile.setImageDrawable(item.getFoodimg());
    }
    @Override// 그거 아니야 형 ㅅㅂ
    public int getItemCount() {
        return mData.size();
    }

    public void updateData(ArrayList<ItemData> itemData){
        mData.clear();
        mData.addAll(itemData);
        notifyDataSetChanged();
    }
}
