package com.zjk.despairk.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.carlosdelachica.easyrecycleradapters.adapter.EasyRecyclerAdapter;
import com.zjk.despairk.bean.ItemB;
import com.zjk.despairk.bean.MessageData;
import com.zjk.despairk.bean.Title;
import com.zjk.despairk.data.FibonacciData;
import com.zjk.despairk.viewholder.ItemBViewHolder;
import com.zjk.despairk.viewholder.TitleViewHolder;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EasyRecyclerAdapter recyclerViewAdapter = new EasyRecyclerAdapter(this);
    private int page = 0;
    private int lastPage = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        recyclerView = (RecyclerView) findViewById(R.id.rv_recyclerview);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        initData();
        loadingData();
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void loadingData() {
        recyclerViewAdapter.bind(Title.class, TitleViewHolder.class);
        recyclerViewAdapter.bind(ItemB.class, ItemBViewHolder.class);
    }

    private void initData() {
        data();
    }

    private void data() {
        List<Object> list = new ArrayList<>();
        for (int i = page * 50; i < (page + 1) * 50; i++) {
            list.add(new Title(new FibonacciData().getNthNumber1(i * i)));
        }
        list.add(new ItemB("加载更多"));
        Message message = new Message();
        message.what = 1;
        message.obj = list;
        handler.sendMessage(message);
    }

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            // handler接收到消息后就会执行此方法
            switch (msg.what) {
                case 1:
                    lastPage = page;
                    page++;
                    recyclerViewAdapter.appendAll((List<String>) msg.obj);
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @org.greenrobot.eventbus.Subscribe
    public void onEvent(MessageData event) {
        if (event != null) {
            synchronized(this) {
                if (lastPage == page -1) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            data();
                        }
                    }).start();
                }

            }
        }
    }

}
