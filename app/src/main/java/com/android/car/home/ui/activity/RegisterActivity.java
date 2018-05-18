package com.android.car.home.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.car.R;
import com.android.car.common.base.BaseTransparentActivity;

import butterknife.BindView;

/**
 * Created by gumenghao on 2018/5/18.
 */

public class RegisterActivity extends BaseTransparentActivity implements View.OnClickListener {
    @BindView(R.id.bt_register)
    Button btRegister;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initListener() {
        super.initListener();
        btRegister.setOnClickListener(this);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_register:

                RegisterActivity.this.finish();
                break;
        }

    }
}
