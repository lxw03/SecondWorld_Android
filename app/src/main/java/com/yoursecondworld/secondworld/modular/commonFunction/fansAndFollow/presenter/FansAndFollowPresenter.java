package com.yoursecondworld.secondworld.modular.commonFunction.fansAndFollow.presenter;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.modular.commonFunction.fansAndFollow.model.FansAndFollowModel;
import com.yoursecondworld.secondworld.modular.commonFunction.fansAndFollow.model.IFansAndFollowModel;
import com.yoursecondworld.secondworld.modular.commonFunction.fansAndFollow.view.IFansAndFollowView;
import com.yoursecondworld.secondworld.modular.systemInfo.entity.UserResult;

/**
 * Created by cxj on 2016/9/9.
 */
public class FansAndFollowPresenter {

    private IFansAndFollowModel model = new FansAndFollowModel();

    private IFansAndFollowView view;

    public FansAndFollowPresenter(IFansAndFollowView view) {
        this.view = view;
    }

    public void loadUnFollowFans() {

        model.loadUnFollowFans(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), null,
                new NetWorkSoveListener<UserResult>() {
                    @Override
                    public void success(UserResult userResult) {
                        view.onLoadUnFollowFansSuccess(userResult.getUsers());
                        view.savePass(userResult.getPass());
                    }

                    @Override
                    public void fail(String msg) {
                        view.tip("加载失败");
                    }
                });

    }

    public void loadMoreUnFollowFans() {

        model.loadUnFollowFans(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), view.getPass(),
                new NetWorkSoveListener<UserResult>() {
                    @Override
                    public void success(UserResult userResult) {
                        view.onLoadMoreUnFollowFansSuccess(userResult.getUsers());
                        view.savePass(userResult.getPass());
                    }

                    @Override
                    public void fail(String msg) {
                        view.tip("加载失败");
                    }
                });

    }

    public void getFollowEachOther() {

        model.getFollowEachOther(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), new NetWorkSoveListener<UserResult>() {
            @Override
            public void success(UserResult userResult) {
                for (int i = 0; i < userResult.getUsers().size(); i++) {
                    userResult.getUsers().get(i).setFollow(true);
                }
                view.onLoadFollowEachOtherSuccess(userResult.getUsers());
            }

            @Override
            public void fail(String msg) {
                view.tip("加载失败");
            }
        });

    }

}
