package com.example.kindersmart.Activity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.kindersmart.R;

public class MenuActivity extends AppCompatActivity {
    private ImageView kindersmartIcon;
    private Button startbtn, helpbtn, exitbtn;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        context = getApplicationContext();
        playBackgroundMusic();
        setImage();
        startGame();
        helpGame();
        exitGame();
    }

    public void setImage(){
        kindersmartIcon = findViewById(R.id.kindersmarticon);
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

    public void exitGame(){
        exitbtn = findViewById(R.id.ibExit);
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void playBackgroundMusic(){
        MediaPlayer bgMusic = MediaPlayer.create(MenuActivity.this, R.raw.backgroundmusic);
        bgMusic.start();
    }

}
