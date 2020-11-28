package com.shevchuk.dao.implementation;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.dao.HospitalHasPatientDao;
import com.shevchuk.model.HospitalHasPatientEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalHasPatientDaoImpl implements HospitalHasPatientDao {

    private static final String FIND_ALL = "SELECT * FROM hospital_has_patient";
    private static final String FIND_BY_ID = "SELECT * FROM hospital_has_patient WHERE id=?";
    private static final String CREATE = "INSERT hospital_has_patient (id,hospital_id,patient_id) VALUES(?,?,?)";
    private static final String UPDATE = "UPDATE hospital_has_patient SET id=?,hospital_id=?,patient_id=? WHERE id = ?";
    private static final String DELETE = "DELETE FROM hospital_has_patient WHERE id=?";

    /*        int id;
    int hospital_id;
    int patient_id;*/
    @Override
    public List<HospitalHasPatientEntity> findAll() throws SQLException {
        List<HospitalHasPatientEntity> hospitaldAndPatients = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    int hospital_id = resultSet.getInt(2);
                    int patient_id = resultSet.getInt(3);
                    hospitaldAndPatients.add(new HospitalHasPatientEntity(id, hospital_id, patient_id));
                }
            }
        }
        return hospitaldAndPatients;
    }

    @Override
    public HospitalHasPatientEntity findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        HospitalHasPatientEntity hospitaldAndPatientById = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int hospital_id = resultSet.getInt(2);
                    int patient_id = resultSet.getInt(3);
                    hospitaldAndPatientById = new HospitalHasPatientEntity(id, hospital_id, patient_id);
                }

            }

        }
        return hospitaldAndPatientById;
    }

    @Override
    public int create(HospitalHasPatientEntity hospitaldAndPatient) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setInt(1, hospitaldAndPatient.getId());
            preparedStatement.setInt(2, hospitaldAndPatient.getHospitalId());
            preparedStatement.setInt(3, hospitaldAndPatient.getPatientId());
            return preparedStatement.executeUpdate();
        }


    }

    @Override
    public int update(HospitalHasPatientEntity hospitaldAndPatient) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, hospitaldAndPatient.getId());
            preparedStatement.setInt(2, hospitaldAndPatient.getHospitalId());
            preparedStatement.setInt(3, hospitaldAndPatient.getPatientId());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();

        }

    }
}
