package com.filano.sikemastekber.Model;

public class Present {
    private String date;
    private int pertemuan;
    private int statusKehadiran;

    public Present(String date, int pertemuan, int statusKehadiran) {
        this.date = date;
        this.pertemuan = pertemuan;
        this.statusKehadiran = statusKehadiran;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPertemuan() {
        return pertemuan;
    }

    public void setPertemuan(int pertemuan) {
        this.pertemuan = pertemuan;
    }

    public int getStatusKehadiran() {
        return statusKehadiran;
    }

    public void setStatusKehadiran(int statusKehadiran) {
        this.statusKehadiran = statusKehadiran;
    }
}
