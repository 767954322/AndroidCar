package com.android.car.home.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class HomePagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mListFrags;

    public HomePagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);

        this.mListFrags = list;

    }

    @Override
    public Fragment getItem(int position) {

        return mListFrags.get(position);

    }

    @Override
    public int getCount() {

        return mListFrags.size();

    }
}
