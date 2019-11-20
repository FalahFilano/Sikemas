package com.filano.sikemastekber.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.filano.sikemastekber.Activity.BluetoothActivity;
import com.filano.sikemastekber.Fragment.HomeFragment;
import com.filano.sikemastekber.Model.Course;
import com.filano.sikemastekber.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<Course> itemList;
    private Context context;

    public HomeAdapter(ArrayList<Course> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;

    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeAdapter.ViewHolder viewHolder, int i) {
        Course item = itemList.get(i);
        viewHolder.courseName.setText(item.getCourseName());
        viewHolder.jam.setText(item.getJam());
        viewHolder.ruang.setText(item.getRuang());
        viewHolder.agenda.setText(item.getAgenda());
        viewHolder.btnAbsen.setText(item.getBtnLabel());
        if(item.getBtnStatus()== 0){
            viewHolder.btnAbsen.setBackground(context.getResources().getDrawable(R.drawable.button_style_disable, context.getTheme()));
            viewHolder.btnAbsen.setEnabled(false);
        }
        viewHolder.btnAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, BluetoothActivity.class);
                context.startActivity(intent);
                viewHolder.btnAbsen.setBackground(context.getResources().getDrawable(R.drawable.button_style_disable, context.getTheme()));
                viewHolder.btnAbsen.setEnabled(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView courseName, jam, ruang, agenda;
        public Button btnAbsen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseName = itemView.findViewById(R.id.tvName);
            jam = itemView.findViewById(R.id.tvJam);
            ruang = itemView.findViewById(R.id.tvRuang);
            agenda = itemView.findViewById(R.id.tvAgenda);
            btnAbsen = itemView.findViewById(R.id.btnAbsen);

        }
    }
}
