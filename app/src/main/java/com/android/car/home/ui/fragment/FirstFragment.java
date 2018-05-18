package com.android.car.home.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.car.R;
import com.android.car.common.base.BaseFragment;
import com.android.car.common.recycleradapter.BaseViewHolder;
import com.android.car.common.recycleradapter.MultiItemCommonAdapter;
import com.android.car.common.recycleradapter.MultiItemTypeSupport;
import com.android.car.common.viewpagerscroll.ConvenientBanner;
import com.android.car.common.viewpagerscroll.NetworkImageHolderView;
import com.android.car.common.viewpagerscroll.holder.CBViewHolderCreator;
import com.android.car.common.viewpagerscroll.listener.OnItemClickListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by gumenghao on 2018/5/15.
 */

@SuppressLint("ValidFragment")
public class FirstFragment extends BaseFragment implements View.OnClickListener, OnLoadMoreListener {

    @BindView(R.id.convenientBanner)
    ConvenientBanner mConvenientBanner;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.rv_recyclerview)
    RecyclerView rvRecyclerview;

    private ClassicsFooter mClassicsFooter;

    private FragmentManager fragmentManager;
    private List<String> imageUrlList = new ArrayList<>();
    private List<String> dataList = new ArrayList<>();
    private MultiItemCommonAdapter<String> mAdapter;

    {
        imageUrlList.add("http://pic4.nipic.com/20091113/2847083_105626034638_2.jpg");
        imageUrlList.add("http://f2.topitme.com/2/6a/bc/113109954583dbc6a2o.jpg");
        imageUrlList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2137958015,4291978384&fm=27&gp=0.jpg");
        imageUrlList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3102711909,683345632&fm=27&gp=0.jpg");

        for (int i = 0; i < 10; i++)
            dataList.add("");
    }

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

        mRefreshLayout.setOnLoadMoreListener(this);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        setBannerData(imageUrlList);

        mClassicsFooter = (ClassicsFooter) mRefreshLayout.getRefreshFooter();
        mClassicsFooter.setSpinnerStyle(SpinnerStyle.Translate);
        mRefreshLayout.setFooterHeight(50);

        MultiItemTypeSupport<String> support = new MultiItemTypeSupport<String>() {
            @Override
            public int getLayoutId(int itemType) {
                return R.layout.item_shouye;
            }

            @Override
            public int getItemViewType(int position, String s) {
                return 0;
            }
        };
        mAdapter = new MultiItemCommonAdapter<String>(activity, dataList, support) {

            @Override
            public void convert(BaseViewHolder holder, int position) {

            }
        };
        rvRecyclerview.setLayoutManager(new LinearLayoutManager(activity));
        rvRecyclerview.setItemAnimator(new DefaultItemAnimator());
        rvRecyclerview.setNestedScrollingEnabled(false);
        rvRecyclerview.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }

    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

        handler.sendEmptyMessageDelayed(0, 1500);

    }

    public void setBannerData(final List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        if (list.size() != 1) {
            mConvenientBanner.startTurning(3000);
            mConvenientBanner.setPointViewVisible(true);
        } else {
            mConvenientBanner.setCanLoop(false);
            mConvenientBanner.setPointViewVisible(false);
        }
        mConvenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, list)
                .setPageIndicator(new int[]{R.drawable.point, R.drawable.point_current})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                .setPageIndicatorMargin(0, 0, 50, 50)
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {

                    }
                });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            for (int i = 0; i < 10; i++)
                dataList.add("");
            mRefreshLayout.finishLoadMore();
            mAdapter.notifyDataSetChanged();

        }
    };

}
