package com.shevchuk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Adress")
@Table(name = "adress", schema = "lab6db")
public class Adress implements GeneralEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @Column(name = "city_or_village")
  private String cityOrVillage;
  @Column(name = "street")
  private String street;

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Adress adress = (Adress) o;

    if (id != null ? !id.equals(adress.id) : adress.id != null) {
      return false;
    }
    if (cityOrVillage != null ? !cityOrVillage.equals(adress.cityOrVillage)
            : adress.cityOrVillage != null) {
      return false;
    }
    if (street != null ? !street.equals(adress.street) : adress.street != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (cityOrVillage != null ? cityOrVillage.hashCode() : 0);
    result = 31 * result + (street != null ? street.hashCode() : 0);
    return result;
  }

  public Adress(Integer id, String cityOrVillage, String street) {
    this.id = id;
    this.cityOrVillage = cityOrVillage;
    this.street = street;
  }

  public Adress(String cityOrVillage, String street) {
    this.cityOrVillage = cityOrVillage;
    this.street = street;
  }

  public Adress() {
  }

  @Override
  public String toString() {
    return "Adress{"
            + "id=" + id
            + ", cityOrVillage='" + cityOrVillage + '\''
            + ", street='" + street + '\''
            + '}';
  }
}
