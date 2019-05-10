package com.filano.sikemastekber.Model;

import com.google.gson.annotations.SerializedName;

public class Dosen {
    @SerializedName("no_identitas")
    private String nip;

    @SerializedName("nama")
    private String nama;

    public Dosen(String nip, String nama) {
        this.nip = nip;
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
