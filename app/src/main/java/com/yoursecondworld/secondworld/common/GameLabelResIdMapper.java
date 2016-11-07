package com.yoursecondworld.secondworld.common;

import com.yoursecondworld.secondworld.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cxj on 2016/9/5.
 */
public class GameLabelResIdMapper {

    public static final String HUANGSHI = "皇室战争";
    public static final String QIJINUANNUAN = "奇迹暖暖";
    public static final String ZHUXIANSHOUYOU = "诛仙手游";
    public static final String WANGZHERONGYAO = "王者荣耀";

    public static Map<String, Integer> mapper = new HashMap<String, Integer>();

    static {
        mapper.put(HUANGSHI, R.mipmap.huangshi);
        mapper.put(HUANGSHI + "_big", R.mipmap.huangshi_big);
        mapper.put(QIJINUANNUAN, R.mipmap.nuanuan);
        mapper.put(QIJINUANNUAN + "_big", R.mipmap.nuannuan_big);
        mapper.put(ZHUXIANSHOUYOU, R.mipmap.zhuxian);
        mapper.put(ZHUXIANSHOUYOU + "_big", R.mipmap.zhuxian_big);
        mapper.put(WANGZHERONGYAO, R.mipmap.wangzhe);
        mapper.put(WANGZHERONGYAO + "_big", R.mipmap.wangzhe_big);
    }

}
