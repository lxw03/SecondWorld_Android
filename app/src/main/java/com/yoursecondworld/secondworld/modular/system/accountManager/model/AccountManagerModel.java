package com.yoursecondworld.secondworld.modular.system.accountManager.model;

import com.yoursecondworld.secondworld.AppConfig;
import com.yoursecondworld.secondworld.MyApp;
import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.common.JsonRequestParameter;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.ResultStatusFilter;
import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.modular.main.message.entity.MessageEntity;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cxj on 2016/9/27.
 */
public class AccountManagerModel implements IAccountManagerModel {
    @Override
    public void send_bind_phone_number_message(String session_id, String object_id, String phone_number, final NetWorkSoveListener<BaseEntity> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, object_id)
                .addParameter("phone_number", phone_number)
                .build();
        Call<MessageEntity> call = AppConfig.netWorkService.send_bind_phone_number_message(body);
        call.enqueue(new Callback<MessageEntity>() {
            @Override
            public void onResponse(Call<MessageEntity> call, Response<MessageEntity> response) {
                MessageEntity bb = response.body();
                listener.success(bb);
                ResultStatusFilter.filter(bb);
            }

            @Override
            public void onFailure(Call<MessageEntity> call, Throwable t) {
                listener.fail("网络有点问题");
            }
        });
    }

    @Override
    public void auth_bind_phone_number_message(String session_id, String object_id, String phone_number, String password,
                                               String code, final NetWorkSoveListener<BaseEntity> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, object_id)
                .addParameter("phone_number", phone_number)
                .addParameter("password", password)
                .addParameter("code", code)
                .build();
        Call<MessageEntity> call = AppConfig.netWorkService.send_bind_phone_number_message(body);
        call.enqueue(new Callback<MessageEntity>() {
            @Override
            public void onResponse(Call<MessageEntity> call, Response<MessageEntity> response) {
                MessageEntity bb = response.body();
                listener.success(bb);
                ResultStatusFilter.filter(bb);
            }

            @Override
            public void onFailure(Call<MessageEntity> call, Throwable t) {
                listener.fail("网络有点问题");
            }
        });
    }
}
