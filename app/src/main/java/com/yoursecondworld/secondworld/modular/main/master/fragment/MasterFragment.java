package com.yoursecondworld.secondworld.modular.main.master.fragment;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yoursecondworld.secondworld.R;
import com.yoursecondworld.secondworld.common.view.WaveLoadingView;
import com.yoursecondworld.secondworld.modular.budget.view.BudgetAct;
import com.yoursecondworld.secondworld.modular.gameTimeDetail.view.GameTimeDetailAct;
import com.yoursecondworld.secondworld.modular.kryptonGoldDetail.view.KryptonGoldDetailAct;
import com.yoursecondworld.secondworld.modular.main.popupWindow.inputKryton.InputKrytonPopupWindow;
import com.yoursecondworld.secondworld.modular.selectPostGame.view.SelectPostGameAct;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import xiaojinzi.activity.fragment.BaseFragment;
import xiaojinzi.annotation.Injection;
import xiaojinzi.base.android.activity.ActivityUtil;
import xiaojinzi.base.android.os.ScreenUtils;

/**
 * Created by cxj on 2016/10/31.
 * 主界面挂载的Master功能的fragment
 */
public class MasterFragment extends BaseFragment {

    public static final int REQUEST_GAME_NAME_CODE = 122;

    @Injection(R.id.tv_date)
    private TextView tv_date;

    @Injection(value = R.id.iv_add_money, click = "clickView")
    private ImageView iv_add_money;

    @Injection(value = R.id.tv_budget_setting, click = "clickView")
    private TextView tv_budget_setting;

    @Injection(value = R.id.view_left, click = "clickView")
    private View view_left;

    @Injection(value = R.id.view_right, click = "clickView")
    private View view_right;

    @Injection(value = R.id.tv_krypton_detail, click = "clickView")
    private TextView tv_krypton_detail;

    @Injection(value = R.id.tv_time_detail, click = "clickView")
    private TextView tv_time_detail;

    @Injection(R.id.wldv_money)
    private WaveLoadingView wldv_money;

    @Injection(R.id.wldv_time)
    private WaveLoadingView wldv_time;

    private int year;
    private int month;

    @Override
    public int getLayoutId() {
        return R.layout.frag_master_for_main;
    }

    @Override
    protected void initView() {
        super.initView();

        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH) + 1;

        tv_date.setText(year + "-" + month);

    }

    private InputKrytonPopupWindow popupWindow;

    /**
     * 点击事件集中处理
     *
     * @param v
     */
    public void clickView(View v) {
        int id = v.getId();
        Random r = new Random();
        int value = r.nextInt(100);
        switch (id) {

            case R.id.view_left:

                tip("您点击的往左的日期");

                month--;


                wldv_money.setProgressValue(value);
                wldv_time.setProgressValue(value);
                wldv_money.setCenterTitle(value + "%");
                wldv_time.setCenterTitle(value + "%");

                tv_date.setText(year + "-" + month);

                break;

            case R.id.view_right:

                month++;

                wldv_money.setProgressValue(value);
                wldv_time.setProgressValue(value);
                wldv_money.setCenterTitle(value + "%");
                wldv_time.setCenterTitle(value + "%");

                tip("您点击的往右的日期");

                tv_date.setText(year + "-" + month);

                break;

            case R.id.iv_add_money:

                popupWindow = new InputKrytonPopupWindow(context);
//                popupWindow.setHeight(ScreenUtils.getScreenHeight(context));
                popupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);

                popupWindow.setListenerGameNameClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, SelectPostGameAct.class);
                        intent.putExtra(SelectPostGameAct.IS_RETURN_FLAG, true);
                        getActivity().startActivityForResult(intent, REQUEST_GAME_NAME_CODE);
                    }
                });

                break;
            case R.id.tv_krypton_detail:

                ActivityUtil.startActivity(context, KryptonGoldDetailAct.class);

                break;

            case R.id.tv_time_detail:

                ActivityUtil.startActivity(context, GameTimeDetailAct.class);

                break;

            case R.id.tv_budget_setting:

                ActivityUtil.startActivity(context, BudgetAct.class);

                break;


        }
    }

    /**
     * 设置游戏名称
     *
     * @param gameName 游戏名称
     */
    public void setGameName(String gameName) {
        popupWindow.setGameName(gameName);
    }
}
