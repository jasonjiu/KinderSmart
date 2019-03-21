package com.example.kindersmart.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.kindersmart.R;

public class RecentScoreActivity extends AppCompatActivity {
    private TextView    scoreTinggi, scoreRendah, nilaiScore;
    private int         getScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_score);
        Intent intent       = getIntent();
        getScore            = intent.getIntExtra("score", 0);
        Log.d("nialinya", String.valueOf(getScore));
        init();
        nilaiScore.setText(String.valueOf(getScore));
    }

    public void init(){
        scoreTinggi = findViewById(R.id.tvScoreTinggi);
        scoreRendah = findViewById(R.id.tvScoreAllFalse);
        nilaiScore  = findViewById(R.id.tvNilaiScore);

    }

}
