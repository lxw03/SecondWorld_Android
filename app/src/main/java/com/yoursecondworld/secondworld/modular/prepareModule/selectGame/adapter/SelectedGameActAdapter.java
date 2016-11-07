package com.yoursecondworld.secondworld.modular.prepareModule.selectGame.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yoursecondworld.secondworld.MyApp;
import com.yoursecondworld.secondworld.R;
import com.yoursecondworld.secondworld.common.GameLabelResIdMapper;
import com.yoursecondworld.secondworld.modular.systemInfo.entity.GameLabel;

import java.util.List;

import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewAdapter;
import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewHolder;

/**
 * Created by cxj on 2016/7/5.
 */
public class SelectedGameActAdapter extends CommonRecyclerViewAdapter<String> {


    /**
     * 构造函数
     *
     * @param context 上下文
     * @param data    显示的数据
     */
    public SelectedGameActAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public void convert(CommonRecyclerViewHolder h, String entity, int position) {
        h.setText(R.id.tv_flow_label_game_name, entity);
        SimpleDraweeView icon = h.getView(R.id.iv_flow_label_item_icon);
        Integer resId = GameLabelResIdMapper.mapper.get(entity);
        if (resId != null) {
            icon.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(resId)).build());
        }
    }

    @Override
    public int getLayoutViewId(int viewType) {
        return R.layout.act_select_game_flow_label_item;
    }
}
