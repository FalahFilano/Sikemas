package com.filano.sikemastekber.Response;

import com.filano.sikemastekber.Model.User;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("status")
    String status;

    @SerializedName("data")
    DataLogin data;

    @SerializedName("message")
    String message;

    public LoginResponse() {
    }

    public String getStatus() {
        return status;
    }

    public DataLogin getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public class DataLogin {
        @SerializedName("token_type")
        String token_type;

        @SerializedName("access_token")
        String token;

        @SerializedName("user")
        User user;

        public String getToken_type() {
            return token_type;
        }

        public String getToken() {
            return token;
        }

        public User getUser() {
            return user;
        }
    }
}
