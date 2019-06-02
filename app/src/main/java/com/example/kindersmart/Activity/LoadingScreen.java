package com.example.kindersmart.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;
import com.example.kindersmart.R;

public class LoadingScreen extends AppCompatActivity {

    private int SLEEP_TIMER = 7;
    private LottieAnimationView lottieAnimationView;
    private String              getLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading_screen);

        Intent intent   = getIntent();
        getLoading      = intent.getStringExtra("loading");

//        Log.d("loadingnya", firstLoad);
        lottieAnimationView = findViewById(R.id.animation_view);

        Logo logo = new Logo();
        logo.start();
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
                Intent intent = new Intent(LoadingScreen.this, TebakGambarActivity.class);
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
            else if (getLoading.equals("highscore")){
                Intent intent = new Intent(LoadingScreen.this, HighscoreActivity.class);
                startActivity(intent);
                LoadingScreen.this.finish();
            }



        }
    }
}


