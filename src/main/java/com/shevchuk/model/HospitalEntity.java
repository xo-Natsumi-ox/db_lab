package com.shevchuk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Basic;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.util.Objects;

@Entity
@Table(name = "hospital", schema = "db_shevchuk")
public class HospitalEntity {
    private Integer id;
    private String name;
    private Integer number;
    private AdressEntity adresslId;

    public HospitalEntity(String name, Integer number, AdressEntity adresslId) {
        this.name = name;
        this.number = number;
        this.adresslId = adresslId;
    }

    public HospitalEntity() {

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @ManyToOne
    @JoinColumn(name = "adress_id", referencedColumnName = "id",
            nullable = false)
    public AdressEntity getAdressId() {
        return adresslId;
    }

    public void setAdressId(AdressEntity adresslId) {
        this.adresslId = adresslId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HospitalEntity that = (HospitalEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(number, that.number)
                && Objects.equals(adresslId, that.adresslId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number, adresslId);
    }

    @Override
    public String toString() {
        return "\nHospitalEntity{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", number=" + number
                + ", adresslId=" + adresslId.getId()
                + '}';
    }
}
