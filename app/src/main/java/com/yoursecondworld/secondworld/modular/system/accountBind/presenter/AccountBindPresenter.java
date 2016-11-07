package com.yoursecondworld.secondworld.modular.system.accountBind.presenter;

import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.modular.system.accountBind.entity.AccountBindInfoResult;
import com.yoursecondworld.secondworld.modular.system.accountBind.model.AccountBindModel;
import com.yoursecondworld.secondworld.modular.system.accountBind.model.IAccountBindModel;
import com.yoursecondworld.secondworld.modular.system.accountBind.ui.IAccountBindView;

/**
 * Created by cxj on 2016/9/17.
 */
public class AccountBindPresenter {

    private IAccountBindView view;

    private IAccountBindModel model = new AccountBindModel();

    public AccountBindPresenter(IAccountBindView view) {
        this.view = view;
    }

    public void getThirdBindInfo() {

        view.showDialog("正在获取绑定信息");

        model.is_third_party_account_binded(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), new NetWorkSoveListener<AccountBindInfoResult>() {
            @Override
            public void success(AccountBindInfoResult entity) {
                view.closeDialog();
                view.onLoadAccountBindInfoSuccess(entity);
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
            }
        });

    }

    public void bindQq(String openid, String access_token) {
//        view.showDialog("正在绑定");

        model.bind_qq(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), openid, access_token, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                view.closeDialog();
                view.tip("绑定成功");
                view.onBindQQSuccess();
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
                view.tip("账号已使用");
            }
        });

    }

    public void bind_wechat(String openid, String access_token) {
//        view.showDialog("正在绑定");
        model.bind_wechat(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), openid, access_token, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                view.closeDialog();
                view.tip("绑定成功");
                view.onBindWeiXinSuccess();
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
                view.tip("账号已使用");
            }
        });

    }

    public void bind_weibo(String openid, String access_token) {
//        view.showDialog("正在绑定");

        model.bind_weibo(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), openid, access_token, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                view.closeDialog();
                view.tip("绑定成功");
                view.onBindWeiBoSuccess();
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
                view.tip("账号已使用");
            }
        });

    }

}
