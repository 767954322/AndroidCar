package com.android.car.home.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.car.R;
import com.android.car.common.base.BaseTransparentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gumenghao on 2018/5/18.
 */

public class LoginActivity extends BaseTransparentActivity implements View.OnClickListener {
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.tv_go_register)
    TextView tvGoRegister;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initListener() {
        super.initListener();
        btLogin.setOnClickListener(this);
        tvGoRegister.setOnClickListener(this);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_login:
                Intent intent_login = new Intent(this, MainActivity.class);
                startActivity(intent_login);
                finish();
                break;
            case R.id.tv_go_register:
                Intent intent_register = new Intent(this, RegisterActivity.class);
                startActivity(intent_register);
                break;
        }

    }
}
