package com.yoursecondworld.secondworld.modular.postDynamics.model;

import com.yoursecondworld.secondworld.AppConfig;
import com.yoursecondworld.secondworld.MyApp;
import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.Constant;
import com.yoursecondworld.secondworld.common.JsonRequestParameter;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.ResultStatusFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cxj on 2016/8/24.
 */
public class PostDynamicsModel implements IPostDynamicsModel {

    @Override
    public void postDynamics(String session_id, String object_id, String game_tag, String type_tag,
                             String content, String[] video_list, String[] picture_list, Integer money, String infor_type,
                             final NetWorkSoveListener<BaseEntity> listener) {

        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter(Constant.RESULT_SESSION_ID, session_id)
                .addParameter(Constant.RESULT_OBJECT_ID, object_id)
                .addParameter("game_tag", game_tag)
                .addParameter("type_tag", type_tag)
                .addParameter("content", content)
                .addParameter("money", money)
                .addParameter("infor_type", infor_type)
                .addParameter("picture_list", picture_list)
                .addParameter("video_list", video_list)
                .build();

        Call<BaseEntity> call = AppConfig.netWorkService.postDynamics(body);
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
    public List<File> converse(List<String> images) {
        List<File> files = new ArrayList<File>();
        int size = images.size();
        for (int i = 0; i < size; i++) {
            File f = new File(images.get(i));
            if (f.exists() && f.isFile()) {
                files.add(f);
            }
        }
        return files;
    }


}
