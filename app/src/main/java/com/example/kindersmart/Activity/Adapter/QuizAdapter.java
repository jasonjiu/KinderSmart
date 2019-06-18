package com.example.kindersmart.Activity.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kindersmart.Activity.Model.OnImageClickListener;
import com.example.kindersmart.Activity.Model.SoalQuiz;
import com.example.kindersmart.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.tgViewHolder> {
    private Context                         context;
    private List<SoalQuiz>                  soalQuizs;
    private OnImageClickListener            onImageClickListener;
    private int                             lastPos = 0;
    private MediaPlayer                     trueFalseSound;


    public QuizAdapter(Context context) {
        this.context = context;
    }

    public void setSoalQuizs(List<SoalQuiz> soalQuizs) {
        this.soalQuizs = soalQuizs;
    }

    public void setQuizAdapter(OnImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    @NonNull
    @Override
    public QuizAdapter.tgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_quiz, parent, false);
        return new tgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuizAdapter.tgViewHolder holder, final int position) {
        final SoalQuiz soalQuiz = soalQuizs.get(position);
        Picasso.with(context).load(soalQuiz.getUrl_soal()).placeholder(R.drawable.progress_animation ).resize(300 ,300).into(holder.soalTebak);
        holder.tvSoal.setText(soalQuiz.getSoal());
        holder.jbtn1.setText(soalQuiz.getPilihan_jawaban1());
        holder.jbtn2.setText(soalQuiz.getPilihan_jawaban2());
        holder.jbtn3.setText(soalQuiz.getPilihan_jawaban3());
        holder.jbtn4.setText(soalQuiz.getPilihan_jawaban4());



        holder.jbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.jbtn1.setEnabled(false);
                holder.jbtn2.setEnabled(false);
                holder.jbtn3.setEnabled(false);
                holder.jbtn4.setEnabled(false);
                lastPos = position;

                if (soalQuiz.getPilihan_jawaban1().equals(soalQuiz.getKunci_jawaban())){
                    holder.jbtn1.setBackgroundTintList(context.getResources().getColorStateList(R.color.correct));

                    try {
                        trueFalseSound = MediaPlayer.create(context, R.raw.truesound);
                        trueFalseSound.start();
                        trueFalseSound.setLooping(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (trueFalseSound.isPlaying()){
                        Toast.makeText(context, "playing", Toast.LENGTH_SHORT).show();
                    }

                    trueFalseSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            Toast.makeText(context, "is done", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else if (!soalQuiz.getPilihan_jawaban1().equals(soalQuiz.getKunci_jawaban())){
                    holder.jbtn1.setBackgroundTintList(context.getResources().getColorStateList(R.color.bg_red));
                    try {
                        trueFalseSound = MediaPlayer.create(context, R.raw.wrong);
                        trueFalseSound.start();
                        trueFalseSound.setLooping(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (trueFalseSound.isPlaying()){
                        Toast.makeText(context, "playing", Toast.LENGTH_SHORT).show();
                    }

                    trueFalseSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            Toast.makeText(context, "is done", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

              holder.jbtn1.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      onImageClickListener.onImageClick(soalQuiz.getPilihan_jawaban1(), position);
                  }
              },300);

            }
        });

        holder.jbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.jbtn1.setEnabled(false);
                holder.jbtn2.setEnabled(false);
                holder.jbtn3.setEnabled(false);
                holder.jbtn4.setEnabled(false);
                lastPos = position;

                if (soalQuiz.getPilihan_jawaban2().equals(soalQuiz.getKunci_jawaban())){
                    holder.jbtn2.setBackgroundTintList(context.getResources().getColorStateList(R.color.correct));
                    try {
                        trueFalseSound = MediaPlayer.create(context, R.raw.truesound);
                        trueFalseSound.start();
                        trueFalseSound.setLooping(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (trueFalseSound.isPlaying()){
                        Toast.makeText(context, "playing", Toast.LENGTH_SHORT).show();

                    }

                    trueFalseSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            Toast.makeText(context, "is done", Toast.LENGTH_SHORT).show();

                        }
                    });

                }
                else if (!soalQuiz.getPilihan_jawaban2().equals(soalQuiz.getKunci_jawaban())){
                    holder.jbtn2.setBackgroundTintList(context.getResources().getColorStateList(R.color.bg_red));
                    try {
                        trueFalseSound = MediaPlayer.create(context, R.raw.wrong);
                        trueFalseSound.start();
                        trueFalseSound.setLooping(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (trueFalseSound.isPlaying()){
                        Toast.makeText(context, "playing", Toast.LENGTH_SHORT).show();
                    }

                    trueFalseSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            Toast.makeText(context, "is done", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                holder.jbtn2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onImageClickListener.onImageClick(soalQuiz.getPilihan_jawaban2(), position);
                    }
                },300);            }
        });

        holder.jbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.jbtn1.setEnabled(false);
                holder.jbtn2.setEnabled(false);
                holder.jbtn3.setEnabled(false);
                holder.jbtn4.setEnabled(false);
                lastPos = position;

                if (soalQuiz.getPilihan_jawaban3().equals(soalQuiz.getKunci_jawaban())){
                    holder.jbtn3.setBackgroundTintList(context.getResources().getColorStateList(R.color.correct));
                    try {
                        trueFalseSound = MediaPlayer.create(context, R.raw.truesound);
                        trueFalseSound.start();
                        trueFalseSound.setLooping(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (trueFalseSound.isPlaying()){
                        Toast.makeText(context, "playing", Toast.LENGTH_SHORT).show();
                    }

                    trueFalseSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            Toast.makeText(context, "is done", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else if (!soalQuiz.getPilihan_jawaban3().equals(soalQuiz.getKunci_jawaban())){
                    holder.jbtn3.setBackgroundTintList(context.getResources().getColorStateList(R.color.bg_red));
                    try {
                        trueFalseSound = MediaPlayer.create(context, R.raw.wrong);
                        trueFalseSound.start();
                        trueFalseSound.setLooping(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (trueFalseSound.isPlaying()){
                        Toast.makeText(context, "playing", Toast.LENGTH_SHORT).show();
                    }

                    trueFalseSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            Toast.makeText(context, "is done", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                holder.jbtn3.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onImageClickListener.onImageClick(soalQuiz.getPilihan_jawaban3(), position);
                    }
                },300);
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

                if (soalQuiz.getPilihan_jawaban4().equals(soalQuiz.getKunci_jawaban())){
                    holder.jbtn4.setBackgroundTintList(context.getResources().getColorStateList(R.color.correct));
                    try {
                        trueFalseSound = MediaPlayer.create(context, R.raw.truesound);
                        trueFalseSound.start();
                        trueFalseSound.setLooping(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (trueFalseSound.isPlaying()){
                        Toast.makeText(context, "playing", Toast.LENGTH_SHORT).show();
                    }

                    trueFalseSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            Toast.makeText(context, "is done", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else if (!soalQuiz.getPilihan_jawaban4().equals(soalQuiz.getKunci_jawaban())){
                    holder.jbtn4.setBackgroundTintList(context.getResources().getColorStateList(R.color.bg_red));
                    try {
                        trueFalseSound = MediaPlayer.create(context, R.raw.wrong);
                        trueFalseSound.start();
                        trueFalseSound.setLooping(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (trueFalseSound.isPlaying()){
                        Toast.makeText(context, "playing", Toast.LENGTH_SHORT).show();
                    }

                    trueFalseSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            Toast.makeText(context, "is done", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                holder.jbtn4.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onImageClickListener.onImageClick(soalQuiz.getPilihan_jawaban4(), position);
                    }
                },300);            }
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
