package com.filano.sikemastekber.Model;

import com.google.gson.annotations.SerializedName;

public class Jadwal {
    @SerializedName("hari")
    private String hari;

    @SerializedName("jam_mulai")
    private String jam_mulai;

    @SerializedName("jam_selesai")
    private String jam_selesai;

    public Jadwal(String hari, String jam_mulai, String jam_selesai) {
        this.hari = hari;
        this.jam_mulai = jam_mulai;
        this.jam_selesai = jam_selesai;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(String jam_mulai) {
        this.jam_mulai = jam_mulai;
    }

    public String getJam_selesai() {
        return jam_selesai;
    }

    public void setJam_selesai(String jam_selesai) {
        this.jam_selesai = jam_selesai;
    }
}
