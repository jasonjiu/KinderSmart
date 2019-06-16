package com.example.kindersmart.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kindersmart.R;

public class MenuActivity extends AppCompatActivity {
    private Button      startbtn, helpbtn, exitbtn, highscoreBtn;
    private Context     context;
    private MediaPlayer bgMusic;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        context = getApplicationContext();
        startGame();
        videoEdukasi();
        exitGame();
        highScore();

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


    public void startGame(){
        startbtn = findViewById(R.id.ibStartGame);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startbtn.setEnabled(false);
                Intent intent = new Intent(MenuActivity.this, LoadingScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("loading", "start");
                startActivity(intent);
                finish();
                }
        });
    }

    public void videoEdukasi(){
        helpbtn = findViewById(R.id.ibTutorial);
        helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpbtn.setEnabled(false);
                Intent intent = new Intent(MenuActivity.this, LoadingScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("loading", "video");
                startActivity(intent);
                finish();
            }
        });
    }

    public void highScore(){
        highscoreBtn = findViewById(R.id.highScore);
        highscoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highscoreBtn.setEnabled(false);
                Intent intent = new Intent(MenuActivity.this, HighscoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
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

        AlertDialog.Builder dialogBuilder   = new AlertDialog.Builder(this);
        View                layoutView      = getLayoutInflater().inflate(layout, null);
        Button              dialogButton    = layoutView.findViewById(R.id.btnDialogExit);
        Button              dialogCancel    = layoutView.findViewById(R.id.btnDialogCancel);
        TextView            tvDialog1       = layoutView.findViewById(R.id.textView);
        TextView            tvDialog2       = layoutView.findViewById(R.id.textView2);
        dialogBuilder.setView(layoutView);
        alertDialog  = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        exitbtn.setEnabled(true);

        tvDialog1.setText(getResources().getString(R.string.keluar_permainan));
        tvDialog2.setText(getResources().getString(R.string.confirm_exit));

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
                exitbtn.setEnabled(false);
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
        exitbtn.setEnabled(true);
        startbtn.setEnabled(true);
        helpbtn.setEnabled(true);
        highscoreBtn.setEnabled(true);
        super.onResume();
    }


}
