package com.filano.sikemastekber.Fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.filano.sikemastekber.Adapter.ScheduleAdapter;
import com.filano.sikemastekber.Model.Course;
import com.filano.sikemastekber.Model.Kelas;
import com.filano.sikemastekber.R;
import com.filano.sikemastekber.Response.KelasResponse;
import com.filano.sikemastekber.Retrofit.ApiClient;
import com.filano.sikemastekber.Retrofit.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleRecyclerFragment extends android.support.v4.app.Fragment {

    ArrayList<Kelas> itemList;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ScheduleAdapter scheduleAdapter;

    private ApiInterface api;
    private String hari;

    public ScheduleRecyclerFragment(){ }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment_schedule_recycler

        api = ApiClient.getInstance().create(ApiInterface.class);
        hari = getArguments().getString("hari", "senin");

        itemList = new ArrayList<>();
        generateItemList();

        View rootView = inflater.inflate(R.layout.fragment_schedule_recycler, container, false);

        recyclerView = rootView.findViewById(R.id.rvSchedule);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        scheduleAdapter = new ScheduleAdapter(itemList);
        recyclerView.setAdapter(scheduleAdapter);

        return rootView;
    }

    private void generateItemList() {
        api.getKelas(hari).enqueue(new Callback<KelasResponse>() {
            @Override
            public void onResponse(Call<KelasResponse> call, Response<KelasResponse> response) {
                itemList = response.body().getListKelas();
                scheduleAdapter.setItemList(itemList);
            }

            @Override
            public void onFailure(Call<KelasResponse> call, Throwable t) {

            }
        });
    }
}
