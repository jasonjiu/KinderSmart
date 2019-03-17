package com.example.kindersmart.Activity.Model;

public class JawabanTebakGambar {
    private int     idSoal;
    private int     soal_ke;
    private String  pilihan;

    public JawabanTebakGambar(int idSoal, int soal_ke, String pilihan) {
        this.idSoal     = idSoal;
        this.soal_ke    = soal_ke;
        this.pilihan    = pilihan;
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

    public String getPilihan() {
        return pilihan;
    }

    public void setPilihan(String pilihan) {
        this.pilihan = pilihan;
    }
}
