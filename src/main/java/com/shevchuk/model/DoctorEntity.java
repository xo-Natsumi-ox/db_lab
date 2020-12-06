package com.shevchuk.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "doctor", schema = "db_shevchuk")
public class DoctorEntity {
    private Integer id;
    private String name;
    private String surname;
    private HospitalEntity hospitalId;

    public DoctorEntity(Integer id, String name, String surname, HospitalEntity hospitalId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.hospitalId = hospitalId;
    }

    public DoctorEntity() {

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
        DoctorEntity that = (DoctorEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(hospitalId, that.hospitalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, hospitalId);
    }

    @Override
    public String toString() {
        return "\n" + "DoctorEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
