package com.android.car.home.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.car.R;
import com.android.car.common.base.BaseTransparentActivity;

import butterknife.BindView;

/**
 * Created by gumenghao on 2018/5/18.
 */

public class AdvertisementActivity extends BaseTransparentActivity {


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_advertisement;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {


        mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            super.handleMessage(msg);
            Intent intent = new Intent(AdvertisementActivity.this, LoginActivity.class);
            startActivity(intent);
            AdvertisementActivity.this.finish();

        }
    };

}
