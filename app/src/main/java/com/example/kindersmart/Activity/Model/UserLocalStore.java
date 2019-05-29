package com.example.kindersmart.Activity.Model;

import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {
    public static final String          SP_Name             = "userScore";
    private SharedPreferences           userLocalDatabase;
    private Context                     context;
    private SharedPreferences.Editor    editor;
    private static final String         TEBAK_HEWAN         = "tebak_hewan";
    private static final String         TEBAK_BUAH          = "tebak_buah";
    private static final String         TEBAK_ORGAN         = "tebak_organ";
    private static final String         TEBAK_WARNA         = "tebak_warna";
    private static final String         PENJUMLAHAN         = "penjumlahan";
    private static final String         PENGURANGAN         = "pengurangan";
    private static final String         HITUNG_GAMBAR       = "hitung_gambar";
    private static final String         TEBAK_ANGKA         = "tebak_angka";
    private static final String         IS_SCORE            = "is_score";

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_Name, 0);
        this.context = context;
        editor = userLocalDatabase.edit();
    }

    public void storeScoreHewan(Score score){
        editor.putInt(TEBAK_HEWAN, score.tebakHewanScore);
        editor.commit();
    }

    public void storeScoreBuah(Score score){
        editor.putInt(TEBAK_BUAH, score.tebakBuahScore);
        editor.commit();
    }

    public void storeScoreOrgan(Score score){
        editor.putInt(TEBAK_ORGAN, score.tebakOrganScore);
        editor.commit();
    }

    public void storeScoreWarna(Score score){
        editor.putInt(TEBAK_WARNA, score.tebakWarnaScore);
        editor.commit();
    }

    public void storeScorePenjumlahan(Score score){
        editor.putInt(PENJUMLAHAN, score.penjumlahanScore);
        editor.commit();
    }

    public void storeScorePengurangan(Score score){
        editor.putInt(PENGURANGAN, score.penguranganScore);
        editor.commit();
    }

    public void storeScoreHitungGambar(Score score){
        editor.putInt(HITUNG_GAMBAR, score.hitungGambarScore);
        editor.commit();
    }

    public void storeScoreTebakAngka(Score score){
        editor.putInt(TEBAK_ANGKA, score.tebakAngkaScore);
        editor.commit();
    }

    public Score getUserScore(){
        int tebakHewan = userLocalDatabase.getInt(TEBAK_HEWAN, 1);
        int tebakBuah = userLocalDatabase.getInt(TEBAK_BUAH, 1);
        int tebakOrgan = userLocalDatabase.getInt(TEBAK_ORGAN, 1);
        int tebakWarna = userLocalDatabase.getInt(TEBAK_WARNA, 1);
        int penjumlahan = userLocalDatabase.getInt(PENJUMLAHAN, 1);
        int pengurangan = userLocalDatabase.getInt(PENGURANGAN, 1);
        int hitungGabmar = userLocalDatabase.getInt(HITUNG_GAMBAR, 1);
        int tebakAngka = userLocalDatabase.getInt(TEBAK_ANGKA, 1);
        Score storedScore = new Score(tebakHewan, tebakBuah, tebakOrgan, tebakWarna, penjumlahan, pengurangan, hitungGabmar, tebakAngka);
        return storedScore;
    }

    public void setUserScore(Boolean scored){
        editor.putBoolean(IS_SCORE, scored);
        editor.commit();
    }

    public boolean getUserScored(){
        return userLocalDatabase.getBoolean(IS_SCORE, false);
    }

    public void clearUserScore(){
        editor.clear();
        editor.commit();
    }


}
