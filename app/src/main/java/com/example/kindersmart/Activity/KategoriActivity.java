package com.example.kindersmart.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.kindersmart.R;

public class KategoriActivity extends AppCompatActivity {

    private LinearLayout    tebakhewanll, tebakangkall, tebakbentukll, tebakwarnall,
                            kenalhewanll, kenalangkall, kenalbentukll, kenalwarnall,
                            penjumlahall, penguranganll, perkalianll, pembagianll;

    private ImageView       ivBack;
    private MediaPlayer     bgMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategory);
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

    public void setTebakhewanll(){
        tebakhewanll = findViewById(R.id.llTebakHewan);
        tebakhewanll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriActivity.this, TebakGambarActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "1");
                intent.putExtra("tebak","Tebak Hewan");
                startActivity(intent);
            }
        });
    }
    public void setTebakangkall(){
        tebakangkall = findViewById(R.id.llTebakAngka);
        tebakangkall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriActivity.this, TebakGambarActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "2");
                intent.putExtra("tebak", "Tebak Angka");
                startActivity(intent);
            }
        });
    }
    public void setTebakbentukll(){
        tebakbentukll = findViewById(R.id.llTebakBentuk);
        tebakbentukll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriActivity.this, TebakGambarActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "3");
                intent.putExtra("tebak", "Tebak Bentuk");
                startActivity(intent);
            }
        });
    }
    public void setTebakwarnall(){
        tebakwarnall = findViewById(R.id.llTebakWarna);
        tebakwarnall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriActivity.this, TebakGambarActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Tebak", "4");
                intent.putExtra("tebak", "Tebak Warna");
                startActivity(intent);
            }
        });
    }
    public void setKenalhewanll(){
        kenalhewanll = findViewById(R.id.llKenalHewan);
        kenalhewanll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriActivity.this, PengenalanActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Kenal", "KenalHewan");
                startActivity(intent);
            }
        });
    }
    public void setKenalangkall(){
        kenalangkall = findViewById(R.id.llKenalAngka);
        kenalangkall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriActivity.this, PengenalanActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Kenal", "KenalAngka");
                startActivity(intent);
            }
        });
    }
    public void setKenalbentukll(){
        kenalbentukll = findViewById(R.id.llKenalBentuk);
        kenalbentukll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriActivity.this, PengenalanActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Kenal", "KenalBentuk");
                startActivity(intent);
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
                intent.putExtra("Kategori_Kenal", "KenalWarna");
                startActivity(intent);
            }
        });
    }
    public void setPenjumlahall(){
        penjumlahall = findViewById(R.id.llPenjumlahan);
        penjumlahall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriActivity.this, MatematikaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Mat", "Penjumlahan");
                startActivity(intent);
            }
        });
    }
    public void setPenguranganll(){
        penguranganll = findViewById(R.id.llPengurangan);
        penguranganll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriActivity.this, MatematikaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Mat", "Pengurangan");
                startActivity(intent);
            }
        });
    }
    public void setPerkalianll(){
        perkalianll = findViewById(R.id.llPerkalian);
        perkalianll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriActivity.this, MatematikaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Mat", "Perkalian");
                startActivity(intent);
            }
        });
    }
    public void setPembagianll(){
        pembagianll = findViewById(R.id.llPembagian);
        pembagianll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KategoriActivity.this, MatematikaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Kategori_Mat", "Pembagian");
                startActivity(intent);
            }
        });
    }

    public void playBackgroundMusic(){
        bgMusic = MediaPlayer.create(KategoriActivity.this, R.raw.xuemiaojiao);
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
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
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
