package com.yoursecondworld.secondworld.modular.personInfo.presenter;

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
import com.yoursecondworld.secondworld.modular.personInfo.model.EditPersonInfoModel;
import com.yoursecondworld.secondworld.modular.personInfo.model.IEditPersonInfoModel;
import com.yoursecondworld.secondworld.modular.personInfo.view.IEditPersonInfoView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by cxj on 2016/9/6.
 */
public class EditPersonInfoPresenter implements OSSUtil.InitListener, OSSCompletedCallback<PutObjectRequest, PutObjectResult> {


    private IEditPersonInfoView view;

    private IEditPersonInfoModel model = new EditPersonInfoModel();

    public EditPersonInfoPresenter(IEditPersonInfoView view) {
        this.view = view;
    }

    /**
     * 更新昵称
     */
    public void updateNickName() {

        String nickName = view.getNickName();
        if (TextUtils.isEmpty(nickName)) {
            view.tip("昵称不可以为空");
            return;
        }

        if (nickName.length() > 12) {
            view.tip("昵称长度不可以超过12个字符");
            return;
        }

        view.showDialog("正在保存");

        model.set_nickname(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), nickName, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                view.closeDialog();
                view.tip("保存成功");
                view.onUpdateNickNameSuccess();
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
                view.tip("昵称已存在");
            }
        });

    }

    public void updateSex() {
        //拿到性别
        String sex = view.getSex();

        view.showDialog("正在保存");

        model.set_sex(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), sex, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                view.closeDialog();
//                view.tip("保存成功");
                view.onUpdateSexSuccess();
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
                view.tip("保存性别失败");
            }
        });

    }

    public void updateAge() {

        //拿到生日信息
        String birth = view.getBirth();

        model.set_birthday(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), birth, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                view.closeDialog();
                view.tip("保存成功");
                view.onUpdateBirthSuccess();
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
                view.tip("保存失败");
            }
        });

    }

    /**
     * 更新描述
     */
    public void updateDesc() {

        //获取到描述的信息
        String desc = view.getDesc();

        if (TextUtils.isEmpty(desc)) {
            view.tip("描述不能为空");
            return;
        }

        view.showDialog("正在保存");

        model.set_introduction(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), desc, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                view.closeDialog();
                view.tip("保存成功");
                view.onUpdateDescSuccess();
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
                view.tip("保存简介失败");
            }
        });

    }

    private File imageFile;

    /**
     * 开始上传图片的工作
     */
    public void set_head_image(String localImagePath) {

        view.showDialog("正在上传头像");

        //拿到要上传的图片
        String imagepath = view.getImagepath();
        if (TextUtils.isEmpty(imagepath)) {
            view.closeDialog();
            view.tip("请选择文件");
        } else {
            File f = new File(imagepath);
            if (f.exists() && f.isFile()) {
                imageFile = f;
                OSSUtil.relaese();
                OSSUtil.init(view.getContext(), view.getUserId(), this);
            } else {
                view.closeDialog();
                view.tip("文件不存在");
            }
        }

    }

    /**
     * 上传成功之后这个地址就是网络的地址
     */
    private String imageUrl;

    @Override
    public void onInitSuccess() {
        //上传成功的话这个地址就是图片你的网络地址
        imageUrl = OSSUtil.getInstance().uploadHeadImage(imageFile, this);
    }

    @Override
    public void onInitFailure() {
        view.closeDialog();
        view.tip("初始化头像上传组建失败");
    }

    /**
     * 头像上传成功之后
     *
     * @param putObjectRequest
     * @param putObjectResult
     */
    @Override
    public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {

        //设置头像到服务器
        model.set_head_image(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), imageUrl, new NetWorkSoveListener<BaseEntity>() {
            @Override
            public void success(BaseEntity entity) {
                view.closeDialog();
                view.tip("保存顺利");
            }

            @Override
            public void fail(String msg) {
                view.closeDialog();
                view.tip("设置头像失败");
            }
        });

    }

    /**
     * 头像上传失败之后
     *
     * @param putObjectRequest
     * @param e
     * @param e1
     */
    @Override
    public void onFailure(PutObjectRequest putObjectRequest, ClientException e, ServiceException e1) {
        view.closeDialog();
        view.tip("头像上传失败");
    }
}
