package com.shevchuk.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tracker", schema = "db_shevchuk")
public class TrackerEntity {
    private Integer id;
    private Integer pressure;
    private Double temperature;
    private Integer palpitation;
    private String diagnos;
    private PatientEntity patientId;

    public TrackerEntity(Integer id, Integer pressure, Double temperature, Integer palpitation, String diagnos, PatientEntity patientId) {
        this.id = id;
        this.pressure = pressure;
        this.temperature = temperature;
        this.palpitation = palpitation;
        this.diagnos = diagnos;
        this.patientId = patientId;
    }

    public TrackerEntity() {

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
    @Column(name = "pressure")
    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    @Basic
    @Column(name = "temperature")
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "palpitation")
    public Integer getPalpitation() {
        return palpitation;
    }

    public void setPalpitation(Integer palpitation) {
        this.palpitation = palpitation;
    }

    @Basic
    @Column(name = "diagnos")
    public String getDiagnos() {
        return diagnos;
    }

    public void setDiagnos(String diagnos) {
        this.diagnos = diagnos;
    }

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    public PatientEntity getPatientId() {
        return patientId;
    }

    public void setPatientId(PatientEntity patientId) {
        this.patientId = patientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackerEntity that = (TrackerEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(pressure, that.pressure) &&
                Objects.equals(temperature, that.temperature) &&
                Objects.equals(palpitation, that.palpitation) &&
                Objects.equals(diagnos, that.diagnos) &&
                Objects.equals(patientId, that.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pressure, temperature, palpitation, diagnos, patientId);
    }

    @Override
    public String toString() {
        return "\n" + "TrackerEntity{" +
                "id=" + id +
                ", pressure=" + pressure +
                ", temperature=" + temperature +
                ", palpitation=" + palpitation +
                ", diagnos='" + diagnos + '\'' +
                '}';
    }
}
