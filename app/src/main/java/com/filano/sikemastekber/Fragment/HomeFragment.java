package com.filano.sikemastekber.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.filano.sikemastekber.Adapter.HomeAdapter;
import com.filano.sikemastekber.Model.Course;
import com.filano.sikemastekber.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    ArrayList<Course> itemList;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private HomeAdapter homeAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        itemList = new ArrayList<>();
        generateItemList();

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = rootView.findViewById(R.id.rvCourse);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        homeAdapter = new HomeAdapter(itemList, getContext());
        recyclerView.setAdapter(homeAdapter);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        return rootView;
    }

    private void generateItemList() {
        itemList.add(new Course("Pemrograman Jaringan F", "08.00 - 10.30", "LP 2", "Tugas 4 & Tugas 5", 0, "Kelas Berakhir"));
        itemList.add(new Course("Rekayasa Kebutuhan E", "13.00 - 15.30", "IF - 106", "Demo Final Project", 1, "Absen"));
        itemList.add(new Course("Animasi Komputer dan Permodelan 3D", "15.30 - 18.00", "IF - 106", "Presentasi dan pengumpulan PPT", 0, "Kelas Belum Dimulai"));
    }


}
