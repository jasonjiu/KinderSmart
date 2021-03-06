package com.example.kindersmart.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.kindersmart.Activity.Adapter.QuizAdapter;
import com.example.kindersmart.Activity.Model.OnImageClickListener;
import com.example.kindersmart.Activity.Model.CustomLinearLayoutManager;
import com.example.kindersmart.Activity.Model.SoalQuiz;
import com.example.kindersmart.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity implements OnImageClickListener {
    private String                      getKategoriExtra, getNamaTebakan;
    private RecyclerView                rvSoal;
    private Context                     context;
    private RequestQueue                queue;
    private QuizAdapter                 quizAdapter;
    private List<SoalQuiz>              soalQuizList = new ArrayList<>();
    private CustomLinearLayoutManager   layoutManager;
    private int                         score = 0;
    private TextView                    tvTb;
    private ImageView                   ivTb;
    private AlertDialog                 alertDialog;
    private LottieAnimationView         loading;
    private FragmentManager             fragmentManager;
    private FragmentTransaction         fragmentTransaction;
    private ConnectionErrorFragment     fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        context             = QuizActivity.this;
        Intent intent       = getIntent();
        getKategoriExtra    = intent.getStringExtra("Kategori_Tebak");
        getNamaTebakan      = intent.getStringExtra("tebak");
        queue               = Volley.newRequestQueue(context);
        rvSoal              = findViewById(R.id.rvSoalTebak);
        loading             = findViewById(R.id.loadingAnimation);
        layoutManager = new CustomLinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        layoutManager.setScrollEnabled(false);
        rvSoal.setLayoutManager(layoutManager);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new ConnectionErrorFragment();

        show_soal();
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

    public void exitDialog(int layout){

        AlertDialog.Builder dialogBuilder   = new AlertDialog.Builder(this);
        View                layoutView      = getLayoutInflater().inflate(layout, null);
        Button              dialogButton    = layoutView.findViewById(R.id.btnDialogExit);
        Button              dialogCancel    = layoutView.findViewById(R.id.btnDialogCancel);
        TextView            tvDialog1       = layoutView.findViewById(R.id.textView);
        TextView            tvDialog2       = layoutView.findViewById(R.id.textView2);
        dialogBuilder.setView(layoutView);

        alertDialog  = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        ivTb.setEnabled(true);

        tvDialog1.setText(getResources().getString(R.string.stop_playing));
        tvDialog2.setText(getResources().getString(R.string.confrim_stop_playing));

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, KategoriActivity.class);
                startActivity(intent);
                finish();
            }
        });

        dialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

    }


    public void toolbar(){
        Toolbar mToolbar = findViewById(R.id.tbConfirmation);
        tvTb             = mToolbar.findViewById(R.id.tvtbTitle);
        ivTb             = mToolbar.findViewById(R.id.ivtbExit);
        tvTb.setText(getNamaTebakan);
        ivTb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.RubberBand)
                        .duration(500)
                        .repeat(2)
                        .playOn(ivTb);
                ivTb.setEnabled(false);
                exitDialog(R.layout.dialog_exit);
            }
        });

    }

    public void show_soal(){
        JsonObjectRequest rec= new JsonObjectRequest
                ("https://mikeztj.com/Jason/PHPTebakGambar/SoalTebakGambar.php?id="+getKategoriExtra, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                JSONArray listSoal = null;
                                soalQuizList.clear();
                                try {
                                    listSoal = response.getJSONArray("result");
//                                    Log.d("listSoal",listSoal.toString());
                                    for (int i = 0; i < listSoal.length(); i++) {
                                        try {
                                            loading.setVisibility(View.GONE);
                                            rvSoal.setVisibility(View.VISIBLE);
                                            final JSONObject obj = listSoal.getJSONObject(i);

                                            soalQuizList.add(new SoalQuiz(
                                                    obj.getInt("kategoriID"),
                                                    obj.getInt("soal_ke"),
                                                    obj.getString("soal_picture"),
                                                    obj.getString("kunci_jawaban"),
                                                    obj.getString("pilihan_jawaban_1"),
                                                    obj.getString("pilihan_jawaban_2"),
                                                    obj.getString("pilihan_jawaban_3"),
                                                    obj.getString("pilihan_jawaban_4"),
                                                    obj.getString("soal"),
                                                    obj.getString("soal_suara")));
                                        } catch (JSONException e1) {
                                            e1.printStackTrace();
                                        }
                                    }
                                    quizAdapter = new QuizAdapter(context);
                                    quizAdapter.setSoalQuizs(soalQuizList);
                                    quizAdapter.setQuizAdapter((OnImageClickListener) context);
                                    rvSoal.setAdapter(quizAdapter);


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.GONE);
                        Toast.makeText(context, "Koneksi Bermasalah", Toast.LENGTH_LONG).show();
                        fragmentTransaction.add(R.id.fragmen404, fragment);
                        fragmentTransaction.commit();
                        //Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(rec);
    }


    @Override
    public void onImageClick(String data, int position) {


        try {
            if (data.equals(soalQuizList.get(position).getKunci_jawaban())){
                score += 10;
//                Toast.makeText(context, "score"+score, Toast.LENGTH_SHORT).show();
                rvSoal.getLayoutManager().scrollToPosition(position+1);
            }
            else {
                rvSoal.getLayoutManager().scrollToPosition(position+1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        
            if (position == quizAdapter.getItemCount()-1 && getKategoriExtra.equals("1") ) {
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("hewan", score);
                intent.putExtra("kategori", "hewan");
                startActivity(intent);
                finish();
            }
            if (position == quizAdapter.getItemCount()-1 && getKategoriExtra.equals("2")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("buah", score);
                intent.putExtra("kategori", "buah");
                startActivity(intent);
                finish();
            }
            if (position == quizAdapter.getItemCount()-1 && getKategoriExtra.equals("3")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("organ", score);
                intent.putExtra("kategori", "organ");
                startActivity(intent);
                finish();
            }
            if (position == quizAdapter.getItemCount()-1 && getKategoriExtra.equals("4")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("warna", score);
                intent.putExtra("kategori", "warna");
                startActivity(intent);
                finish();
            }
            if (position == quizAdapter.getItemCount()-1 && getKategoriExtra.equals("5")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("penjumlahan", score);
                intent.putExtra("kategori", "penjumlahan");
                startActivity(intent);
                finish();
            }
            if (position == quizAdapter.getItemCount()-1 && getKategoriExtra.equals("6")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("pengurangan", score);
                intent.putExtra("kategori", "pengurangan");
                startActivity(intent);
                finish();
            }
            if (position == quizAdapter.getItemCount()-1 && getKategoriExtra.equals("7")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("hitungGambar", score);
                intent.putExtra("kategori", "hitungGambar");
                startActivity(intent);
                finish();
            }
            if (position == quizAdapter.getItemCount()-1 && getKategoriExtra.equals("8")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("tebakAngka", score);
                intent.putExtra("kategori", "tebakAngka");
                startActivity(intent);
                finish();
            }

    }


    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onResume() {
        try {
            quizAdapter.isPlaying = "true";
            quizAdapter.notifyDataSetChanged();
//            Log.d("playing", quizAdapter.isPlaying+"");
        }catch (Exception e){
            e.printStackTrace();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        try {
            if ( quizAdapter.suaraSoal.isPlaying()){
                quizAdapter.suaraSoal.stop();
                if (isFinishing()){
                    quizAdapter.suaraSoal.stop();
                    quizAdapter.suaraSoal.release();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        super.onPause();
    }

}
