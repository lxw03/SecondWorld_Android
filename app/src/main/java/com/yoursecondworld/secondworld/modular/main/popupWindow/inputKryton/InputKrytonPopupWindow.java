package com.yoursecondworld.secondworld.modular.main.popupWindow.inputKryton;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yoursecondworld.secondworld.R;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.common.ViewPagerViewAdapter;
import com.yoursecondworld.secondworld.common.timePicker.DatePickerAct;
import com.yoursecondworld.secondworld.modular.dynamics.entity.DynamicsContentEntity;
import com.yoursecondworld.secondworld.modular.main.popupWindow.postDynamics.PostDynamicsPopupWindowSpaceItemDecoration;
import com.yoursecondworld.secondworld.modular.main.popupWindow.postDynamics.SelectGameAdapter;
import com.yoursecondworld.secondworld.modular.main.popupWindow.postDynamics.SelectTopicAdapter;
import com.yoursecondworld.secondworld.modular.main.popupWindow.postDynamics.entity.TopicEntity;
import com.yoursecondworld.secondworld.modular.postDynamics.view.PostDynamicsAct;

import java.util.ArrayList;
import java.util.List;

import xiaojinzi.autolayout.utils.AutoUtils;
import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewAdapter;
import xiaojinzi.base.android.os.KeyBoardUtils;
import xiaojinzi.base.android.os.T;

/**
 * Created by cxj on 2016/7/13.
 * 弹出选择游戏和分享的方法
 */
public class InputKrytonPopupWindow extends PopupWindow implements View.OnClickListener {

    /**
     * 弹出的试图
     */
    private View contentView = null;

    /**
     * 上下文
     */
    private Context context = null;

    private RelativeLayout rl_game_name;

    private EditText et_money;

    /**
     * 构造函数
     *
     * @param context 上下文
     */
    public InputKrytonPopupWindow(final Context context) {
        super(context);

        //记录上下文
        this.context = context;

        //创建视图
        contentView = View.inflate(context, R.layout.popup_input_kryton, null);

        //初始化控件
        initView(contentView);

        //点击额外的区域都是关闭键盘
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //关闭键盘
                KeyBoardUtils.closeKeybord(et_money, context);
                rl_pick_date.setVisibility(View.INVISIBLE);
            }
        });

        //初始化popupWindow本身
        initPopupWindow();

    }

    private RelativeLayout rl_date;
    private RelativeLayout rl_pick_date;
    private Button bt_confirm;
    private TextView tv_date;
    private TextView tv_game_name_content;
    private DatePicker dp_date;

    /**
     * 初始化控件
     *
     * @param contentView
     */
    private void initView(View contentView) {
        rl_game_name = (RelativeLayout) contentView.findViewById(R.id.rl_game_name);
        et_money = (EditText) contentView.findViewById(R.id.et_money);
        rl_date = (RelativeLayout) contentView.findViewById(R.id.rl_date);
        rl_pick_date = (RelativeLayout) contentView.findViewById(R.id.rl_pick_date);
        bt_confirm = (Button) contentView.findViewById(R.id.bt_confirm);
        tv_date = (TextView) contentView.findViewById(R.id.tv_date);
        tv_game_name_content = (TextView) contentView.findViewById(R.id.tv_game_name_content);
        dp_date = (DatePicker) contentView.findViewById(R.id.dp_date);
        rl_game_name.setOnClickListener(this);
        rl_date.setOnClickListener(this);
        bt_confirm.setOnClickListener(this);
    }

    /**
     * 初始化popupWindow本身
     */
    private void initPopupWindow() {
        setContentView(contentView);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        setFocusable(true);
        setAnimationStyle(R.style.anim_popup_dir);
        Drawable drawable = new ColorDrawable(Color.parseColor("#000000"));
        drawable.setAlpha(180);
        setBackgroundDrawable(drawable);
    }

    private View.OnClickListener listenerGameNameClick;

    public void setListenerGameNameClick(View.OnClickListener listenerGameNameClick) {
        this.listenerGameNameClick = listenerGameNameClick;
        rl_game_name.setOnClickListener(listenerGameNameClick);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.rl_date://点击了日期
                //显示时间选择器
                rl_pick_date.setVisibility(View.VISIBLE);
                break;
            case R.id.rl_game_name:

                T.showShort(context, "hello");

                break;
            case R.id.bt_confirm://点击了日期确定的按钮
                //设置时间
                tv_date.setText((dp_date.getMonth() + 1) + "-" + dp_date.getDayOfMonth());
                //隐藏时间选择器
                rl_pick_date.setVisibility(View.INVISIBLE);
                break;

        }
    }

    public void setGameName(String gameName) {
        tv_game_name_content.setText(gameName);
    }
}
