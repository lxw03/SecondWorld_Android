package com.yoursecondworld.secondworld.modular.commonModel;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;

/**
 * Created by cxj on 2016/10/27.
 */
public interface IUserModel {

    void report_user(String sessionId, String objectId, String userId, String reason,
                     final NetWorkSoveListener<BaseEntity> listener);

}
