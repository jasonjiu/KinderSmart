package com.example.kindersmart.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.kindersmart.Activity.Model.Score;
import com.example.kindersmart.Activity.Model.UserLocalStore;
import com.example.kindersmart.R;

public class HighscoreActivity extends AppCompatActivity {
    private Score           highScore;
    private UserLocalStore  userLocalStore;
    private ImageView       ivTb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        userLocalStore = new UserLocalStore(this);
        highScore = userLocalStore.getUserScore();
        init();
        toolbar();
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


    public void init(){
        ImageView ivHewan         = findViewById(R.id.ivHsHewan);
        ImageView ivBuah          = findViewById(R.id.ivHsBuah);
        ImageView ivOrgan         = findViewById(R.id.ivHsOrgan);
        ImageView ivWarna         = findViewById(R.id.ivHsWarna);
        ImageView ivPenjumlahan   = findViewById(R.id.ivHsPenjumlahan);
        ImageView ivPengurangan   = findViewById(R.id.ivHsPengurangan);
        ImageView ivHitungGambar  = findViewById(R.id.ivHsHitungGambar);
        ImageView ivTebakAngka    = findViewById(R.id.ivHsTebakAngka);
        TextView tvHewan         = findViewById(R.id.tvHsHewan);
        TextView tvBuah          = findViewById(R.id.tvHsBuah);
        TextView tvOrgan         = findViewById(R.id.tvHsOrgan);
        TextView tvWarna         = findViewById(R.id.tvHsWarna);
        TextView tvPenjumlahan   = findViewById(R.id.tvHsPenjumlahan);
        TextView tvPengurangan   = findViewById(R.id.tvHsPengurangan);
        TextView tvHitungGambar  = findViewById(R.id.tvHsHitungGambar);
        TextView tvTebakAngka    = findViewById(R.id.tvHsTebakAngka);

        tvHewan.setText(highScore.tebakHewanScore+"");
        tvBuah.setText(highScore.tebakBuahScore+"");
        tvOrgan.setText(highScore.tebakOrganScore+"");
        tvWarna.setText(highScore.tebakWarnaScore+"");
        tvPenjumlahan.setText(highScore.penjumlahanScore+"");
        tvPengurangan.setText(highScore.penguranganScore+"");
        tvHitungGambar.setText(highScore.hitungGambarScore+"");
        tvTebakAngka.setText(highScore.tebakAngkaScore+"");

        //hewan
        if (highScore.tebakHewanScore == 0){

        }
        else if (highScore.tebakHewanScore == 10){

        }
        else if (highScore.tebakHewanScore >= 50){

        }
        else if (highScore.tebakHewanScore == 100){

        }

        //buah
        if (highScore.tebakBuahScore == 0){

        }
        else if (highScore.tebakBuahScore == 10){

        }
        else if (highScore.tebakBuahScore >= 50){

        }
        else if (highScore.tebakBuahScore == 100){

        }

        //organ
        if (highScore.tebakOrganScore == 0){

        }
        else if (highScore.tebakOrganScore == 10){

        }
        else if (highScore.tebakOrganScore >= 50){

        }
        else if (highScore.tebakOrganScore == 100){

        }

        //warna
        if (highScore.tebakWarnaScore == 0){

        }
        else if (highScore.tebakWarnaScore == 10){

        }
        else if (highScore.tebakWarnaScore >= 50){

        }
        else if (highScore.tebakWarnaScore == 100){

        }

        //penjumlahan
        if (highScore.penjumlahanScore == 0){

        }
        else if (highScore.penjumlahanScore == 10){

        }
        else if (highScore.penjumlahanScore >= 50){

        }
        else if (highScore.penjumlahanScore == 100){

        }

        //pengurangan
        if (highScore.penguranganScore == 0){

        }
        else if (highScore.penguranganScore == 10){

        }
        else if (highScore.penguranganScore >= 50){

        }
        else if (highScore.penguranganScore == 100){

        }

        //hitung gambar
        if (highScore.hitungGambarScore == 0){

        }
        else if (highScore.hitungGambarScore == 10){

        }
        else if (highScore.hitungGambarScore >= 50){

        }
        else if (highScore.hitungGambarScore == 100){

        }

        //tebak angka
        if (highScore.tebakAngkaScore == 0){

        }
        else if (highScore.tebakAngkaScore == 10){

        }
        else if (highScore.tebakAngkaScore >= 50){

        }
        else if (highScore.tebakAngkaScore == 100){

        }

    }

    public void toolbar(){
        Toolbar mToolbar = findViewById(R.id.tbHighScore);
        ivTb             = mToolbar.findViewById(R.id.ivtbExit);
        ivTb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RubberBand)
                        .duration(500)
                        .repeat(2)
                        .playOn(ivTb);
                ivTb.setEnabled(false);
                Intent intent = new Intent(HighscoreActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {

    }
}
