package com.tuwan.android.home.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.tuwan.android.R;

import butterknife.BindView;

import com.tuwan.android.common.base.BaseActivity;
import com.tuwan.android.common.permission.MPermission;
import com.tuwan.android.home.ui.fragment.FirstFragment;
import com.tuwan.android.home.ui.fragment.FourFragment;
import com.tuwan.android.home.ui.fragment.ThreeFragment;
import com.tuwan.android.home.ui.fragment.TwoFragment;


public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.main_content)
    RelativeLayout mainContent;
    @BindView(R.id.rg_home_radio_group)
    RadioGroup rgHomeRadioGroup;

    private String[] BASIC_PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    private final int BASIC_PERMISSION_REQUEST_CODE = 100;
    private FragmentTransaction transaction;
    private FirstFragment mFirstFragment;
    private ThreeFragment mThreeFragment;
    private FourFragment mFourFragment;
    private TwoFragment mTwoFragment;
    private Fragment mTagFragment;

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

        initRadio();

        requestBasicPermission();

    }

    private void initRadio() {

        if (null == mFirstFragment) {

            mFirstFragment = new FirstFragment(getSupportFragmentManager());

        }

        transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.main_content, mFirstFragment).commit();

        rgHomeRadioGroup.check(R.id.radio_btn_first);

        mTagFragment = mFirstFragment;

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {

            case R.id.radio_btn_first:

                if (null == mFirstFragment) {

                    mFirstFragment = new FirstFragment(getSupportFragmentManager());

                }
                if (mTagFragment != mFirstFragment) {

                    mTagFragment = mFirstFragment;

                    replaceFragment(mFirstFragment);

                }
                break;
            case R.id.radio_btn_two:

                if (null == mTwoFragment) {

                    mTwoFragment = new TwoFragment(getSupportFragmentManager());

                }

                if (mTagFragment != mTwoFragment) {

                    mTagFragment = mTwoFragment;

                    replaceFragment(mTwoFragment);

                }
                break;
            case R.id.radio_btn_three:

                if (null == mThreeFragment) {

                    mThreeFragment = new ThreeFragment(getSupportFragmentManager());

                }

                if (mTagFragment != mThreeFragment) {

                    mTagFragment = mThreeFragment;

                    replaceFragment(mThreeFragment);

                }
                break;
            case R.id.radio_btn_four:

                if (null == mFourFragment) {

                    mFourFragment = new FourFragment(getSupportFragmentManager());

                }

                if (mTagFragment != mFourFragment) {

                    mTagFragment = mFourFragment;

                    replaceFragment(mFourFragment);

                }
                break;
        }

    }

    public void replaceFragment(Fragment fragment) {

        transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.main_content, fragment);

        transaction.commit();

    }

    private void requestBasicPermission() {

        MPermission.with(MainActivity.this).setRequestCode(BASIC_PERMISSION_REQUEST_CODE).permissions(BASIC_PERMISSIONS).request();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        MPermission.onRequestPermissionsResult(this, requestCode, permissions, grantResults);

    }

}
