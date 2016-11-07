package com.yoursecondworld.secondworld.modular.commonFunction.searchUserDynamics.model;

import com.yoursecondworld.secondworld.AppConfig;
import com.yoursecondworld.secondworld.MyApp;
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
 * Created by cxj on 2016/9/12.
 */
public class SearchUserDynamicsModel implements ISearchUserDynamicsModel {

    @Override
    public void searchUserDynamics(String sessionId, String objectId, String userId, String to_search, String pass,
                                   final NetWorkSoveListener<DynamicsResult> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, sessionId)
                .addParameter(Constant.RESULT_OBJECT_ID, objectId)
                .addParameter("user_id", userId)
                .addParameter("to_search", to_search)
                .addParameter(Constant.RESULT_PASS, pass)
                .build();

        Call<DynamicsResult> call = AppConfig.netWorkService.search_user_article(body);
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

}
