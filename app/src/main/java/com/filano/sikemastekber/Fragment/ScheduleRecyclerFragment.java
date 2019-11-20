package com.filano.sikemastekber.Fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.filano.sikemastekber.Adapter.ScheduleAdapter;
import com.filano.sikemastekber.Model.Course;
import com.filano.sikemastekber.R;

import java.util.ArrayList;

public class ScheduleRecyclerFragment extends android.support.v4.app.Fragment {

    ArrayList<Course> itemList;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ScheduleAdapter scheduleAdapter;

    public ScheduleRecyclerFragment(){ }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment_schedule_recycler
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
        itemList.add(new Course("Pemrograman Jaringan F", "08.00 - 10.30", "LP 2", "Tugas 4 & Tugas 5", 0, "Kelas Berakhir"));
        itemList.add(new Course("Rekayasa Kebutuhan E", "13.00 - 15.30", "IF - 106", "Demo Final Project", 1, "Absen"));
        itemList.add(new Course("Animasi Komputer dan Permodelan 3D", "15.30 - 18.00", "IF - 106", "Presentasi dan pengumpulan PPT", 0, "Kelas Belum Dimulai"));
        itemList.add(new Course("Pra TA", "-", "-", "Proposal TA", 0, "Kelas Berakhir"));
    }
}
