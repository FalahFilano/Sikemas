package com.filano.sikemastekber.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.filano.sikemastekber.Model.Course;
import com.filano.sikemastekber.Model.Kelas;
import com.filano.sikemastekber.R;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private ArrayList<Kelas> itemList;

    public ScheduleAdapter(ArrayList<Kelas> itemList) {
        this.itemList = itemList;
    }

    public void setItemList(ArrayList<Kelas> itemList) {
        this.itemList = itemList;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.schedule_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapter.ViewHolder viewHolder, int i) {
        Kelas item = itemList.get(i);
        viewHolder.courseName.setText(item.getNama());
        String jam = item.getJadwal().getJam_mulai() + " " + item.getJadwal().getJam_selesai();
        viewHolder.jam.setText(jam);
        viewHolder.ruang.setText(item.getRuangan().getNama());
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView courseName, jam, ruang;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseName = itemView.findViewById(R.id.tvName);
            jam = itemView.findViewById(R.id.tvJam);
            ruang = itemView.findViewById(R.id.tvRuang);
        }
    }
}
