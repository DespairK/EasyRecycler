package com.zjk.despairk.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;
import com.zjk.despairk.bean.Title;
import com.zjk.despairk.activity.R;

/**
 * com.zjk.despairk.viewholder
 * DespairK
 *
 * @author ZJK
 *         created at 2017/2/13 17:51
 *         功能:
 */
public class TitleViewHolder extends EasyViewHolder<Title> {
    private TextView tvTitle;
    private Context context;

    public TitleViewHolder(Context context, ViewGroup parent) {
        super(context, parent, R.layout.title_layout);
        this.context = context;
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }

    @Override
    public void bindTo(Title value) {
        if (value != null) {
            itemView.setTag(value);
            tvTitle.setText(value.getTitle());
        }
    }
}
