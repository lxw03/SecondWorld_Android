package com.yoursecondworld.secondworld.modular.statusNotification.model;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.modular.statusNotification.enity.CommentsListResult;
import com.yoursecondworld.secondworld.modular.statusNotification.enity.ZanListResult;

/**
 * Created by cxj on 2016/9/19.
 */
public interface IStatusNotificationModel {

    void mes_get_comments_list(String sessionId, String objectId, String pass,
                               final NetWorkSoveListener<CommentsListResult> listener);

    void mes_get_likes_list(String sessionId, String objectId, String pass,
                            final NetWorkSoveListener<ZanListResult> listener);

}
