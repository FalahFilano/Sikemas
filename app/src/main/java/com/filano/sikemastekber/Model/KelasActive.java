package com.filano.sikemastekber.Model;

import com.google.gson.annotations.SerializedName;

public class KelasActive {
    @SerializedName("kelas")
    private Kelas kelas;

    @SerializedName("jadwal")
    private Jadwal jadwal;

    @SerializedName("ruangan")
    private Ruangan ruangan;

    @SerializedName("status")
    private String status;

    @SerializedName("pertemuan")
    private Integer pertemuan;

    public KelasActive() {
    }

    public KelasActive(Kelas kelas, Jadwal jadwal, Ruangan ruangan, String status, Integer pertemuan) {
        this.kelas = kelas;
        this.jadwal = jadwal;
        this.ruangan = ruangan;
        this.status = status;
        this.pertemuan = pertemuan;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPertemuan() {
        return pertemuan;
    }

    public void setPertemuan(Integer pertemuan) {
        this.pertemuan = pertemuan;
    }
}
