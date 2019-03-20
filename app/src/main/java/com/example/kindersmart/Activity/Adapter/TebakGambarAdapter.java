package com.example.kindersmart.Activity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
    private OnImageClickListener            onImageClickListener;

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
    public void onBindViewHolder(@NonNull final TebakGambarAdapter.tgViewHolder holder, final int position) {
        final SoalTebakGambar soalTebakGambar = soalTebakGambars.get(position);

        Picasso.with(context).load(soalTebakGambar.getUrl_soal()).into(holder.soalTebak);

        holder.jbtn1.setText(soalTebakGambar.getPilihan_jawaban1());
        holder.jbtn2.setText(soalTebakGambar.getPilihan_jawaban2());
        holder.jbtn3.setText(soalTebakGambar.getPilihan_jawaban3());
        holder.jbtn4.setText(soalTebakGambar.getPilihan_jawaban4());

        holder.jbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.onImageClick("",position);
                Log.d("kunci", soalTebakGambar.getKunci_jawaban());
            }
        });
        holder.jbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.onImageClick("",position);
                Log.d("kunci", soalTebakGambar.getKunci_jawaban());
            }
        });
        holder.jbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.onImageClick("",position);
                Log.d("kunci", soalTebakGambar.getKunci_jawaban());
            }
        });
        holder.jbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.onImageClick("",position);
                Log.d("kunci", soalTebakGambar.getKunci_jawaban());
            }
        });

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
        public ImageView        soalTebak, sound;
        public RelativeLayout   relativeLayout;
        public Button           jbtn1, jbtn2, jbtn3, jbtn4;

        public tgViewHolder(View itemView) {
            super(itemView);
            soalTebak       = itemView.findViewById(R.id.ivSoalTebakGambar);
            sound           = itemView.findViewById(R.id.ivSoundTebakGambar);
            relativeLayout  = itemView.findViewById(R.id.linear1);
            jbtn1           = itemView.findViewById(R.id.btnJawabTebak1);
            jbtn2           = itemView.findViewById(R.id.btnJawabTebak2);
            jbtn3           = itemView.findViewById(R.id.btnJawabTebak3);
            jbtn4           = itemView.findViewById(R.id.btnJawabTebak4);

        }
    }
}
