package com.yoursecondworld.secondworld.modular.personInfo.model;

import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;

/**
 * Created by cxj on 2016/9/6.
 */
public interface IEditPersonInfoModel {

    void set_head_image(String sessionId, String objectId, String head_image, NetWorkSoveListener<BaseEntity> listener);

    void set_nickname(String sessionId, String objectId, String nickname, NetWorkSoveListener<BaseEntity> listener);

    void set_introduction(String sessionId, String objectId, String introduction, NetWorkSoveListener<BaseEntity> listener);

    void set_sex(String sessionId, String objectId, String sex, NetWorkSoveListener<BaseEntity> listener);

    void set_birthday(String sessionId, String objectId,
                      String birth, NetWorkSoveListener<BaseEntity> listener);

    void updateGameLabel(String sessionId, String objectId, String[] game_name, NetWorkSoveListener<BaseEntity> listener);

}
