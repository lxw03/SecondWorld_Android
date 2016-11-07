package com.yoursecondworld.secondworld.modular.commonFunction.postComment.presenter;

import android.text.TextUtils;

import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.modular.commonFunction.postComment.model.IPostCommentModel;
import com.yoursecondworld.secondworld.modular.commonFunction.postComment.model.PostCommentModel;
import com.yoursecondworld.secondworld.modular.commonFunction.postComment.view.IpostCommentView;

/**
 * Created by cxj on 2016/9/20.
 */
public class PostCommentPresenter {

    private IPostCommentModel model = new PostCommentModel();

    private IpostCommentView view;

    public PostCommentPresenter(IpostCommentView view) {
        this.view = view;
    }

    /**
     * 发布动态的评论
     */
    public void postDynamicsComment() {

        String commentContent = view.getCommentContent();

        if (TextUtils.isEmpty(commentContent)) {
            view.tip("评论内容不能为空");
            return;
        }

        commentContent = commentContent.trim();

        if (commentContent.length() > 120) {
            view.tip("评论内容过长");
            return;
        }

        view.showDialog("正在发布评论");

        //发布评论
        model.postDynamicsComment(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), view.getDynamicsId(), commentContent.trim(), view.getComentTargetUserId(),
                new NetWorkSoveListener<BaseEntity>() {
                    @Override
                    public void success(BaseEntity entity) {
                        view.closeDialog();
                        view.clearCommentContent();
                        view.onCommentSuccess();
                    }

                    @Override
                    public void fail(String msg) {
                        view.closeDialog();
                        view.tip("加载评论列表失败");
                    }
                });

    }

}
