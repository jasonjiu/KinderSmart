package com.example.kindersmart.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;
import com.example.kindersmart.R;

public class LoadingScreen extends AppCompatActivity {

    private int                 SLEEP_TIMER  = 3;
    private LottieAnimationView animationView;
    private String              getLoading;
    private Logo                logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading_screen);
        Intent intent           = getIntent();
        getLoading              = intent.getStringExtra("loading");
        animationView           = findViewById(R.id.animation_view);
        logo = new Logo();
        logo.start();
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

    @Override
    public void onBackPressed() {

    }

    public class Logo extends Thread{
        public void run(){
            try {
                sleep(1000 * SLEEP_TIMER);
            }catch (Exception e){
                e.printStackTrace();
            }

            if (getLoading.equals("start")) {
                Intent intent = new Intent(LoadingScreen.this, KategoriActivity.class);
                startActivity(intent);
                LoadingScreen.this.finish();
            }
            else if (getLoading.equals("quiz")){
                Intent intent = new Intent(LoadingScreen.this, QuizActivity.class);
                startActivity(intent);
                LoadingScreen.this.finish();
            }
            else if (getLoading.equals("mengenal")){
                Intent intent = new Intent(LoadingScreen.this, PengenalanActivity.class);
                startActivity(intent);
                LoadingScreen.this.finish();
            }
            else if (getLoading.equals("video")){
                Intent intent = new Intent(LoadingScreen.this, VideoEdukasiActivity.class);
                startActivity(intent);
                LoadingScreen.this.finish();
            }
        }
    }
}


