package com.edu.kindersmart.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.edu.kindersmart.R;

public class KategoriActivity extends AppCompatActivity {

    private LinearLayout    tebakHewan, tebakBuah, tebakOrgan, tebakWarna,
                            mengenalHewan, mengenalBuah, mengenalOrgan, mengenalWarna,
                            penjumlahan, pengurangan, hitungGambar, belajarAngka;
    private LinearLayout    backLayout;
    private MediaPlayer     bgMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategory);

        setTebakhewan();
        setTebakBuah();
        setTebakOrgan();
        setTebakWarna();
        setKenalHewan();
        setKenalBuah();
        setKenalOrgan();
        setKenalWarna();
        setPenjumlahan();
        setPengurangan();
        setHitungGambar();
        setBelajarAngka();
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

    public void setTebakhewan(){
        tebakHewan = findViewById(R.id.llTebakHewan);
        tebakHewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tebakBuah.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "1");
                intent.putExtra("tebak","Tebak Hewan");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setTebakBuah(){
        tebakBuah = findViewById(R.id.llTebakAngka);
        tebakBuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tebakBuah.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "2");
                intent.putExtra("tebak", "Tebak Buah");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setTebakOrgan(){
        tebakOrgan = findViewById(R.id.llTebakBentuk);
        tebakOrgan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tebakOrgan.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "3");
                intent.putExtra("tebak", "Tebak Organ");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setTebakWarna(){
        tebakWarna = findViewById(R.id.llTebakWarna);
        tebakWarna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tebakWarna.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "4");
                intent.putExtra("tebak", "Tebak Warna");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setKenalHewan(){
        mengenalHewan = findViewById(R.id.llKenalHewan);
        mengenalHewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mengenalHewan.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, PengenalanActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Kenal", "9");
                intent.putExtra("kenal", "Mengenal Hewan");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setKenalBuah(){
        mengenalBuah = findViewById(R.id.llKenalAngka);
        mengenalBuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mengenalBuah.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, PengenalanActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Kenal", "10");
                intent.putExtra("kenal", "Mengenal Buah");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setKenalOrgan(){
        mengenalOrgan = findViewById(R.id.llKenalBentuk);
        mengenalOrgan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mengenalOrgan.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, PengenalanActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Kenal", "11");
                intent.putExtra("kenal", "Mengenal Organ");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setKenalWarna(){
        mengenalWarna = findViewById(R.id.llKenalWarna);
        mengenalWarna.setOnClickListener(new View.OnClickListener() {
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
    public void setPenjumlahan(){
        penjumlahan = findViewById(R.id.llPenjumlahan);
        penjumlahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                penjumlahan.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "5");
                intent.putExtra("tebak","Penjumlahan");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setPengurangan(){
        pengurangan = findViewById(R.id.llPengurangan);
        pengurangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pengurangan.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "6");
                intent.putExtra("tebak","Pengurangan");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setHitungGambar(){
        hitungGambar = findViewById(R.id.llPerkalian);
        hitungGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungGambar.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "7");
                intent.putExtra("tebak","Hitung Gambar");
                startActivity(intent);
                finish();
            }
        });
    }
    public void setBelajarAngka(){
        belajarAngka = findViewById(R.id.llPembagian);
        belajarAngka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                belajarAngka.setClickable(false);
                Intent intent = new Intent(KategoriActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "8");
                intent.putExtra("tebak","Belajar Angka");
                startActivity(intent);
                finish();
            }
        });
    }

    public void playBackgroundMusic(){
        bgMusic = MediaPlayer.create(KategoriActivity.this, R.raw.bgmusic);
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
        tebakHewan.setClickable(true);
        tebakBuah.setClickable(true);
        tebakOrgan.setClickable(true);
        tebakWarna.setClickable(true);
        mengenalHewan.setClickable(true);
        mengenalBuah.setClickable(true);
        mengenalOrgan.setClickable(true);
        mengenalWarna.setClickable(true);
        penjumlahan.setClickable(true);
        pengurangan.setClickable(true);
        hitungGambar.setClickable(true);
        belajarAngka.setClickable(true);
        backLayout.setClickable(true);
        super.onResume();
    }

}
