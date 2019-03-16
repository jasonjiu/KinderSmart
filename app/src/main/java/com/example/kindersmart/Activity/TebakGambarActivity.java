package com.example.kindersmart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kindersmart.R;

public class TebakGambarActivity extends AppCompatActivity {
    private String getKategoriExtra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebak_gambar);
        Intent intent = getIntent();
        getKategoriExtra = intent.getStringExtra("Kategori_Tebak");
        Toast.makeText(this, getKategoriExtra, Toast.LENGTH_SHORT).show();
    }
}
