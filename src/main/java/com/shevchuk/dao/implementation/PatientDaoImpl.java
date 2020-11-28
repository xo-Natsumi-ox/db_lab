package com.shevchuk.dao.implementation;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.dao.PatientDao;
import com.shevchuk.model.PatientEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoImpl implements PatientDao {

    private static final String FIND_ALL = "SELECT * FROM patient";
    private static final String FIND_BY_ID = "SELECT * FROM patient WHERE id=?";
    private static final String CREATE = "INSERT patient (id,name,surname,age) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE patient SET id=?,name=?,surname=?,age=? WHERE id = ?";
    private static final String DELETE = "DELETE FROM patient WHERE id=?";

    /*        int id;
    String name;
    String surname;
    int age;*/
    @Override
    public List<PatientEntity> findAll() throws SQLException {
        List<PatientEntity> patients = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    int age = resultSet.getInt(4);
                    patients.add(new PatientEntity(id, name, surname, age));
                }

            }

        }
        return patients;
    }

    @Override
    public PatientEntity findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        PatientEntity patientById = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    int age = resultSet.getInt(4);
                    patientById = new PatientEntity(id, name, surname, age);
                }

            }

        }
        return patientById;
    }

    @Override
    public int create(PatientEntity patient) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setInt(1, patient.getId());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getSurname());
            preparedStatement.setInt(4, patient.getAge());
            return preparedStatement.executeUpdate();
        }


    }

    @Override
    public int update(PatientEntity patient) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, patient.getId());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getSurname());
            preparedStatement.setInt(4, patient.getAge());
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
