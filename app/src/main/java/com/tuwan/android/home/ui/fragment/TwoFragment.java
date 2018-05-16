package com.tuwan.android.home.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.tuwan.android.R;
import com.tuwan.android.common.base.BaseFragment;

/**
 * Created by gumenghao on 2018/5/15.
 */

@SuppressLint("ValidFragment")
public class TwoFragment extends BaseFragment {

    private FragmentManager fragmentManager;

    public TwoFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home_two;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
