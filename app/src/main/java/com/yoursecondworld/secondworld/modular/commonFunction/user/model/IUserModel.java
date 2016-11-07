package com.yoursecondworld.secondworld.modular.commonFunction.user.model;

import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;


/**
 * Created by cxj on 2016/9/1.
 */
public interface IUserModel {

    /**
     * 关注用户
     *
     * @param session_id
     * @param object_id
     * @param user_id
     * @param listener
     */
    void followUser(String session_id, String object_id, String user_id, NetWorkSoveListener<BaseEntity> listener);

    /**
     * 取消关注
     *
     * @param session_id
     * @param object_id
     * @param user_id
     * @param listener
     */
    void unFollowUser(String session_id, String object_id, String user_id, NetWorkSoveListener<BaseEntity> listener);

    /**
     * 拉黑用户
     *
     * @param session_id
     * @param object_id
     * @param user_id
     * @param listener
     */
    void blockUser(String session_id, String object_id, String user_id, NetWorkSoveListener<BaseEntity> listener);

    /**
     * 取消拉黑用户
     *
     * @param session_id
     * @param object_id
     * @param user_id
     * @param listener
     */
    void unblock_user(String session_id, String object_id, String user_id, NetWorkSoveListener<BaseEntity> listener);

}
