package com.yoursecondworld.secondworld.modular.commonFunction.postComment.model;

import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;

/**
 * Created by cxj on 2016/9/20.
 */
public interface IPostCommentModel {

    void postDynamicsComment(String session_id, String object_id, String article_id, String comment, String userId
            , NetWorkSoveListener<BaseEntity> listener);

}
