package com.yoursecondworld.secondworld.modular.system.accountManager.presenter;

import android.text.TextUtils;

import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.modular.system.accountManager.model.AccountManagerModel;
import com.yoursecondworld.secondworld.modular.system.accountManager.model.IAccountManagerModel;
import com.yoursecondworld.secondworld.modular.system.accountManager.ui.AccountManagerView;

/**
 * Created by cxj on 2016/9/27.
 */
public class AccountManagerPresenter {

    /**
     * 手机号码的正则表达式
     */
    private String phoneMatche = "^1[3|4|5|7|8][0-9]\\d{8}$";

    private AccountManagerView view;

    private IAccountManagerModel model = new AccountManagerModel();

    public AccountManagerPresenter(AccountManagerView view) {
        this.view = view;

    }

    public void send_bind_phone_number_message() {

        String phoneNumber = view.getPhoneNumber();

        if (TextUtils.isEmpty(phoneNumber)) {
            view.tip("电话号码不能为空");
            return;
        }

        //手机号的正则
        boolean matches = phoneNumber.matches(phoneMatche);
        if (!matches) { //如果不匹配,提示用户
            view.tip("请输入正确的手机号");
            return;
        }

        model.send_bind_phone_number_message(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), phoneNumber, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity baseEntity) {
                if (baseEntity.getStatus() == Constant.Status.SUCCESS) {
                    view.tip("短信发送成功");
                    view.onSendMessageSuccess();
                } else if (baseEntity.getStatus() == 105) {
                    view.tip("手机号已经被绑定,请更换手机号");
                } else {
                    view.tip("发送失败");
                }
            }

            @Override
            public void fail(String msg) {
                view.tip("绑定失败");
            }
        });
    }


    public void auth_bind_phone_number_message() {
        String phoneNumber = view.getPhoneNumber();

        if (TextUtils.isEmpty(phoneNumber)) {
            view.tip("电话号码不能为空");
            return;
        }

        //手机号的正则
        boolean matches = phoneNumber.matches(phoneMatche);
        if (!matches) { //如果不匹配,提示用户
            view.tip("请输入正确的手机号");
            return;
        }

        model.auth_bind_phone_number_message(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), phoneNumber,
                view.getPassword(), view.getCheckCode(),
                new NetWorkSoveListener<BaseEntity>() {
                    @Override
                    public void success(BaseEntity baseEntity) {
                        if (baseEntity.getStatus() == Constant.Status.SUCCESS) {
                            view.tip("绑定成功成功");
                            view.onBindPhoneSuccess();
                        } else {
                            view.tip("绑定失败");
                        }
                    }

                    @Override
                    public void fail(String msg) {
                        view.tip("绑定失败");
                    }
                });
    }

}
