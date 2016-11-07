package com.yoursecondworld.secondworld.modular.commonFunction.feedback.model;

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
 * Created by cxj on 2016/9/16.
 */
public class FeedbackModel implements IFeedbackModel {
    @Override
    public void post_feedback(String sessionId, String objectId, String feedback, final NetWorkSoveListener<BaseEntity> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, sessionId)
                .addParameter(Constant.RESULT_OBJECT_ID, objectId)
                .addParameter("feedback", feedback)
                .build();
        Call<BaseEntity> call = AppConfig.netWorkService.post_feedback(body);
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
