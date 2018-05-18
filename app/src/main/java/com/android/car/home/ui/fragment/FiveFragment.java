package com.android.car.home.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import com.android.car.R;
import com.android.car.common.base.BaseFragment;
import com.android.car.home.ui.activity.ReflushActivity1;
import com.android.car.home.ui.activity.ReflushActivity2;
import com.android.car.home.ui.activity.ReflushActivity3;
import com.android.car.home.ui.activity.ReflushActivity4;
import com.android.car.home.ui.activity.ReflushActivity5;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by gumenghao on 2018/5/15.
 */

@SuppressLint("ValidFragment")
public class FiveFragment extends BaseFragment implements View.OnClickListener {

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
    @BindView(R.id.bt_eight)
    Button btEight;
    @BindView(R.id.bt_nine)
    Button btNine;
    @BindView(R.id.bt_ten)
    Button btTen;
    @BindView(R.id.bt_eleven)
    Button btEleven;
    @BindView(R.id.bt_twelve)
    Button btTwelve;
    @BindView(R.id.bt_thirteen)
    Button btThirteen;

    Unbinder unbinder;
    private FragmentManager fragmentManager;

    public FiveFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home_five;
    }

    @Override
    protected void initListener() {
        super.initListener();

        btOne.setOnClickListener(this);
        btTwo.setOnClickListener(this);
        btThree.setOnClickListener(this);
        btFour.setOnClickListener(this);
        btFive.setOnClickListener(this);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_one:

                Intent intent1 = new Intent(activity, ReflushActivity1.class);
                startActivity(intent1);
                break;
            case R.id.bt_two:

                Intent intent2 = new Intent(activity, ReflushActivity2.class);
                startActivity(intent2);
                break;
            case R.id.bt_three:

                Intent intent3 = new Intent(activity, ReflushActivity3.class);
                startActivity(intent3);
                break;
            case R.id.bt_four:

                Intent intent4 = new Intent(activity, ReflushActivity4.class);
                startActivity(intent4);
                break;
            case R.id.bt_five:

                Intent intent5 = new Intent(activity, ReflushActivity5.class);
                startActivity(intent5);
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
