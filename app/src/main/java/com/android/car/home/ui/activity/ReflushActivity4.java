package com.android.car.home.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;

import com.android.car.R;
import com.android.car.common.base.BaseActivity;
import com.android.car.common.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import butterknife.BindView;

/**
 * Created by gumenghao on 2018/5/17.
 */

public class ReflushActivity4 extends BaseActivity {
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private ClassicsHeader mClassicsHeader;
    private ClassicsFooter mClassicsFooter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_reflush4;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        mClassicsHeader = (ClassicsHeader) mRefreshLayout.getRefreshHeader();
        mClassicsFooter = (ClassicsFooter) mRefreshLayout.getRefreshFooter();
        mClassicsHeader.setSpinnerStyle(SpinnerStyle.Translate);
        mClassicsFooter.setSpinnerStyle(SpinnerStyle.Translate);
        mRefreshLayout.setHeaderHeight(40);

        mRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

                ToastUtils.showCenter("加载中");

                handler.sendEmptyMessageDelayed(2, 3000);

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

                ToastUtils.showCenter("刷新中");

                handler.sendEmptyMessageDelayed(1, 3000);

            }
        });

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:

                    ToastUtils.showCenter("刷新完成");

                    mRefreshLayout.finishRefresh();

                    break;
                case 2:

                    ToastUtils.showCenter("加载完成");

                    mRefreshLayout.finishLoadMore();

                    break;
            }

        }
    };


}
