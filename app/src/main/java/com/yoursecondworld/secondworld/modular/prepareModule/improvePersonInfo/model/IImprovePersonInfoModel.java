package com.yoursecondworld.secondworld.modular.prepareModule.improvePersonInfo.model;

import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.modular.prepareModule.improvePersonInfo.entity.NickNameIsExistResult;

/**
 * Created by cxj on 2016/8/11.
 * 完善信息的业务逻辑层
 */
public interface IImprovePersonInfoModel {

    /**
     * 上传头像
     *
     * @param localImagePath
     */
    void uploadAvatarAddress(String localImagePath);

    /**
     * 完善信息
     *
     * @param sessionId
     * @param objectId
     * @param avatarAddress
     * @param nickName
     * @param sex
     * @param listener
     */
    void improveInfo(String sessionId, String objectId,
                     String avatarAddress, String nickName, String sex,
                     NetWorkSoveListener<BaseEntity> listener);

    /**
     * 设置出生日期
     *
     * @param sessionId
     * @param objectId
     * @param birth
     * @param listener
     */
    void set_birthday(String sessionId, String objectId,
                      String birth, NetWorkSoveListener<BaseEntity> listener);

    /**
     * 判断昵称是否存在
     *
     * @param nickName
     * @param listener
     */
    void isNickNameExist(String nickName, NetWorkSoveListener<NickNameIsExistResult> listener);

}
