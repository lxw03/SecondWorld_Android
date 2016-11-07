package com.yoursecondworld.secondworld.modular.main.popupWindow.postDynamics;

import android.content.Context;
import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yoursecondworld.secondworld.MyApp;
import com.yoursecondworld.secondworld.R;
import com.yoursecondworld.secondworld.common.GameLabelResIdMapper;
import com.yoursecondworld.secondworld.modular.systemInfo.entity.GameLabel;

import java.util.List;

import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewAdapter;
import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewHolder;

/**
 * Created by cxj on 2016/7/13.
 */
public class SelectGameAdapter extends CommonRecyclerViewAdapter<String> {

    /**
     * 构造函数
     *
     * @param context 上下文
     * @param data    显示的数据
     */
    public SelectGameAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public void convert(CommonRecyclerViewHolder h, String entity, int position) {

        SimpleDraweeView icon = h.getView(R.id.iv_act_main_popupwindow_select_game_and_topic_item_icon);
        Integer resId = GameLabelResIdMapper.mapper.get(entity + "_big");
        if (resId != null) {
            icon.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(resId)).build());
        }

        h.setText(R.id.tv_act_main_popupwindow_select_game_and_topic_item_name, entity);

    }

    @Override
    public int getLayoutViewId(int viewType) {
        return R.layout.act_main_popupwindow_select_game_and_topic_item;
    }
}
