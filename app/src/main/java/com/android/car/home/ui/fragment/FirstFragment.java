package com.android.car.home.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.car.R;
import com.android.car.common.base.BaseFragment;
import com.android.car.common.viewpagerscroll.ConvenientBanner;
import com.android.car.common.viewpagerscroll.NetworkImageHolderView;
import com.android.car.common.viewpagerscroll.holder.CBViewHolderCreator;
import com.android.car.common.viewpagerscroll.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by gumenghao on 2018/5/15.
 */

@SuppressLint("ValidFragment")
public class FirstFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.convenientBanner)
    ConvenientBanner mConvenientBanner;
    private FragmentManager fragmentManager;
    private List<String> imageUrlList = new ArrayList<>();

    {
        imageUrlList.add("http://pic4.nipic.com/20091113/2847083_105626034638_2.jpg");
        imageUrlList.add("http://f2.topitme.com/2/6a/bc/113109954583dbc6a2o.jpg");
        imageUrlList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2137958015,4291978384&fm=27&gp=0.jpg");
        imageUrlList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3102711909,683345632&fm=27&gp=0.jpg");
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


    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        setBannerData(imageUrlList);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }

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
                .setPageIndicator(new int[]{R.drawable.gallery_normal, R.drawable.gallery_select})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                .setPageIndicatorMargin(0, 0, 50, 50)
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {

                    }
                });
    }


}
