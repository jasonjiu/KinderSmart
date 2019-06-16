package com.example.kindersmart.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.kindersmart.Activity.Model.Score;
import com.example.kindersmart.Activity.Model.UserLocalStore;
import com.example.kindersmart.R;

public class KategoriActivity extends AppCompatActivity {

    private LinearLayout    tebakhewanll, tebakangkall, tebakbentukll, tebakwarnall,
                            kenalhewanll, kenalangkall, kenalbentukll, kenalwarnall,
                            penjumlahall, penguranganll, perkalianll, pembagianll;
    private LinearLayout    backLayout;
    private MediaPlayer     bgMusic;
    private Score           currScore;
    private UserLocalStore  userLocalStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategory);
        userLocalStore = new UserLocalStore(this);
        currScore = userLocalStore.getUserScore();
        Log.d("skornyahewan", currScore.tebakHewanScore+"");
        Log.d("skornyabuah", currScore.tebakBuahScore+"");
        Log.d("skornyaorgan", currScore.tebakOrganScore+"");
        Log.d("skornyawarna", currScore.tebakWarnaScore+"");
        setTebakhewanll();
        setTebakangkall();
        setTebakbentukll();
        setTebakwarnall();
        setKenalhewanll();
        setKenalangkall();
        setKenalbentukll();
        setKenalwarnall();
        setPenjumlahall();
        setPenguranganll();
        setPerkalianll();
        setPembagianll();
        setIvBack();
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

    public void setTebakhewanll(){
        tebakhewanll = findViewById(R.id.llTebakHewan);
        tebakhewanll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tebakangkall.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "1");
                intent.putExtra("tebak","Tebak Hewan");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setTebakangkall(){
        tebakangkall = findViewById(R.id.llTebakAngka);
        tebakangkall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tebakangkall.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "2");
                intent.putExtra("tebak", "Tebak Angka");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setTebakbentukll(){
        tebakbentukll = findViewById(R.id.llTebakBentuk);
        tebakbentukll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tebakbentukll.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "3");
                intent.putExtra("tebak", "Tebak Bentuk");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setTebakwarnall(){
        tebakwarnall = findViewById(R.id.llTebakWarna);
        tebakwarnall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tebakwarnall.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "4");
                intent.putExtra("tebak", "Tebak Warna");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setKenalhewanll(){
        kenalhewanll = findViewById(R.id.llKenalHewan);
        kenalhewanll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kenalhewanll.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, PengenalanActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Kenal", "9");
                intent.putExtra("kenal", "Mengenal Hewan");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setKenalangkall(){
        kenalangkall = findViewById(R.id.llKenalAngka);
        kenalangkall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kenalangkall.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, PengenalanActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Kenal", "10");
                intent.putExtra("kenal", "Mengenal Angka");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setKenalbentukll(){
        kenalbentukll = findViewById(R.id.llKenalBentuk);
        kenalbentukll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kenalbentukll.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, PengenalanActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Kenal", "11");
                intent.putExtra("kenal", "Mengenal Bentuk");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setKenalwarnall(){
        kenalwarnall = findViewById(R.id.llKenalWarna);
        kenalwarnall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriActivity.this, PengenalanActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Kenal", "12");
                intent.putExtra("kenal", "Mengenal Warna");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setPenjumlahall(){
        penjumlahall = findViewById(R.id.llPenjumlahan);
        penjumlahall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                penjumlahall.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "5");
                intent.putExtra("tebak","Penjumlahan");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setPenguranganll(){
        penguranganll = findViewById(R.id.llPengurangan);
        penguranganll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                penguranganll.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "6");
                intent.putExtra("tebak","Pengurangan");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setPerkalianll(){
        perkalianll = findViewById(R.id.llPerkalian);
        perkalianll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perkalianll.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "7");
                intent.putExtra("tebak","Perkalian");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setPembagianll(){
        pembagianll = findViewById(R.id.llPembagian);
        pembagianll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pembagianll.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "8");
                intent.putExtra("tebak","Pembagian");
                startActivity(intent);
                finish();
            }
        });
    }

    public void playBackgroundMusic(){
        bgMusic = MediaPlayer.create(KategoriActivity.this, R.raw.solo);
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


    public void setIvBack(){
        backLayout = findViewById(R.id.linearBack2menu);
        backLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backLayout.setClickable(false);
                pauseBackgroundMusic();
                Intent intent = new Intent(KategoriActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
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
        tebakhewanll.setClickable(true);
        tebakangkall.setClickable(true);
        tebakbentukll.setClickable(true);
        tebakwarnall.setClickable(true);
        kenalhewanll.setClickable(true);
        kenalangkall.setClickable(true);
        kenalbentukll.setClickable(true);
        kenalwarnall.setClickable(true);
        penjumlahall.setClickable(true);
        penguranganll.setClickable(true);
        perkalianll.setClickable(true);
        pembagianll.setClickable(true);
        backLayout.setClickable(true);
        super.onResume();
    }

}
