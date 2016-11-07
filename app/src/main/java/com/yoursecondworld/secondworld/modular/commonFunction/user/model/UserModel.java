package com.yoursecondworld.secondworld.modular.commonFunction.user.model;

import com.yoursecondworld.secondworld.AppConfig;
import com.yoursecondworld.secondworld.MyApp;
import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.common.JsonRequestParameter;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.ResultStatusFilter;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cxj on 2016/9/1.
 */
public class UserModel implements IUserModel {

    @Override
    public void followUser(String session_id, String object_id, String user_id,
                           final NetWorkSoveListener<BaseEntity> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, object_id)
                .addParameter("user_id", user_id)
                .build();
        Call<BaseEntity> call = AppConfig.netWorkService.followUser(body);
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
    public void unFollowUser(String session_id, String object_id, String user_id,
                             final NetWorkSoveListener<BaseEntity> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, object_id)
                .addParameter("user_id", user_id)
                .build();
        Call<BaseEntity> call = AppConfig.netWorkService.unFollowUser(body);
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
    public void blockUser(String session_id, String object_id, String user_id,
                          final NetWorkSoveListener<BaseEntity> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, object_id)
                .addParameter("user_id", user_id)
                .build();
        Call<BaseEntity> call = AppConfig.netWorkService.blockUser(body);
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
    public void unblock_user(String session_id, String object_id, String user_id,
                             final NetWorkSoveListener<BaseEntity> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, object_id)
                .addParameter("user_id", user_id)
                .build();
        Call<BaseEntity> call = AppConfig.netWorkService.unblock_user(body);
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

