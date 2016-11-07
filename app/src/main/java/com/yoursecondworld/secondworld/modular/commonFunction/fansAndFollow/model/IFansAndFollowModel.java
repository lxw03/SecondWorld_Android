package com.yoursecondworld.secondworld.modular.commonFunction.fansAndFollow.model;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.modular.systemInfo.entity.UserResult;

/**
 * Created by cxj on 2016/9/9.
 */
public interface IFansAndFollowModel {

    void loadUnFollowFans(String sessionId, String objectId, String pass,
                          NetWorkSoveListener<UserResult> listener);


    void getFollowEachOther(String sessionId, String objectId, NetWorkSoveListener<UserResult> listener);

}
