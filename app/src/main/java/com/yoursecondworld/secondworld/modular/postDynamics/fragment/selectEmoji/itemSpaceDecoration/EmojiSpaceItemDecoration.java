package com.yoursecondworld.secondworld.modular.postDynamics.fragment.selectEmoji.itemSpaceDecoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import xiaojinzi.autolayout.utils.AutoUtils;

/**
 * Created by cxj on 2016/7/6.
 * 用在发布动态界面的底部的选择图片的列表上,水平的间距
 */
public class EmojiSpaceItemDecoration extends RecyclerView.ItemDecoration {

    /**
     * 水平方向的间距
     */
    private int hSpace;

    public EmojiSpaceItemDecoration() {
        hSpace = AutoUtils.getPercentWidthSize(28);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        if (parent.getChildAdapterPosition(view) > 0) {
            outRect.left = hSpace;
            outRect.right = hSpace;
//        }
    }
}
