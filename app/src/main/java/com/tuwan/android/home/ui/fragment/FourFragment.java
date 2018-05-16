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
public class FourFragment extends BaseFragment {

    private FragmentManager fragmentManager;

    public FourFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home_four;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
