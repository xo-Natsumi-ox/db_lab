package com.shevchuk.view;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.model.*;
import com.shevchuk.service.implemention.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner input = new Scanner(System.in);

    public View() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("11", "11 - get all adresses");
        menu.put("12", "12 - get adress by id");
        menu.put("13", "13 - create adress");
        menu.put("14", "14 - update adress");
        menu.put("15", "15 - delete adress");

        menu.put("21", "21 - get all doctors");
        menu.put("22", "22 - get doctor by id");
        menu.put("23", "23 - create doctor");
        menu.put("24", "24 - update doctor");
        menu.put("25", "25 - delete doctor");

        menu.put("31", "31 - get all paients");
        menu.put("32", "32 - get paients by id");
        menu.put("33", "33 - create paients");
        menu.put("34", "34 - update paients");
        menu.put("35", "35 - delete paients");

        menu.put("41", "41 - get all hospitals and patients");
        menu.put("42", "42 - get hospital and patient by id");
        menu.put("43", "43 - create hospital and patient");
        menu.put("44", "44 - update hospital and patient");
        menu.put("45", "45 - delete hospital and patient");

        menu.put("51", "51 - get all hospitals");
        menu.put("52", "52 - get hospital by id");
        menu.put("53", "53 - create hospital");
        menu.put("54", "54 - update hospital");
        menu.put("55", "55 - delete hospital");

        menu.put("q", "q - exit");

        methodsMenu.put("11", this::getAllAdresses);
        methodsMenu.put("12", this::getAdressById);
        methodsMenu.put("13", this::createAdress);
        methodsMenu.put("14", this::updateAdress);
        methodsMenu.put("15", this::deleteAdress);

        methodsMenu.put("21", this::getAllDoctors);
        methodsMenu.put("22", this::getDoctorById);
        methodsMenu.put("23", this::createDoctor);
        methodsMenu.put("24", this::updateDoctor);
        methodsMenu.put("25", this::deleteDoctor);

        methodsMenu.put("31", this::getAllPatients);
        methodsMenu.put("32", this::getPatientById);
        methodsMenu.put("33", this::createPatient);
        methodsMenu.put("34", this::updatePatient);
        methodsMenu.put("35", this::deletePatient);

        methodsMenu.put("41", this::getAllHospitalHasPatients);
        methodsMenu.put("42", this::getHospitalHasPatientById);
        methodsMenu.put("43", this::createHospitalHasPatient);
        methodsMenu.put("44", this::updateHospitalHasPatient);
        methodsMenu.put("45", this::deleteHospitalHasPatient);

        methodsMenu.put("51", this::getAllHospitals);
        methodsMenu.put("52", this::getHospitalById);
        methodsMenu.put("53", this::createHospital);
        methodsMenu.put("54", this::updateHospital);
        methodsMenu.put("55", this::deleteHospital);
    }

    private void getAllPatients() throws SQLException {

        PatientServiceImpl patientService = new PatientServiceImpl();
        List<PatientEntity> patients = patientService.getAll();
        for (PatientEntity entity : patients) {
            System.out.println(entity);
        }
    }

    private void getAllDoctors() throws SQLException {

        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        List<DoctorEntity> doctors = doctorService.getAll();
        for (DoctorEntity entity : doctors) {
            System.out.println(entity);
        }
    }

    private void getAllAdresses() throws SQLException {

        AdressServiceImpl adressService = new AdressServiceImpl();
        List<AdressEntity> adresses = adressService.getAll();
        for (AdressEntity entity : adresses) {
            System.out.println(entity);
        }
    }

    private void getAllHospitals() throws SQLException {

        HospitalServiceImpl hospitalService = new HospitalServiceImpl();
        List<HospitalEntity> hospitals = hospitalService.getAll();
        for (HospitalEntity entity : hospitals) {
            System.out.println(entity);
        }
    }

    private void getAllHospitalHasPatients() throws SQLException {

        HospitalHasPatientServiceImpl hospitalHasPatientService = new HospitalHasPatientServiceImpl();
        List<HospitalHasPatientEntity> hospitalHasPatients = hospitalHasPatientService.getAll();
        for (HospitalHasPatientEntity entity : hospitalHasPatients) {
            System.out.println(entity);
        }
    }

    private void getPatientById() throws SQLException {
        System.out.println("input id patient you want to find ");
        int id = input.nextInt();
        PatientServiceImpl patientService = new PatientServiceImpl();
        PatientEntity entity = patientService.getById(id);
        System.out.println(entity);

    }

    private void getDoctorById() throws SQLException {
        System.out.println("input id doctor you want to find ");
        int id = input.nextInt();
        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        DoctorEntity entity = doctorService.getById(id);
        System.out.println(entity);

    }

    private void getAdressById() throws SQLException {
        System.out.println("input id adress you want to find ");
        int id = input.nextInt();
        AdressServiceImpl adressService = new AdressServiceImpl();
        AdressEntity entity = adressService.getById(id);
        System.out.println(entity);

    }

    private void getHospitalById() throws SQLException {
        System.out.println("input id hospital you want to find ");
        int id = input.nextInt();
        HospitalServiceImpl hospitalService = new HospitalServiceImpl();
        HospitalEntity entity = hospitalService.getById(id);
        System.out.println(entity);

    }

    private void getHospitalHasPatientById() throws SQLException {
        System.out.println("input id hospital and patient you want to find ");
        int id = input.nextInt();
        HospitalHasPatientServiceImpl hospitalHasPatientService = new HospitalHasPatientServiceImpl();
        HospitalHasPatientEntity entity = hospitalHasPatientService.getById(id);
        System.out.println(entity);
    }

    private void createPatient() throws SQLException {
        System.out.println("input a new patient id");
        int id = input.nextInt();
        System.out.println("input a new patient name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("input a new patient surname");
        String surname = input.nextLine();
        System.out.println("input a new patient age");
        int age = input.nextInt();
        PatientEntity entity = new PatientEntity(id, name, surname, age);

        PatientServiceImpl patientService = new PatientServiceImpl();
        int count = patientService.create(entity);
        System.out.println("rows that created " + count);
    }

    private void createDoctor() throws SQLException {
        System.out.println("input a new doctor id");
        int id = input.nextInt();
        System.out.println("input a new doctor name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("input a new doctor surname");
        String surname = input.nextLine();
        System.out.println("input a new doctor hospital_id");
        int hospital_id = input.nextInt();
        DoctorEntity entity = new DoctorEntity(id, name, surname, hospital_id);

        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        int count = doctorService.create(entity);
        System.out.println("rows that created " + count);
    }

    private void createAdress() throws SQLException {
        System.out.println("input a new adress id");
        int id = input.nextInt();
        System.out.println("input a new adress city or village");
        input.nextLine();
        String city_or_village = input.nextLine();
        System.out.println("input a new adress street");
        String street = input.nextLine();
        AdressEntity entity = new AdressEntity(id, city_or_village, street);

        AdressServiceImpl adressService = new AdressServiceImpl();
        int count = adressService.create(entity);
        System.out.println("rows that created " + count);
    }

    private void createHospital() throws SQLException {
        System.out.println("input a new hospital id");
        int id = input.nextInt();
        System.out.println("input a new hospital name");
        Scanner inputName = new Scanner(System.in);
        String name = inputName.next();
        System.out.println("input a new hospital number");
        int number = input.nextInt();
        System.out.println("input a new hospital adress_id");
        int adress_id = input.nextInt();
        HospitalEntity entity = new HospitalEntity(id, name, number, adress_id);

        HospitalServiceImpl hospitalService = new HospitalServiceImpl();
        int count = hospitalService.create(entity);
        System.out.println("rows that created " + count);
    }

    private void createHospitalHasPatient() throws SQLException {
        System.out.println("input a new hospitalHasPatient id ");
        int id = input.nextInt();
        System.out.println("input a new patient id ");
        int patientId = input.nextInt();
        System.out.println("input a new hospital id ");
        int age = input.nextInt();
        HospitalHasPatientEntity entity = new HospitalHasPatientEntity(id, patientId, age);

        HospitalHasPatientServiceImpl hospitalHasPatientService = new HospitalHasPatientServiceImpl();
        int count = hospitalHasPatientService.create(entity);
        System.out.println("rows that created " + count);
    }

    private void updatePatient() throws SQLException {
        System.out.println("input a new patient id");
        int id = input.nextInt();
        System.out.println("input a new patient name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("input a new patient surname");
        String surname = input.nextLine();
        System.out.println("input a new patient age");
        int age = input.nextInt();
        PatientEntity entity = new PatientEntity(id, name, surname, age);

        PatientServiceImpl patientService = new PatientServiceImpl();
        int count = patientService.update(entity);
        System.out.println("rows that updated " + count);
    }

    private void updateDoctor() throws SQLException {
        System.out.println("input a new doctor id");
        int id = input.nextInt();
        System.out.println("input a new doctor name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("input a new doctor surname");
        String surname = input.nextLine();
        System.out.println("input a new doctor hospital_id");
        int hospital_id = input.nextInt();
        DoctorEntity entity = new DoctorEntity(id, name, surname, hospital_id);

        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        int count = doctorService.update(entity);
        System.out.println("rows that updated " + count);
    }

    private void updateAdress() throws SQLException {
        System.out.println("input a new adress id");
        int id = input.nextInt();
        System.out.println("input a new adress city or village");
        input.nextLine();
        String city_or_village = input.nextLine();
        System.out.println("input a new adress street");
        String street = input.nextLine();
        AdressEntity entity = new AdressEntity(id, city_or_village, street);

        AdressServiceImpl adressService = new AdressServiceImpl();
        int count = adressService.update(entity);
        System.out.println("rows that updateded " + count);
    }

    private void updateHospital() throws SQLException {
        System.out.println("input a new hospital id");
        int id = input.nextInt();
        System.out.println("input a new hospital name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("input a new hospital number");
        int number = input.nextInt();
        System.out.println("input a new hospital adress_id");
        int adress_id = input.nextInt();
        HospitalEntity entity = new HospitalEntity(id, name, number, adress_id);

        HospitalServiceImpl hospitalService = new HospitalServiceImpl();
        int count = hospitalService.update(entity);
        System.out.println("rows that updateded " + count);
    }

    private void updateHospitalHasPatient() throws SQLException {
        System.out.println("input a new hospitalHasPatient id ");
        int id = input.nextInt();
        System.out.println("input a new patient id ");
        int patientId = input.nextInt();
        System.out.println("input a new hospital id ");
        int age = input.nextInt();
        HospitalHasPatientEntity entity = new HospitalHasPatientEntity(id, patientId, age);

        HospitalHasPatientServiceImpl hospitalHasPatientService = new HospitalHasPatientServiceImpl();
        int count = hospitalHasPatientService.update(entity);
        System.out.println("rows that updateded " + count);
    }

    private void deletePatient() throws SQLException {
        System.out.println("input a patient id you want to delete");
        int id = input.nextInt();

        PatientServiceImpl patientService = new PatientServiceImpl();
        int count = patientService.delete(id);
        System.out.println("rows that deleted " + count);
    }

    private void deleteDoctor() throws SQLException {
        System.out.println("input a doctor id you want to delete");
        int id = input.nextInt();

        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        int count = doctorService.delete(id);
        System.out.println("rows that deleted " + count);
    }

    private void deleteAdress() throws SQLException {
        System.out.println("input a adress id you want to delete");
        int id = input.nextInt();

        AdressServiceImpl adressService = new AdressServiceImpl();
        int count = adressService.delete(id);
        System.out.println("rows that deleted " + count);
    }

    private void deleteHospital() throws SQLException {
        System.out.println("input a hospital id you want to delete");
        int id = input.nextInt();

        HospitalServiceImpl hospitalService = new HospitalServiceImpl();
        int count = hospitalService.delete(id);
        System.out.println("rows that deleted " + count);
    }

    private void deleteHospitalHasPatient() throws SQLException {
        System.out.println("input a hospitalHasPatient id you want to delete");
        int id = input.nextInt();

        HospitalHasPatientServiceImpl hospitalHasPatientService = new HospitalHasPatientServiceImpl();
        int count = hospitalHasPatientService.delete(id);
        System.out.println("rows that deleted " + count);
    }

    private void outputMenu() {
        System.out.println("\nMenu");
        for (String key : menu.values())
            System.out.println(key);
    }

    public void show() {
        System.out.println("input something\n write M - for watchin menu\n write Q - for closing connection\n write G - for getting connection");
        String keyMenu;
        System.out.println("select point");
        do {
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputMenu();
                System.out.println("Select menu point.");
                keyMenu = input.nextLine().toUpperCase();

                try {
                    methodsMenu.get(keyMenu).print();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
            if (keyMenu.equalsIgnoreCase("G")) {
                ConnectionManager.getConnection();
                System.out.println("you get connection");
            }
            if (keyMenu.equalsIgnoreCase("Q")) {
                ConnectionManager.getConnection();
                System.out.println("you close connection");
            }
        } while (!keyMenu.equals('Q'));
        ConnectionManager.exitConnection();
        System.out.println("connection closed");
    }
}