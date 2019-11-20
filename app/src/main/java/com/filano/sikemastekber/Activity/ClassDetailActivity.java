package com.filano.sikemastekber.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;

import com.filano.sikemastekber.Adapter.ClassAdapter;
import com.filano.sikemastekber.Adapter.HomeAdapter;
import com.filano.sikemastekber.Model.Present;
import com.filano.sikemastekber.R;

import java.util.ArrayList;

public class ClassDetailActivity extends AppCompatActivity {

    ArrayList<Present> itemList;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ClassAdapter classAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_detail);
        itemList = new ArrayList<>();
        generateItemList();

        recyclerView = findViewById(R.id.rvDetail);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        classAdapter = new ClassAdapter(itemList, this);
        recyclerView.setAdapter(classAdapter);
    }

    private void generateItemList() {
        itemList.add(new Present("31 Jan", 1, 1));
        itemList.add(new Present("7 Feb", 2, 1));
        itemList.add(new Present("14 Feb", 3, 0));
        itemList.add(new Present("28 Feb", 4, 1));
        itemList.add(new Present("7 Apr", 5, 1));
        itemList.add(new Present("14 Apr", 6, 1));
        itemList.add(new Present("21 Apr", 7, 0));
        itemList.add(new Present("28 Apr", 8, 1));
        itemList.add(new Present("4 Apr", 9, 1));
        itemList.add(new Present("11 Apr", 10, 1));
        itemList.add(new Present("18 Apr", 11, 0));
//        itemList.add(new Present("25 Apr", 12, 1));
//        itemList.add(new Present("2 Mei", 13, 1));
//        itemList.add(new Present("9 Mei", 14, 1));
//        itemList.add(new Present("16 Mei", 15, 1));
//        itemList.add(new Present("23 Mei", 16, 1));
    }
}
