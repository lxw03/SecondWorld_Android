package com.yoursecondworld.secondworld.modular.commonModel;

import com.yoursecondworld.secondworld.AppConfig;
import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.common.JsonRequestParameter;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cxj on 2016/10/27.
 */
public class UserModel implements IUserModel {

    @Override
    public void report_user(String sessionId, String objectId, String userId, String reason,
                            final NetWorkSoveListener<BaseEntity> listener) {

        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, sessionId)
                .addParameter(Constant.RESULT_OBJECT_ID, objectId)
                .addParameter("user_id", userId)
                .addParameter("reason", "no")
                .build();


        Call<BaseEntity> call = AppConfig.netWorkService.report_user(body);
        call.enqueue(new Callback<BaseEntity>() {
            @Override
            public void onResponse(Call<BaseEntity> call, Response<BaseEntity> response) {
                listener.success(response.body());
            }

            @Override
            public void onFailure(Call<BaseEntity> call, Throwable t) {
                listener.fail("网络似乎有点问题");
            }
        });

    }

}
