package com.filano.sikemastekber.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.filano.sikemastekber.Model.Course;
import com.filano.sikemastekber.Model.Kelas;
import com.filano.sikemastekber.Model.KelasActive;
import com.filano.sikemastekber.R;
import com.filano.sikemastekber.Response.KehadiranResponse;
import com.filano.sikemastekber.Retrofit.ApiClient;
import com.filano.sikemastekber.Retrofit.ApiInterface;
import com.filano.sikemastekber.SessionManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<KelasActive> itemList;
    private ApiInterface api;
    private SessionManager sessionManager;
    private Context context;

    public HomeAdapter(ArrayList<KelasActive> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
        api = ApiClient.getInstance().create(ApiInterface.class);
        sessionManager = new SessionManager(context);
    }

    public void setItemList(ArrayList<KelasActive> itemList) {
        this.itemList = itemList;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeAdapter.ViewHolder viewHolder, int i) {
        final KelasActive item = itemList.get(i);
        viewHolder.courseName.setText(item.getKelas().getNama());
        String jam = item.getJadwal().getJam_mulai() + " " + item.getJadwal().getJam_selesai();
        viewHolder.jam.setText(jam);
        viewHolder.ruang.setText(item.getRuangan().getNama());
        viewHolder.agenda.setText("UAS - Progress Final Project");

        if (item.getStatus_absen().equals(KelasActive.BELUM_ABSEN)) {
            viewHolder.btnAbsen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    api.absen(sessionManager.getToken(), item.getId()).enqueue(new Callback<KehadiranResponse>() {
                        @Override
                        public void onResponse(Call<KehadiranResponse> call, Response<KehadiranResponse> response) {
                            String status = response.body().getStatus();
                            if (status.equals("success")) {
                                viewHolder.btnAbsen.setBackground(context.getResources().getDrawable(R.drawable.button_style_disable, context.getTheme()));
                                viewHolder.btnAbsen.setEnabled(false);
                            }
                        }

                        @Override
                        public void onFailure(Call<KehadiranResponse> call, Throwable t) {

                        }
                    });
                }
            });
        } else {
            viewHolder.btnAbsen.setBackground(context.getResources().getDrawable(R.drawable.button_style_disable, context.getTheme()));
            viewHolder.btnAbsen.setEnabled(false);
        }

    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView courseName, jam, ruang, agenda;
        private Button btnAbsen;

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
