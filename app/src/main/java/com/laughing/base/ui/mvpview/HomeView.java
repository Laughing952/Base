package com.laughing.base.ui.mvpview;

import android.support.v4.app.Fragment;

/**
 * Created by Water on 2018/3/28.
 */

public interface HomeView {
    /**
     * 选中的fragment
     *
     * @param fragment
     */
    void selectFragment(Fragment fragment);

    /**
     * 添加tab
     *
     * @param res  tab的图片
     * @param text tab的名字
     */
    void addTabView(int res, String text);

    /**
     * 改变tab
     *
     * @param position tab的位置
     * @param res      tab的图片
     * @param color    tab的字体颜色
     */
    void alterTabState(int position, int res, int color);
}
