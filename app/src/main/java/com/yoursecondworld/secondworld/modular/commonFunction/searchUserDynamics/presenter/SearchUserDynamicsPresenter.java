package com.yoursecondworld.secondworld.modular.commonFunction.searchUserDynamics.presenter;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.modular.commonFunction.searchUserDynamics.model.ISearchUserDynamicsModel;
import com.yoursecondworld.secondworld.modular.commonFunction.searchUserDynamics.model.SearchUserDynamicsModel;
import com.yoursecondworld.secondworld.modular.commonFunction.searchUserDynamics.view.ISearchUserDynamicsView;
import com.yoursecondworld.secondworld.modular.dynamics.entity.DynamicsResult;

/**
 * Created by cxj on 2016/9/12.
 */
public class SearchUserDynamicsPresenter {

    private ISearchUserDynamicsView view;

    private ISearchUserDynamicsModel model = new SearchUserDynamicsModel();

    public SearchUserDynamicsPresenter(ISearchUserDynamicsView view) {
        this.view = view;
    }

    /**
     * 搜索用户的发布的文章
     */
    public void searchUserDynamics() {
        view.showDialog("正在搜索");

        model.searchUserDynamics(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), StaticDataStore.newUser.getUser_id(), view.getSearchContent(), null,
                new NetWorkSoveListener<DynamicsResult>() {
                    @Override
                    public void success(DynamicsResult dynamicsResult) {
                        view.disPlay(dynamicsResult.getArticles());
                        view.closeDialog();
                        view.savePass(dynamicsResult.getPass());
                    }

                    @Override
                    public void fail(String msg) {
                        view.closeDialog();
                    }
                });

    }

    /**
     * 搜索更多的用户动态
     */
    public void searchMoreUserDynamics() {
        view.showDialog("正在搜索");

        model.searchUserDynamics(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), StaticDataStore.newUser.getUser_id(), view.getSearchContent(), view.getPass(),
                new NetWorkSoveListener<DynamicsResult>() {
                    @Override
                    public void success(DynamicsResult dynamicsResult) {
                        view.disPlayMore(dynamicsResult.getArticles());
                        view.closeDialog();
                        view.savePass(dynamicsResult.getPass());
                    }

                    @Override
                    public void fail(String msg) {
                        view.closeDialog();
                    }
                });

    }

}
