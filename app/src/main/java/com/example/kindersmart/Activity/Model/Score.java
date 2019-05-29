package com.example.kindersmart.Activity.Model;

public class Score {
    public int tebakHewanScore;
    public int tebakBuahScore;
    public int tebakOrganScore;
    public int tebakWarnaScore;
    public int penjumlahanScore;
    public int penguranganScore;
    public int hitungGambarScore;
    public int tebakAngkaScore;

    public int getTebakHewanScore() {
        return tebakHewanScore;
    }

    public void setTebakHewanScore(int tebakHewanScore) {
        this.tebakHewanScore = tebakHewanScore;
    }

    public int getTebakBuahScore() {
        return tebakBuahScore;
    }

    public void setTebakBuahScore(int tebakBuahScore) {
        this.tebakBuahScore = tebakBuahScore;
    }

    public int getTebakOrganScore() {
        return tebakOrganScore;
    }

    public void setTebakOrganScore(int tebakOrganScore) {
        this.tebakOrganScore = tebakOrganScore;
    }

    public int getTebakWarnaScore() {
        return tebakWarnaScore;
    }

    public void setTebakWarnaScore(int tebakWarnaScore) {
        this.tebakWarnaScore = tebakWarnaScore;
    }

    public int getPenjumlahanScore() {
        return penjumlahanScore;
    }

    public void setPenjumlahanScore(int penjumlahanScore) {
        this.penjumlahanScore = penjumlahanScore;
    }

    public int getPenguranganScore() {
        return penguranganScore;
    }

    public void setPenguranganScore(int penguranganScore) {
        this.penguranganScore = penguranganScore;
    }

    public int getHitungGambarScore() {
        return hitungGambarScore;
    }

    public void setHitungGambarScore(int hitungGambarScore) {
        this.hitungGambarScore = hitungGambarScore;
    }

    public int getTebakAngkaScore() {
        return tebakAngkaScore;
    }

    public void setTebakAngkaScore(int tebakAngkaScore) {
        this.tebakAngkaScore = tebakAngkaScore;
    }

    public Score(int tebakHewanScore, int tebakBuahScore, int tebakOrganScore, int tebakWarnaScore,
                 int penjumlahanScore, int penguranganScore, int hitungGambarScore, int tebakAngkaScore) {
        this.tebakHewanScore = tebakHewanScore;
        this.tebakBuahScore = tebakBuahScore;
        this.tebakOrganScore = tebakOrganScore;
        this.tebakWarnaScore = tebakWarnaScore;
        this.penjumlahanScore = penjumlahanScore;
        this.penguranganScore = penguranganScore;
        this.hitungGambarScore = hitungGambarScore;
        this.tebakAngkaScore = tebakAngkaScore;
    }


}