package com.android.car.home.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.android.car.R;

import android.widget.Button;
import android.content.Intent;

import com.android.car.common.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by gumenghao on 2018/5/17.
 */

public class ReflushActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.bt_one)
    Button btOne;
    @BindView(R.id.bt_two)
    Button btTwo;
    @BindView(R.id.bt_three)
    Button btThree;
    @BindView(R.id.bt_four)
    Button btFour;
    @BindView(R.id.bt_five)
    Button btFive;
    @BindView(R.id.bt_six)
    Button btSix;
    @BindView(R.id.bt_seven)
    Button btSeven;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_reflush;
    }


    @Override
    protected void initListener() {
        super.initListener();

        btOne.setOnClickListener(this);
        btTwo.setOnClickListener(this);
        btThree.setOnClickListener(this);
        btFour.setOnClickListener(this);
        btFive.setOnClickListener(this);
        btSix.setOnClickListener(this);
        btSeven.setOnClickListener(this);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_one:

                Intent intent1 = new Intent(this, ReflushActivity1.class);
                startActivity(intent1);
                break;
            case R.id.bt_two:

                Intent intent2 = new Intent(this, ReflushActivity2.class);
                startActivity(intent2);
                break;
            case R.id.bt_three:

                Intent intent3 = new Intent(this, ReflushActivity3.class);
                startActivity(intent3);
                break;
            case R.id.bt_four:

                Intent intent4 = new Intent(this, ReflushActivity4.class);
                startActivity(intent4);
                break;
            case R.id.bt_five:

                Intent intent5 = new Intent(this, ReflushActivity5.class);
                startActivity(intent5);
                break;
            case R.id.bt_six:

                Intent intent6 = new Intent(this, ReflushActivity6.class);
                startActivity(intent6);
                break;
            case R.id.bt_seven:

                Intent intent7 = new Intent(this, ReflushActivity7.class);
                startActivity(intent7);
                break;
        }

    }

    /**
     *
     * srlPrimaryColor             主题颜色 (背景色)
     * srlAccentColor              强调颜色 (文字颜色)
     * srlDragRate                 显示拖动高度/真实拖动高度（默认0.5，阻尼效果）
     * srlEnableLoadMore           是否开启加上拉加载功能（默认false-智能开启）
     * srlEnablePureScrollMode     是否开启纯滚动模式（默认false-开启时只支持一个子视图）
     * srlFixedHeaderViewId        指定固定顶部的视图Id
     * srlFixedFooterViewId        指定固定底部的视图Id
     * srlEnablePreviewInEditMode  是否启用Android Studio编辑xml时预览效果
     * layout_srlSpinnerStyle      设置移动样式:Scale(跟随)  Translate（底部）
     *
     */

}
