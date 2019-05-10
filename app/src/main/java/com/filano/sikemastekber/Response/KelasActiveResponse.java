package com.filano.sikemastekber.Response;

import com.filano.sikemastekber.Model.Kelas;
import com.filano.sikemastekber.Model.KelasActive;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class KelasActiveResponse {

    @SerializedName("status")
    String status;

    @SerializedName("data")
    ArrayList<KelasActive> listKelas;

    @SerializedName("message")
    String errorMessage;

    public KelasActiveResponse() {
    }

    public KelasActiveResponse(String status, ArrayList<KelasActive> listKelas, String errorMessage) {
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

    public ArrayList<KelasActive> getListKelas() {
        return listKelas;
    }

    public void setListKelas(ArrayList<KelasActive> listKelas) {
        this.listKelas = listKelas;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
