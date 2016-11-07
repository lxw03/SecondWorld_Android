package com.yoursecondworld.secondworld.modular.prepareModule.selectPlayer.model;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.modular.systemInfo.entity.UserResult;

/**
 * Created by cxj on 2016/9/18.
 */
public interface ISelectPlayerModel {

    void get_recommend_user_list(String sessionId, String objectId, NetWorkSoveListener<UserResult> listener);

}
