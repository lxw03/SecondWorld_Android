package com.yoursecondworld.secondworld.modular.system.accountManager.model;

import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;

/**
 * Created by cxj on 2016/9/27.
 */
public interface IAccountManagerModel {

    void send_bind_phone_number_message(String session_id, String object_id, String phone_number, NetWorkSoveListener<BaseEntity> listener);


    void auth_bind_phone_number_message(String session_id, String object_id,
                                        String phone_number, String password, String code,
                                        NetWorkSoveListener<BaseEntity> listener);

}
