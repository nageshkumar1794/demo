package com.example.demo.port;

public class Line {
private String name;
private String city;
private String phoneNum;

    public Line(String name, String city, String phoneNum) {
        this.name = name;
        this.city = city;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Line{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
