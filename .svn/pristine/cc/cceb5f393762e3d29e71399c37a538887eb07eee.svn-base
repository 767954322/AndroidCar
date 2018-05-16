package com.tuwan.android.home.ui.adapter;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.tuwan.android.R;
import com.tuwan.android.common.videoplayer.JZVideoPlayer;
import com.tuwan.android.common.videoplayer.JZVideoPlayerStandard;


public class AdapterVideoList extends BaseAdapter {

    public static final String TAG = "JiaoZiVideoPlayer";

    Context context;

    String[] videoUrls;
    String[] videoTitles;
    String[] videoThumbs;

    public AdapterVideoList(Context context, String[] videoUrls, String[] videoTitles, String[] videoThumbs) {
        this.context = context;
        this.videoUrls = videoUrls;
        this.videoTitles = videoTitles;
        this.videoThumbs = videoThumbs;
    }

    @Override
    public int getCount() {
        return videoUrls.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            LayoutInflater mInflater = LayoutInflater.from(context);
            convertView = mInflater.inflate(R.layout.item_videoview, null);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.jzVideoPlayer = convertView.findViewById(R.id.videoplayer);
        viewHolder.jzVideoPlayer.setUp(
                videoUrls[position], JZVideoPlayer.SCREEN_WINDOW_NORMAL,
                videoTitles[position]);
        Glide.with(convertView.getContext())
                .load(videoThumbs[position])
                .into(viewHolder.jzVideoPlayer.thumbImageView);
        viewHolder.jzVideoPlayer.positionInList = position;

        //直接大屏，不根据重力显示
//        JZVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
//        JZVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        return convertView;
    }

    class ViewHolder {
        JZVideoPlayerStandard jzVideoPlayer;
    }
}
