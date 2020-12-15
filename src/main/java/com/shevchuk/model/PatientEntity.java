package com.shevchuk.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "patient", schema = "db_shevchuk")
public class PatientEntity {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private HospitalEntity hospitalId;

    public PatientEntity(Integer id, String name, String surname, Integer age, HospitalEntity hospitalId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.hospitalId = hospitalId;
    }

    public PatientEntity() {

    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "id", nullable = false)
    public HospitalEntity getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(HospitalEntity hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientEntity that = (PatientEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(age, that.age) &&
                Objects.equals(hospitalId, that.hospitalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, hospitalId);
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", hospitalId=" + hospitalId.getId() +
                '}';
    }
}
