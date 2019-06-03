package com.example.kindersmart.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.kindersmart.R;

public class MenuActivity extends AppCompatActivity {
    private Button      startbtn, helpbtn, exitbtn, highscoreBtn;
    private Context     context;
    private MediaPlayer bgMusic;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        context = getApplicationContext();
        startGame();
        helpGame();
        exitGame();
        highScore();
    }


    public void startGame(){
        startbtn = findViewById(R.id.ibStartGame);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, LoadingScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("loading", "start");
                startActivity(intent);
                }
        });
    }

    public void helpGame(){
        helpbtn = findViewById(R.id.ibTutorial);
        helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, LoadingScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("loading", "video");
                startActivity(intent);
            }
        });
    }

    public void highScore(){
        highscoreBtn = findViewById(R.id.highScore);
        highscoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, LoadingScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("loading", "highscore");
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

    public void exitDialog(int layout){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        View layoutView = getLayoutInflater().inflate(layout, null);
        Button dialogButton = layoutView.findViewById(R.id.btnDialogExit);
        Button dialogCancel = layoutView.findViewById(R.id.btnDialogCancel);
        dialogBuilder.setView(layoutView);

        alertDialog  = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseBackgroundMusic();
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

        dialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });

    }

    public void exitGame(){
        exitbtn = findViewById(R.id.ibExit);
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitDialog(R.layout.dialog_exit);
            }
        });
    }

    @Override
    public void onBackPressed() {

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
