package com.android.car.home.ui.activity;


import com.android.car.R;

import java.util.List;

import android.Manifest;
import android.os.Bundle;

import java.util.ArrayList;

import butterknife.BindView;

import android.widget.RadioGroup;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;

import com.android.car.common.base.BaseActivity;
import com.android.car.common.permission.MPermission;
import com.android.car.common.view.NoScrollViewPager;
import com.android.car.home.ui.adapter.HomePagerAdapter;
import com.android.car.home.ui.fragment.FirstFragment;
import com.android.car.home.ui.fragment.FiveFragment;
import com.android.car.home.ui.fragment.FourFragment;
import com.android.car.home.ui.fragment.ThreeFragment;
import com.android.car.home.ui.fragment.TwoFragment;


public class MainActivity
        extends BaseActivity
        implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.svp_viewpager)
    NoScrollViewPager svpViewpager;
    @BindView(R.id.rg_home_radio_group)
    RadioGroup rgHomeRadioGroup;

    private String[] BASIC_PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    private List<Fragment> mListFrags = new ArrayList<>();
    private final int BASIC_PERMISSION_REQUEST_CODE = 100;
    private HomePagerAdapter mHomePagerAdapter;
    private FirstFragment mFirstFragment;
    private TwoFragment mTwoFragment;
    private ThreeFragment mThreeFragment;
    private FourFragment mFourFragment;
    private FiveFragment mFiveFragment;

    @Override
    protected int getLayoutResId() {

        requestBasicPermission();
        return R.layout.activity_main;

    }

    @Override
    protected void initListener() {
        super.initListener();

        rgHomeRadioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        initViewPager();

        requestBasicPermission();

    }

    private void initViewPager() {

        mFirstFragment = new FirstFragment(getSupportFragmentManager());
        mTwoFragment = new TwoFragment(getSupportFragmentManager());
        mThreeFragment = new ThreeFragment(getSupportFragmentManager());
        mFourFragment = new FourFragment(getSupportFragmentManager());
        mFiveFragment = new FiveFragment(getSupportFragmentManager());

        mListFrags.add(mFirstFragment);
        mListFrags.add(mTwoFragment);
        mListFrags.add(mThreeFragment);
        mListFrags.add(mFourFragment);
        mListFrags.add(mFiveFragment);

        mHomePagerAdapter = new HomePagerAdapter(getSupportFragmentManager(), mListFrags);
        svpViewpager.setAdapter(mHomePagerAdapter);
        svpViewpager.setCurrentItem(0);
        svpViewpager.setOffscreenPageLimit(5);
        rgHomeRadioGroup.check(R.id.radio_btn_first);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {

            case R.id.radio_btn_first:

                svpViewpager.setCurrentItem(0);
                break;
            case R.id.radio_btn_two:

                svpViewpager.setCurrentItem(1);
                break;
            case R.id.radio_btn_three:

                svpViewpager.setCurrentItem(2);
                break;
            case R.id.radio_btn_four:

                svpViewpager.setCurrentItem(3);
                break;
            case R.id.radio_btn_five:

                svpViewpager.setCurrentItem(4);
                break;
        }

    }

    private void requestBasicPermission() {

        MPermission.with(MainActivity.this).setRequestCode(BASIC_PERMISSION_REQUEST_CODE).permissions(BASIC_PERMISSIONS).request();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        MPermission.onRequestPermissionsResult(this, requestCode, permissions, grantResults);

    }


}

