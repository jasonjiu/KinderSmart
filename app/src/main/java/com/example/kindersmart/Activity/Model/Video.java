package com.example.kindersmart.Activity.Model;

/**
 * Created by USER on 5/30/2019.
 */

public class Video {
    private int VideoID;
    private String VideoName;
    private String VideoLink;

    public Video(int videoID, String videoName, String videoLink) {
        VideoID = videoID;
        VideoName = videoName;
        VideoLink = videoLink;
    }

    public int getVideoID() {
        return VideoID;
    }

    public void setVideoID(int videoID) {
        VideoID = videoID;
    }

    public String getVideoName() {
        return VideoName;
    }

    public void setVideoName(String videoName) {
        VideoName = videoName;
    }

    public String getVideoLink() {
        return VideoLink;
    }

    public void setVideoLink(String videoLink) {
        VideoLink = videoLink;
    }
}
