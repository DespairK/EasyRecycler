package com.zjk.despairk.viewholder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;
import com.zjk.despairk.adapter.GridAdapter;
import com.zjk.despairk.bean.ItemB;
import com.zjk.despairk.activity.R;

/**
 * com.zjk.despairk.viewholder
 * DespairK
 *
 * @author ZJK
 *         created at 2017/2/13 18:13
 *         功能:
 */
public class ItemBViewHolder extends EasyViewHolder<ItemB> {
    private RecyclerView recyclerView;
    private Context context;
    public ItemBViewHolder(Context context, ViewGroup parent) {
        super(context, parent, R.layout.item_b);
        this.context = context;
        recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_item_b_recyclerview);
    }

    @Override
    public void bindTo(ItemB value) {
        if (value != null) {
            //改下面这个参数，要几列有几列
            GridLayoutManager layoutManager = new GridLayoutManager(this.context, 2);
            GridAdapter gridAdapter = new GridAdapter(context);
            gridAdapter.setListData(value.getListData());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(gridAdapter);
        }
    }
}
