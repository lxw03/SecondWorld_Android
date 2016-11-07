package com.yoursecondworld.secondworld.modular.main.popupWindow.postDynamics;

import android.content.Context;
import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yoursecondworld.secondworld.R;
import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.modular.main.popupWindow.postDynamics.entity.TopicEntity;

import java.util.List;

import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewAdapter;
import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewHolder;

/**
 * Created by cxj on 2016/7/13.
 * 选择话题的页面的适配器
 */
public class SelectTopicAdapter extends CommonRecyclerViewAdapter<TopicEntity> {

    /**
     * 构造函数
     *
     * @param context 上下文
     * @param data    显示的数据
     */
    public SelectTopicAdapter(Context context, List<TopicEntity> data) {
        super(context, data);
    }

    @Override
    public void convert(CommonRecyclerViewHolder h, TopicEntity entity, int position) {
        SimpleDraweeView icon = h.getView(R.id.iv_act_main_popupwindow_select_game_and_topic_item_icon);
        icon.setImageURI(Uri.parse(Constant.FRESCO_LOCALIMAGE_PREFIX + entity.getImageRsd()));
        h.setTextAndColor(R.id.tv_act_main_popupwindow_select_game_and_topic_item_name, entity.getName(),entity.getNameColor());
    }

    @Override
    public int getLayoutViewId(int viewType) {
        return R.layout.act_main_popupwindow_select_game_and_topic_item;
    }
}
