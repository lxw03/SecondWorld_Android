package com.yoursecondworld.secondworld.modular.commonFunction.loadMyDynamics.model;

import com.yoursecondworld.secondworld.AppConfig;
import com.yoursecondworld.secondworld.MyApp;
import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.common.JsonRequestParameter;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.ResultStatusFilter;
import com.yoursecondworld.secondworld.modular.dynamics.entity.DynamicsResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cxj on 2016/9/2.
 */
public class LoadMyDynamicsModel implements ILoadMyDynamicsModel {
    @Override
    public void loadMyDynamics(String sessionId, String objectId, String user_id, String pass,
                               final NetWorkSoveListener<DynamicsResult> listener) {

        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, sessionId)
                .addParameter(Constant.RESULT_OBJECT_ID, objectId)
                .addParameter("user_id", user_id)
                .addParameter(Constant.RESULT_PASS, pass)
                .build();

        Call<DynamicsResult> call = AppConfig.netWorkService.getUserDynamics(body);
        call.enqueue(new Callback<DynamicsResult>() {
            @Override
            public void onResponse(Call<DynamicsResult> call, Response<DynamicsResult> response) {
                listener.success(response.body());
                ResultStatusFilter.filter(response.body());
            }

            @Override
            public void onFailure(Call<DynamicsResult> call, Throwable t) {
                listener.fail("网络有点问题");
            }

        });
    }

    @Override
    public void deleteDynamics(String sessionId, String objectId, String dynamicsid, final NetWorkSoveListener<BaseEntity> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, sessionId)
                .addParameter(Constant.RESULT_OBJECT_ID, objectId)
                .addParameter("article_id", dynamicsid)
                .build();

        Call<BaseEntity> call = AppConfig.netWorkService.deleteDynamics(body);
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
