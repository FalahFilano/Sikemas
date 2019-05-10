package com.filano.sikemastekber.Response;

import com.filano.sikemastekber.Model.Kelas;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class KelasResponse {
    @SerializedName("status")
    String status;

    @SerializedName("data")
    ArrayList<Kelas> listKelas;

    @SerializedName("message")
    String errorMessage;

    public KelasResponse() {
    }

    public KelasResponse(String status, ArrayList<Kelas> listKelas, String errorMessage) {
        this.status = status;
        this.listKelas = listKelas;
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Kelas> getListKelas() {
        return listKelas;
    }

    public void setListKelas(ArrayList<Kelas> listKelas) {
        this.listKelas = listKelas;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
