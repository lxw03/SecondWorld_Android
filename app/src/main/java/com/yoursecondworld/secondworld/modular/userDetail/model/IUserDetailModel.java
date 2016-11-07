package com.yoursecondworld.secondworld.modular.userDetail.model;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.modular.systemInfo.entity.UserResult;

/**
 * Created by cxj on 2016/8/26.
 */
public interface IUserDetailModel {

    /**
     * 获取用户的信息
     *
     * @param session_id
     * @param object_id
     * @param user_id
     * @param listener
     */
    void getUserInfo(String session_id, String object_id, String user_id, NetWorkSoveListener<UserResult> listener);

}
