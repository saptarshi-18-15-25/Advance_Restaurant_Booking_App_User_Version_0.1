package com.example.restro;

public class User {
    String Name,Phone,Password;
    double Point,Offer;

    public User() {
    }

    public User(String name, String phone, String password, double point, double offer) {
        Name = name;
        Phone = phone;
        Password = password;
        Point = point;
        Offer = offer;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public double getPoint() {
        return Point;
    }

    public void setPoint(double point) {
        Point = point;
    }

    public double getOffer() {
        return Offer;
    }

    public void setOffer(double offer) {
        Offer = offer;
    }
}
