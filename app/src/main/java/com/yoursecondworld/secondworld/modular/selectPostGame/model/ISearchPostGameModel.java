package com.yoursecondworld.secondworld.modular.selectPostGame.model;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.modular.selectPostGame.entity.GamesResult;

/**
 * Created by cxj on 2016/10/24.
 */
public interface ISearchPostGameModel {

    /**
     * 搜索游戏标签
     *
     * @param to_search
     * @param listener
     */
    void searchGames(String to_search,
                     NetWorkSoveListener<GamesResult> listener);

}
