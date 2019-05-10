package com.filano.sikemastekber.Model;

public class Ruangan {
    private String nama;
    private String bluetooth;

    public Ruangan(String nama, String bluetooth) {
        this.nama = nama;
        this.bluetooth = bluetooth;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }
}
