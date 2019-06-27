package com.edu.kindersmart.Activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.edu.kindersmart.Activity.Model.Score;
import com.edu.kindersmart.Activity.Model.UserLocalStore;
import com.edu.kindersmart.R;
import com.squareup.picasso.Picasso;

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



        if (highScore.tebakHewanScore == 1){
            tvHewan.setText(0+"");
            ivHewan.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.chalk), PorterDuff.Mode.SRC_IN);
            Picasso.with(getApplicationContext()).load(R.drawable.sad).into(ivHewan);
        }
        else {
            tvHewan.setText(highScore.tebakHewanScore+"");
        }

        if (highScore.tebakBuahScore == 1){
            tvBuah.setText(0+"");
            ivBuah.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.chalk), PorterDuff.Mode.SRC_IN);
            Picasso.with(getApplicationContext()).load(R.drawable.sad).into(ivBuah);
        }
        else {
            tvBuah.setText(highScore.tebakBuahScore+"");
        }

        if (highScore.tebakOrganScore == 1){
            tvOrgan.setText(0+"");
            ivOrgan.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.chalk), PorterDuff.Mode.SRC_IN);
            Picasso.with(getApplicationContext()).load(R.drawable.sad).into(ivOrgan);
        }
        else {
            tvOrgan.setText(highScore.tebakOrganScore+"");

        }

        if (highScore.tebakWarnaScore == 1){
            tvWarna.setText(0+"");
            ivWarna.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.chalk), PorterDuff.Mode.SRC_IN);
            Picasso.with(getApplicationContext()).load(R.drawable.sad).into(ivWarna);

        }
        else {
            tvWarna.setText(highScore.tebakWarnaScore+"");
        }

        if (highScore.penjumlahanScore == 1){
            tvPenjumlahan.setText(0+"");
            ivPenjumlahan.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.chalk), PorterDuff.Mode.SRC_IN);
            Picasso.with(getApplicationContext()).load(R.drawable.sad).into(ivPenjumlahan);

        }
        else {
            tvPenjumlahan.setText(highScore.penjumlahanScore+"");
        }

        if (highScore.penguranganScore == 1){
            tvPengurangan.setText(0+"");
            ivPengurangan.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.chalk), PorterDuff.Mode.SRC_IN);
            Picasso.with(getApplicationContext()).load(R.drawable.sad).into(ivPengurangan);

        }
        else {
            tvPengurangan.setText(highScore.penguranganScore+"");

        }

        if (highScore.hitungGambarScore == 1){
            tvHitungGambar.setText(0+"");
            ivHitungGambar.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.chalk), PorterDuff.Mode.SRC_IN);
            Picasso.with(getApplicationContext()).load(R.drawable.sad).into(ivHitungGambar);

        }
        else {
            tvHitungGambar.setText(highScore.hitungGambarScore+"");
        }

        if (highScore.tebakAngkaScore == 1){
            tvTebakAngka.setText(0+"");
            ivTebakAngka.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.chalk), PorterDuff.Mode.SRC_IN);
            Picasso.with(getApplicationContext()).load(R.drawable.sad).into(ivTebakAngka);
        }
        else {
            tvTebakAngka.setText(highScore.tebakAngkaScore+"");
        }

        //hewan
        if(highScore.tebakHewanScore == 10 ||  highScore.tebakHewanScore == 20 ||  highScore.tebakHewanScore == 30 ||  highScore.tebakHewanScore == 40 ){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_bronze).into(ivHewan);
        }
        else if (highScore.tebakHewanScore == 50 ||  highScore.tebakHewanScore == 60 ||  highScore.tebakHewanScore == 70 ||  highScore.tebakHewanScore == 80){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_silver).into(ivHewan);
        }
        else if(highScore.tebakHewanScore == 90 ||  highScore.tebakHewanScore == 100){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_gold).into(ivHewan);
        }


        //buah
        if(highScore.tebakBuahScore == 10 ||  highScore.tebakBuahScore == 20 ||  highScore.tebakBuahScore == 30 ||  highScore.tebakBuahScore == 40){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_bronze).into(ivBuah);
        }
        else if (highScore.tebakBuahScore == 50 ||  highScore.tebakBuahScore == 60 ||  highScore.tebakBuahScore == 70 ||  highScore.tebakBuahScore == 80){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_silver).into(ivBuah);
        }
        else if(highScore.tebakBuahScore == 90 ||  highScore.tebakBuahScore == 100){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_gold).into(ivBuah);

        }


        //organ
        if(highScore.tebakOrganScore == 10 ||  highScore.tebakOrganScore == 20 ||  highScore.tebakOrganScore == 30 ||  highScore.tebakOrganScore == 40){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_bronze).into(ivOrgan);
        }
        else if (highScore.tebakOrganScore == 50 ||  highScore.tebakOrganScore == 60 ||  highScore.tebakOrganScore == 70 ||  highScore.tebakOrganScore == 80){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_silver).into(ivOrgan);
        }
        else if(highScore.tebakOrganScore == 90 ||  highScore.tebakOrganScore == 100){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_gold).into(ivOrgan);

        }

        //warna
        if(highScore.tebakWarnaScore == 10 ||  highScore.tebakWarnaScore == 20  ||  highScore.tebakWarnaScore == 30 ||  highScore.tebakWarnaScore == 40){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_bronze).into(ivWarna);
        }
        else if (highScore.tebakWarnaScore == 50 ||  highScore.tebakWarnaScore == 60 ||  highScore.tebakWarnaScore == 70 ||  highScore.tebakWarnaScore == 80){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_silver).into(ivWarna);
        }
        else if(highScore.tebakWarnaScore == 90 ||  highScore.tebakWarnaScore == 100){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_gold).into(ivWarna);
        }


        //penjumlahan
        if(highScore.penjumlahanScore == 10 ||  highScore.penjumlahanScore == 20  ||  highScore.penjumlahanScore == 30  ||  highScore.penjumlahanScore == 40){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_bronze).into(ivPenjumlahan);
        }
        else if (highScore.penjumlahanScore == 50  ||  highScore.penjumlahanScore == 60  ||  highScore.penjumlahanScore == 70  ||  highScore.penjumlahanScore == 80){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_silver).into(ivPenjumlahan);
        }
        else if(highScore.penjumlahanScore == 90  ||  highScore.penjumlahanScore == 100){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_gold).into(ivPenjumlahan);
        }

        //pengurangan
        if(highScore.penguranganScore == 10 ||  highScore.penguranganScore == 20 ||  highScore.penguranganScore == 30 ||  highScore.penguranganScore == 40){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_bronze).into(ivPengurangan);
        }
        else if (highScore.penguranganScore == 50 ||  highScore.penguranganScore == 60 ||  highScore.penguranganScore == 70 ||  highScore.penguranganScore == 80){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_silver).into(ivPengurangan);
        }
        else if(highScore.penguranganScore == 90 ||  highScore.penguranganScore == 100){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_gold).into(ivPengurangan);
        }

        //hitung gambar
        if(highScore.hitungGambarScore == 10 ||  highScore.hitungGambarScore == 20 ||  highScore.hitungGambarScore == 30 ||  highScore.hitungGambarScore == 40){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_bronze).into(ivHitungGambar);
        }
        else if (highScore.hitungGambarScore == 50 ||  highScore.hitungGambarScore == 60 ||  highScore.hitungGambarScore == 70 ||  highScore.hitungGambarScore == 80){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_silver).into(ivHitungGambar);
        }
        else if(highScore.hitungGambarScore == 90 ||  highScore.hitungGambarScore == 100){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_gold).into(ivHitungGambar);
        }

        //tebak angka
        if(highScore.tebakAngkaScore == 10 ||  highScore.tebakAngkaScore == 20 ||  highScore.tebakAngkaScore == 30 ||  highScore.tebakAngkaScore == 40){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_bronze).into(ivTebakAngka);
        }
        else if (highScore.tebakAngkaScore == 50 ||  highScore.tebakAngkaScore == 60 ||  highScore.tebakAngkaScore == 70 ||  highScore.tebakAngkaScore == 80){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_silver).into(ivTebakAngka);
        }
        else if(highScore.tebakAngkaScore == 90 ||  highScore.tebakAngkaScore == 100){
            Picasso.with(getApplicationContext()).load(R.drawable.thropy_gold).into(ivTebakAngka);
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
