package com.yoursecondworld.secondworld.modular.statusNotification.model;

import com.yoursecondworld.secondworld.AppConfig;
import com.yoursecondworld.secondworld.MyApp;
import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.common.JsonRequestParameter;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.ResultStatusFilter;
import com.yoursecondworld.secondworld.modular.statusNotification.enity.CommentsListResult;
import com.yoursecondworld.secondworld.modular.statusNotification.enity.ZanListResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cxj on 2016/9/19.
 */
public class StatusNotificationModel implements IStatusNotificationModel {

    @Override
    public void mes_get_comments_list(String sessionId, String objectId, String pass,
                                      final NetWorkSoveListener<CommentsListResult> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, sessionId)
                .addParameter(Constant.RESULT_OBJECT_ID, objectId)
                .addParameter(Constant.RESULT_PASS, pass)
                .build();
        Call<CommentsListResult> call = AppConfig.netWorkService.mes_get_comments_list(body);
        call.enqueue(new Callback<CommentsListResult>() {
            @Override
            public void onResponse(Call<CommentsListResult> call, Response<CommentsListResult> response) {
                listener.success(response.body());
                ResultStatusFilter.filter(response.body());
            }

            @Override
            public void onFailure(Call<CommentsListResult> call, Throwable t) {
                listener.fail("网络有点问题");
            }
        });
    }

    @Override
    public void mes_get_likes_list(String sessionId, String objectId, String pass, final NetWorkSoveListener<ZanListResult> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, sessionId)
                .addParameter(Constant.RESULT_OBJECT_ID, objectId)
                .addParameter(Constant.RESULT_PASS, pass)
                .build();
        Call<ZanListResult> call = AppConfig.netWorkService.mes_get_likes_list(body);
        call.enqueue(new Callback<ZanListResult>() {
            @Override
            public void onResponse(Call<ZanListResult> call, Response<ZanListResult> response) {
                listener.success(response.body());
                ResultStatusFilter.filter(response.body());
            }

            @Override
            public void onFailure(Call<ZanListResult> call, Throwable t) {
                listener.fail("网络有点问题");
            }
        });
    }

}
