package com.example.kindersmart.Activity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kindersmart.Activity.Model.OnImageClickListener;
import com.example.kindersmart.Activity.Model.SoalTebakGambar;
import com.example.kindersmart.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TebakGambarAdapter extends RecyclerView.Adapter<TebakGambarAdapter.tgViewHolder> {
    private Context                         context;
    private List<SoalTebakGambar>           soalTebakGambars;
    private OnImageClickListener            onImageClickListener;
    private int lastPos = 0;


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
        holder.tvSoal.setText(soalTebakGambar.getSoal());
        holder.jbtn1.setText(soalTebakGambar.getPilihan_jawaban1());
        holder.jbtn2.setText(soalTebakGambar.getPilihan_jawaban2());
        holder.jbtn3.setText(soalTebakGambar.getPilihan_jawaban3());
        holder.jbtn4.setText(soalTebakGambar.getPilihan_jawaban4());

        holder.jbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.jbtn1.setEnabled(false);
                holder.jbtn2.setEnabled(false);
                holder.jbtn3.setEnabled(false);
                holder.jbtn4.setEnabled(false);
                lastPos = position;
                onImageClickListener.onImageClick(soalTebakGambar.getPilihan_jawaban1(), position);
            }
        });
        holder.jbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.jbtn1.setEnabled(false);
                holder.jbtn2.setEnabled(false);
                holder.jbtn3.setEnabled(false);
                holder.jbtn4.setEnabled(false);                lastPos = position;
                onImageClickListener.onImageClick(soalTebakGambar.getPilihan_jawaban2(), position);
            }
        });
        holder.jbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.jbtn1.setEnabled(false);
                holder.jbtn2.setEnabled(false);
                holder.jbtn3.setEnabled(false);
                holder.jbtn4.setEnabled(false);
                lastPos = position;
                onImageClickListener.onImageClick(soalTebakGambar.getPilihan_jawaban3(), position);
            }
        });
        holder.jbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.jbtn1.setEnabled(false);
                holder.jbtn2.setEnabled(false);
                holder.jbtn3.setEnabled(false);
                holder.jbtn4.setEnabled(false);
                lastPos = position;
                onImageClickListener.onImageClick(soalTebakGambar.getPilihan_jawaban4(), position);
            }
        });

        if (position > lastPos){
            holder.jbtn1.setEnabled(true);
            holder.jbtn2.setEnabled(true);
            holder.jbtn3.setEnabled(true);
            holder.jbtn4.setEnabled(true);
            Toast.makeText(context, lastPos+"", Toast.LENGTH_SHORT).show();
        }

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
        private ImageView        soalTebak, sound;
        private Button           jbtn1, jbtn2, jbtn3, jbtn4;
        private TextView         tvSoal;

        public tgViewHolder(View itemView) {
            super(itemView);
            soalTebak       = itemView.findViewById(R.id.ivSoalTebakGambar);
            tvSoal          = itemView.findViewById(R.id.soal);
            sound           = itemView.findViewById(R.id.ivSoundTebakGambar);
            jbtn1           = itemView.findViewById(R.id.btnJawabTebak1);
            jbtn2           = itemView.findViewById(R.id.btnJawabTebak2);
            jbtn3           = itemView.findViewById(R.id.btnJawabTebak3);
            jbtn4           = itemView.findViewById(R.id.btnJawabTebak4);

        }
    }
}
