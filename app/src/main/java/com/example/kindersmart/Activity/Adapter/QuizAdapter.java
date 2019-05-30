package com.example.kindersmart.Activity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kindersmart.Activity.Model.OnImageClickListener;
import com.example.kindersmart.Activity.Model.SoalQuiz;
import com.example.kindersmart.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.tgViewHolder> {
    private Context                         context;
    private List<SoalQuiz> soalQuizs;
    private OnImageClickListener            onImageClickListener;

    public QuizAdapter(Context context) {
        this.context = context;
    }

    public void setSoalQuizs(List<SoalQuiz> soalQuizs) {
        this.soalQuizs = soalQuizs;
    }

    public void setTebakGambarAdapter(OnImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    @NonNull
    @Override
    public QuizAdapter.tgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_tebak, parent, false);
        return new tgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuizAdapter.tgViewHolder holder, final int position) {
        final SoalQuiz soalQuiz = soalQuizs.get(position);

        Picasso.with(context).load(soalQuiz.getUrl_soal()).into(holder.soalTebak);
        holder.tvSoal.setText(soalQuiz.getSoal());
        holder.jbtn1.setText(soalQuiz.getPilihan_jawaban1());
        holder.jbtn2.setText(soalQuiz.getPilihan_jawaban2());
        holder.jbtn3.setText(soalQuiz.getPilihan_jawaban3());
        holder.jbtn4.setText(soalQuiz.getPilihan_jawaban4());

        holder.jbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.onImageClick(soalQuiz.getPilihan_jawaban1(), position);
            }
        });
        holder.jbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.onImageClick(soalQuiz.getPilihan_jawaban2(), position);
            }
        });
        holder.jbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.onImageClick(soalQuiz.getPilihan_jawaban3(), position);
            }
        });
        holder.jbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.onImageClick(soalQuiz.getPilihan_jawaban4(), position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return soalQuizs.size();
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
