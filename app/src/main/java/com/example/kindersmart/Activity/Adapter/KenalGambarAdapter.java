package com.example.kindersmart.Activity.Adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.kindersmart.Activity.Model.Mengenal;
import com.example.kindersmart.Activity.Model.OnImageClickListener;
import com.example.kindersmart.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

public class KenalGambarAdapter extends RecyclerView.Adapter<KenalGambarAdapter.kgViewHolder> {
    private Context                 context;
    private OnImageClickListener    onImageClickListener;
    private List<Mengenal>          mengenalList;
    public  MediaPlayer             kenalSound;
    public  String                  isPlaying = "true";

    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    public void setMengenalList(List<Mengenal> mengenalList) {
        this.mengenalList = mengenalList;
    }

    public KenalGambarAdapter(Context context) {
        this.context                = context;
    }

    @NonNull
    @Override
    public KenalGambarAdapter.kgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_kenal, parent, false);
        return new kgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final KenalGambarAdapter.kgViewHolder holder, final int position) {
        final Mengenal mengenal = mengenalList.get(position);
        Picasso.with(context).load(mengenal.getGambarKenal()).into(holder.ivKenal);
        holder.tvKenal.setText(mengenal.getNamaKenal());


        if (position == 0){
            holder.back.setVisibility(View.GONE);
        }
        else if (position == mengenalList.size() - 1){
            holder.next.setVisibility(View.GONE);
        }

        if(isPlaying.equals("true")){
            holder.sound.setEnabled(true);
        }

        holder.sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    kenalSound = new MediaPlayer();
                    kenalSound.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    kenalSound.setDataSource(mengenal.getSuaraKenal());
                    kenalSound.prepare();
                    kenalSound.start();
                    holder.sound.setEnabled(true);
                    kenalSound.setLooping(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (kenalSound.isPlaying()){
                    Toast.makeText(context, "playing", Toast.LENGTH_SHORT).show();
                   holder.sound.setEnabled(false);
                }

                kenalSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(context, "is done", Toast.LENGTH_SHORT).show();
                        holder.sound.setEnabled(true);
                    }
                });
            }
        });

        holder.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.sound.setEnabled(true);
                try {
                    kenalSound.stop();
                }catch (Exception e){
                    e.printStackTrace();
                }
                onImageClickListener.onImageClick("back", position);
            }
        });

        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.sound.setEnabled(true);
                try {
                    kenalSound.stop();
                }catch (Exception e){
                    e.printStackTrace();
                }
                onImageClickListener.onImageClick("next", position);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mengenalList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class kgViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivKenal, sound, back, next;
        private TextView  tvKenal;

        public kgViewHolder(View itemView) {
            super(itemView);
            ivKenal = itemView.findViewById(R.id.ivKenal);
            sound   = itemView.findViewById(R.id.ivSoundKenal);
            back    = itemView.findViewById(R.id.ivBackKenal);
            next    = itemView.findViewById(R.id.ivNextKenal);
            tvKenal = itemView.findViewById(R.id.tvKenal);
        }
    }
}
