package com.yoursecondworld.secondworld.modular.selectPostGame.model;

import com.yoursecondworld.secondworld.AppConfig;
import com.yoursecondworld.secondworld.common.JsonRequestParameter;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.modular.selectPostGame.entity.GamesResult;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cxj on 2016/10/24.
 */
public class SearchPostGameModel implements ISearchPostGameModel {
    @Override
    public void searchGames(String to_search, final NetWorkSoveListener<GamesResult> listener) {

        RequestBody body = JsonRequestParameter.getInstance()
                .addParameter("to_search", to_search)
                .build();

        Call<GamesResult> call = AppConfig.netWorkService.search_game(body);
        call.enqueue(new Callback<GamesResult>() {
            @Override
            public void onResponse(Call<GamesResult> call, Response<GamesResult> response) {
                listener.success(response.body());
            }

            @Override
            public void onFailure(Call<GamesResult> call, Throwable t) {
                listener.fail("网络有点问题");
            }
        });

    }
}
