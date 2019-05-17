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
import android.widget.Toast;

import com.filano.sikemastekber.Adapter.DosenHomeAdapter;
import com.filano.sikemastekber.Adapter.HomeAdapter;
import com.filano.sikemastekber.Helper.Tanggal;
import com.filano.sikemastekber.Model.Kelas;
import com.filano.sikemastekber.Model.KelasActive;
import com.filano.sikemastekber.R;
import com.filano.sikemastekber.Response.KelasActiveResponse;
import com.filano.sikemastekber.Response.KelasResponse;
import com.filano.sikemastekber.Retrofit.ApiClient;
import com.filano.sikemastekber.Retrofit.ApiInterface;
import com.filano.sikemastekber.SessionManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenHomeFragment extends Fragment {

    ArrayList<Kelas> itemList;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DosenHomeAdapter homeAdapter;
    private TextView tvTanggal;

    private SessionManager sessionManager;
    private ApiInterface api;

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
        sessionManager = new SessionManager(getContext());

        Log.d("test", "halo");

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
        api.getKelasDosen(sessionManager.getToken(), Tanggal.hari()).enqueue(new Callback<KelasResponse>() {
            @Override
            public void onResponse(Call<KelasResponse> call, Response<KelasResponse> response) {
                itemList = response.body().getListKelas();
                homeAdapter.setItemList(itemList);
            }

            @Override
            public void onFailure(Call<KelasResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Failed.", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
