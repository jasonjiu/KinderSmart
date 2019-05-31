package com.example.kindersmart.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.kindersmart.Activity.Adapter.TebakGambarAdapter;
import com.example.kindersmart.Activity.Adapter.VideoAdapter;
import com.example.kindersmart.Activity.Model.OnImageClickListener;
import com.example.kindersmart.Activity.Model.SoalTebakGambar;
import com.example.kindersmart.Activity.Model.Video;
import com.example.kindersmart.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VideoEdukasiActivity extends AppCompatActivity {
    private Context context;
    private RequestQueue queue;
    private RecyclerView rvVideo;
    private List<Video> videoList = new ArrayList<>();
    private VideoAdapter videoAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_edukasi);
        context = VideoEdukasiActivity.this;

        rvVideo = findViewById(R.id.rvVideo);
        rvVideo.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvVideo.setLayoutManager(linearLayoutManager);

        queue= Volley.newRequestQueue(context);
        show_video();
    }

    public void show_video(){
        JsonObjectRequest rec= new JsonObjectRequest
                ("https://mikeztj.com/Jason/PHPTebakGambar/Video.php", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray listVideo = null;
                        videoList.clear();
                        try {
                            listVideo = response.getJSONArray("result");
                            Log.d("listVideo",listVideo.toString());
                            for (int i = 0; i < listVideo.length(); i++) {
                                try {
                                    rvVideo.setVisibility(View.VISIBLE);
                                    final JSONObject obj = listVideo.getJSONObject(i);

                                    videoList.add(new Video(
                                            obj.getInt("videoID"),
                                            obj.getString("videoName"),
                                            obj.getString("videoURL")));
                                } catch (JSONException e1) {
                                    e1.printStackTrace();
                                }
                            }
                            videoAdapter = new VideoAdapter(context);
                            videoAdapter.setVideoList(videoList);
                            rvVideo.setAdapter(videoAdapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(rec);

    }
}
