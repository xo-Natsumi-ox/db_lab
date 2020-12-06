package com.shevchuk.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "shedule", schema = "db_shevchuk")
public class SheduleEntity {
    private Integer id;
    private Integer data;
    private String time;
    private String additionalInfo;
    private DoctorEntity doctorId;

    public SheduleEntity(Integer id, Integer data, String time, String additionalInfo, DoctorEntity doctorId) {
        this.id = id;
        this.data = data;
        this.time = time;
        this.additionalInfo = additionalInfo;
        this.doctorId = doctorId;
    }

    public SheduleEntity() {

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
    @Column(name = "data")
    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "additional_info")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    public DoctorEntity getDoctorId(DoctorEntity sheDoctor) {
        return doctorId;
    }

    public void setDoctorId(DoctorEntity doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SheduleEntity that = (SheduleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(data, that.data) &&
                Objects.equals(time, that.time) &&
                Objects.equals(additionalInfo, that.additionalInfo) &&
                Objects.equals(doctorId, that.doctorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, time, additionalInfo, doctorId);
    }

    @Override
    public String toString() {
        return "\n" + "SheduleEntity{" +
                "id=" + id +
                ", data=" + data +
                ", time='" + time + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
