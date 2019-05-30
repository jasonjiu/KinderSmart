package com.example.kindersmart.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.kindersmart.Activity.Adapter.QuizAdapter;
import com.example.kindersmart.Activity.Model.CustomLinearLayoutManager;
import com.example.kindersmart.Activity.Model.SoalQuiz;
import com.example.kindersmart.R;

import java.util.ArrayList;
import java.util.List;

public class MatematikaActivity extends AppCompatActivity {
    private String                      getKategoriExtra, getNamaTebakan;
    private RecyclerView                rvSoal;
    private Context                     context;
    private RequestQueue                queue;
    private QuizAdapter quizAdapter;
    private List<SoalQuiz> soalQuizList = new ArrayList<>();
    private CustomLinearLayoutManager   lm;
    private int                         score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematika);
        context             = MatematikaActivity.this;
        Intent intent       = getIntent();
        getKategoriExtra    = intent.getStringExtra("Kategori_Mat");
        Toast.makeText(this, getKategoriExtra, Toast.LENGTH_SHORT).show();

        rvSoal = findViewById(R.id.rvSoalMat);
        lm = new CustomLinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        lm.setScrollEnabled(false);
        rvSoal.setLayoutManager(lm);
        queue= Volley.newRequestQueue(context);
        toolbar();
    }

    public void toolbar(){
        Toolbar mToolbar = findViewById(R.id.tbConfirmation);
        mToolbar.setTitle(getNamaTebakan);
        mToolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
