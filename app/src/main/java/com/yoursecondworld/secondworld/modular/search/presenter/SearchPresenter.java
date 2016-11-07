package com.yoursecondworld.secondworld.modular.search.presenter;

import android.text.TextUtils;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.modular.dynamics.entity.DynamicsResult;
import com.yoursecondworld.secondworld.modular.search.model.ISearchModel;
import com.yoursecondworld.secondworld.modular.search.model.SearchModel;
import com.yoursecondworld.secondworld.modular.search.ui.ISearchView;
import com.yoursecondworld.secondworld.modular.systemInfo.entity.UserResult;

/**
 * Created by cxj on 2016/9/3.
 */
public class SearchPresenter {

    private ISearchModel model = new SearchModel();

    private ISearchView view;

    public SearchPresenter(ISearchView view) {
        this.view = view;
    }

    /**
     * 搜索动态
     */
    public void searchDynamics() {

        if (TextUtils.isEmpty(view.getSearchContent())) {
            view.tip("搜索内容不能为空哦");
            return;
        }

        view.showDialog("正在搜索动态");

        model.searchDynamics(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), view.getSearchContent(), null,
                new NetWorkSoveListener<DynamicsResult>() {
            @Override
            public void success(DynamicsResult dynamicsResult) {
                view.closeDialog();
                view.onSearchDynamicsSuccess(dynamicsResult.getArticles());
                view.savePass(dynamicsResult.getPass());
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
            }
        });

    }

    public void searchMoreDynamics() {

        if (TextUtils.isEmpty(view.getSearchContent())) {
            view.tip("搜索内容不能为空哦");
            return;
        }

        view.showDialog("正在搜索动态");

        model.searchDynamics(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), view.getSearchContent(),  view.getPass(),
                new NetWorkSoveListener<DynamicsResult>() {
                    @Override
                    public void success(DynamicsResult dynamicsResult) {
                        view.closeDialog();
                        view.onSearchMoreDynamicsSuccess(dynamicsResult.getArticles());
                        view.savePass(dynamicsResult.getPass());
                    }

                    @Override
                    public void fail(String msg) {
                        view.closeDialog();
                    }
                });

    }

    /**
     * 搜索用户
     */
    public void searchUser() {

        if (TextUtils.isEmpty(view.getSearchContent())) {
            view.tip("搜索内容不能为空哦");
            return;
        }

        view.showDialog("正在搜索用户");

        model.searchUser(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), view.getSearchContent(), null,
                new NetWorkSoveListener<UserResult>() {
                    @Override
                    public void success(UserResult userResult) {
                        view.closeDialog();
                        view.onSearchUsersSuccess(userResult.getUsers());
                        view.savePass(userResult.getPass());
                    }
                    @Override
                    public void fail(String msg) {
                        view.closeDialog();
                    }
                });

    }

    public void searchMoreUser() {

        if (TextUtils.isEmpty(view.getSearchContent())) {
            view.tip("搜索内容不能为空哦");
            return;
        }

        view.showDialog("正在搜索用户");

        model.searchUser(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), view.getSearchContent(), view.getPass(),
                new NetWorkSoveListener<UserResult>() {
                    @Override
                    public void success(UserResult userResult) {
                        view.closeDialog();
                        view.onSearchMoreUsersSuccess(userResult.getUsers());
                        view.savePass(userResult.getPass());
                    }
                    @Override
                    public void fail(String msg) {
                        view.closeDialog();
                    }
                });

    }

}
