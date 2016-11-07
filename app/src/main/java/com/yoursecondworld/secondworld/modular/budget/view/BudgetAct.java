package com.yoursecondworld.secondworld.modular.budget.view;

import android.view.View;
import android.widget.TextView;

import com.yoursecondworld.secondworld.R;
import com.yoursecondworld.secondworld.common.BaseAct;

import xiaojinzi.annotation.Injection;

/**
 * 预算的界面
 */
@Injection(R.layout.act_budget)
public class BudgetAct extends BaseAct {

    @Injection(value = R.id.tv_menu, click = "clickView")
    private TextView tv_menu;

    @Injection(R.id.tv_title_name)
    private TextView tv_title;

    @Override
    public void initView() {
        super.initView();
        tv_title.setText("预算设置");
        tv_menu.setVisibility(View.VISIBLE);
        tv_menu.setText("完成");
    }

    /**
     * 点击事件的集中处理
     *
     * @param v
     */
    public void clickView(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.tv_menu:
                finish();
                break;
        }
    }


    @Override
    public boolean isRegisterEvent() {
        return false;
    }
}
