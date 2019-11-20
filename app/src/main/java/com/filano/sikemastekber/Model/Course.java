package com.filano.sikemastekber.Model;

public class Course {
    private String courseName;
    private String jam;
    private String ruang;
    private String agenda;
    private int btnStatus;
    private String btnLabel;

    public Course(String courseName, String jam, String ruang, String agenda, int btnStatus, String btnLabel) {
        this.courseName = courseName;
        this.jam = jam;
        this.ruang = ruang;
        this.agenda = agenda;
        this.btnStatus = btnStatus;
        this.btnLabel = btnLabel;
    }

    public String getBtnLabel() {
        return btnLabel;
    }

    public void setBtnLabel(String btnLabel) {
        this.btnLabel = btnLabel;
    }

    public int getBtnStatus() {
        return btnStatus;
    }

    public void setBtnStatus(int btnStatus) {
        this.btnStatus = btnStatus;
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


}
