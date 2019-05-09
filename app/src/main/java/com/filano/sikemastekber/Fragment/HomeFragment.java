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

        homeAdapter = new HomeAdapter(itemList);
        recyclerView.setAdapter(homeAdapter);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        return rootView;
    }

    private void generateItemList() {
        itemList.add(new Course("Pemrograman Jaringan", "08.00 - 10.30", "IF - 102", "UAS - Progress Final Project", 7));
        itemList.add(new Course("Teknologi Bergerak", "13.00 - 15.30", "Ruang SI", "UAS - Progress Final Project", 8));
        itemList.add(new Course("Rekayasa Kebutuhan", "15.30 - 18.00", "IF - 106", "UAS - Progress Final Project", 8));
        itemList.add(new Course("Animasi Komputer dan Permodelan 3D", "15.30 - 18.00", "IF - 106", "bersama ericko", 8));
    }


}
