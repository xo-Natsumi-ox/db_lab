package com.shevchuk.model;

public class HospitalEntity {
    int id;
    String name;
    int number;
    int adress_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAdress_id() {
        return adress_id;
    }

    public void setAdress_id(int adress_id) {
        this.adress_id = adress_id;
    }

    public HospitalEntity(int id, String name, int number, int adress_id) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.adress_id = adress_id;
    }

    @Override
    public String toString() {
        return "HospitalEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", adress_id=" + adress_id +
                '}';
    }
}
