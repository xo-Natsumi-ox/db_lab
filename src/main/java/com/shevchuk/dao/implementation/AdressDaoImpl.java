package com.shevchuk.dao.implementation;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.dao.AdressDao;
import com.shevchuk.model.AdressEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdressDaoImpl implements AdressDao {
    private static final String FIND_ALL = "SELECT * FROM adress";
    private static final String FIND_BY_ID = "SELECT * FROM adress WHERE id=?";
    private static final String CREATE = "INSERT adress (id,city_or_village,street) VALUES(?,?,?)";
    private static final String UPDATE = "UPDATE adress SET id=?,city_or_village=?,street=? WHERE id = ?";
    private static final String DELETE = "DELETE FROM adress WHERE id=?";

    /*    int id;
        String city_or_village;
        String street;
        int patient_id;*/
    @Override
    public List<AdressEntity> findAll() throws SQLException {
        List<AdressEntity> adresses = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String city_or_village = resultSet.getString(2);
                    String street = resultSet.getString(3);
                    adresses.add(new AdressEntity(id, city_or_village, street));
                }

            }

        }
        return adresses;
    }

    @Override
    public AdressEntity findById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        AdressEntity adressById = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String city_or_village = resultSet.getString(2);
                    String street = resultSet.getString(3);
                    adressById = new AdressEntity(id, city_or_village, street);
                }

            }

        }
        return adressById;
    }

    @Override
    public int create(AdressEntity adress) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setInt(1, adress.getId());
            preparedStatement.setString(2, adress.getCity_or_village());
            preparedStatement.setString(3, adress.getStreet());
            return preparedStatement.executeUpdate();
        }


    }

    @Override
    public int update(AdressEntity adress) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, adress.getId());
            preparedStatement.setString(2, adress.getCity_or_village());
            preparedStatement.setString(3, adress.getStreet());
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

