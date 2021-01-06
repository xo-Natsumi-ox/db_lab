package com.shevchuk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Patient")
@Table(name = "patient", schema = "lab6db")
public class Patient implements GeneralEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;
  @Column(name = "age")
  private Integer age;

  @ManyToOne
  @JoinColumn(name = "hospital_id", referencedColumnName = "id", nullable = false)
  private Hospital hospitalId;

  public Patient() {

  }

  public Patient(Integer id, String name, String surname, Integer age, Hospital hospitalId) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.hospitalId = hospitalId;
  }

  public Patient(String name, String surname, Integer age, Hospital hospitalId) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.hospitalId = hospitalId;
  }

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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Hospital getHospitalId() {
    return hospitalId;
  }

  public void setHospitalId(Hospital hospitalId) {
    this.hospitalId = hospitalId;
  }

  @Override
  public String toString() {
    return "Patient{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", surname='" + surname + '\''
            + ", age=" + age
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

    Patient patient = (Patient) o;

    if (id != null ? !id.equals(patient.id) : patient.id != null) {
      return false;
    }
    if (name != null ? !name.equals(patient.name) : patient.name != null) {
      return false;
    }
    if (surname != null ? !surname.equals(patient.surname) : patient.surname != null) {
      return false;
    }
    if (age != null ? !age.equals(patient.age) : patient.age != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + (age != null ? age.hashCode() : 0);
    return result;
  }
}
