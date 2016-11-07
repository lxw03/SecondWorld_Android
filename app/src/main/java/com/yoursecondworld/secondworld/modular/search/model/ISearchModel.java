package com.yoursecondworld.secondworld.modular.search.model;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.modular.dynamics.entity.DynamicsResult;
import com.yoursecondworld.secondworld.modular.systemInfo.entity.UserResult;

/**
 * Created by cxj on 2016/9/3.
 */
public interface ISearchModel {

    /**
     * 搜索动态
     *
     * @param session_id
     * @param object_id
     * @param to_search
     * @param pass
     * @param listener
     */
    void searchDynamics(String session_id, String object_id, String to_search, String pass,
                        NetWorkSoveListener<DynamicsResult> listener);

    /**
     * 搜索用户
     *
     * @param session_id
     * @param object_id
     * @param to_search
     * * @param pass
     * @param listener
     */
    void searchUser(String session_id, String object_id, String to_search, String pass,
                    NetWorkSoveListener<UserResult> listener);

}
