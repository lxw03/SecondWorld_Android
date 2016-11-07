package com.yoursecondworld.secondworld.modular.system.accountBind.model;

import com.yoursecondworld.secondworld.AppConfig;
import com.yoursecondworld.secondworld.MyApp;
import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.common.JsonRequestParameter;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.ResultStatusFilter;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.modular.system.accountBind.entity.AccountBindInfoResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cxj on 2016/9/17.
 */
public class AccountBindModel implements IAccountBindModel {
    @Override
    public void is_third_party_account_binded(String sessionId, String objectId,
                                              final NetWorkSoveListener<AccountBindInfoResult> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, StaticDataStore.session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, StaticDataStore.newUser.getUser_id())
                .build();

        Call<AccountBindInfoResult> call = AppConfig.netWorkService.is_third_party_account_binded(body);
        call.enqueue(new Callback<AccountBindInfoResult>() {
            @Override
            public void onResponse(Call<AccountBindInfoResult> call, Response<AccountBindInfoResult> response) {
                listener.success(response.body());
                ResultStatusFilter.filter(response.body());
            }

            @Override
            public void onFailure(Call<AccountBindInfoResult> call, Throwable t) {
                listener.fail("网络有点问题");
            }
        });
    }

    @Override
    public void bind_qq(String sessionId, String objectId, String openid, String access_token,
                        final NetWorkSoveListener<BaseEntity> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, StaticDataStore.session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, StaticDataStore.newUser.getUser_id())
                .addParameter("openid", openid)
                .addParameter("access_token", access_token)
                .build();

        Call<BaseEntity> call = AppConfig.netWorkService.bind_qq(body);
        call.enqueue(new Callback<BaseEntity>() {
            @Override
            public void onResponse(Call<BaseEntity> call, Response<BaseEntity> response) {
                listener.success(response.body());
                ResultStatusFilter.filter(response.body());
            }

            @Override
            public void onFailure(Call<BaseEntity> call, Throwable t) {
                listener.fail("网络有点问题");
            }
        });
    }

    @Override
    public void bind_wechat(String sessionId, String objectId, String openid, String access_token,
                            final NetWorkSoveListener<BaseEntity> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, StaticDataStore.session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, StaticDataStore.newUser.getUser_id())
                .addParameter("openid", openid)
                .addParameter("access_token", access_token)
                .build();

        Call<BaseEntity> call = AppConfig.netWorkService.bind_wechat(body);
        call.enqueue(new Callback<BaseEntity>() {
            @Override
            public void onResponse(Call<BaseEntity> call, Response<BaseEntity> response) {
                listener.success(response.body());
                ResultStatusFilter.filter(response.body());
            }

            @Override
            public void onFailure(Call<BaseEntity> call, Throwable t) {
                listener.fail("网络有点问题");
            }
        });
    }

    @Override
    public void bind_weibo(String sessionId, String objectId, String uid, String access_token,
                           final NetWorkSoveListener<BaseEntity> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, StaticDataStore.session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, StaticDataStore.newUser.getUser_id())
                .addParameter("uid", uid)
                .addParameter("access_token", access_token)
                .build();

        Call<BaseEntity> call = AppConfig.netWorkService.bind_weibo(body);
        call.enqueue(new Callback<BaseEntity>() {
            @Override
            public void onResponse(Call<BaseEntity> call, Response<BaseEntity> response) {
                listener.success(response.body());
                ResultStatusFilter.filter(response.body());
            }

            @Override
            public void onFailure(Call<BaseEntity> call, Throwable t) {
                listener.fail("网络有点问题");
            }
        });
    }
}
