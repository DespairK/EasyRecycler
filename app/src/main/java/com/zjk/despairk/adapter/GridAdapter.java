package com.zjk.despairk.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zjk.despairk.test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * com.zjk.despairk.adapter
 * DespairK
 *
 * @author ZJK
 *         created at 2017/2/13 18:18
 *         功能:
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    private Context context;
    private final LayoutInflater layoutInflater;
    private List<String> listData = new ArrayList<>();
    public GridAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setListData(List<String> listData) {
        this.listData.clear();
        this.listData = listData;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GridViewHolder(layoutInflater.inflate(R.layout.item_b_item, parent, false));
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        holder.textView.setText(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public GridViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item_b_text);
        }
    }
}
