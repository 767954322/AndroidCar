package com.android.car.common.net;

import com.android.car.home.data.InBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * @author gumenghao .
 * @version v1.0 .
 * @date 2018/5/7.
 * @file CommonDialog.java .
 * @brief Dialog工具类 .
 */
public interface ApiService {

    String BASE_URL = "https://y.tuwan.com/m/";

    /**
     * 导师入驻
     */
    @GET("https://api.tuwan.com/mobileplay/?data=game_info&returntype=1&platform=app&ver=0.0.7&format=json")
    Observable<InBean> test();

    /**
     * 下载图片
     */
    @GET
    Observable<ResponseBody> downloadImage(@Url String imageUrl);


}
