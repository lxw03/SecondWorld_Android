package com.yoursecondworld.secondworld.modular.prepareModule.selectGame.presenter;

import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.GameLabelResIdMapper;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.modular.prepareModule.selectGame.model.ISelectGameModel;
import com.yoursecondworld.secondworld.modular.prepareModule.selectGame.model.SelectGameModel;
import com.yoursecondworld.secondworld.modular.prepareModule.selectGame.view.ISelectGameView;

import java.util.ArrayList;

/**
 * Created by cxj on 2016/8/15.
 */
public class SelectGamePresenter {

    private ISelectGameView selectGameView;

    private ISelectGameModel selectGameModel = new SelectGameModel();

    public SelectGamePresenter(ISelectGameView selectGameView) {
        this.selectGameView = selectGameView;

    }

    /**
     * 获取所有的标签
     */
    public void getAllGameLabel() {

//        selectGameView.showDialog("正在获取标签");

        ArrayList<String> games = new ArrayList<String>();
        games.add(GameLabelResIdMapper.HUANGSHI);
        games.add(GameLabelResIdMapper.QIJINUANNUAN);
        games.add(GameLabelResIdMapper.WANGZHERONGYAO);
        games.add(GameLabelResIdMapper.ZHUXIANSHOUYOU);

        selectGameView.disPlayData(games);

    }

    private String gamaLabelId[];

    public void improveGameLabel() {

        selectGameView.showDialog("正在完善选择的标签");

        gamaLabelId = selectGameView.getSelectGameLabelIds();

        selectGameModel.updateGameLabel(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), selectGameView.getSelectGameLabelIds(), new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                selectGameView.onSuccess(gamaLabelId);
                selectGameView.closeDialog();
            }

            @Override
            public void fail(String msg) {
                selectGameView.closeDialog();
            }
        });


    }

}
