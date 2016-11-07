package com.yoursecondworld.secondworld.modular.commonFunction.loadMyDynamics.model;

import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.modular.dynamics.entity.DynamicsResult;

/**
 * Created by cxj on 2016/9/2.
 * 加载我的动态的逻辑处理层面
 */
public interface ILoadMyDynamicsModel {

    /**
     * 加载我的动态
     *
     * @param sessionId
     * @param objectId
     * @param userid
     * @param listener
     */
    void loadMyDynamics(String sessionId, String objectId, String userid, String pass,
                        NetWorkSoveListener<DynamicsResult> listener);

    /**
     * 删除动态
     *
     * @param sessionId
     * @param objectId
     * @param dynamicsid
     * @param listener
     */
    void deleteDynamics(String sessionId, String objectId, String dynamicsid, NetWorkSoveListener<BaseEntity> listener);

}
