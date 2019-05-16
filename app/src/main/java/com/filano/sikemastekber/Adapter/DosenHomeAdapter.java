package com.filano.sikemastekber.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.filano.sikemastekber.Model.KelasActive;
import com.filano.sikemastekber.R;

import java.util.ArrayList;

public class DosenHomeAdapter extends RecyclerView.Adapter<DosenHomeAdapter.ViewHolder> {
    private ArrayList<KelasActive> itemList;

    public DosenHomeAdapter(ArrayList<KelasActive> itemList) {
        this.itemList = itemList;
    }

    public void setItemList(ArrayList<KelasActive> itemList) {
        this.itemList = itemList;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DosenHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dosen_course_item, viewGroup, false);
        return new DosenHomeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DosenHomeAdapter.ViewHolder viewHolder, int i) {
        KelasActive item = itemList.get(i);
        viewHolder.courseName.setText(item.getKelas().getNama());
        String jam = item.getJadwal().getJam_mulai() + " " + item.getJadwal().getJam_selesai();
        viewHolder.jam.setText(jam);
        viewHolder.ruang.setText(item.getRuangan().getNama());
        viewHolder.agenda.setText("UAS - Progress Final Project");
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
