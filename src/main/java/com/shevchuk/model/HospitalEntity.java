package com.shevchuk.model;

public final class HospitalEntity {
    private int id;
    private String name;
    private int number;
    private int adressId;

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

    public int getAdressId() {
        return adressId;
    }

    public void setAdressId(int adressId) {
        this.adressId = adressId;
    }

    public HospitalEntity(int id, String name, int number, int adressId) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.adressId = adressId;
    }

    @Override
    public String toString() {
        return "Hospital{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", number=" + number
                + ", adress id=" + adressId
                + '}';
    }
}
