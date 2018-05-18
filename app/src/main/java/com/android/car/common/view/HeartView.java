package com.android.car.common.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;

import com.android.car.R;
import com.android.car.common.utils.UIUtils;
import com.scwang.smartrefresh.layout.util.DensityUtil;

/**
 * Created by gumenghao on 2018/5/18.
 */

public class HeartView extends LinearLayout {
    private ImageView mHeart1;
    private ImageView mHeart2;
    private ImageView mHeart3;
    private Animation animation1;
    private Animation animation2;
    private Animation animation3;

    public HeartView(Context context) {
        super(context);

        initView(context);
    }

    public HeartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public HeartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public HeartView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {

        setGravity(Gravity.CENTER_VERTICAL);

        mHeart1 = new ImageView(context);
        mHeart2 = new ImageView(context);
        mHeart3 = new ImageView(context);

        mHeart1.setScaleType(ImageView.ScaleType.FIT_XY);
        mHeart2.setScaleType(ImageView.ScaleType.FIT_XY);
        mHeart3.setScaleType(ImageView.ScaleType.FIT_XY);

        mHeart1.setLayoutParams(new LinearLayout.LayoutParams(UIUtils.getDimens(R.dimen.font_8), UIUtils.getDimens(R.dimen.font_8)));
        mHeart2.setLayoutParams(new LinearLayout.LayoutParams(UIUtils.getDimens(R.dimen.font_8), UIUtils.getDimens(R.dimen.font_8)));
        mHeart3.setLayoutParams(new LinearLayout.LayoutParams(UIUtils.getDimens(R.dimen.font_8), UIUtils.getDimens(R.dimen.font_8)));

        mHeart1.setImageResource(R.drawable.heart_big);
        mHeart2.setImageResource(R.drawable.heart_big);
        mHeart3.setImageResource(R.drawable.heart_big);

        addView(mHeart1, UIUtils.getDimens(R.dimen.font_8), UIUtils.getDimens(R.dimen.font_8));
        addView(new Space(context), DensityUtil.dp2px(4), DensityUtil.dp2px(4));
        addView(mHeart2, UIUtils.getDimens(R.dimen.font_8), UIUtils.getDimens(R.dimen.font_8));
        addView(new Space(context), DensityUtil.dp2px(4), DensityUtil.dp2px(4));
        addView(mHeart3, UIUtils.getDimens(R.dimen.font_8), UIUtils.getDimens(R.dimen.font_8));

        setMinimumHeight(DensityUtil.dp2px(60));
    }

    public void initAnimation() {

        animation1 = AnimationUtils.loadAnimation(getContext(), R.anim.anim_small);
        animation1.setRepeatCount(1);
        animation2 = AnimationUtils.loadAnimation(getContext(), R.anim.anim_small);
        animation2.setRepeatCount(1);
        animation3 = AnimationUtils.loadAnimation(getContext(), R.anim.anim_small);
        animation3.setRepeatCount(1);

        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                handler.sendEmptyMessageDelayed(1, 50);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                handler.sendEmptyMessageDelayed(2, 50);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animation3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                handler.sendEmptyMessageDelayed(3, 50);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void startAnimation() {

        initAnimation();
        mHeart1.startAnimation(animation1);

    }

    public void finishAnimation() {

        try {
            mHeart1.clearAnimation();
        } catch (Exception e) {
        }
        try {
            mHeart2.clearAnimation();
        } catch (Exception e) {
        }
        try {
            mHeart3.clearAnimation();
        } catch (Exception e) {
        }

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:
                    mHeart2.startAnimation(animation2);
                    break;
                case 2:
                    mHeart3.startAnimation(animation3);
                    break;
                case 3:
                    mHeart1.startAnimation(animation1);
                    break;
            }

        }
    };

}
