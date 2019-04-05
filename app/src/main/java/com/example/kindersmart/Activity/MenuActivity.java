package com.example.kindersmart.Activity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.kindersmart.R;

public class MenuActivity extends AppCompatActivity {
    private Button      startbtn, helpbtn, exitbtn, highscoreBtn;
    private Context     context;
    private MediaPlayer bgMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        context = getApplicationContext();
        startGame();
        helpGame();
        exitGame();
    }


    public void startGame(){
        startbtn = findViewById(R.id.ibStartGame);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, KategoriActivity.class);
                startActivity(intent);
                }
        });
    }

    public void helpGame(){
        helpbtn = findViewById(R.id.ibTutorial);
        helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });
    }

    public void highScore(){
        highscoreBtn = findViewById(R.id.highScore);
        highscoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, HighscoreActivity.class);
                startActivity(intent);
            }
        });
    }

    public void playBackgroundMusic(){
        bgMusic = MediaPlayer.create(MenuActivity.this, R.raw.solo);
        bgMusic.start();
        bgMusic.setLooping(true);
    }

    public void pauseBackgroundMusic(){
        if (bgMusic != null){
            bgMusic.stop();
            if (isFinishing()){
                bgMusic.stop();
                bgMusic.release();
            }
        }
    }

    public void exitGame(){
        exitbtn = findViewById(R.id.ibExit);
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseBackgroundMusic();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        pauseBackgroundMusic();
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (bgMusic != null){
            bgMusic.stop();
            if (isFinishing()){
                bgMusic.stop();
                bgMusic.release();
            }
        }
    }

    @Override
    protected void onResume() {
        playBackgroundMusic();
        super.onResume();
    }


}
