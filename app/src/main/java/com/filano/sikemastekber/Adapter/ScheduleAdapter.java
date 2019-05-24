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
import com.filano.sikemastekber.Model.Kelas;
import com.filano.sikemastekber.R;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private ArrayList<Kelas> itemList;
    private Context context;

    public ScheduleAdapter(ArrayList<Kelas> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
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
        final Kelas item = itemList.get(i);
        viewHolder.courseName.setText(item.getNama());
        final String jam = item.getJadwal().getJam_mulai() + " " + item.getJadwal().getJam_selesai();
        viewHolder.jam.setText(jam);
        viewHolder.ruang.setText(item.getRuangan().getNama());
        
        viewHolder.cvSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ClassDetailActivity.class);
                intent.putExtra("kelas_id", item.getId());
                intent.putExtra("kelas_nama", item.getNama());
                intent.putExtra("kelas_jam", jam);
                intent.putExtra("kelas_ruangan", item.getRuangan().getNama());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView courseName, jam, ruang;
        private CardView cvSchedule;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseName = itemView.findViewById(R.id.tvName);
            jam = itemView.findViewById(R.id.tvJam);
            ruang = itemView.findViewById(R.id.tvRuang);
            cvSchedule = itemView.findViewById(R.id.cvSchedule);
        }
    }
}
