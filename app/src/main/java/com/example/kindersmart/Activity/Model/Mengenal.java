package com.example.kindersmart.Activity.Model;

public class Mengenal {
    private int     kenalId;
    private int     kenalKe;
    private String  namaKenal;
    private String  gambarKenal;
    private String  suaraKenal;

    public Mengenal(int kenalId, int kenalKe, String namaKenal, String gambarKenal, String suaraKenal) {
        this.kenalId = kenalId;
        this.kenalKe = kenalKe;
        this.namaKenal = namaKenal;
        this.gambarKenal = gambarKenal;
        this.suaraKenal = suaraKenal;
    }

    public int getKenalId() {
        return kenalId;
    }

    public void setKenalId(int kenalId) {
        this.kenalId = kenalId;
    }

    public int getKenalKe() {
        return kenalKe;
    }

    public void setKenalKe(int kenalKe) {
        this.kenalKe = kenalKe;
    }

    public String getNamaKenal() {
        return namaKenal;
    }

    public void setNamaKenal(String namaKenal) {
        this.namaKenal = namaKenal;
    }

    public String getGambarKenal() {
        return gambarKenal;
    }

    public void setGambarKenal(String gambarKenal) {
        this.gambarKenal = gambarKenal;
    }

    public String getSuaraKenal() {
        return suaraKenal;
    }

    public void setSuaraKenal(String suaraKenal) {
        this.suaraKenal = suaraKenal;
    }
}
