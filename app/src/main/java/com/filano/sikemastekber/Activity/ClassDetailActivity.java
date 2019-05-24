package com.filano.sikemastekber.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.filano.sikemastekber.Adapter.ClassAdapter;
import com.filano.sikemastekber.Model.KelasActive;
import com.filano.sikemastekber.R;

import java.util.ArrayList;

public class ClassDetailActivity extends AppCompatActivity {

    ArrayList<KelasActive> itemList;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ClassAdapter classAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_detail);
        itemList = new ArrayList<>();
        generateItemList();

        recyclerView = findViewById(R.id.rvCourseDetail);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        classAdapter = new ClassAdapter(itemList, this);
        recyclerView.setAdapter(classAdapter);
    }

    private void generateItemList() {
    }
}
