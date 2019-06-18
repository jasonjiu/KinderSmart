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
import com.example.kindersmart.Activity.Adapter.KenalGambarAdapter;
import com.example.kindersmart.Activity.Model.CustomLinearLayoutManager;
import com.example.kindersmart.Activity.Model.Mengenal;
import com.example.kindersmart.Activity.Model.OnImageClickListener;
import com.example.kindersmart.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PengenalanActivity extends AppCompatActivity implements OnImageClickListener {
    private String                      getKategoriExtra, getNamaPengenalan;
    private Context                     context;
    private RequestQueue                queue;
    private CustomLinearLayoutManager   layoutManager;
    private RecyclerView                rvKenal;
    private KenalGambarAdapter          kenalGambarAdapter;
    private List<Mengenal>              mengenalList = new ArrayList<>();
    private AlertDialog                 alertDialog;
    private TextView                    tvTb;
    private ImageView                   ivTb;
    private LottieAnimationView         loading;
    private FragmentManager             fragmentManager;
    private FragmentTransaction         fragmentTransaction;
    private ConnectionErrorFragment     fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan);
        context             = PengenalanActivity.this;
        Intent intent       = getIntent();
        getKategoriExtra    = intent.getStringExtra("Kategori_Kenal");
        getNamaPengenalan   = intent.getStringExtra("kenal");
        queue               = Volley.newRequestQueue(context);
        rvKenal = findViewById(R.id.rvKenal);
        loading             = findViewById(R.id.loadingAnimation);
        layoutManager = new CustomLinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        layoutManager.setScrollEnabled(false);
        rvKenal.setLayoutManager(layoutManager);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new ConnectionErrorFragment();

        toolbar();
        show_kenal();

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

    public void toolbar(){
        Toolbar mToolbar = findViewById(R.id.tbMengenal);
        tvTb             = mToolbar.findViewById(R.id.tvtbTitle);
        ivTb             = mToolbar.findViewById(R.id.ivtbExit);
        tvTb.setText(getNamaPengenalan);
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
    public void exitDialog(int layout){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
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
                Intent intent = new Intent(PengenalanActivity.this, KategoriActivity.class);
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

    public void show_kenal(){
        JsonObjectRequest rec= new JsonObjectRequest
                ("https://mikeztj.com/Jason/PHPTebakGambar/Mengenal.php?id="+getKategoriExtra, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                JSONArray listSoal = null;
                                mengenalList.clear();
                                try {
                                    listSoal = response.getJSONArray("result");
                                    Log.d("listSoal",listSoal.toString());
                                    for (int i = 0; i < listSoal.length(); i++) {
                                        try {
                                            loading.setVisibility(View.GONE);
                                            rvKenal.setVisibility(View.VISIBLE);
                                            final JSONObject obj = listSoal.getJSONObject(i);

                                            mengenalList.add(new Mengenal(
                                                    obj.getInt("kategoriID"),
                                                    obj.getInt("kenal_ke"),
                                                    obj.getString("nama_kenal"),
                                                    obj.getString("gambar_kenal"),
                                                    obj.getString("suara_kenal")));
                                        } catch (JSONException e1) {
                                            e1.printStackTrace();
                                        }
                                    }
                                    kenalGambarAdapter = new KenalGambarAdapter(context);
                                    kenalGambarAdapter.setMengenalList(mengenalList);
                                    kenalGambarAdapter.setOnImageClickListener((OnImageClickListener) context);
                                    rvKenal.setAdapter(kenalGambarAdapter);

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
        if (data.equals("back")){
            rvKenal.getLayoutManager().scrollToPosition(position - 1);
        }
        else if (data.equals("next")){
            rvKenal.getLayoutManager().scrollToPosition(position + 1);
        }
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onPause() {
        try {
            if ( kenalGambarAdapter.kenalSound.isPlaying()){
                kenalGambarAdapter.kenalSound.stop();
                if (isFinishing()){
                    kenalGambarAdapter.kenalSound.stop();
                    kenalGambarAdapter.kenalSound.release();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        super.onPause();
    }

    @Override
    protected void onResume() {
        try {
            kenalGambarAdapter.isPlaying = "true";
            kenalGambarAdapter.notifyDataSetChanged();
            Log.d("playing", kenalGambarAdapter.isPlaying+"");
        }catch (Exception e){
            e.printStackTrace();
        }
        super.onResume();

    }
}
