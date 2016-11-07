package com.yoursecondworld.secondworld.modular.commonFunction.postComment.model;

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
 * Created by cxj on 2016/9/20.
 */
public class PostCommentModel implements IPostCommentModel {

    @Override
    public void postDynamicsComment(String session_id, String object_id, String article_id, String comment, String userId,
                                    final NetWorkSoveListener<BaseEntity> listener) {
        JsonRequestParameter jp = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, object_id)
                .addParameter("article_id", article_id)
                .addParameter("comment", comment);
        if (userId != null) {
            jp.addParameter("userId", userId);
        }
        RequestBody body = jp.build();

        Call<BaseEntity> call = AppConfig.netWorkService.postDynamicsComment(body);
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
