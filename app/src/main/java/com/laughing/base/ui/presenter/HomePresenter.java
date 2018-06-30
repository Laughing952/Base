package com.laughing.base.ui.presenter;

import android.support.v4.app.Fragment;

import com.laughing.base.R;
import com.laughing.base.ui.mvpview.HomeView;


/**
 * Created by Water on 2018/3/28.
 */

public class HomePresenter {

    public static final int[] mTabRes = new int[]{R.mipmap.navigation_desk_normal, R.mipmap.navigation_project_normal, R.mipmap.navigation_user_normal};
    public static final int[] mTabResPressed = new int[]{R.mipmap.navigation_desk_pressed, R.mipmap.navigation_project_pressed, R.mipmap.navigation_user_pressed};
    public static final String[] mTabTitle = new String[]{"工作台", "项目", "我的"};
    private Fragment fragments[];
    private HomeView mHomeView;
    private int selected = 0;

    public HomePresenter(HomeView homeView) {
        this.mHomeView = homeView;
        // 初始化数据
        getFragments();
        addTabData();
    }

    private void addTabData() {
        for (int i = 0; i < mTabTitle.length; i++) {
            mHomeView.addTabView(mTabRes[i], mTabTitle[i]);
        }
        mHomeView.selectFragment(fragments[0]);
        mHomeView.alterTabState(0, mTabResPressed[0], R.color.main_color);
    }

    public void getFragments() {
        fragments = new Fragment[4];

//        fragments[0] = F_Working.newInstance();
//        fragments[1] = F_Project.newInstance();
//        fragments[2] = F_MyCenter.newInstance();
    }

    public void onTabItemSelected(int position) {
        Fragment fragment = null;
        fragment = fragments[position];
        mHomeView.selectFragment(fragment);
        mHomeView.alterTabState(position, mTabResPressed[position], R.color.main_color);
        mHomeView.alterTabState(selected, mTabRes[selected], R.color.black);
        selected = position;
    }
}
