package com.example.kindersmart.Activity.Model;

public class SoalTebakGambar {
    private int     idSoal;
    private int     soal_ke;
    private String  url_soal;
    private String  kunci_jawaban;

    public SoalTebakGambar(int idSoal, int soal_ke, String url_soal, String kunci_jawaban) {
        this.idSoal         = idSoal;
        this.soal_ke        = soal_ke;
        this.url_soal       = url_soal;
        this.kunci_jawaban  = kunci_jawaban;
    }

    public int getIdSoal() {
        return idSoal;
    }

    public void setIdSoal(int idSoal) {
        this.idSoal = idSoal;
    }

    public int getSoal_ke() {
        return soal_ke;
    }

    public void setSoal_ke(int soal_ke) {
        this.soal_ke = soal_ke;
    }

    public String getUrl_soal() {
        return url_soal;
    }

    public void setUrl_soal(String url_soal) {
        this.url_soal = url_soal;
    }

    public String getKunci_jawaban() {
        return kunci_jawaban;
    }

    public void setKunci_jawaban(String kunci_jawaban) {
        this.kunci_jawaban = kunci_jawaban;
    }
}
