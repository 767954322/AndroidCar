package com.android.car.common.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by gumenghao on 2018/5/10.
 */

public class PublicUtils {


    /**
     * 获取时间戳
     *
     * @return 获取时间戳
     */
    public static String getTimeString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

    /**
     * 发广播告诉相册有图片需要更新，这样可以在图册下看到保存的图片了
     *
     * @return 获取时间戳
     */
    public static void updatePhoneAlbum(File file, Context context) {

        //发广播告诉相册有图片需要更新，这样可以在图册下看到保存的图片了
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(file);
        intent.setData(uri);
        context.sendBroadcast(intent);

    }


}
