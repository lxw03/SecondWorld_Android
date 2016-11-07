package com.yoursecondworld.secondworld.modular.prepareModule.selectPlayer.presenter;

import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.modular.prepareModule.selectPlayer.model.ISelectPlayerModel;
import com.yoursecondworld.secondworld.modular.prepareModule.selectPlayer.model.SelectPlayerModel;
import com.yoursecondworld.secondworld.modular.prepareModule.selectPlayer.ui.ISelectPlayerView;
import com.yoursecondworld.secondworld.modular.systemInfo.entity.NewUser;
import com.yoursecondworld.secondworld.modular.systemInfo.entity.UserResult;

/**
 * Created by cxj on 2016/9/18.
 */
public class SelectPlayerPresenter {

    private ISelectPlayerView view;

    private ISelectPlayerModel model = new SelectPlayerModel();

    public SelectPlayerPresenter(ISelectPlayerView view) {
        this.view = view;
    }

    public void get_recommend_user_list() {

        model.get_recommend_user_list(StaticDataStore.session_id,
                StaticDataStore.newUser.getUser_id(), new NetWorkSoveListener<UserResult>() {
                    @Override
                    public void success(UserResult userResult) {
                        view.onLoadUsersSuccess(userResult.getUsers());
                    }

                    @Override
                    public void fail(String msg) {
                    }
                });

    }

}
