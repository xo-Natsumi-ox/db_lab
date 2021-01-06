package com.shevchuk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Hospital")
@Table(name = "hospital", schema = "lab6db")
public class Hospital implements GeneralEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "number")
  private Integer number;

  @ManyToOne
  @JoinColumn(name = "adress_id", referencedColumnName = "id", nullable = false)
  private Adress adressId;

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Adress getAdressId() {
    return adressId;
  }

  public void setAdressId(Adress adressId) {
    this.adressId = adressId;
  }

  public Hospital(Integer id, String name, Integer number, Adress adressId) {
    this.id = id;
    this.name = name;
    this.number = number;
    this.adressId = adressId;
  }

  public Hospital(String name, Integer number, Adress adressId) {
    this.name = name;
    this.number = number;
    this.adressId = adressId;
  }

  public Hospital() {
  }

  @Override
  public String toString() {
    return "Hospital{"
            + "id=" + id
            + ", name=" + name
            + ", number=" + number
            + ", adressId=" + adressId
            + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Hospital hospital = (Hospital) o;

    if (id != null ? !id.equals(hospital.id) : hospital.id != null) {
      return false;
    }
    if (name != null ? !name.equals(hospital.name) : hospital.name != null) {
      return false;
    }
    if (number != null ? !number.equals(hospital.number) : hospital.number != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (number != null ? number.hashCode() : 0);
    return result;
  }
}
