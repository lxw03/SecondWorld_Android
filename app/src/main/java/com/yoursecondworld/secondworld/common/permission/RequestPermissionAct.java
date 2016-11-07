package com.yoursecondworld.secondworld.common.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import android.os.Bundle;
import android.view.Window;


/**
 * 申请权限的activity
 * 申请流程的封装
 */
public class RequestPermissionAct extends Activity {

    /**
     * 请求权限的请求码
     */
    public static final int REQUEST_PERMISSION_CODE = 31 * 6;

    /**
     * 要申请的权限
     */
    private static String permission;

    /**
     * 申请结果的监听
     */
    private static OnResultListener listener;

    private Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            int what = msg.what;
            if (what == 0) { //表示成功
                listener.onRequestSuccess(permission);
            } else { //失败
                listener.onRequestFail(permission);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置没有标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        doRequestPermission();

    }

    /**
     * 申请权限
     */
    private void doRequestPermission() {
        //如果手机系统是api23的,那么就得检查权限,如果没有权限的话应该去请求
        if (Build.VERSION.SDK_INT >= 23) {
            int checkCameraPermission = ContextCompat.checkSelfPermission(this, permission);
            if (checkCameraPermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{permission}, REQUEST_PERMISSION_CODE);
                return;
            }
        }
        listener.onRequestSuccess(permission);
        finish();
    }

    /**
     * 权限申请的结果回掉
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) { //如果允许了
                    h.sendEmptyMessage(0);
                } else {
                    h.sendEmptyMessage(1);
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        finish();
    }

    /**
     * 申请权限,不用启动这个activity
     * 调用这个方法自己会完成启动和销毁的工作
     *
     * @param context    上下文
     * @param permission 权限 {@link Manifest.permission}
     * @param listener   监听器
     */
    public static void requestPermission(Context context, String permission, OnResultListener listener) {
        RequestPermissionAct.permission = permission;
        RequestPermissionAct.listener = listener;
        //启动activity
        context.startActivity(new Intent(context, RequestPermissionAct.class));
    }


    /**
     * 权限申请结果的回掉
     */
    public interface OnResultListener {

        /**
         * 权限申请成功
         *
         * @param permission
         */
        void onRequestSuccess(String permission);

        /**
         * 权限申请失败
         *
         * @param permission
         */
        void onRequestFail(String permission);

    }

}
