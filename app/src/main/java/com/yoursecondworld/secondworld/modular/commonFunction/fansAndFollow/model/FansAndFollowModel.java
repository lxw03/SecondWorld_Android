package com.yoursecondworld.secondworld.modular.commonFunction.fansAndFollow.model;

import com.yoursecondworld.secondworld.AppConfig;
import com.yoursecondworld.secondworld.MyApp;
import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.common.JsonRequestParameter;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.ResultStatusFilter;
import com.yoursecondworld.secondworld.modular.systemInfo.entity.UserResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cxj on 2016/9/9.
 */
public class FansAndFollowModel implements IFansAndFollowModel {

    @Override
    public void loadUnFollowFans(String sessionId, String objectId, String pass,
                                 final NetWorkSoveListener<UserResult> listener) {
        //请求未关注的
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, sessionId)
                .addParameter(Constant.RESULT_OBJECT_ID, objectId)
                .addParameter(Constant.RESULT_PASS, pass)
                .build();

        //我的粉丝,为关注的
        Call<UserResult> call = AppConfig.netWorkService.loadUnFollowFans(body);
        call.enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                listener.success(response.body());
                ResultStatusFilter.filter(response.body());
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                listener.fail("网络有点问题");
            }
        });

    }

    @Override
    public void getFollowEachOther(String sessionId, String objectId, final NetWorkSoveListener<UserResult> listener) {

        //请求未关注的
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, sessionId)
                .addParameter(Constant.RESULT_OBJECT_ID, objectId)
                .build();

        //我的粉丝,为关注的
        Call<UserResult> call = AppConfig.netWorkService.getFollowEachOther(body);

        call.enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                listener.success(response.body());
                ResultStatusFilter.filter(response.body());
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                listener.fail("网络有点问题");
            }
        });

    }
}
