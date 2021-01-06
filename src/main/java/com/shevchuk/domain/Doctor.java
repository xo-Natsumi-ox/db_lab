package com.shevchuk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Doctor")
@Table(name = "doctor", schema = "lab6db")
public class Doctor implements GeneralEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @ManyToOne
  @JoinColumn(name = "hospital_id", referencedColumnName = "id", nullable = false)
  private Hospital hospitalId;

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

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Hospital getHospitalId() {
    return hospitalId;
  }

  public void setHospitalId(Hospital hospitalId) {
    this.hospitalId = hospitalId;
  }

  public Doctor(Integer id, String name, String surname, Hospital hospitalId) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.hospitalId = hospitalId;
  }

  public Doctor(String name, String surname, Hospital hospitalId) {
    this.name = name;
    this.surname = surname;
    this.hospitalId = hospitalId;
  }

  public Doctor() {
  }

  @Override
  public String toString() {
    return "Doctor{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", surname='" + surname + '\''
            + ", hospitalId=" + hospitalId
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

    Doctor doctor = (Doctor) o;

    if (id != null ? !id.equals(doctor.id) : doctor.id != null) {
      return false;
    }
    if (name != null ? !name.equals(doctor.name) : doctor.name != null) {
      return false;
    }
    if (surname != null ? !surname.equals(doctor.surname) : doctor.surname != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    return result;
  }
}
