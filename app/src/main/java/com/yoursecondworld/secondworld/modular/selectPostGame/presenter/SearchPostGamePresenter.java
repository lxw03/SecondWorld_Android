package com.yoursecondworld.secondworld.modular.selectPostGame.presenter;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.modular.selectPostGame.entity.GamesResult;
import com.yoursecondworld.secondworld.modular.selectPostGame.model.ISearchPostGameModel;
import com.yoursecondworld.secondworld.modular.selectPostGame.model.SearchPostGameModel;
import com.yoursecondworld.secondworld.modular.selectPostGame.view.ISearchPostGameView;

/**
 * Created by cxj on 2016/10/24.
 */
public class SearchPostGamePresenter {

    private ISearchPostGameView view;

    private ISearchPostGameModel model = new SearchPostGameModel();

    public SearchPostGamePresenter(ISearchPostGameView view) {
        this.view = view;
    }

    public void searchGames() {
        model.searchGames(view.getSearchKey(), new NetWorkSoveListener<GamesResult>() {
            @Override
            public void success(GamesResult searchGamesResult) {
                view.onSearchSuccess(searchGamesResult.getGames());
            }

            @Override
            public void fail(String msg) {
                view.tip(msg);
            }
        });
    }


}
