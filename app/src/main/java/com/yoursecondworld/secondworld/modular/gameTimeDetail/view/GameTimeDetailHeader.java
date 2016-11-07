package com.yoursecondworld.secondworld.modular.gameTimeDetail.view;

import android.content.Context;
import android.view.View;

import com.yoursecondworld.secondworld.R;

/**
 * Created by cxj on 2016/10/31.
 * 游戏时间详情的Header
 */
public class GameTimeDetailHeader {

    /**
     * 初始化视图
     *
     * @param mContext 上下文
     * @return
     */
    public View init(Context mContext) {

        View contentView = View.inflate(mContext, R.layout.act_game_time_detail_header, null);

        return contentView;

    }

}
