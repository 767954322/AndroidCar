package com.android.car.common.view.headersfootors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.android.car.R;
import com.android.car.common.utils.UIUtils;
import com.android.car.common.view.HeartView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ArrowDrawable;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;

/**
 * Created by gumenghao on 2018/5/18.
 */

public class ClassicsHeader1 extends LinearLayout implements RefreshHeader {

    private HeartView mHeartView;
    private TextView mHeaderText;//标题文本
    private ImageView mArrowView;//下拉箭头


    public ClassicsHeader1(Context context) {
        this(context, null);

    }

    public ClassicsHeader1(Context context, AttributeSet attrs) {
        super(context, attrs, 0);

        setGravity(Gravity.CENTER);
        mHeartView = new HeartView(context);
        mHeartView.setGravity(Gravity.CENTER);
        mHeartView.setLayoutParams(new LinearLayout.LayoutParams(UIUtils.getDimens(R.dimen.font_60), ViewGroup.LayoutParams.WRAP_CONTENT));


        mHeaderText = new TextView(context);
        mHeaderText.setGravity(Gravity.CENTER);
        mHeaderText.setLayoutParams(new LinearLayout.LayoutParams(UIUtils.getDimens(R.dimen.font_60), ViewGroup.LayoutParams.WRAP_CONTENT));


        mArrowView = new ImageView(context);
        mArrowView.setScaleType(ImageView.ScaleType.FIT_XY);
        mArrowView.setLayoutParams(new LinearLayout.LayoutParams(UIUtils.getDimens(R.dimen.font_32), UIUtils.getDimens(R.dimen.font_32)));
        mArrowView.setImageResource(R.drawable.icon_first);

        addView(mHeartView, UIUtils.getDimens(R.dimen.font_60), LayoutParams.WRAP_CONTENT);
        addView(mHeaderText, UIUtils.getDimens(R.dimen.font_60), LayoutParams.WRAP_CONTENT);
        addView(new Space(context), DensityUtil.dp2px(10), DensityUtil.dp2px(10));
        addView(mArrowView, UIUtils.getDimens(R.dimen.font_32), UIUtils.getDimens(R.dimen.font_32));
        setMinimumHeight(DensityUtil.dp2px(60));

    }


    @NonNull
    public View getView() {

        return this;//真实的视图就是自己，不能返回null
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;//指定为平移，不能null
    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout layout, int height, int maxDragHeight) {
    }

    @Override
    public int onFinish(@NonNull RefreshLayout layout, boolean success) {
        if (success) {
            mHeartView.setVisibility(GONE);
            mHeartView.finishAnimation();
            mHeaderText.setText("刷新完成");
            mHeaderText.setVisibility(VISIBLE);
            mArrowView.setImageResource(R.drawable.icon_third);
        } else {
            mHeartView.setVisibility(GONE);
            mHeartView.finishAnimation();
            mHeaderText.setText("刷新失败");
            mHeaderText.setVisibility(VISIBLE);
            mArrowView.setImageResource(R.drawable.icon_third);
        }
        return 500;//延迟500毫秒之后再弹回
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        switch (newState) {
            case None:
            case PullDownToRefresh:

                mHeaderText.setText("下拉刷新");
                mHeaderText.setVisibility(VISIBLE);
                mHeartView.setVisibility(GONE);
                mHeartView.finishAnimation();
                mArrowView.setImageResource(R.drawable.icon_first);
                break;
            case Refreshing:

                mHeartView.initAnimation();
                mHeartView.startAnimation();
                mHeaderText.setText("正在刷新");
                mHeaderText.setVisibility(GONE);
                mHeartView.setVisibility(VISIBLE);
                mArrowView.setImageResource(R.drawable.icon_third);
                break;
            case ReleaseToRefresh:

                mHeaderText.setText("松开刷新");
                mHeaderText.setVisibility(VISIBLE);
                mHeartView.setVisibility(GONE);
                mHeartView.finishAnimation();
                mArrowView.setImageResource(R.drawable.icon_second);
                break;
        }
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {

    }

    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {

    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }


}
