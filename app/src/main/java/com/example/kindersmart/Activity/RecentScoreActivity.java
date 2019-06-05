package com.example.kindersmart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.kindersmart.Activity.Model.Score;
import com.example.kindersmart.Activity.Model.UserLocalStore;
import com.example.kindersmart.R;

public class RecentScoreActivity extends AppCompatActivity {
    private TextView    nilaiScore;
    private TextView    tekan;
    private TextView    back2Menu;
    private ImageView   ivRecentScore;
    private int         getScoreTebakHewan;
    private int         getScoreTebakBuah;
    private int         getScoreTebakOrgan;
    private int         getScoreTebakWarna;
    private int         getScorePenjumlahan;
    private int         getScorePengurangan;
    private int         getScoreHitungGambar;
    private int         getScoreTebakAngka;
    private String      getKategori;
    private UserLocalStore userLocalStore;
    private Score       currScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_score);
        init();
        imageAnimation();
        setBack2Menu();

        try {
            Intent intent       = getIntent();
            getScoreTebakHewan = intent.getIntExtra("hewan", 0);
            getScoreTebakBuah = intent.getIntExtra("buah", 0);
            getScoreTebakOrgan = intent.getIntExtra("organ", 0);
            getScoreTebakWarna = intent.getIntExtra("warna", 0);
            getScorePenjumlahan = intent.getIntExtra("penjumlahan", 0);
            getScorePengurangan = intent.getIntExtra("pengurangan", 0);
            getScoreHitungGambar = intent.getIntExtra("hitungGambar", 0);
            getScoreTebakAngka = intent.getIntExtra("tebakAngka", 0);
            getKategori = intent.getStringExtra("kategori");
            Log.d("nialinya", String.valueOf(getScoreTebakHewan));
            Log.d("nialinyabuah", String.valueOf(getScoreTebakBuah));
            Log.d("kategorinya", getKategori);
            userLocalStore = new UserLocalStore(this);
            currScore = userLocalStore.getUserScore();
        }catch (Exception e){
            e.printStackTrace();
        }

        if (getKategori.equals("hewan") ){
            nilaiScore.setText(String.valueOf(getScoreTebakHewan));

            if (getKategori.equals("hewan") && currScore.tebakHewanScore == 0) {
                userLocalStore.setUserScore(true);
                userLocalStore.storeScoreHewan(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));
            }

            else if(getKategori.equals("hewan") && getScoreTebakHewan > currScore.tebakHewanScore){
                userLocalStore.setUserScore(true);
                userLocalStore.storeScoreHewan(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));

            }
        }

        if (getKategori.equals("buah")){
            nilaiScore.setText(String.valueOf(getScoreTebakBuah));

            if (getKategori.equals("buah") && currScore.tebakBuahScore == 0) {
                userLocalStore.setUserScore(true);
                userLocalStore.storeScoreBuah(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));
            }

            else if(getKategori.equals("buah") && getScoreTebakBuah > currScore.tebakBuahScore){
                userLocalStore.setUserScore(true);
                userLocalStore.storeScoreBuah(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));

            }
        }

        if (getKategori.equals("organ")){
            nilaiScore.setText(String.valueOf(getScoreTebakOrgan));

            if (getKategori.equals("organ") && currScore.tebakOrganScore == 0) {
                userLocalStore.setUserScore(true);
                userLocalStore.storeScoreOrgan(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));
            }

            else if(getKategori.equals("organ") && getScoreTebakOrgan > currScore.tebakOrganScore){
                userLocalStore.setUserScore(true);
                userLocalStore.storeScoreOrgan(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));

            }
        }

        if (getKategori.equals("warna")){
            nilaiScore.setText(String.valueOf(getScoreTebakWarna));

            if (getKategori.equals("warna") && currScore.tebakWarnaScore == 0) {
                userLocalStore.setUserScore(true);
                userLocalStore.storeScoreWarna(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));
            }

            else if(getKategori.equals("warna") && getScoreTebakWarna > currScore.tebakWarnaScore){
                userLocalStore.setUserScore(true);
                userLocalStore.storeScoreWarna(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));

            }
        }

        if (getKategori.equals("penjumlahan")){
            nilaiScore.setText(String.valueOf(getScorePenjumlahan));

            if (getKategori.equals("penjumlahan") && currScore.penjumlahanScore == 0) {
                userLocalStore.setUserScore(true);
                userLocalStore.storeScorePenjumlahan(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));
            }

            else if(getKategori.equals("penjumlahan") && getScorePenjumlahan > currScore.penjumlahanScore){
                userLocalStore.setUserScore(true);
                userLocalStore.storeScorePenjumlahan(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));

            }
        }

        if (getKategori.equals("pengurangan")){
            nilaiScore.setText(String.valueOf(getScorePengurangan));

            if (getKategori.equals("pengurangan") && currScore.penguranganScore == 0) {
                userLocalStore.setUserScore(true);
                userLocalStore.storeScorePengurangan(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));
            }

            else if(getKategori.equals("pengurangan") && getScorePengurangan > currScore.penguranganScore){
                userLocalStore.setUserScore(true);
                userLocalStore.storeScorePengurangan(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));

            }
        }

        if (getKategori.equals("hitungGambar")){
            nilaiScore.setText(String.valueOf(getScoreHitungGambar));

            if (getKategori.equals("hitungGambar") && currScore.hitungGambarScore == 0) {
                userLocalStore.setUserScore(true);
                userLocalStore.storeScoreHitungGambar(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));
            }

            else if(getKategori.equals("hitungGambar") && getScoreHitungGambar > currScore.hitungGambarScore){
                userLocalStore.setUserScore(true);
                userLocalStore.storeScoreHitungGambar(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));

            }
        }

        if (getKategori.equals("tebakAngka")){
            nilaiScore.setText(String.valueOf(getScoreTebakAngka));

            if (getKategori.equals("tebakAngka") && currScore.tebakAngkaScore == 0) {
                userLocalStore.setUserScore(true);
                userLocalStore.storeScoreTebakAngka(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));
            }

            else if(getKategori.equals("tebakAngka") && getScoreTebakAngka > currScore.tebakAngkaScore){
                userLocalStore.setUserScore(true);
                userLocalStore.storeScoreTebakAngka(new Score(getScoreTebakHewan, getScoreTebakBuah,
                        getScoreTebakOrgan, getScoreTebakWarna, getScorePenjumlahan, getScorePengurangan, getScoreHitungGambar, getScoreTebakAngka));

            }
        }

        Log.d("tebakhewan",  currScore.tebakHewanScore+"");
        Log.d("tebakwarna",  currScore.tebakWarnaScore+"");

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
        nilaiScore       = findViewById(R.id.tvNilaiScore);
        ivRecentScore    = findViewById(R.id.ivRecentScore);
        tekan            = findViewById(R.id.tvTekan);
        back2Menu        = findViewById(R.id.tvMenu);
    }

    public void imageAnimation(){
        YoYo.with(Techniques.RubberBand)
                .duration(700)
                .repeat(5)
                .playOn(tekan);

        ivRecentScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RubberBand)
                        .duration(700)
                        .repeat(1)
                        .playOn(ivRecentScore);

                ivRecentScore.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        YoYo.with(Techniques.FadeOut)
                                .duration(700)
                                .repeat(1)
                                .playOn(ivRecentScore);

                        ivRecentScore.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ivRecentScore.setVisibility(View.GONE);
                                tekan.setVisibility(View.GONE);
                                nilaiScore.setVisibility(View.VISIBLE);
                                back2Menu.setVisibility(View.VISIBLE);
                            }
                        }, 1000);
                    }
                },1000);

            }
        });
    }

    public void setBack2Menu(){
        back2Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecentScoreActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
