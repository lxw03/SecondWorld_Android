package com.yoursecondworld.secondworld.modular.statusNotification.presenter;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.modular.statusNotification.enity.CommentsListResult;
import com.yoursecondworld.secondworld.modular.statusNotification.enity.ZanListResult;
import com.yoursecondworld.secondworld.modular.statusNotification.model.IStatusNotificationModel;
import com.yoursecondworld.secondworld.modular.statusNotification.model.StatusNotificationModel;
import com.yoursecondworld.secondworld.modular.statusNotification.ui.IStatusNotificationView;

/**
 * Created by cxj on 2016/9/19.
 */
public class StatusNotificationPresenter {

    private IStatusNotificationView view;

    private IStatusNotificationModel model = new StatusNotificationModel();

    public StatusNotificationPresenter(IStatusNotificationView view) {
        this.view = view;
    }

    public void getCommentsList() {

        model.mes_get_comments_list(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), null, new NetWorkSoveListener<CommentsListResult>() {
            @Override
            public void success(CommentsListResult commentsListResult) {
                view.onLoadCommentsListSuccess(commentsListResult.getEvent());
                view.savePass(commentsListResult.getPass());
            }

            @Override
            public void fail(String msg) {

            }
        });
    }

    public void getMoreCommentsList() {

        model.mes_get_comments_list(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), view.getPass(), new NetWorkSoveListener<CommentsListResult>() {
            @Override
            public void success(CommentsListResult commentsListResult) {
                view.onLoadMoreCommentsListSuccess(commentsListResult.getEvent());
                view.savePass(commentsListResult.getPass());
            }

            @Override
            public void fail(String msg) {
                view.tip("加载失败");
            }
        });
    }

    public void getZanList() {

        model.mes_get_likes_list(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), null, new NetWorkSoveListener<ZanListResult>() {
            @Override
            public void success(ZanListResult zanListResult) {
                view.onLoadZanListSuccess(zanListResult.getEvent());
                view.savePass(zanListResult.getPass());
            }

            @Override
            public void fail(String msg) {

            }
        });

    }

    public void getMoreZanList() {

        model.mes_get_likes_list(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), view.getPass(), new NetWorkSoveListener<ZanListResult>() {
            @Override
            public void success(ZanListResult zanListResult) {
                view.onLoadMoreZanListSuccess(zanListResult.getEvent());
                view.savePass(zanListResult.getPass());
            }

            @Override
            public void fail(String msg) {

            }
        });

    }

}
