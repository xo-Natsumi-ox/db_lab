package com.shevchuk.dao.implementation;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.dao.DoctorDao;
import com.shevchuk.model.DoctorEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {

    private static final String FIND_ALL = "SELECT * FROM doctor";
    private static final String FIND_BY_ID = "SELECT * FROM doctor WHERE id=?";
    private static final String CREATE = "INSERT doctor (id,name,surname,hospital_id) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE doctor SET id=?,name=?,surname=?,hospital_id=? WHERE id = ?";
    private static final String DELETE = "DELETE FROM doctor WHERE id=?";

    //    int id;
//    String name;
//    String surname;
//    int hospital_id;
    @Override
    public List<DoctorEntity> findAll() throws SQLException {
        List<DoctorEntity> doctors = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    int hospital_id = resultSet.getInt(4);
                    doctors.add(new DoctorEntity(id, name, surname, hospital_id));
                }

            }

        }
        return doctors;
    }

    @Override
    public DoctorEntity findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        DoctorEntity doctorById = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    int hospital_id = resultSet.getInt(4);
                    doctorById = new DoctorEntity(id, name, surname, hospital_id);
                }

            }

        }
        return doctorById;
    }

    @Override
    public int create(DoctorEntity doctor) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setInt(1, doctor.getId());
            preparedStatement.setString(2, doctor.getName());
            preparedStatement.setString(3, doctor.getSurname());
            preparedStatement.setInt(4, doctor.getHospital_id());
            return preparedStatement.executeUpdate();
        }


    }

    @Override
    public int update(DoctorEntity doctor) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, doctor.getId());
            preparedStatement.setString(2, doctor.getName());
            preparedStatement.setString(3, doctor.getSurname());
            preparedStatement.setInt(4, doctor.getHospital_id());
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
