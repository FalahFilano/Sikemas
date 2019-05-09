package com.filano.sikemastekber.Adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.filano.sikemastekber.Model.Course;
import com.filano.sikemastekber.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<Course> itemList;

    public HomeAdapter(ArrayList<Course> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder viewHolder, int i) {
        Course item = itemList.get(i);
        viewHolder.courseName.setText(item.getCourseName());
        viewHolder.jam.setText(item.getJam());
        viewHolder.ruang.setText(item.getRuang());
        viewHolder.agenda.setText(item.getAgenda());
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView courseName, jam, ruang, agenda;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseName = itemView.findViewById(R.id.tvName);
            jam = itemView.findViewById(R.id.tvJam);
            ruang = itemView.findViewById(R.id.tvRuang);
            agenda = itemView.findViewById(R.id.tvAgenda);
        }
    }
}
