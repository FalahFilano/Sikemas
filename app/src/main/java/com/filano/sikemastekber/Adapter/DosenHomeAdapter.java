package com.filano.sikemastekber.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.filano.sikemastekber.Model.Kelas;
import com.filano.sikemastekber.Model.KelasActive;
import com.filano.sikemastekber.R;
import com.filano.sikemastekber.Response.KelasActiveResponse;
import com.filano.sikemastekber.Retrofit.ApiClient;
import com.filano.sikemastekber.Retrofit.ApiInterface;
import com.filano.sikemastekber.SessionManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenHomeAdapter extends RecyclerView.Adapter<DosenHomeAdapter.ViewHolder> {
    private ArrayList<Kelas> itemList;
    private ApiInterface api;
    private SessionManager sessionManager;
    private Context context;

    public DosenHomeAdapter(ArrayList<Kelas> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
        api = ApiClient.getInstance().create(ApiInterface.class);
        sessionManager = new SessionManager(context);
    }

    public void setItemList(ArrayList<Kelas> itemList) {
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
    public void onBindViewHolder(@NonNull final DosenHomeAdapter.ViewHolder viewHolder, int i) {
        final Kelas item = itemList.get(i);
        viewHolder.courseName.setText(item.getNama());
        String jam = item.getJadwal().getJam_mulai() + " " + item.getJadwal().getJam_selesai();
        viewHolder.jam.setText(jam);
        viewHolder.ruang.setText(item.getRuangan().getNama());
        viewHolder.agenda.setText("UAS - Progress Final Project");

        if (item.getStatus().equals(Kelas.BELUM_AKTIF)) {
            viewHolder.btnAktifkan.setText("Aktifkan");
            viewHolder.btnAktifkan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    api.aktifkanKelas(sessionManager.getToken(), item.getId()).enqueue(new Callback<KelasActiveResponse>() {
                        @Override
                        public void onResponse(Call<KelasActiveResponse> call, Response<KelasActiveResponse> response) {
                            String status = response.body().getStatus();
                            if (status.equals("success")) {
                                viewHolder.btnAktifkan.setText("Matikan");
                            }
                        }

                        @Override
                        public void onFailure(Call<KelasActiveResponse> call, Throwable t) {

                        }
                    });
                }
            });
        } else if (item.getStatus().equals(Kelas.AKTIF)) {
            viewHolder.btnAktifkan.setText("Matikan");
            viewHolder.btnAktifkan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    api.matikanKelas(sessionManager.getToken(), item.getId()).enqueue(new Callback<KelasActiveResponse>() {
                        @Override
                        public void onResponse(Call<KelasActiveResponse> call, Response<KelasActiveResponse> response) {
                            String status = response.body().getStatus();
                            if (status.equals("success")) {
                                viewHolder.btnAktifkan.setText("Selesai");
                                viewHolder.btnAktifkan.setEnabled(false);
                            }
                        }

                        @Override
                        public void onFailure(Call<KelasActiveResponse> call, Throwable t) {

                        }
                    });
                }
            });
        } else {
            viewHolder.btnAktifkan.setBackground(context.getResources().getDrawable(R.drawable.button_style_disable, context.getTheme()));
            viewHolder.btnAktifkan.setText("Selesai");
            viewHolder.btnAktifkan.setEnabled(false);
        }
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView courseName, jam, ruang, agenda;
        public Button btnAktifkan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseName = itemView.findViewById(R.id.tvName);
            jam = itemView.findViewById(R.id.tvJam);
            ruang = itemView.findViewById(R.id.tvRuang);
            agenda = itemView.findViewById(R.id.tvAgenda);
            btnAktifkan = itemView.findViewById(R.id.btnAktifkan);
        }
    }
}
