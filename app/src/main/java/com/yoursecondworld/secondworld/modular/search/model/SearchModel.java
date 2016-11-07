package com.yoursecondworld.secondworld.modular.search.model;

import com.yoursecondworld.secondworld.AppConfig;
import com.yoursecondworld.secondworld.MyApp;
import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.common.JsonRequestParameter;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.ResultStatusFilter;
import com.yoursecondworld.secondworld.modular.dynamics.entity.DynamicsResult;
import com.yoursecondworld.secondworld.modular.systemInfo.entity.UserResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cxj on 2016/9/3.
 */
public class SearchModel implements ISearchModel {

    @Override
    public void searchDynamics(String session_id, String object_id, String to_search, String pass,
                               final NetWorkSoveListener<DynamicsResult> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, object_id)
                .addParameter("to_search", to_search)
                .addParameter(Constant.RESULT_PASS, pass)
                .build();

        Call<DynamicsResult> call = AppConfig.netWorkService.searchDynamics(body);

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
    public void searchUser(String session_id, String object_id, String to_search, String pass,
                           final NetWorkSoveListener<UserResult> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, object_id)
                .addParameter("to_search", to_search)
                .addParameter(Constant.RESULT_PASS, pass)
                .build();

        Call<UserResult> call = AppConfig.netWorkService.searchUser(body);

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
