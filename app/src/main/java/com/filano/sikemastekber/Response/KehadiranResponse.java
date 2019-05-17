package com.filano.sikemastekber.Response;

import com.filano.sikemastekber.Model.Kehadiran;
import com.google.gson.annotations.SerializedName;

public class KehadiranResponse {
    @SerializedName("status")
    String status;

    @SerializedName("data")
    Kehadiran kehadiran;

    @SerializedName("message")
    String message;

    public KehadiranResponse() {
    }

    public String getStatus() {
        return status;
    }

    public Kehadiran getKehadiran() {
        return kehadiran;
    }

    public String getMessage() {
        return message;
    }
}
