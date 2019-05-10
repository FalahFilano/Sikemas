package com.filano.sikemastekber.Model;

import com.google.gson.annotations.SerializedName;

public class Kelas {
    @SerializedName("nama")
    private String nama;

    @SerializedName("mata_kuliah")
    private MataKuliah mataKuliah;

    @SerializedName("dosen")
    private Dosen dosen;

    @SerializedName("jadwal")
    private Jadwal jadwal;

    @SerializedName("ruangan")
    private Ruangan ruangan;

    public Kelas(String nama, MataKuliah mataKuliah, Dosen dosen, Jadwal jadwal, Ruangan ruangan) {
        this.nama = nama;
        this.mataKuliah = mataKuliah;
        this.dosen = dosen;
        this.jadwal = jadwal;
        this.ruangan = ruangan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public Jadwal getJadwal() {
        return jadwal;
    }

    public void setJadwal(Jadwal jadwal) {
        this.jadwal = jadwal;
    }

    public Ruangan getRuangan() {
        return ruangan;
    }

    public void setRuangan(Ruangan ruangan) {
        this.ruangan = ruangan;
    }
}
