package com.filano.sikemastekber.Model;

public class Course {
    private String courseName;
    private String jam;
    private String ruang;
    private String agenda;
    private int pertemuan;

    public Course(String courseName, String jam, String ruang, String agenda, int pertemuan) {
        this.courseName = courseName;
        this.jam = jam;
        this.ruang = ruang;
        this.agenda = agenda;
        this.pertemuan = pertemuan;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public int getPertemuan() {
        return pertemuan;
    }

    public void setPertemuan(int pertemuan) {
        this.pertemuan = pertemuan;
    }
}
