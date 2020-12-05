package com.shevchuk.dao.implementation;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.dao.HospitalDao;
import com.shevchuk.model.HospitalEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public final class HospitalDaoImpl implements HospitalDao {

    private static final String FIND_ALL = "SELECT * FROM hospital";
    private static final String FIND_BY_ID = "SELECT * FROM hospital WHERE id=?";
    private static final String CREATE = "INSERT hospital (id,name,number,adress_id) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE hospital SET name=?,number=?,adress_id=? WHERE id = ?";
    private static final String DELETE = "DELETE FROM hospital WHERE id=?";

    @Override
    public List<HospitalEntity> findAll() throws SQLException {
        List<HospitalEntity> hospitals = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int number = resultSet.getInt(3);
                    int adressId = resultSet.getInt(4);
                    hospitals.add(new HospitalEntity(id, name, number, adressId));
                }

            }

        }
        return hospitals;
    }

    @Override
    public HospitalEntity findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        HospitalEntity hospitalById = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString(2);
                    int number = resultSet.getInt(3);
                    int adressId = resultSet.getInt(4);
                    hospitalById = new HospitalEntity(id, name, number, adressId);
                }

            }

        }
        return hospitalById;
    }

    @Override
    public int create(HospitalEntity hospital) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setInt(1, hospital.getId());
            preparedStatement.setString(2, hospital.getName());
            preparedStatement.setInt(3, hospital.getNumber());
            preparedStatement.setInt(4, hospital.getAdressId());
            return preparedStatement.executeUpdate();
        }


    }

    @Override
    public int update(HospitalEntity hospital) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, hospital.getName());
            preparedStatement.setInt(2, hospital.getNumber());
            preparedStatement.setInt(3, hospital.getAdressId());
            preparedStatement.setInt(4, hospital.getId());
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
