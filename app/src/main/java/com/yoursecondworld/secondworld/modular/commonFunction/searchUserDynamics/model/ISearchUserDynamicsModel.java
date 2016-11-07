package com.yoursecondworld.secondworld.modular.commonFunction.searchUserDynamics.model;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.modular.dynamics.entity.DynamicsResult;

/**
 * Created by cxj on 2016/9/12.
 */
public interface ISearchUserDynamicsModel {

    /**
     * 搜索我的动态
     *
     * @param sessionId
     * @param objectId
     * @param userId
     * @param to_search
     * @param pass
     * @param listener
     */
    void searchUserDynamics(String sessionId, String objectId, String userId, String to_search, String pass,
                            NetWorkSoveListener<DynamicsResult> listener);

}
