package com.yoursecondworld.secondworld.modular.prepareModule.improvePersonInfo.model;


import com.yoursecondworld.secondworld.AppConfig;
import com.yoursecondworld.secondworld.MyApp;
import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.common.JsonRequestParameter;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.ResultStatusFilter;
import com.yoursecondworld.secondworld.modular.prepareModule.improvePersonInfo.entity.NickNameIsExistResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cxj on 2016/8/11.
 */
public class ImprovePersonInfoModel implements IImprovePersonInfoModel {

    @Override
    public void uploadAvatarAddress(String localImagePath) {

    }

    @Override
    public void improveInfo(String sessionId, String objectId,
                            String avatarAddress, String nickName, String sex, final NetWorkSoveListener<BaseEntity> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, sessionId)
                .addParameter(Constant.RESULT_OBJECT_ID, objectId)
                .addParameter("nickname", nickName)
                .addParameter("sex", sex)
                .addParameter("head_image", avatarAddress)
                .build();
        Call<BaseEntity> call = AppConfig.netWorkService.combine_set_information(body);
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
    public void set_birthday(String sessionId, String objectId, String birthday, final NetWorkSoveListener<BaseEntity> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, sessionId)
                .addParameter(Constant.RESULT_OBJECT_ID, objectId)
                .addParameter("birthday", birthday)
                .build();
        Call<BaseEntity> call = AppConfig.netWorkService.set_birthday(body);
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
    public void isNickNameExist(String nickName, final NetWorkSoveListener<NickNameIsExistResult> listener) {
        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter("nickname", nickName)
                .build();
        Call<NickNameIsExistResult> call = AppConfig.netWorkService.nickname_exist(body);
        call.enqueue(new Callback<NickNameIsExistResult>() {

            @Override
            public void onResponse(Call<NickNameIsExistResult> call, Response<NickNameIsExistResult> response) {
                listener.success(response.body());
                ResultStatusFilter.filter(response.body());
            }

            @Override
            public void onFailure(Call<NickNameIsExistResult> call, Throwable t) {
                listener.fail("网络有点问题");
            }

        });
    }
}
