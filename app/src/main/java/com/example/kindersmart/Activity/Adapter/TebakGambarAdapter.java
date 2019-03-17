package com.example.kindersmart.Activity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.kindersmart.Activity.Model.JawabanTebakGambar;
import com.example.kindersmart.Activity.Model.OnImageClickListener;
import com.example.kindersmart.Activity.Model.SoalTebakGambar;
import com.example.kindersmart.Activity.TebakGambarActivity;
import com.example.kindersmart.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TebakGambarAdapter extends RecyclerView.Adapter<TebakGambarAdapter.tgViewHolder> {
    public static Context                   context;
    private List<SoalTebakGambar>           soalTebakGambars;
    private List<JawabanTebakGambar>        jawabanTebakGambars;
    private List<JawabanTebakGambar>        tempJawaban;
    private JawabanTebakAdapter             jawabanTebakAdapter;
    private OnImageClickListener            onImageClickListener;


    public void setJawabanTebakGambars(List<JawabanTebakGambar> jawabanTebakGambars) {
        this.jawabanTebakGambars = jawabanTebakGambars;
    }

    public TebakGambarAdapter(Context context) {
        this.context = context;
    }

    public void setSoalTebakGambars(List<SoalTebakGambar> soalTebakGambars) {
        this.soalTebakGambars = soalTebakGambars;
    }

    public void setTebakGambarAdapter(OnImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    @NonNull
    @Override
    public TebakGambarAdapter.tgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_tebak, parent, false);
        return new tgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TebakGambarAdapter.tgViewHolder holder, final int position) {
        final SoalTebakGambar soalTebakGambar = soalTebakGambars.get(position);
        tempJawaban = new ArrayList<>();

        for (JawabanTebakGambar j:jawabanTebakGambars){
            if(j.getSoal_ke()==soalTebakGambar.getSoal_ke()){
                tempJawaban.add(j);
            }
        }
        Picasso.with(context).load(soalTebakGambar.getUrl_soal()).into(holder.soalTebak);
        jawabanTebakAdapter = new JawabanTebakAdapter(tempJawaban, context, (OnImageClickListener) context);
        holder.rvTebak.setLayoutManager(new GridLayoutManager(context, 2));
        holder.rvTebak.setAdapter(jawabanTebakAdapter);
        holder.rvTebak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.onImageClick("",position+"");
            }
        });
        Log.d("kunci", soalTebakGambar.getKunci_jawaban());

    }

    @Override
    public int getItemCount() {
        return soalTebakGambars.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public class tgViewHolder extends RecyclerView.ViewHolder {
        public  ImageView     soalTebak, sound;
        public  RecyclerView  rvTebak;
        public tgViewHolder(View itemView) {
            super(itemView);
            soalTebak = itemView.findViewById(R.id.ivSoalTebakGambar);
            sound = itemView.findViewById(R.id.ivSoundTebakGambar);

            rvTebak = itemView.findViewById(R.id.rvJawabanTebak);
            rvTebak.setHasFixedSize(true);

        }
    }
}
