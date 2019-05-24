package com.filano.sikemastekber.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.filano.sikemastekber.Helper.Tanggal;
import com.filano.sikemastekber.Model.KelasActive;
import com.filano.sikemastekber.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ViewHolder> {


    private ArrayList<KelasActive> itemList;
    private Context context;

    public ClassAdapter(ArrayList<KelasActive> itemList, Context context){
        this.itemList = itemList;
        this.context = context;
    }

    public void setItemList(ArrayList<KelasActive> itemList) {
        this.itemList = itemList;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ClassAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.class_mhs_item, viewGroup, false);
        return new ClassAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ClassAdapter.ViewHolder viewHolder, int i) {
        KelasActive item = itemList.get(i);
        viewHolder.tgl.setText(Tanggal.dateFormater(item.getCreated_at(), "YYYY-MM-dd HH:mm:ss", "dd/MM"));
        viewHolder.pertemuan.setText(String.valueOf(item.getPertemuan()));
        switch (item.getStatus_absen()){
            case 0:
                viewHolder.kehadiran.setText("Absen");
                viewHolder.kehadiran.setBackground(context.getDrawable(R.color.white));
                break;

            case 1:
                viewHolder.kehadiran.setText("Hadir");
                break;
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
