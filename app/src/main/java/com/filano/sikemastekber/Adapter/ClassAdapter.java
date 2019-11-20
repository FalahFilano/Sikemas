package com.filano.sikemastekber.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.filano.sikemastekber.Model.Present;
import com.filano.sikemastekber.R;

import java.util.ArrayList;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {


    private ArrayList<Present> itemList;
    private Context context;

    public ClassAdapter(ArrayList<Present> itemList, Context context){
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ClassAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.class_mhs_item, viewGroup, false);
        return new ClassAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ClassAdapter.ViewHolder viewHolder, int i) {
        Present item = itemList.get(i);
        viewHolder.tgl.setText(item.getDate());
        viewHolder.pertemuan.setText(String.valueOf(item.getPertemuan()));
        switch (item.getStatusKehadiran()){
            case 0:{
                viewHolder.kehadiran.setText("Absen");
                viewHolder.kehadiran.setBackground(context.getDrawable(R.color.white));
                Log.d("TAG", "onBindViewHolder: ");
                break;
            }
            case 1: viewHolder.kehadiran.setText("Hadir"); break;
        }
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tgl, pertemuan, kehadiran;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tgl = itemView.findViewById(R.id.tvTglPertemuan);
            pertemuan = itemView.findViewById(R.id.tvPertemuan);
            kehadiran = itemView.findViewById(R.id.tvStatusKehadiran);

        }
    }
}
