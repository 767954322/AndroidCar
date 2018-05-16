package com.android.car.home.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.android.car.R;
import com.android.car.common.base.BaseFragment;

/**
 * Created by gumenghao on 2018/5/15.
 */

@SuppressLint("ValidFragment")
public class FiveFragment extends BaseFragment {

    private FragmentManager fragmentManager;

    public FiveFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home_five;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
