package com.android.car.common.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoScrollViewPager extends ViewPager {

    private boolean isCanScroll = false;

    public NoScrollViewPager(Context context) {
        super(context);

    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public void setScanScroll(boolean isCanScroll) {

        this.isCanScroll = isCanScroll;

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        return isCanScroll && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        return isCanScroll && super.onTouchEvent(ev);
    }

    @Override
    public void setCurrentItem(int item) {
        //false 去除滚动效果
        super.setCurrentItem(item,false);
    }

}