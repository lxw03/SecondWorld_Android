package com.yoursecondworld.secondworld.modular.commonFunction.user.presenter;

import android.text.TextUtils;

import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.modular.commonFunction.user.model.IUserModel;
import com.yoursecondworld.secondworld.modular.commonFunction.user.model.UserModel;
import com.yoursecondworld.secondworld.modular.commonFunction.user.view.IUserView;

/**
 * Created by cxj on 2016/9/1.
 */
public class UserPresenter {

    private IUserView view;

    private IUserModel model = new UserModel();

    public UserPresenter(IUserView view) {
        this.view = view;
    }

    /**
     * 关注用户
     */
    public void followUser(String userId, final Object... obs) {
        view.showDialog("正在关注");

        if (TextUtils.isEmpty(userId)) {
            view.closeDialog();
            return;
        }

        model.followUser(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), userId, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                view.closeDialog();
                view.onFollowSuccess(obs);
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
                view.tip("关注失败");
            }
        });
    }

    /**
     * 取消关注
     */
    public void unFollowUser(String userId, final Object... obs) {
        view.showDialog("正在取消关注");

        if (TextUtils.isEmpty(userId)) {
            view.closeDialog();
            return;
        }

        model.unFollowUser(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), userId, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                view.closeDialog();
                view.onUnFollowSuccess(obs);
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
                view.tip("取消关注失败");
            }
        });
    }

    /**
     * 拉黑用户
     *
     * @param userId
     */
    public void blockUser(String userId) {

        view.showDialog("正在屏蔽该用户");

        model.blockUser(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), userId, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                view.closeDialog();
                view.onBlockSuccess();
                view.tip("拉黑用户成功");
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
                view.tip("拉黑用户失败");
            }
        });

    }

    public void unblockUser(String userId) {

        view.showDialog("正在屏蔽该用户");

        model.unblock_user(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), userId, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                view.closeDialog();
                view.onUnBlockSuccess();
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
                view.tip("取消拉黑用户失败");
            }
        });

    }

}
