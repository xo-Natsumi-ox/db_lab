package com.shevchuk.model;

public final class AdressEntity {
    private int id;
    private String cityOrVillage;
    private String street;

    public AdressEntity(int id, String cityOrVillage, String street) {
        this.id = id;
        this.cityOrVillage = cityOrVillage;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityOrVillage() {
        return cityOrVillage;
    }

    public void setCityOrVillage(String cityOrVillage) {
        this.cityOrVillage = cityOrVillage;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    @Override
    public String toString() {
        return "Adress{"
                + "id=" + id
                + ", city or village='" + cityOrVillage + '\''
                + ", street='" + street + '\''
                + '}';
    }
}
