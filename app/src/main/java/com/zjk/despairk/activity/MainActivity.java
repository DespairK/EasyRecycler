package com.zjk.despairk.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.carlosdelachica.easyrecycleradapters.adapter.EasyRecyclerAdapter;
import com.zjk.despairk.bean.ItemB;
import com.zjk.despairk.bean.Title;
import com.zjk.despairk.viewholder.ItemBViewHolder;
import com.zjk.despairk.viewholder.TitleViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Object> list = new ArrayList<>();
    private EasyRecyclerAdapter recyclerViewAdapter = new EasyRecyclerAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv_recyclerview);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        initData();
        loadingData();
        recyclerViewAdapter.addAll(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void loadingData() {
        recyclerViewAdapter.bind(Title.class, TitleViewHolder.class);
        recyclerViewAdapter.bind(ItemB.class, ItemBViewHolder.class);
    }

    private void initData() {
        list.add(new Title("我就是itemA"));
        List<String> lisData = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            lisData.add("我是ItemB第" + i + "个");
        }
        list.add(new ItemB(lisData));
    }
}
