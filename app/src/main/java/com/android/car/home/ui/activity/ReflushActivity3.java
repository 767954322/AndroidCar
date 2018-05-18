package com.android.car.home.ui.activity;

import android.os.Bundle;

import com.android.car.R;
import com.android.car.common.base.BaseActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gumenghao on 2018/5/17.
 */

public class ReflushActivity3 extends BaseActivity {
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private ClassicsHeader mClassicsHeader;
    private ClassicsFooter mClassicsFooter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_reflush3;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mClassicsHeader = (ClassicsHeader) mRefreshLayout.getRefreshHeader();
        mClassicsFooter = (ClassicsFooter) mRefreshLayout.getRefreshFooter();
        mClassicsHeader.setSpinnerStyle(SpinnerStyle.Translate);
        mClassicsFooter.setSpinnerStyle(SpinnerStyle.Translate);
    }

}
