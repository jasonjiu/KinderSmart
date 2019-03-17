package com.example.kindersmart.Activity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.kindersmart.Activity.Model.JawabanTebakGambar;
import com.example.kindersmart.Activity.Model.OnImageClickListener;
import com.example.kindersmart.R;

import java.util.List;

import javax.security.auth.callback.Callback;

public class JawabanTebakAdapter extends RecyclerView.Adapter<JawabanTebakAdapter.jtViewHolder> {
    private List<JawabanTebakGambar>    jawabanTebakGambarList;
    private Context                     context;
    public static String                lastAnswer = "";
    private OnImageClickListener        onImageClickListener;

    public String getLastAnswer() {
        return lastAnswer;
    }


    public JawabanTebakAdapter(List<JawabanTebakGambar> jawabanTebakGambarList, Context context, OnImageClickListener onImageClickListener) {
        this.jawabanTebakGambarList = jawabanTebakGambarList;
        this.context                = context;
        this.onImageClickListener   = onImageClickListener;
    }

    @NonNull
    @Override
    public JawabanTebakAdapter.jtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_jawaban_tebak, parent, false);
        return new jtViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull JawabanTebakAdapter.jtViewHolder holder, final int position) {
        final JawabanTebakGambar jawabanTebakGambar = jawabanTebakGambarList.get(position);
        holder.btnJawab.setText(jawabanTebakGambar.getPilihan());
        holder.btnJawab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastAnswer = jawabanTebakGambar.getPilihan();
                Toast.makeText(context, lastAnswer+"", Toast.LENGTH_SHORT).show();
                Log.d("hahaha", getLastAnswer());
//                onImageClickListener.onImageClick(getLastAnswer(), position+"");
            }
        });

    }

    @Override
    public int getItemCount() {
        return jawabanTebakGambarList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class jtViewHolder extends RecyclerView.ViewHolder {
        private   Button btnJawab;
        public jtViewHolder(View itemView) {
            super(itemView);
            btnJawab = itemView.findViewById(R.id.btnJawabTebak);
        }
    }
}
