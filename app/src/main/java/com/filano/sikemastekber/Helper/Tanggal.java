package com.filano.sikemastekber.Helper;

import java.util.Calendar;

public class Tanggal {
    private static Calendar calendar;

    public Tanggal() {
    }

    public static String getDate() {
        if (calendar == null) {
            calendar = Calendar.getInstance();
        }

        String hari = getHari(calendar.get(Calendar.DAY_OF_WEEK));
        String tanggal = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String bulan = getBulan(calendar.get(Calendar.MONTH));

        return hari + ", " + tanggal + " " + bulan;
    }

    public static String hari() {
        if (calendar == null) {
            calendar = Calendar.getInstance();
        }

        return getHari(calendar.get(Calendar.DAY_OF_WEEK));
    }

    private static String getBulan(int month) {
        String bulan;

        switch (month) {
            case Calendar.JANUARY:
                bulan = "Januari";
                break;
            case Calendar.FEBRUARY:
                bulan = "Februari";
                break;
            case Calendar.MARCH:
                bulan = "Maret";
                break;
            case Calendar.APRIL:
                bulan = "April";
                break;
            case Calendar.MAY:
                bulan = "Mei";
                break;
            case Calendar.JUNE:
                bulan = "Juni";
                break;
            case Calendar.JULY:
                bulan = "Juli";
                break;
            case Calendar.AUGUST:
                bulan = "Agustus";
                break;
            case Calendar.SEPTEMBER:
                bulan = "September";
                break;
            case Calendar.OCTOBER:
                bulan = "Oktober";
                break;
            case Calendar.NOVEMBER:
                bulan = "Nopember";
                break;
            case Calendar.DECEMBER:
                bulan = "Desember";
                break;
            default:
                bulan = "Januari";
        }

        return bulan;
    }

    private static String getHari(int day) {
        String hari;

        switch (day) {
            case Calendar.SUNDAY:
                hari = "Minggu";
                break;
            case Calendar.MONDAY:
                hari = "Senin";
                break;
            case Calendar.TUESDAY:
                hari = "Selasa";
                break;
            case Calendar.WEDNESDAY:
                hari = "Rabu";
                break;
            case Calendar.THURSDAY:
                hari = "Kamis";
                break;
            case Calendar.FRIDAY:
                hari = "Jumat";
                break;
            case Calendar.SATURDAY:
                hari = "Sabtu";
                break;
            default:
                hari = "Senin";
        }

        return hari;
    }
}
