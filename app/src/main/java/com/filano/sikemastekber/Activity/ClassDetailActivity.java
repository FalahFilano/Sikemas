package com.filano.sikemastekber.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.filano.sikemastekber.Adapter.ClassAdapter;
import com.filano.sikemastekber.Model.KelasActive;
import com.filano.sikemastekber.R;
import com.filano.sikemastekber.Response.ListKelasActiveResponse;
import com.filano.sikemastekber.Retrofit.ApiClient;
import com.filano.sikemastekber.Retrofit.ApiInterface;
import com.filano.sikemastekber.SessionManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassDetailActivity extends AppCompatActivity {

    ArrayList<KelasActive> itemList;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ClassAdapter classAdapter;
    private TextView tvNamaKelas, tvJam, tvRuang;

    private ApiInterface api;
    private SessionManager sessionManager;
    private Integer kelas_id;
    private String kelas_nama, kelas_jam, kelas_ruangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_detail);
        api = ApiClient.getInstance().create(ApiInterface.class);
        sessionManager = new SessionManager(this);

        kelas_id = getIntent().getIntExtra("kelas_id", -1);
        kelas_nama = getIntent().getStringExtra("kelas_nama");
        kelas_jam = getIntent().getStringExtra("kelas_jam");
        kelas_ruangan = getIntent().getStringExtra("kelas_ruangan");

        tvNamaKelas = findViewById(R.id.tvNamaKelas);
        tvJam = findViewById(R.id.tvJam);
        tvRuang = findViewById(R.id.tvRuang);

        tvNamaKelas.setText(kelas_nama);
        tvJam.setText(kelas_jam);
        tvRuang.setText(kelas_ruangan);

        itemList = new ArrayList<>();
        generateItemList();

        recyclerView = findViewById(R.id.rvCourseDetail);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        classAdapter = new ClassAdapter(itemList, this);
        recyclerView.setAdapter(classAdapter);
    }

    private void generateItemList() {
        api.getDetailKehadiran(sessionManager.getToken(), kelas_id).enqueue(new Callback<ListKelasActiveResponse>() {
            @Override
            public void onResponse(Call<ListKelasActiveResponse> call, Response<ListKelasActiveResponse> response) {
                String status = response.body().getStatus();

                if (status.equals("success")) {
                    itemList = response.body().getListKelas();
                    classAdapter.setItemList(itemList);
                }
            }

            @Override
            public void onFailure(Call<ListKelasActiveResponse> call, Throwable t) {

            }
        });
    }
}
