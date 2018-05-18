package com.android.car.home.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import com.android.car.R;
import com.android.car.common.base.BaseFragment;
import com.android.car.home.ui.activity.TestActivity;

import butterknife.BindView;

/**
 * Created by gumenghao on 2018/5/15.
 */

@SuppressLint("ValidFragment")
public class FiveFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.bt_jump_test)
    Button btJumpTest;
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

//        btJumpTest.setOnClickListener(this);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_jump_test:

                Intent intent = new Intent(activity, TestActivity.class);
                startActivity(intent);
                break;

        }

    }
}
