package com.yoursecondworld.secondworld.modular.main.popupWindow.postDynamics;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by cxj on 2016/7/6.
 */
public class PostDynamicsPopupWindowSpaceItemDecoration extends RecyclerView.ItemDecoration {

    /**
     * 竖直方向的间距
     */
    private int vSpace;


    public PostDynamicsPopupWindowSpaceItemDecoration(int vSpace) {
        this.vSpace = vSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        if (parent.getChildAdapterPosition(view) >= 3)
            outRect.top = vSpace;
            outRect.bottom = vSpace;
    }
}
