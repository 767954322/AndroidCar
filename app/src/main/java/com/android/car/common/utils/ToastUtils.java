package com.android.car.common.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.android.car.MyApplication;

/**
 * @author gumenghao .
 * @version v1.0 .
 * @date 2018/5/7.
 * @file ToastUtils.java .
 * @brief ToastUtils工具类 .
 */
public class ToastUtils {

    public static void showCenter(String text) {
        Toast centerToast = Toast.makeText(MyApplication.getInstance(), text, Toast.LENGTH_SHORT);
        centerToast.setGravity(Gravity.CENTER, 0, 0);
        centerToast.show();
    }

    public static void showCenter(double text) {
        Toast centerToast = Toast.makeText(MyApplication.getInstance(), text + "", Toast.LENGTH_SHORT);
        centerToast.setGravity(Gravity.CENTER, 0, 0);
        centerToast.show();
    }

    public static void showShortToast(String text) {
        Toast shortToast = Toast.makeText(MyApplication.getInstance(), text, Toast.LENGTH_SHORT);
        shortToast.show();
    }

    public static void showShortToast(double text) {
        Toast shortToast = Toast.makeText(MyApplication.getInstance(), text + "", Toast.LENGTH_SHORT);
        shortToast.show();
    }

    public static void showLongToast(String text) {
        Toast longToast = Toast.makeText(MyApplication.getInstance(), text, Toast.LENGTH_LONG);
        longToast.show();
    }

    public static void showLongToast(double text) {
        Toast longToast = Toast.makeText(MyApplication.getInstance(), text + "", Toast.LENGTH_LONG);
        longToast.show();
    }

}
