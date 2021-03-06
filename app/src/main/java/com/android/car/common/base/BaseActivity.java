package com.android.car.common.base;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.android.car.R;

import android.content.res.Resources;
import android.content.pm.ActivityInfo;

import com.jaeger.library.StatusBarUtil;

import android.content.res.Configuration;

import com.android.car.common.utils.UIUtils;
import com.umeng.analytics.MobclickAgent;

import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by gumenghao on 2018/5/7.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initStatusBar();

        setContentView(getLayoutResId());

        ButterKnife.bind(this);

        initExtraBundle();

        initData(savedInstanceState);

        initListener();

    }

    //设置顶部状态栏
    private void initStatusBar() {

        //SYSTEM_UI_FLAG_FULLSCREEN : 隐藏顶部导航栏
        //SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR  白色顶部导航栏（图标和文字）
        //SYSTEM_UI_FLAG_LIGHT_STATUS_BAR  黑色顶部导航栏（图标和文字）
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        StatusBarUtil.setColor(this, UIUtils.getColor(R.color.white), 0);

    }

    /**
     * 获取布局的Id
     */
    protected abstract int getLayoutResId();

    /**
     * 获取bundle数据
     */
    protected void initExtraBundle() {

    }

    /**
     * 初始化数据操作
     *
     * @param savedInstanceState
     */
    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 设置监听
     */
    protected void initListener() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }
}
