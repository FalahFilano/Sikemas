package com.filano.sikemastekber.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.filano.sikemastekber.Adapter.DosenHomeAdapter;
import com.filano.sikemastekber.Adapter.HomeAdapter;
import com.filano.sikemastekber.Helper.Tanggal;
import com.filano.sikemastekber.Model.KelasActive;
import com.filano.sikemastekber.R;
import com.filano.sikemastekber.Response.KelasActiveResponse;
import com.filano.sikemastekber.Retrofit.ApiClient;
import com.filano.sikemastekber.Retrofit.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenHomeFragment extends Fragment {

    ArrayList<KelasActive> itemList;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DosenHomeAdapter homeAdapter;
    private TextView tvTanggal;

    ApiInterface api;

    public DosenHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        api = ApiClient.getInstance().create(ApiInterface.class);

        itemList = new ArrayList<>();
        generateItemList();

        View rootView = inflater.inflate(R.layout.fragment_dosen_home, container, false);

        tvTanggal = rootView.findViewById(R.id.tvTangal);
        tvTanggal.setText(Tanggal.getDate());

        recyclerView = rootView.findViewById(R.id.rvCourse);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        homeAdapter = new DosenHomeAdapter(itemList);
        recyclerView.setAdapter(homeAdapter);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        return rootView;
    }

    private void generateItemList() {
        api.getKelasActive().enqueue(new Callback<KelasActiveResponse>() {
            @Override
            public void onResponse(Call<KelasActiveResponse> call, Response<KelasActiveResponse> response) {
                itemList = response.body().getListKelas();
                homeAdapter.setItemList(itemList);
            }

            @Override
            public void onFailure(Call<KelasActiveResponse> call, Throwable t) {
//                Toast.makeText(getContext(), "Failed.", Toast.LENGTH_SHORT).show();
                Log.d("Failed", t.getMessage().toString());
            }
        });
    }


}