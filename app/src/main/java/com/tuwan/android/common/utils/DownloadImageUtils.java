package com.tuwan.android.common.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.ResponseBody;

import android.os.Environment;
import android.content.Context;

import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.util.Map;

import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

import com.tuwan.android.common.net.ApiService;
import com.tuwan.android.common.net.CommonObserver;
import com.tuwan.android.common.net.ServiceFactory;

/**
 * Created by gumenghao on 2018/5/10.
 */
public class DownloadImageUtils {

    public static final String APP_IMAGE_DIR = Environment.getExternalStorageDirectory() + "/TuWanImages/";

    public static Map<Integer, String> hasSavaUrl = new HashMap<>();

    /**
     * 下载图片
     *
     * @param context
     * @param imageUrlList
     */
    public static void downloadImage(final Context context, List<String> imageUrlList) {
        for (int i = 0; i < imageUrlList.size(); i++) {

            final int finalI = i;

            ServiceFactory.getNoCacheInstance()
                    .createService(ApiService.class)
                    .downloadImage(imageUrlList.get(i))
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .subscribe(new CommonObserver<ResponseBody>() {

                        @Override
                        public void onNext(@NonNull ResponseBody value) {
                            super.onNext(value);
                            writeResponseBodyToDisk(context, PublicUtils.getTimeString() + finalI + ".jpg", value);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            super.onError(e);

                        }

                    });

        }

    }

    /**
     * 保存下载的图片流写入SD卡文件
     *
     * @param imageName xxx.jpg
     * @param body      image stream
     */
    public static void writeResponseBodyToDisk(Context context, String imageName, ResponseBody body) {

        if (body == null) {

            ToastUtils.showShortToast("图片源错误");

            return;
        }

        try {

            InputStream is = body.byteStream();
            File fileDr = new File(APP_IMAGE_DIR);

            if (!fileDr.exists()) {

                fileDr.mkdir();

            }
            File file = new File(APP_IMAGE_DIR, imageName);

            if (file.exists()) {

                file.delete();
                file = new File(APP_IMAGE_DIR, imageName);

            }
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            int len;

            while ((len = bis.read(buffer)) != -1) {

                fos.write(buffer, 0, len);

            }
            PublicUtils.updatePhoneAlbum(file, context);
            fos.flush();
            fos.close();
            bis.close();
            is.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}
