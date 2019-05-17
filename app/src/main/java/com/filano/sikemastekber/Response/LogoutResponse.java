package com.filano.sikemastekber.Response;

import com.google.gson.annotations.SerializedName;

public class LogoutResponse {
    @SerializedName("status")
    String status;

    @SerializedName("data")
    String data;

    @SerializedName("message")
    String message;

    public LogoutResponse() {
    }

    public String getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
