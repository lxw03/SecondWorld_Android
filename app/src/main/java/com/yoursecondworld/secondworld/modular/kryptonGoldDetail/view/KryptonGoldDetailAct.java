package com.yoursecondworld.secondworld.modular.kryptonGoldDetail.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yoursecondworld.secondworld.R;
import com.yoursecondworld.secondworld.common.BaseAct;
import com.yoursecondworld.secondworld.modular.kryptonGoldDetail.bean.KryptonGoldDetai;

import java.util.ArrayList;
import java.util.List;

import xiaojinzi.annotation.Injection;
import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewAdapter;
import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewHolder;

@Injection(R.layout.act_krypton_gold_detail)
public class KryptonGoldDetailAct extends BaseAct {


    @Injection(R.id.rv)
    private RecyclerView rv;

    /**
     * 要显示的数据
     */
    private List<KryptonGoldDetai> data = new ArrayList<KryptonGoldDetai>();

    private CommonRecyclerViewAdapter adapter;

    private KryptonGoldDetailHeader header = new KryptonGoldDetailHeader();

    @Override
    public void initView() {
        super.initView();

        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());
        data.add(new KryptonGoldDetai());

        //创建适配器
        adapter = new CommonRecyclerViewAdapter<KryptonGoldDetai>(context,data) {

            @Override
            public void convert(CommonRecyclerViewHolder h, KryptonGoldDetai entity, int position) {

            }

            @Override
            public int getLayoutViewId(int viewType) {
                return R.layout.act_krypton_gold_detail_item;
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
