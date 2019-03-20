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
import com.example.kindersmart.Activity.Adapter.JawabanTebakAdapter;
import com.example.kindersmart.Activity.Adapter.TebakGambarAdapter;
import com.example.kindersmart.Activity.Model.OnImageClickListener;
import com.example.kindersmart.Activity.Model.CustomLinearLayoutManager;
import com.example.kindersmart.Activity.Model.JawabanTebakGambar;
import com.example.kindersmart.Activity.Model.SoalTebakGambar;
import com.example.kindersmart.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TebakGambarActivity extends AppCompatActivity implements OnImageClickListener {
    public String                      getKategoriExtra, getNamaTebakan;
    public RecyclerView                rvSoal;
    public Context                     context;
    public RequestQueue                queue;
    public TebakGambarAdapter          tebakGambarAdapter;
    public List<SoalTebakGambar>       soalTebakGambarList    = new ArrayList<>();
    public CustomLinearLayoutManager   lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebak_gambar);
        context             = TebakGambarActivity.this;
        Intent intent       = getIntent();
        getKategoriExtra    = intent.getStringExtra("Kategori_Tebak");
        getNamaTebakan      = intent.getStringExtra("tebak");



        rvSoal = findViewById(R.id.rvSoalTebak);
        lm = new CustomLinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        lm.setScrollEnabled(false);
        rvSoal.setLayoutManager(lm);
        queue= Volley.newRequestQueue(context);
        show_soal();
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

    public void show_soal(){
        JsonObjectRequest rec= new JsonObjectRequest
                ("https://mikeztj.com/Jason/PHPTebakGambar/SoalTebakGambar.php?id="+getKategoriExtra, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                JSONArray listSoal = null;
                                soalTebakGambarList.clear();
                                try {
                                    listSoal = response.getJSONArray("result");
                                    Log.d("listSoal",listSoal.toString());
                                    for (int i = 0; i < listSoal.length(); i++) {
                                        try {
                                            rvSoal.setVisibility(View.VISIBLE);
                                            final JSONObject obj = listSoal.getJSONObject(i);

                                            soalTebakGambarList.add(new SoalTebakGambar(
                                                    obj.getInt("tebakID"),
                                                    obj.getInt("soal_ke"),
                                                    obj.getString("soal_picture"),
                                                    obj.getString("kunci_jawaban"),
                                                    obj.getString("pilihan_jawaban_1"),
                                                    obj.getString("pilihan_jawaban_2"),
                                                    obj.getString("pilihan_jawaban_3"),
                                                    obj.getString("pilihan_jawaban_4")));
                                        } catch (JSONException e1) {
                                            e1.printStackTrace();
                                        }
                                    }
                                    tebakGambarAdapter = new TebakGambarAdapter(context);
                                    tebakGambarAdapter.setSoalTebakGambars(soalTebakGambarList);
                                    tebakGambarAdapter.setTebakGambarAdapter((OnImageClickListener) context);
                                    rvSoal.setAdapter(tebakGambarAdapter);


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
            rvSoal.getLayoutManager().scrollToPosition(position+1);

            if (position == tebakGambarAdapter.getItemCount()-1){
                Intent intent = new Intent(context, HelpActivity.class);
                startActivity(intent);
            }
            Log.d("wow", position+"");
            try {
                Log.d("kuncijawaban", soalTebakGambarList.get(position).getKunci_jawaban());

            }catch (Exception e){
                e.printStackTrace();
            }

    }

}
