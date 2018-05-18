package com.android.car.home.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.widget.RelativeLayout;

import com.android.car.R;
import com.android.car.common.base.BaseActivity;
import com.android.car.common.utils.ToastUtils;
import com.android.car.home.ui.adapter.BaseRecyclerAdapter;
import com.android.car.home.ui.adapter.SmartViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.Arrays;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gumenghao on 2018/5/17.
 */

public class ReflushActivity6 extends BaseActivity {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.rcv_recyclerview)
    RecyclerView rlRecyclerview;
    private ClassicsHeader mClassicsHeader;
    private ClassicsFooter mClassicsFooter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_reflush6;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {


        mClassicsHeader = (ClassicsHeader) mRefreshLayout.getRefreshHeader();
        mClassicsFooter = (ClassicsFooter) mRefreshLayout.getRefreshFooter();
        mClassicsHeader.setSpinnerStyle(SpinnerStyle.Translate);
        mClassicsFooter.setSpinnerStyle(SpinnerStyle.Translate);
        mRefreshLayout.setHeaderHeight(50);
        mRefreshLayout.setFooterHeight(50);

        rlRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rlRecyclerview.setItemAnimator(new DefaultItemAnimator());
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(rlRecyclerview);
        rlRecyclerview.setAdapter(new BaseRecyclerAdapter<Integer>(loadModels(), R.layout.item_snaphelper) {
            @Override
            protected void onBindViewHolder(SmartViewHolder holder, Integer model, int position) {
                holder.image(R.id.imageView, model);
            }
        });

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

    private Collection<Integer> loadModels() {
        return Arrays.asList(
                R.drawable.image_weibo_home_1,
                R.drawable.image_weibo_home_2,
                R.drawable.image_weibo_home_1,
                R.drawable.image_weibo_home_2,
                R.drawable.image_weibo_home_1,
                R.drawable.image_weibo_home_2);
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
