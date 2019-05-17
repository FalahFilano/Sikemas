package com.filano.sikemastekber.Model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("no_identitas")
    private String no_identitas;

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    public User(String no_identitas, String name, String type) {
        this.no_identitas = no_identitas;
        this.name = name;
        this.type = type;
    }

    public String getNo_identitas() {
        return no_identitas;
    }

    public void setNo_identitas(String no_identitas) {
        this.no_identitas = no_identitas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
