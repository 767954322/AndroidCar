package com.android.car.home.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.car.R;
import com.android.car.common.base.BaseActivity;
import com.android.car.common.permission.MPermission;
import com.android.car.common.utils.DownloadImageUtils;
import com.android.car.common.utils.GlideManager;
import com.android.car.common.videoplayer.CustomView.MyJZVideoPlayerStandard;
import com.android.car.common.videoplayer.JZVideoPlayer;
import com.android.car.common.view.FilletImageView;
import com.android.car.common.view.RoundImageView;
import com.android.car.home.contract.TestContract;
import com.android.car.home.data.InBean;
import com.android.car.home.presenter.TestPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends BaseActivity implements TestContract.View, View.OnClickListener {


    @Override
    protected int getLayoutResId() {

        return R.layout.activity_test;

    }

    @Override
    protected void initListener() {
        super.initListener();

        btJumpVideolist.setOnClickListener(this);
        btLoadImage.setOnClickListener(this);
        btJumpReflush.setOnClickListener(this);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        //测试网络请求
        mTestPresenter = new TestPresenter(this, this);
        mTestPresenter.getTestData();

        //图片展示
        String imageUrl = "http://img2.imgtn.bdimg.com/it/u=1740012619,4009379465&fm=27&gp=0.jpg";
        GlideManager.glideLoader(TestActivity.this, imageUrl, ivTestRound, GlideManager.TAG_ROUND, R.drawable.icon_first, R.drawable.icon_first, R.drawable.icon_first);
        GlideManager.glideLoader(TestActivity.this, imageUrl, ivTestFillet, GlideManager.TAG_FILLET, R.drawable.icon_first, R.drawable.icon_first, R.drawable.icon_first);

        //video设置及展示
        jzVideo.setUp("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db3" +
                "7e62345123a1be272f8b.mp4", jzVideo.SCREEN_WINDOW_NORMAL, "饺子快长大");
        GlideManager.glideLoader(TestActivity.this, "http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png",
                jzVideo.thumbImageView, GlideManager.TAG_FILLET, R.color.black, R.color.black, R.color.black);

        requestBasicPermission();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_jump_videolist:

                startActivity(new Intent(TestActivity.this, TestVideoListActivity.class));

                break;
            case R.id.bt_load_image:

                DownloadImageUtils.downloadImage(TestActivity.this, imageUrlList);

                break;
            case R.id.bt_jump_reflush:

                Intent intent = new Intent(this, ReflushActivity.class);
                startActivity(intent);

                break;

        }

    }

    @Override
    public void onRefreshTestData(boolean requestStatus, InBean result) {

        if (requestStatus) {

            if (null != result && result.getLineg().size() > 0) {

                tvTestTital.setText(result.getLineg().get(0).getTitle());

            }

        } else {

            //TODO 请求失败
            tvTestTital.setText("数据获取失败");

        }

    }


    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    private void requestBasicPermission() {
        MPermission.printMPermissionResult(true, this, BASIC_PERMISSIONS);
        MPermission.with(TestActivity.this)
                .setRequestCode(BASIC_PERMISSION_REQUEST_CODE)
                .permissions(BASIC_PERMISSIONS)
                .request();
    }


    @BindView(R.id.bt_jump_reflush)
    Button btJumpReflush;
    @BindView(R.id.tv_test_tital)
    TextView tvTestTital;
    @BindView(R.id.iv_test_round)
    RoundImageView ivTestRound;
    @BindView(R.id.iv_test_fillet)
    FilletImageView ivTestFillet;
    @BindView(R.id.bt_load_image)
    Button btLoadImage;
    @BindView(R.id.jz_video)
    MyJZVideoPlayerStandard jzVideo;
    @BindView(R.id.bt_jump_videolist)
    Button btJumpVideolist;
    private TestPresenter mTestPresenter;

    private final int BASIC_PERMISSION_REQUEST_CODE = 100;
    private String[] BASIC_PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private List<String> imageUrlList = new ArrayList<>();

    {
        imageUrlList.add("http://pic4.nipic.com/20091113/2847083_105626034638_2.jpg");
        imageUrlList.add("http://f2.topitme.com/2/6a/bc/113109954583dbc6a2o.jpg");
        imageUrlList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2137958015,4291978384&fm=27&gp=0.jpg");
        imageUrlList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3102711909,683345632&fm=27&gp=0.jpg");
        imageUrlList.add("http://img0.imgtn.bdimg.com/it/u=2851272418,293470202&fm=27&gp=0.jpg");
    }

}
