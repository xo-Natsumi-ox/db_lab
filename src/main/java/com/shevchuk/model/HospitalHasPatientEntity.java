package com.shevchuk.model;

public final class HospitalHasPatientEntity {
    private int id;
    private int patientId;
    private int hospitalId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public HospitalHasPatientEntity(int id, int patientId, int hospitalId) {
        this.id = id;
        this.patientId = patientId;
        this.hospitalId = hospitalId;
    }

    @Override
    public String toString() {
        return "HospitalHasPatient{"
                + "id=" + id
                + ", patient id=" + patientId
                + ", hospital id=" + hospitalId
                + '}';
    }
}
