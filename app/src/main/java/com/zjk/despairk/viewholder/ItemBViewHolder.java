package com.zjk.despairk.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;
import com.zjk.despairk.bean.ItemB;
import com.zjk.despairk.activity.R;
import com.zjk.despairk.bean.MessageData;

import org.greenrobot.eventbus.EventBus;

/**
 * com.zjk.despairk.viewholder
 * DespairK
 *
 * @author ZJK
 *         created at 2017/2/13 18:13
 *         功能:
 */
public class ItemBViewHolder extends EasyViewHolder<ItemB> {
    private TextView textView;
    private Context context;
    public ItemBViewHolder(Context context, ViewGroup parent) {
        super(context, parent, R.layout.item_b);
        this.context = context;
        textView = (TextView) itemView.findViewById(R.id.tv_item_b);
    }

    @Override
    public void bindTo(ItemB value) {
        if (value != null) {
            itemView.setTag(value);
            textView.setText(value.getListData());
            itemView.findViewById(R.id.ll).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().post(new MessageData());
                }
            });
        }
    }
}
