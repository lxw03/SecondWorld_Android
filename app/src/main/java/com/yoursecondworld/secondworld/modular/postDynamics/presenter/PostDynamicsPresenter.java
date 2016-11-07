package com.yoursecondworld.secondworld.modular.postDynamics.presenter;


import android.text.TextUtils;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.modular.oos.OSSUtil;
import com.yoursecondworld.secondworld.modular.postDynamics.model.IPostDynamicsModel;
import com.yoursecondworld.secondworld.modular.postDynamics.model.PostDynamicsModel;
import com.yoursecondworld.secondworld.modular.postDynamics.view.IPostDynamicsView;

import java.io.File;
import java.util.List;

/**
 * Created by cxj on 2016/8/24.
 */
public class PostDynamicsPresenter implements OSSUtil.InitListener, OSSCompletedCallback<PutObjectRequest, PutObjectResult> {

    /**
     * 试图层
     */
    private IPostDynamicsView view;

    private IPostDynamicsModel model = new PostDynamicsModel();

    public PostDynamicsPresenter(IPostDynamicsView view) {
        this.view = view;
    }

    /**
     * 发布动态
     */
    public void postDynamics() {


        //发布之前做一些健壮性的判断
        String dynamicsContent = view.getDynamicsContent().trim();
        if (TextUtils.isEmpty(dynamicsContent)) {
            view.tip("发布内容不能为空");
            return;
        }

        //弹出进度条对话框
        view.showDialog("正在发布");
        OSSUtil.relaese();
        OSSUtil.init(view.getContext(), StaticDataStore.newUser.getUser_id(), this);


    }

    private String[] imageUrls;

    private String videoUrl;

    @Override
    public void onInitSuccess() {
        imageUrls = null;
        videoUrl = null;
        //拿到要上传的文件对象的集合
        List<File> files = model.converse(view.getSelectImages());
        if (files.size() == 0) { //如果没有图片的任务
            //再检查有没有视频的任务
            if (view.getVideoPath() != null) {
                videoUrl = OSSUtil.getInstance().uploadVideo(new File(view.getVideoPath()), this);
            } else {
                doPostDynamics();
            }
        } else {
            //先把图片给上传了,返回图片的访问路径
            imageUrls = OSSUtil.getInstance().uploadImage(files, view.getDialog(), this);
        }

//        view.closeDialog();
//        view.tip("初始化成功");
    }

    @Override
    public void onInitFailure() {
        view.closeDialog();
        view.tip("初始化失败,发布失败");
    }

    //图片或者视频上传成功回掉
    @Override
    public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
//        view.tip("图片或者视频全部上传成功,正在发布动态");
//        view.closeDialog();
        doPostDynamics();
    }

    /**
     * 做发布的工作
     */
    private void doPostDynamics() {
        //发布视频
        model.postDynamics(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), view.getGameLabel(), view.getTopic(), view.getDynamicsContent(), new String[]{videoUrl},
                imageUrls, view.getMoney(), view.getExtraInfo(), new NetWorkSoveListener<BaseEntity>() {
                    @Override
                    public void success(BaseEntity entity) {
                        view.closeDialog();
                        view.tip("发布成功");
                        view.finishActivity();
                    }

                    @Override
                    public void fail(String msg) {
                        view.closeDialog();
                        view.tip("发布失败");
                    }
                });

    }

    @Override
    public void onFailure(PutObjectRequest putObjectRequest, ClientException e, ServiceException e1) {
        view.closeDialog();
        view.tip("图片上传失败,发布失败");
    }
}
