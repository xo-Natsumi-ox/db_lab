package com.shevchuk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Basic;
import java.util.Objects;

@Entity
@Table(name = "adress", schema = "db_shevchuk")
public class AdressEntity {
    private Integer id;
    private String cityOrVillage;
    private String street;

    public AdressEntity(String cityOrVillage, String street) {
        this.cityOrVillage = cityOrVillage;
        this.street = street;
    }

    public AdressEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city_or_village")
    public String getCityOrVillage() {
        return cityOrVillage;
    }

    public void setCityOrVillage(String cityOrVillage) {
        this.cityOrVillage = cityOrVillage;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdressEntity that = (AdressEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(cityOrVillage, that.cityOrVillage)
                && Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityOrVillage, street);
    }

    @Override
    public String toString() {
        return "\nAdressEntity{"
                + "id=" + id
                + ", cityOrVillage='" + cityOrVillage
                + ", street='" + street
                + '}';
    }
}
