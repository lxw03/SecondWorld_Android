package com.yoursecondworld.secondworld.modular.commonFunction.feedback.model;

import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;

/**
 * Created by cxj on 2016/9/16.
 */
public interface IFeedbackModel {

    void post_feedback(String sessionId, String objectId, String feedback, NetWorkSoveListener<BaseEntity> listener);

}
