package com.filano.sikemastekber.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.filano.sikemastekber.Activity.ClassDetailActivity;
import com.filano.sikemastekber.Model.Course;
import com.filano.sikemastekber.R;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private ArrayList<Course> itemList;

    public ScheduleAdapter(ArrayList<Course> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.schedule_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapter.ViewHolder viewHolder, int i) {
        final Course item = itemList.get(i);
        viewHolder.courseName.setText(item.getCourseName());
        viewHolder.jam.setText(item.getJam());
        viewHolder.ruang.setText(item.getRuang());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(item.getCourseName().equals("Rekayasa Kebutuhan E")){
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ClassDetailActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView courseName, jam, ruang;
        public CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            courseName = itemView.findViewById(R.id.tvName);
            jam = itemView.findViewById(R.id.tvJam);
            ruang = itemView.findViewById(R.id.tvRuang);
        }
    }
}
