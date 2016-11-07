package com.yoursecondworld.secondworld.modular.commonFunction.feedback.presenter;

import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.modular.commonFunction.feedback.model.FeedbackModel;
import com.yoursecondworld.secondworld.modular.commonFunction.feedback.model.IFeedbackModel;
import com.yoursecondworld.secondworld.modular.commonFunction.feedback.view.IFeedbackView;

/**
 * Created by cxj on 2016/9/16.
 */
public class FeedbackPresenter {

    private IFeedbackView view;

    private IFeedbackModel model = new FeedbackModel();

    public FeedbackPresenter(IFeedbackView view) {
        this.view = view;
    }

    /**
     * 发送反馈
     *
     * @param content
     */
    public void post_feedback(String content) {

        view.showDialog("正在提交");

        model.post_feedback(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), content, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                view.closeDialog();
                view.tip("提交成功");
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
                view.tip("提交失败");
            }
        });

    }

}
