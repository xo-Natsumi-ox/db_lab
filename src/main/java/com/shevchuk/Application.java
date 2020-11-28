/*
package shevchuk;

import java.sql.*;
import java.util.Scanner;

public class Application {
    private static final String url = "jdbc:mysql://localhost:3306/db_shevchuk_connection?serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "qwerty";
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//reflekcia po ciy strichci zagruzhen driver
            connection = DriverManager.getConnection(url, user, password);//get connection to db
            statement = connection.createStatement();

            readData();
            //updateDoctorName();
            //insertPatient();
            //deletePatient();

        } catch (ClassNotFoundException e) {
            System.out.println("driver isnt loaded");
        } catch (SQLException exception) {
            System.out.println("SQLException " + exception.getMessage());
            System.out.println("SQLState " + exception.getSQLState());
            System.out.println("VendorError " + exception.getErrorCode());
        } catch (Exception e) {
            System.out.println("Something wrong with update doctor name ");
        } finally {
            //close connection statement resultSet v zvorotnyomu poryadku
            if (resultSet != null) try {
                resultSet.close();
            } catch (SQLException exception) {
                System.out.println("cant close resultSet");
            }
            if (statement != null) try {
                statement.close();
            } catch (SQLException exception) {
                System.out.println("cant close statement");
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException exception) {
                System.out.println("cant close connection");
            }
        }
    }
    private static void readData()throws Exception{
        //vyvodymo all table
        //count rows patient
        resultSet=statement.executeQuery("select count(*) from patient");
        while (resultSet.next()){
            int count = resultSet.getInt(1);
            System.out.format("\ncount patient rows: %d\n",count);
        }
        // ********** Patient **********
        //executing select
        resultSet = statement.executeQuery("select * from patient");
        //proccess the result set
        System.out.format("\n ----- Patient table ----- \n");
        System.out.format("%3s | %-10s | %-15s | %-3s | %-25s | %-7s \n", "id", "name", "surname", "age", "email", "phone");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            int age = resultSet.getInt("age");
            String email = resultSet.getString("email");
            int phone = resultSet.getInt("phone");
            System.out.format("%3d | %-10s | %-15s | %-3d | %-25s | %-7d \n", id, name, surname, age, email, phone);
        }

        // ********** Adress **********
        resultSet = statement.executeQuery("select * from adress");
        System.out.format("\n ----- Adress table ----- \n");
        System.out.format("%3s | %-10s | %-10s | %-15s | %-20s | %-4s | %-3s \n", "id", "region", "district", "city_or_village", "street", "house_number", "patient_id");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String region = resultSet.getString("region");
            String district = resultSet.getString("district");
            String city_or_village = resultSet.getString("city_or_village");
            String street = resultSet.getString("street");
            String house_number = resultSet.getString("house_number");
            int patient_id = resultSet.getInt("patient_id");
            System.out.format("%3d | %-10s | %-10s | %-15s | %-20s | %-4s | %-3d \n", id, region, district, city_or_village, street, house_number, patient_id);
        }

        // ********** Hospital **********
        resultSet = statement.executeQuery("select * from hospital");
        System.out.format("\n ----- Hospital table ----- \n");
        System.out.format("%3s | %-45s | %-15s | %-15s | %-6s | %-7s | %-3s \n", "id", "name", "oppening_time", "closing_time", "number", "phone", "adress_id");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String oppening_time = resultSet.getString("oppening_time");
            String closing_time = resultSet.getString("closing_time");
            int number = resultSet.getInt("number");
            int phone = resultSet.getInt("phone");
            int adress_id = resultSet.getInt("adress_id");
            System.out.format("%3d | %-45s | %-15s | %-15s | %-6d | %-7d | %-3d \n", id, name, oppening_time, closing_time, number, phone, adress_id);
        }

        // ********** Doctor **********
        resultSet = statement.executeQuery("select * from doctor");
        System.out.format("\n ----- Doctor table ----- \n");
        System.out.format("%3s | %-10s | %-15s | %-15s | %-10s | %-3s \n", "id", "name", "surname", "start_of_career", "birthday", "hospital_id");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String start_of_career = resultSet.getString("start_of_career");
            String birthday = resultSet.getString("birthday");
            int hospital_id = resultSet.getInt("hospital_id");
            System.out.format("%3d | %-10s | %-15s | %-15s | %-10s | %-3d \n", id, name, surname, start_of_career, birthday, hospital_id);
        }

        // ********** hospital_has_patient **********
        resultSet = statement.executeQuery("select * from hospital_has_patient");
        System.out.format("\n ----- hospital_has_patient table ----- \n");
        System.out.format("%3s | %-10s | %-10s \n", "id", "hospital_id", "patient_id");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int hospital_id = resultSet.getInt("hospital_id");
            int patient_id = resultSet.getInt("patient_id");
            System.out.format("%3d | %-10d | %-10d \n", id, hospital_id, patient_id);
        }
    }
    private static void updateDoctorName() throws Exception{
        //update doctor name
        Scanner input = new Scanner(System.in);
        System.out.println("input doctor name you want to change ");
        String doctorName = input.next();
        System.out.println("input new name for " + doctorName);
        String newDoctorName = input.next();

        PreparedStatement preparedStatement;
        preparedStatement=connection.prepareStatement("UPDATE doctor SET name = ?  WHERE name=?");
        preparedStatement.setString(1,newDoctorName);
        preparedStatement.setString(2,doctorName);
        int countUpdatedDoctor = preparedStatement.executeUpdate();
        System.out.println("rows that updated "+countUpdatedDoctor);}
    private static void insertPatient() throws Exception{
        Scanner inputId = new Scanner(System.in);
        System.out.println("input a new patient id");
        int newPatientId = Integer.parseInt(inputId.next());
        Scanner inputName = new Scanner(System.in);
        System.out.println("input a new patient name");
        String newPatientName = inputName.next();
        Scanner inputSurname = new Scanner(System.in);
        System.out.println("input a new patient surname");
        String newPatientSurname = inputSurname.next();
        Scanner inputAge = new Scanner(System.in);
        System.out.println("input a new patient age");
        int newPatientAge = Integer.parseInt(inputAge.next());


        PreparedStatement preparedStatement;
        preparedStatement=connection.prepareStatement("INSERT patient VALUES (?,?,?,?,null,0)");
        preparedStatement.setInt(1,newPatientId);
        preparedStatement.setString(2,newPatientName);
        preparedStatement.setString(3,newPatientSurname);
        preparedStatement.setInt(4,newPatientAge);
        int countInsertedPatient = preparedStatement.executeUpdate();
        System.out.println("rows that inserted "+countInsertedPatient);}
    private static void deletePatient() throws Exception{
        Scanner inputId = new Scanner(System.in);
        System.out.println("input a patient id you want to delete");
        int deletePatientId = Integer.parseInt(inputId.next());

        PreparedStatement preparedStatement;
        preparedStatement=connection.prepareStatement("DELETE FROM 1patient WHERE id = ?");
        preparedStatement.setInt(1,deletePatientId);
        int countDeletedPatient = preparedStatement.executeUpdate();
        System.out.println("rows that inserted "+countDeletedPatient);}

}
*/
