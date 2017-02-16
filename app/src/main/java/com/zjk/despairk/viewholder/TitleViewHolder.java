package com.zjk.despairk.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;
import com.zjk.despairk.bean.Title;
import com.zjk.despairk.activity.R;

import java.math.BigInteger;
import java.text.DecimalFormat;

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
            String style = "0.00E000";
            DecimalFormat df = new DecimalFormat();
            df.applyPattern(style);
            Double max = Math.pow(10, 10);
            if (value.getBigInteger().compareTo(BigInteger.valueOf(max.intValue())) < 0) {
                tvTitle.setText(value.getBigInteger().toString());
            } else {
                tvTitle.setText(df.format(value.getBigInteger()));
            }
        }
    }
}
