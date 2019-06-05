package com.example.kindersmart.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kindersmart.Activity.Model.Score;
import com.example.kindersmart.Activity.Model.UserLocalStore;
import com.example.kindersmart.R;

public class HighscoreActivity extends AppCompatActivity {
    private ImageView       ivHewan;
    private ImageView       ivBuah;
    private ImageView       ivOrgan;
    private ImageView       ivWarna;
    private ImageView       ivPenjumlahan;
    private ImageView       ivPengurangan;
    private ImageView       ivHitungGambar;
    private ImageView       ivTebakAngka;
    private TextView        tvHewan;
    private TextView        tvBuah;
    private TextView        tvOrgan;
    private TextView        tvWarna;
    private TextView        tvPenjumlahan;
    private TextView        tvPengurangan;
    private TextView        tvHitungGambar;
    private TextView        tvTebakAngka;
    private Score           highScore;
    private UserLocalStore  userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        userLocalStore = new UserLocalStore(this);
        highScore = userLocalStore.getUserScore();
        init();
        toolbar();

        setIcon();
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
        ivHewan         = findViewById(R.id.ivHsHewan);
        ivBuah          = findViewById(R.id.ivHsBuah);
        ivOrgan         = findViewById(R.id.ivHsOrgan);
        ivWarna         = findViewById(R.id.ivHsWarna);
        ivPenjumlahan   = findViewById(R.id.ivHsPenjumlahan);
        ivPengurangan   = findViewById(R.id.ivHsPengurangan);
        ivHitungGambar  = findViewById(R.id.ivHsHitungGambar);
        ivTebakAngka    = findViewById(R.id.ivHsTebakAngka);
        tvHewan         = findViewById(R.id.tvHsHewan);
        tvBuah          = findViewById(R.id.tvHsBuah);
        tvOrgan         = findViewById(R.id.tvHsOrgan);
        tvWarna         = findViewById(R.id.tvHsWarna);
        tvPenjumlahan   = findViewById(R.id.tvHsPenjumlahan);
        tvPengurangan   = findViewById(R.id.tvHsPengurangan);
        tvHitungGambar  = findViewById(R.id.tvHsHitungGambar);
        tvTebakAngka    = findViewById(R.id.tvHsTebakAngka);

        tvHewan.setText(highScore.tebakHewanScore+"");
        tvBuah.setText(highScore.tebakBuahScore+"");
        tvOrgan.setText(highScore.tebakOrganScore+"");
        tvWarna.setText(highScore.tebakWarnaScore+"");
        tvPenjumlahan.setText(highScore.penjumlahanScore+"");
        tvPengurangan.setText(highScore.penguranganScore+"");
        tvHitungGambar.setText(highScore.hitungGambarScore+"");
        tvTebakAngka.setText(highScore.tebakAngkaScore+"");

    }

    public void toolbar(){
        Toolbar mToolbar = findViewById(R.id.tbHighScore);
        mToolbar.setTitle("Nilai Tertinggi");
        mToolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void setIcon(){

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
}
