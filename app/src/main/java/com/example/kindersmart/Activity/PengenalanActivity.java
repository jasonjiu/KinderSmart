package com.example.kindersmart.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.kindersmart.Activity.Adapter.KenalGambarAdapter;
import com.example.kindersmart.Activity.Adapter.TebakGambarAdapter;
import com.example.kindersmart.Activity.Model.CustomLinearLayoutManager;
import com.example.kindersmart.Activity.Model.Mengenal;
import com.example.kindersmart.Activity.Model.OnImageClickListener;
import com.example.kindersmart.Activity.Model.SoalTebakGambar;
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
    private CustomLinearLayoutManager   lm;
    private RecyclerView                rv;
    private KenalGambarAdapter          kenalGambarAdapter;
    private List<Mengenal>              mengenalList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengenalan);
        context             = PengenalanActivity.this;
        Intent intent       = getIntent();
        getKategoriExtra    = intent.getStringExtra("Kategori_Kenal");
        getNamaPengenalan   = intent.getStringExtra("kenal");
        queue               = Volley.newRequestQueue(context);
        rv                  = findViewById(R.id.rvKenal);
        lm                  = new CustomLinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        lm.setScrollEnabled(false);
        rv.setLayoutManager(lm);
        toolbar();
        show_kenal();

    }

    public void toolbar(){
        Toolbar mToolbar = findViewById(R.id.tbConfirmation);
        mToolbar.setTitle(getNamaPengenalan);
        mToolbar.setNavigationIcon(R.drawable.ic_chevron_left_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                                            rv.setVisibility(View.VISIBLE);
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
                                    rv.setAdapter(kenalGambarAdapter);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        queue.add(rec);
    }

    @Override
    public void onImageClick(String data, int position) {
        if (data.equals("back")){
            rv.getLayoutManager().scrollToPosition(position - 1);
        }
        else if (data.equals("next")){
            rv.getLayoutManager().scrollToPosition(position + 1);
        }
    }

    @Override
    public void onBackPressed() {
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
        super.onBackPressed();

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
        }catch (Exception e){}
        super.onResume();

    }
}
