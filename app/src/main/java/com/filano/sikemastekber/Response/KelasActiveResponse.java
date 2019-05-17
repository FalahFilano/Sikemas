package com.filano.sikemastekber.Response;

import com.filano.sikemastekber.Model.KelasActive;
import com.google.gson.annotations.SerializedName;

public class KelasActiveResponse {
    @SerializedName("status")
    String status;

    @SerializedName("data")
    KelasActive kelas;

    @SerializedName("message")
    String errorMessage;

    public KelasActiveResponse() {
    }

    public String getStatus() {
        return status;
    }

    public KelasActive getKelas() {
        return kelas;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
