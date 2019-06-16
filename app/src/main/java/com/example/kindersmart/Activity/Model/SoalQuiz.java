package com.example.kindersmart.Activity.Model;

public class SoalQuiz {
    private int     idSoal;
    private int     soal_ke;
    private String  url_soal;
    private String  kunci_jawaban;
    private String  pilihan_jawaban1;
    private String  pilihan_jawaban2;
    private String  pilihan_jawaban3;
    private String  pilihan_jawaban4;
    private String  soal;

    public SoalQuiz(int idSoal, int soal_ke, String url_soal, String kunci_jawaban,
                    String pilihan_jawaban1, String pilihan_jawaban2, String pilihan_jawaban3, String pilihan_jawaban4, String soal) {
        this.idSoal             = idSoal;
        this.soal_ke            = soal_ke;
        this.url_soal           = url_soal;
        this.kunci_jawaban      = kunci_jawaban;
        this.pilihan_jawaban1   = pilihan_jawaban1;
        this.pilihan_jawaban2   = pilihan_jawaban2;
        this.pilihan_jawaban3   = pilihan_jawaban3;
        this.pilihan_jawaban4   = pilihan_jawaban4;
        this.soal               = soal;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getPilihan_jawaban1() {
        return pilihan_jawaban1;
    }

    public void setPilihan_jawaban1(String pilihan_jawaban1) {
        this.pilihan_jawaban1 = pilihan_jawaban1;
    }

    public String getPilihan_jawaban2() {
        return pilihan_jawaban2;
    }

    public void setPilihan_jawaban2(String pilihan_jawaban2) {
        this.pilihan_jawaban2 = pilihan_jawaban2;
    }

    public String getPilihan_jawaban3() {
        return pilihan_jawaban3;
    }

    public void setPilihan_jawaban3(String pilihan_jawaban3) {
        this.pilihan_jawaban3 = pilihan_jawaban3;
    }

    public String getPilihan_jawaban4() {
        return pilihan_jawaban4;
    }

    public void setPilihan_jawaban4(String pilihan_jawaban4) {
        this.pilihan_jawaban4 = pilihan_jawaban4;
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
