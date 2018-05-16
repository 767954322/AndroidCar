package com.tuwan.android.common.base;

import android.app.Application;
import android.os.Environment;

import com.tuwan.android.common.data.ConstansValue;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import java.io.File;

import okhttp3.Request;

/**
 * @author gumenghao .
 * @version v1.0 .
 * @date 2018/5/7.
 * @file BaseApplication.java .
 * @brief BaseApplication .
 */
public abstract class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        mApplacation = this;

        initUMeng();

    }

    private void initUMeng() {

        UMConfigure.setLogEnabled(false);
        //初始化友盟sdk
        UMConfigure.init(this, ConstansValue.UMENG_KEY, "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");

//        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
//        PlatformConfig.setQQZone("101164104", "28e0959303e8960b06bfa217f959f1d7");
//        PlatformConfig.setSinaWeibo("3994674331", "7450446dd1d555532d14982a13f70408", "http://sns.whalecloud.com/sina2/callback");

    }


    //缓存路径
    @Override
    public File getCacheDir() {

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            File cacheDir = getExternalCacheDir();

            if (cacheDir != null && (cacheDir.exists() || cacheDir.mkdirs())) {

                return cacheDir;

            }
        }
        return super.getCacheDir();

    }

    public abstract Request.Builder addOkHttpAddHeader(Request.Builder builder);


    public static BaseApplication getInstance() {

        return mApplacation;

    }


    private static BaseApplication mApplacation;

}
