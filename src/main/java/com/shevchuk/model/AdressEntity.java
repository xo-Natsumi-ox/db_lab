package com.shevchuk.model;

public class AdressEntity {
    int id;
    String city_or_village;
    String street;

    public AdressEntity(int id, String city_or_village, String street) {
        this.id = id;
        this.city_or_village = city_or_village;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity_or_village() {
        return city_or_village;
    }

    public void setCity_or_village(String city_or_village) {
        this.city_or_village = city_or_village;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    @Override
    public String toString() {
        return "AdressEntity{" +
                "id=" + id +
                ", city_or_village='" + city_or_village + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
