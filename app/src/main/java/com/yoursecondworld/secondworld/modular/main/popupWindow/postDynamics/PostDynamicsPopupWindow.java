package com.yoursecondworld.secondworld.modular.main.popupWindow.postDynamics;

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
import android.widget.ImageView;
import android.widget.PopupWindow;

import xiaojinzi.autolayout.utils.AutoUtils;

import com.yoursecondworld.secondworld.MyApp;
import com.yoursecondworld.secondworld.R;
import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.common.ViewPagerViewAdapter;
import com.yoursecondworld.secondworld.modular.dynamics.entity.DynamicsContentEntity;
import com.yoursecondworld.secondworld.modular.main.popupWindow.postDynamics.entity.TopicEntity;
import com.yoursecondworld.secondworld.modular.postDynamics.view.PostDynamicsAct;
import com.yoursecondworld.secondworld.modular.systemInfo.entity.GameLabel;

import java.util.ArrayList;
import java.util.List;

import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewAdapter;
import xiaojinzi.base.android.os.T;

/**
 * Created by cxj on 2016/7/13.
 * 弹出选择游戏和分享的方法
 */
public class PostDynamicsPopupWindow extends PopupWindow implements View.OnClickListener {

    /**
     * 弹出的试图
     */
    private View contentView = null;

    /**
     * 左右滑动的控件
     */
    private ViewPager vp = null;

    /**
     * ViewPager显示的试图
     */
    private List<View> views = new ArrayList<View>();

    /**
     * 上下文
     */
    private Context context = null;

    /**
     * 被选中的游戏标签
     */
//    private int selectGameIndex = -1;
    private String selectGameTag = null;

    /**
     * 被选中的话题标签
     */
//    private int selectTopicIndex = -1;
    private int selectTopicTag = -1;

    /**
     * 构造函数
     *
     * @param context 上下文
     */
    public PostDynamicsPopupWindow(Context context) {
        super(context);

        this.context = context;

        contentView = View.inflate(context, R.layout.act_main_popup_for_post_dynamics, null);

        vp = (ViewPager) contentView.findViewById(R.id.vp_act_main_popup_for_post_dynamics);

        //初始化选择游戏的
        initSelectGame();

        //初始化选择话题的
        initSelectTopic();

        //设置适配器
        vp.setAdapter(new ViewPagerViewAdapter(views));

        //初始化popupWindow本身
        initPopupWindow();

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
        Drawable drawable = new ColorDrawable(Color.parseColor("#F6F6F6"));
        drawable.setAlpha(246);
        setBackgroundDrawable(drawable);
    }

    /**
     * 初始化选择话题的
     */
    private void initSelectTopic() {
        View view_topic = View.inflate(context, R.layout.act_main_popupwindow_select_topic, null);

        ImageView iv_back = (ImageView) view_topic.findViewById(R.id.iv_act_main_popupwindow_select_topic_foot_back);
        iv_back.setOnClickListener(this);

        //展示的列表控件
        RecyclerView rv = (RecyclerView) view_topic.findViewById(R.id.rv_act_main_popupwindow_select_topic);

        //数据的准备
        List<TopicEntity> data = new ArrayList<TopicEntity>();
        data.add(new TopicEntity(R.mipmap.post_dynamics_topic_raiders, "攻略心得", Color.parseColor("#C6A7C2")));
        data.add(new TopicEntity(R.mipmap.post_dynamics_topic_bagua, "游戏八卦", Color.parseColor("#42C2D6")));
        data.add(new TopicEntity(R.mipmap.post_dynamics_topic_mood_tucao, "心情吐槽", Color.parseColor("#EA908F")));
        data.add(new TopicEntity(R.mipmap.post_dynamics_topic_showtime, "show time", Color.parseColor("#F88CA3")));
        data.add(new TopicEntity(R.mipmap.post_dynamics_topic_duoshou, "剁手时刻", Color.parseColor("#FCBD4F")));
        data.add(new TopicEntity(R.mipmap.post_dynamics_topic_pingce, "游戏测评", Color.parseColor("#7AC2AF")));

        //创建布局管理器和设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        rv.setLayoutManager(gridLayoutManager);

        rv.setNestedScrollingEnabled(false);

        //创建一个条目的装饰者
        PostDynamicsPopupWindowSpaceItemDecoration itemDecoration = new PostDynamicsPopupWindowSpaceItemDecoration(AutoUtils.getPercentHeightSize(35));
        rv.addItemDecoration(itemDecoration);

        //创建适配器和设置适配器i
        CommonRecyclerViewAdapter adapter = new SelectTopicAdapter(context, data);

        //设置选择话题的item的点击事件
        adapter.setOnRecyclerViewItemClickListener(new CommonRecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                if (selectGameTag == null) {
                    T.showShort(context, "您先选择游戏标签");
                    vp.setCurrentItem(0);
                    return;
                }

                Intent intent = new Intent(context, PostDynamicsAct.class);

                intent.putExtra(PostDynamicsAct.GAME_TAG, selectGameTag);
                intent.putExtra(PostDynamicsAct.TYPE_TAG, DynamicsContentEntity.TOPICS[position]);

                //启动发送动态的界面
                context.startActivity(intent);

                //让自己消失,不要发送动态的界面消失了还在
                dismiss();

                selectGameTag = null;

            }
        });

        rv.setAdapter(adapter);

        views.add(view_topic);
    }

    /**
     * 初始化选择游戏的
     */
    private void initSelectGame() {

        View view_selectGame = View.inflate(context, R.layout.act_main_popupwindow_select_game, null);

        //展示的列表控件
        RecyclerView rv = (RecyclerView) view_selectGame.findViewById(R.id.rv_act_main_popupwindow_select_game);
        ImageView iv_cancel = (ImageView) view_selectGame.findViewById(R.id.iv_foot_cancel);
        //设置取消图标的点击事件,点了之后就让popupWindow消失
        iv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        //数据的准备

        List<String> gameLabels = StaticDataStore.newUser.getGames();
        List<String> data = new ArrayList<String>();
        data.addAll(gameLabels);

        //创建布局管理器和设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        rv.setLayoutManager(gridLayoutManager);

        rv.setNestedScrollingEnabled(false);
        rv.setEnabled(false);

        PostDynamicsPopupWindowSpaceItemDecoration itemDecoration = new PostDynamicsPopupWindowSpaceItemDecoration(AutoUtils.getPercentHeightSize(35));
        rv.addItemDecoration(itemDecoration);

        //创建适配器和设置适配器i
        CommonRecyclerViewAdapter adapter = new SelectGameAdapter(context, data);

        adapter.setOnRecyclerViewItemClickListener(new CommonRecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                selectGameTag = StaticDataStore.newUser.getGames().get(position);
                vp.setCurrentItem(1);
            }
        });

        rv.setAdapter(adapter);

        views.add(view_selectGame);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.iv_act_main_popupwindow_select_topic_foot_back:
                vp.setCurrentItem(0);
                break;
        }
    }

    /**
     * 在弹出popupWindow的时候,让页面到选择游戏的页面,在原有的基础上增加一点逻辑
     *
     * @param parent
     * @param gravity
     * @param x
     * @param y
     */
    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
        vp.setCurrentItem(0);
    }

}
