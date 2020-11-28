package com.shevchuk.model;

public class DoctorEntity {
    int id;
    String name;
    String surname;
    int hospital_id;

    public DoctorEntity(int id, String name, String surname, int hospital_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.hospital_id = hospital_id;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    @Override
    public String toString() {
        return "DoctorEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", hospital_id=" + hospital_id +
                '}';
    }
}
