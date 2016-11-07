package com.yoursecondworld.secondworld.modular.im.popupMenu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.yoursecondworld.secondworld.R;
import com.yoursecondworld.secondworld.common.NetWorkSoveListener;
import com.yoursecondworld.secondworld.common.StaticDataStore;
import com.yoursecondworld.secondworld.common.baseResult.BaseEntity;
import com.yoursecondworld.secondworld.modular.commonFunction.user.presenter.UserPresenter;
import com.yoursecondworld.secondworld.modular.commonFunction.user.view.IUserView;
import com.yoursecondworld.secondworld.modular.commonModel.UserModel;
import com.yoursecondworld.secondworld.modular.im.ConversationAct;
import com.yoursecondworld.secondworld.modular.main.eventEntity.SharePlatformEntity;
import com.yoursecondworld.secondworld.modular.main.popupWindow.share.ShareAdapter;
import com.yoursecondworld.secondworld.modular.main.popupWindow.share.ShareEntity;
import com.yoursecondworld.secondworld.modular.main.popupWindow.share.SharePopupWindowSpaceItemDecoration;
import com.yoursecondworld.secondworld.modular.share.ShareUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import io.rong.imkit.RongIM;
import xiaojinzi.base.android.adapter.recyclerView.CommonRecyclerViewAdapter;
import xiaojinzi.base.android.os.T;

/**
 * Created by cxj on 2016/7/24.
 * 弹出分享的界面,这个用android自带的轻量级组件弹出
 */
public class PopupMenu extends BottomSheetDialog implements IUserView, View.OnClickListener {


    /**
     * 弹出的视图
     */
    private View contentView;

    private Context mContext;

    private UserPresenter userPresenter = new UserPresenter(this);

    /**
     * 创建弹出的界面
     *
     * @param context
     */
    public PopupMenu(@NonNull Context context) {
        super(context);
        this.mContext = context;
        contentView = View.inflate(context, R.layout.act_im_converst_popup_menu, null);

        initView(contentView);

        setContentView(contentView);

        setOnListener();
    }

    private TextView tv_shield;
    private TextView tv_report;

    /**
     * 初始化控件
     *
     * @param contentView
     */
    private void initView(View contentView) {
        tv_shield = (TextView) contentView.findViewById(R.id.tv_shield);
        tv_report = (TextView) contentView.findViewById(R.id.tv_report);
    }

    /**
     * 设置条目的监听
     */
    private void setOnListener() {
        tv_shield.setOnClickListener(this);
        tv_report.setOnClickListener(this);
    }

    /**
     * 获取视图
     *
     * @return
     */
    public View getContentView() {
        return contentView;
    }

    @Override
    public void onFollowSuccess(Object... obs) {
    }

    @Override
    public void onUnFollowSuccess(Object... obs) {
    }

    @Override
    public void onBlockSuccess() {
    }

    @Override
    public void onUnBlockSuccess() {
    }

    @Override
    public void showDialog(String content) {
    }

    @Override
    public void closeDialog() {
    }

    @Override
    public void tip(String content) {
        T.showShort(mContext, content);
    }

    @Override
    public void onSessionInvalid() {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.tv_shield: //如果是屏蔽这个人
                userPresenter.blockUser(ConversationAct.targetUserId);
                break;
            case R.id.tv_report: //如果是举报

                UserModel userModel = new UserModel();
                userModel.report_user(StaticDataStore.session_id, StaticDataStore.newUser.getUser_id(), ConversationAct.targetUserId, null, new NetWorkSoveListener<BaseEntity>() {
                    @Override
                    public void success(BaseEntity baseEntity) {
                        tip("举报成功");
                    }

                    @Override
                    public void fail(String msg) {
                        tip(msg);
                    }
                });

                break;
        }
        dismiss();
    }
}
