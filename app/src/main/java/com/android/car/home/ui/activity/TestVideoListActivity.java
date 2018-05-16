package com.android.car.home.ui.activity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import com.android.car.R;
import com.android.car.common.base.BaseActivity;
import com.android.car.common.data.VideoConstant;
import com.android.car.common.videoplayer.JZVideoPlayer;
import com.android.car.home.ui.adapter.AdapterVideoList;

import butterknife.BindView;

/**
 * Created by gumenghao on 2018/5/9.
 */

public class TestVideoListActivity extends BaseActivity {

    @BindView(R.id.listview)
    ListView listView;

    private SensorManager sensorManager;
    private JZVideoPlayer.JZAutoFullscreenListener sensorEventListener;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_test_videolist;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {


        listView = findViewById(R.id.listview);
        listView.setAdapter(new AdapterVideoList(this, VideoConstant.videoUrls[0],
                VideoConstant.videoTitles[0], VideoConstant.videoThumbs[0]));

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                JZVideoPlayer.onScrollReleaseAllVideos(view, firstVisibleItem, visibleItemCount, totalItemCount);
            }
        });

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorEventListener = new JZVideoPlayer.JZAutoFullscreenListener();

    }


    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(sensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
