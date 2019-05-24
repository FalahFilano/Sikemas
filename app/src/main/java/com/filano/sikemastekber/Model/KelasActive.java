package com.filano.sikemastekber.Model;

import com.google.gson.annotations.SerializedName;

public class KelasActive {
    public static final Integer BELUM_ABSEN = 0;
    public static final Integer SUDAH_ABSEN = 1;

    @SerializedName("id")
    private Integer id;

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

    @SerializedName("status_absen")
    private Integer status_absen;

    @SerializedName("created_at")
    private String created_at;

    public KelasActive() {
    }

    public KelasActive(Kelas kelas, Jadwal jadwal, Ruangan ruangan, String status, Integer pertemuan) {
        this.kelas = kelas;
        this.jadwal = jadwal;
        this.ruangan = ruangan;
        this.status = status;
        this.pertemuan = pertemuan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStatus_absen() {
        return status_absen;
    }

    public void setStatus_absen(Integer status_absen) {
        this.status_absen = status_absen;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
