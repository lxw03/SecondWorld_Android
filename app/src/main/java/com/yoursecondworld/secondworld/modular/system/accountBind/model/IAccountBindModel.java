package com.yoursecondworld.secondworld.modular.system.accountBind.model;

import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.modular.system.accountBind.entity.AccountBindInfoResult;

/**
 * Created by cxj on 2016/9/17.
 */
public interface IAccountBindModel {

    void is_third_party_account_binded(String sessionId, String objectId, NetWorkSoveListener<AccountBindInfoResult> listener);

    void bind_qq(String sessionId, String objectId, String openid, String access_token, NetWorkSoveListener<BaseEntity> listener);

    void bind_wechat(String sessionId, String objectId, String openid, String access_token, NetWorkSoveListener<BaseEntity> listener);

    void bind_weibo(String sessionId, String objectId, String uid, String access_token, NetWorkSoveListener<BaseEntity> listener);

}
