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
import com.example.kindersmart.Activity.Adapter.TebakGambarAdapter;
import com.example.kindersmart.Activity.Model.OnImageClickListener;
import com.example.kindersmart.Activity.Model.CustomLinearLayoutManager;
import com.example.kindersmart.Activity.Model.SoalTebakGambar;
import com.example.kindersmart.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TebakGambarActivity extends AppCompatActivity implements OnImageClickListener {
    private String                      getKategoriExtra, getNamaTebakan;
    private RecyclerView                rvSoal;
    private Context                     context;
    private RequestQueue                queue;
    private TebakGambarAdapter          tebakGambarAdapter;
    private List<SoalTebakGambar>       soalTebakGambarList    = new ArrayList<>();
    private CustomLinearLayoutManager   lm;
    private int                         score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebak_gambar);
        context             = TebakGambarActivity.this;
        Intent intent       = getIntent();
        getKategoriExtra    = intent.getStringExtra("Kategori_Tebak");
        getNamaTebakan      = intent.getStringExtra("tebak");
        queue               = Volley.newRequestQueue(context);
        rvSoal              = findViewById(R.id.rvSoalTebak);
        lm                  = new CustomLinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false);
        lm.setScrollEnabled(false);
        rvSoal.setLayoutManager(lm);

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
                                                    obj.getInt("kategoriID"),
                                                    obj.getInt("soal_ke"),
                                                    obj.getString("soal_picture"),
                                                    obj.getString("kunci_jawaban"),
                                                    obj.getString("pilihan_jawaban_1"),
                                                    obj.getString("pilihan_jawaban_2"),
                                                    obj.getString("pilihan_jawaban_3"),
                                                    obj.getString("pilihan_jawaban_4"),
                                                    obj.getString("soal")));
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
    public void onBackPressed() {

    }

    @Override
    public void onImageClick(String data, int position) {
        try {
            Log.d("kuncijawaban", soalTebakGambarList.get(position).getKunci_jawaban());
            Log.d("jawaban", data);
            if (data.equals(soalTebakGambarList.get(position).getKunci_jawaban())){
                score += 10;
                Toast.makeText(context, "score"+score, Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        Log.d("wow", position+"");
        rvSoal.getLayoutManager().scrollToPosition(position+1);
        Log.d("score", score+"");
        Log.d("getextra", getKategoriExtra);
        
            if (position == tebakGambarAdapter.getItemCount()-1 && getKategoriExtra.equals("1") ) {
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("hewan", score);
                intent.putExtra("kategori", "hewan");
                startActivity(intent);
            }
            if (position == tebakGambarAdapter.getItemCount()-1 && getKategoriExtra.equals("2")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("buah", score);
                intent.putExtra("kategori", "buah");
                startActivity(intent);
            }
            if (position == tebakGambarAdapter.getItemCount()-1 && getKategoriExtra.equals("3")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("organ", score);
                intent.putExtra("kategori", "organ");
                startActivity(intent);
            }
            if (position == tebakGambarAdapter.getItemCount()-1 && getKategoriExtra.equals("4")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("warna", score);
                intent.putExtra("kategori", "warna");
                startActivity(intent);
            }
            if (position == tebakGambarAdapter.getItemCount()-1 && getKategoriExtra.equals("5")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("penjumlahan", score);
                intent.putExtra("kategori", "penjumlahan");
                startActivity(intent);
            }
            if (position == tebakGambarAdapter.getItemCount()-1 && getKategoriExtra.equals("6")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("pengurangan", score);
                intent.putExtra("kategori", "pengurangan");
                startActivity(intent);
            }
            if (position == tebakGambarAdapter.getItemCount()-1 && getKategoriExtra.equals("7")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("hitungGambar", score);
                intent.putExtra("kategori", "hitungGambar");
                startActivity(intent);
            }
            if (position == tebakGambarAdapter.getItemCount()-1 && getKategoriExtra.equals("8")){
                Intent intent = new Intent(context, RecentScoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("tebakAngka", score);
                intent.putExtra("kategori", "tebakAngka");
                startActivity(intent);
            }

    }

}
