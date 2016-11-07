package com.yoursecondworld.secondworld.modular.gameTimeDetail.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yoursecondworld.secondworld.R;
import com.yoursecondworld.secondworld.common.BaseAct;
import com.yoursecondworld.secondworld.modular.gameTimeDetail.bean.GameTimeDetai;

import java.util.ArrayList;
import java.util.List;

import xiaojinzi.annotation.Injection;
import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewAdapter;
import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewHolder;

/**
 * 游戏时间明细界面
 */
@Injection(R.layout.act_game_time_detail)
public class GameTimeDetailAct extends BaseAct {

    @Injection(R.id.rv)
    private RecyclerView rv;

    /**
     * 要显示的数据
     */
    private List<GameTimeDetai> data = new ArrayList<GameTimeDetai>();

    private CommonRecyclerViewAdapter adapter;

    private GameTimeDetailHeader header = new GameTimeDetailHeader();

    @Override
    public void initView() {
        super.initView();

        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());
        data.add(new GameTimeDetai());

        //创建适配器
        adapter = new CommonRecyclerViewAdapter<GameTimeDetai>(context,data) {

            @Override
            public void convert(CommonRecyclerViewHolder h, GameTimeDetai entity, int position) {

            }

            @Override
            public int getLayoutViewId(int viewType) {
                return R.layout.act_game_time_detail_item;
            }
        };

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);

        adapter.addHeaderView(header.init(context));

        rv.setAdapter(adapter);


    }

    @Override
    public boolean isRegisterEvent() {
        return false;
    }

}
