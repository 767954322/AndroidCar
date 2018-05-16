package com.android.car.home.contract;

import com.android.car.home.data.InBean;

/**
 * Created by gumenghao on 2018/5/7.
 */

public interface TestContract {

    interface View {

        void onRefreshTestData(boolean requestStatus, InBean result);

    }

    interface Presenter {

        void getTestData();

    }
}
