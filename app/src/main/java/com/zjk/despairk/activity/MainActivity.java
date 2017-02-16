package com.zjk.despairk.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.carlosdelachica.easyrecycleradapters.adapter.EasyRecyclerAdapter;
import com.zjk.despairk.bean.ItemB;
import com.zjk.despairk.bean.Title;
import com.zjk.despairk.data.FibonacciData;
import com.zjk.despairk.viewholder.ItemBViewHolder;
import com.zjk.despairk.viewholder.TitleViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EasyRecyclerAdapter recyclerViewAdapter = new EasyRecyclerAdapter(this);
    private int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv_recyclerview);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        initData();
        loadingData();
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visible = linearLayoutManager.getChildCount();
                int total = linearLayoutManager.getItemCount();
                int past = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                if ((visible + past) >= total) {
                    page++;
                    initData();
                }
            }
        });
    }

    private void loadingData() {
        recyclerViewAdapter.bind(Title.class, TitleViewHolder.class);
    }

    private void initData() {
        List<Object> list = new ArrayList<>();

        for (int i = page * 50; i < (page + 1) * 50; i++) {
            list.add(new Title(new FibonacciData().getNthNumber1(i * i)));
        }
        recyclerViewAdapter.appendAll(list);
    }

}
