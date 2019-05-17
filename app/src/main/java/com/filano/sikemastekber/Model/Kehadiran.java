package com.filano.sikemastekber.Model;

import com.google.gson.annotations.SerializedName;

public class Kehadiran {
    @SerializedName("user_id")
    private Integer user_id;

    @SerializedName("kelas_active_id")
    private Integer kelas_active_id;

    @SerializedName("status")
    private Integer status;

    public Kehadiran(Integer user_id, Integer kelas_active_id, Integer status) {
        this.user_id = user_id;
        this.kelas_active_id = kelas_active_id;
        this.status = status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getKelas_active_id() {
        return kelas_active_id;
    }

    public void setKelas_active_id(Integer kelas_active_id) {
        this.kelas_active_id = kelas_active_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
