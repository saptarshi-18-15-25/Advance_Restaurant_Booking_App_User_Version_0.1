package com.example.restro;

public class Booking {
    String DATE,TIME,TABLE,PHONE,NAME;

    public Booking() {
    }

    public Booking(String DATE, String TIME, String TABLE, String PHONE, String NAME) {
        this.DATE = DATE;
        this.TIME = TIME;
        this.TABLE = TABLE;
        this.PHONE = PHONE;
        this.NAME = NAME;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public String getTABLE() {
        return TABLE;
    }

    public void setTABLE(String TABLE) {
        this.TABLE = TABLE;
    }
}
