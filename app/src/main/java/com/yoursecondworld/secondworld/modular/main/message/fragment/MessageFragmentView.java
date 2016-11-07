package com.yoursecondworld.secondworld.modular.main.message.fragment;

import com.yoursecondworld.secondworld.modular.main.message.entity.MessageEntity;
import com.yoursecondworld.secondworld.modular.mvp.view.IBaseView;

/**
 * Created by cxj on 2016/9/24.
 */
public interface MessageFragmentView extends IBaseView {
    void onloadNewMessageSuccess(MessageEntity messageEntity);
}
