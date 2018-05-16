package com.android.car.home.ui.fragment;

import android.os.Bundle;
import android.view.View;
import com.android.car.R;
import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;
import com.android.car.common.base.BaseFragment;

/**
 * Created by gumenghao on 2018/5/15.
 */

@SuppressLint("ValidFragment")
public class FirstFragment extends BaseFragment implements View.OnClickListener {

    private FragmentManager fragmentManager;

    public FirstFragment(FragmentManager fragmentManager) {

        this.fragmentManager = fragmentManager;

    }

    @Override
    protected int getLayoutResId() {

        return R.layout.fragment_home_first;

    }

    @Override
    protected void initListener() {
        super.initListener();


    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }

    }

}
