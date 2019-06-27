package com.edu.kindersmart.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.edu.kindersmart.Activity.Model.APIKey;
import com.edu.kindersmart.Activity.Model.Video;
import com.edu.kindersmart.Activity.YoutubePlayerActivity;
import com.edu.kindersmart.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.List;

/**
 * Created by USER on 5/30/2019.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.videoViewHolder> {
    private static final String TAG = VideoAdapter.class.getSimpleName();
    private Context context;
    private List<Video> videoList;

    public VideoAdapter(Context context) {
        this.context = context;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public VideoAdapter.videoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_video, parent, false);
        return new videoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.videoViewHolder holder, final int position) {
        final Video video = videoList.get(position);

        holder.videoThumbnailImageView.initialize(APIKey.DEVELOPER_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
                //when initialization is sucess, set the video id to thumbnail to load
                youTubeThumbnailLoader.setVideo(videoList.get(position).getVideoLink());

                youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                    @Override
                    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                        //when thumbnail loaded successfully release the thumbnail loader as we are showing thumbnail in adapter
                        youTubeThumbnailLoader.release();
                    }

                    @Override
                    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {
                        //print or show error when thumbnail load failed
                        Log.e(TAG, "Youtube Thumbnail Error");
                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                //print or show error when initialization failed
                Log.e(TAG, "Youtube Initialization Failure");

            }
        });

        holder.videoThumbnailImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,YoutubePlayerActivity.class).putExtra("video_id", videoList.get(position).getVideoLink());
                context.startActivity(i);
            }
        });

        holder.videoTitle.setText(video.getVideoName());
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public int getItemViewType(int position) {
        return position;
    }

    public class videoViewHolder extends RecyclerView.ViewHolder {
        private YouTubeThumbnailView videoThumbnailImageView;
        private TextView             videoTitle;
        private RelativeLayout layoutYoutube;
        public videoViewHolder(View itemView) {
            super(itemView);
            videoThumbnailImageView = itemView.findViewById(R.id.video_thumbnail_image_view);
            layoutYoutube = itemView.findViewById(R.id.layoutYoutube);
            videoTitle = itemView.findViewById(R.id.tvVideo);

        }
    }
}
