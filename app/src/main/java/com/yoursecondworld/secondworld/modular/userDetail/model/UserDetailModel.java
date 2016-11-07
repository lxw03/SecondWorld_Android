package com.yoursecondworld.secondworld.modular.userDetail.model;


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
 * Created by cxj on 2016/8/26.
 */
public class UserDetailModel implements IUserDetailModel {

    @Override
    public void getUserInfo(String session_id, String object_id, String user_id,
                            final NetWorkSoveListener<UserResult> listener) {

        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, object_id)
                .addParameter("user_id", user_id)
                .build();

        Call<UserResult> call = AppConfig.netWorkService.getUserInfo(body);

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
