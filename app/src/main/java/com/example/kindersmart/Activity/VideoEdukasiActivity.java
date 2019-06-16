package com.example.kindersmart.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.kindersmart.Activity.Adapter.VideoAdapter;
import com.example.kindersmart.Activity.Model.Video;
import com.example.kindersmart.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VideoEdukasiActivity extends AppCompatActivity {
    private Context                     context;
    private RequestQueue                queue;
    private RecyclerView                rvVideo;
    private List<Video>                 videoList = new ArrayList<>();
    private VideoAdapter                videoAdapter;
    private AlertDialog                 alertDialog;
    private ImageView                   ivTb;
    private LottieAnimationView         loading;
    private FragmentManager             fragmentManager;
    private FragmentTransaction         fragmentTransaction;
    private ConnectionErrorFragment     fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_edukasi);
        context     = VideoEdukasiActivity.this;
        rvVideo     = findViewById(R.id.rvVideo);
        loading     = findViewById(R.id.loadingAnimation);
        rvVideo.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvVideo.setLayoutManager(linearLayoutManager);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new ConnectionErrorFragment();

        toolbar();
        queue= Volley.newRequestQueue(context);
        show_video();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            hideSystemUI();

        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                // Hide the nav bar and status bar
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    public void toolbar(){
        Toolbar mToolbar = findViewById(R.id.tbVideo);
        ivTb             = mToolbar.findViewById(R.id.ivtbExit);
        ivTb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RubberBand)
                        .duration(500)
                        .repeat(2)
                        .playOn(ivTb);
                ivTb.setEnabled(false);
                exitDialog(R.layout.dialog_exit);
            }
        });


    }
    public void exitDialog(int layout){

        AlertDialog.Builder dialogBuilder       = new AlertDialog.Builder(this);
        View                layoutView          = getLayoutInflater().inflate(layout, null);
        Button              dialogButton        = layoutView.findViewById(R.id.btnDialogExit);
        Button              dialogCancel        = layoutView.findViewById(R.id.btnDialogCancel);
        TextView            tvDialog1           = layoutView.findViewById(R.id.textView);
        TextView            tvDialog2           = layoutView.findViewById(R.id.textView2);
        dialogBuilder.setView(layoutView);

        alertDialog  = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        ivTb.setEnabled(true);

        tvDialog1.setText(getResources().getString(R.string.back2menu));
        tvDialog2.setText(getResources().getString(R.string.confrim_2menu));

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoEdukasiActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        dialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

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
                                    loading.setVisibility(View.GONE);
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
                loading.setVisibility(View.GONE);
                Toast.makeText(context, "Koneksi Bermasalah", Toast.LENGTH_LONG).show();
                fragmentTransaction.add(R.id.fragmen404, fragment);
                fragmentTransaction.commit();
                //Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(rec);

    }
}
