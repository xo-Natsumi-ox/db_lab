package com.shevchuk.view;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.model.*;
import com.shevchuk.service.*;
import com.shevchuk.service.implemention.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public final class View {
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner input = new Scanner(System.in);
    private final AdressController adressController = new AdressControllerImpl();
    private final DoctorController doctorController = new DoctorControllerImpl();
    private final HospitalController hospitalController = new HospitalControllerImpl();
    private final PatientController patientController = new PatientControllerImpl();
    private final SheduleController sheduleController = new SheduleControllerImpl();
    private final TrackerController trackerController = new TrackerControllerImpl();


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

        menu.put("41", "41 - get all hospitals");
        menu.put("42", "42 - get hospital by id");
        menu.put("43", "43 - create hospital");
        menu.put("44", "44 - update hospital");
        menu.put("45", "45 - delete hospital");

        menu.put("51", "51 - get all trackers");
        menu.put("52", "52 - get tracker by id");
        menu.put("53", "53 - create tracker");
        menu.put("54", "54 - update tracker");
        menu.put("55", "55 - delete tracker");

        menu.put("61", "61 - get all shedules");
        menu.put("62", "62 - get shedule by id");
        menu.put("63", "63 - create shedule");
        menu.put("64", "64 - update shedule");
        menu.put("65", "65 - delete shedule");

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

        methodsMenu.put("41", this::getAllHospitals);
        methodsMenu.put("42", this::getHospitalById);
        methodsMenu.put("43", this::createHospital);
        methodsMenu.put("44", this::updateHospital);
        methodsMenu.put("45", this::deleteHospital);

        methodsMenu.put("51", this::getAllTrackers);
        methodsMenu.put("52", this::getTrackerById);
        methodsMenu.put("53", this::createTracker);
        methodsMenu.put("54", this::updateTracker);
        methodsMenu.put("55", this::deleteTracker);

        methodsMenu.put("61", this::getAllShedules);
        methodsMenu.put("62", this::getSheduleById);
        methodsMenu.put("63", this::createShedule);
        methodsMenu.put("64", this::updateShedule);
        methodsMenu.put("65", this::deleteShedule);
    }

    private void getAllPatients() throws SQLException {
        System.out.println("getAllPatients");
        System.out.println(patientController.getAll() + "\n");
    }

    private void getAllDoctors() throws SQLException {

        System.out.println("getAllDoctors");
        System.out.println(doctorController.getAll() + "\n");
    }

    private void getAllAdresses() throws SQLException {

        System.out.println("getAllAdresses");
        System.out.println(adressController.getAll() + "\n");
    }

    private void getAllHospitals() throws SQLException {

        System.out.println("getAllHospitals");
        System.out.println(hospitalController.getAll() + "\n");
    }

    private void getAllTrackers() throws SQLException {

        System.out.println("getAllTrackers");
        System.out.println(trackerController.getAll() + "\n");
    }

    private void getAllShedules() throws SQLException {

        System.out.println("getAllShedules");
        System.out.println(sheduleController.getAll() + "\n");
    }

    private void getPatientById() throws SQLException {
        System.out.println("input id patient you want to find ");
        int id = new Scanner(System.in).nextInt();
        System.out.println(patientController.getById(id) + "\n");
    }

    private void getDoctorById() throws SQLException {
        System.out.println("input id doctor you want to find ");
        int id = new Scanner(System.in).nextInt();
        System.out.println(doctorController.getById(id) + "\n");

    }

    private void getAdressById() throws SQLException {
        System.out.println("input id adress you want to find ");
        int id = new Scanner(System.in).nextInt();
        System.out.println(adressController.getById(id) + "\n");
    }

    private void getHospitalById() throws SQLException {
        System.out.println("input id hospital you want to find ");
        int id = new Scanner(System.in).nextInt();
        System.out.println(hospitalController.getById(id) + "\n");

    }

    private void getTrackerById() throws SQLException {
        System.out.println("input id tracker you want to find ");
        int id = new Scanner(System.in).nextInt();
        System.out.println(trackerController.getById(id) + "\n");

    }

    private void getSheduleById() throws SQLException {
        System.out.println("input id shedule you want to find ");
        int id = new Scanner(System.in).nextInt();
        System.out.println(sheduleController.getById(id) + "\n");

    }

    private void createAdress() throws SQLException {
        System.out.println("input a new adress id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new adress city or village");
        String cityOrVillage = new Scanner(System.in).nextLine();
        System.out.println("input a new adress street");
        String street = new Scanner(System.in).nextLine();
        AdressEntity entity = new AdressEntity(id, cityOrVillage, street);
        adressController.create(entity);
        System.out.println("created");
    }

    private void createDoctor() throws SQLException {
        System.out.println("input a new doctor id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new doctor name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("input a new doctor surname");
        String surname = new Scanner(System.in).nextLine();
        int hospitalId = new Scanner(System.in).nextInt();
        HospitalEntity hospDoc=hospitalController.getById(hospitalId);
        DoctorEntity entity = new DoctorEntity(id, name, surname, hospDoc);
        doctorController.create(entity);
        System.out.println("created");
    }

    private void createPatient() throws SQLException {
        System.out.println("input a new patient id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new patient name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("input a new patient surname");
        String surname = new Scanner(System.in).nextLine();
        System.out.println("input a new patient age");
        int age = new Scanner(System.in).nextInt();
        System.out.println("input a new hospital hospitalId");
        int hospitalId = new Scanner(System.in).nextInt();
        HospitalEntity hospPat=hospitalController.getById(hospitalId);
        PatientEntity entity = new PatientEntity(id, name, surname, age, hospPat);
        patientController.create(entity);
        System.out.println("created");
    }

    private void createHospital() throws SQLException {
        System.out.println("input a new hospital id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new hospital name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("input a new hospital number");
        int number = new Scanner(System.in).nextInt();
        System.out.println("input a new hospital adressId");
        int adressId = new Scanner(System.in).nextInt();
        AdressEntity hospAdress=adressController.getById(adressId);
        HospitalEntity entity = new HospitalEntity(id, name, number, hospAdress);
        hospitalController.create(entity);
        System.out.println("created");
    }

    private void createTracker() throws SQLException {
        System.out.println("input a new tracker id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new patient pressure");
        int pressure = new Scanner(System.in).nextInt();
        System.out.println("input a new patient temperature(double)");
        double temperature = new Scanner(System.in).nextDouble();
        System.out.println("input a new patient palpitation");
        int palpitation = new Scanner(System.in).nextInt();
        System.out.println("input a new patient diagnos");
        String diagnos = new Scanner(System.in).nextLine();
        System.out.println("input a new patientId");
        int patientId = new Scanner(System.in).nextInt();
        PatientEntity trePatient=patientController.getById(patientId);
        TrackerEntity entity = new TrackerEntity(id, pressure, temperature, palpitation, diagnos, trePatient);
        trackerController.create(entity);
        System.out.println("created");
    }

    private void createShedule() throws SQLException {
        System.out.println("input a new shedule id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new doctor date");
        int date = new Scanner(System.in).nextInt();
        System.out.println("input a new doctor time");
        String time = new Scanner(System.in).nextLine();
        System.out.println("input a new doctor additional_info");
        String additionalInfo = new Scanner(System.in).nextLine();
        System.out.println("input a new doctor doctorId");
        int doctorId = new Scanner(System.in).nextInt();
        DoctorEntity sheDoctor=doctorController.getById(doctorId);
        SheduleEntity entity = new SheduleEntity(id, date, time, additionalInfo, sheDoctor);
        sheduleController.create(entity);
        System.out.println("created");
    }

    private void updateAdress() throws SQLException {
        System.out.println("input a adress id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new adress id");
        int idnew = new Scanner(System.in).nextInt();
        System.out.println("input a new adress city or village");
        String cityOrVillage = new Scanner(System.in).nextLine();
        System.out.println("input a new adress street");
        String street = new Scanner(System.in).nextLine();
        AdressEntity oldAdress = adressController.getById(id);
        oldAdress.setId(idnew);
        oldAdress.setCityOrVillage(cityOrVillage);
        oldAdress.setStreet(street);
        adressController.delete(id);
        adressController.update(oldAdress);
        System.out.println("updated");
    }

    private void updateDoctor() throws SQLException {
        System.out.println("input a doctor id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new doctor id");
        int idnew = new Scanner(System.in).nextInt();
        System.out.println("input a new doctor name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("input a new doctor surname");
        String surname = new Scanner(System.in).nextLine();
        System.out.println("input a new hospital hospitalId");
        int hospitalId = new Scanner(System.in).nextInt();
        HospitalEntity hospDoc=hospitalController.getById(hospitalId);
        DoctorEntity oldDoctor = doctorController.getById(id);
        oldDoctor.setId(idnew);
        oldDoctor.setName(name);
        oldDoctor.setSurname(surname);
        oldDoctor.setHospitalId(hospDoc);
        doctorController.delete(id);
        doctorController.update(oldDoctor);
        System.out.println("updated");
    }

    private void updatePatient() throws SQLException {
        System.out.println("input a patient id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new patient id");
        int idnew = new Scanner(System.in).nextInt();
        System.out.println("input a new patient name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("input a new patient surname");
        String surname = new Scanner(System.in).nextLine();
        System.out.println("input a new patient age");
        int age = new Scanner(System.in).nextInt();
        System.out.println("input a new hospital hospitalId");
        int hospitalId = new Scanner(System.in).nextInt();
        HospitalEntity hospPat=hospitalController.getById(hospitalId);
        PatientEntity oldPatient = patientController.getById(id);
        oldPatient.setId(idnew);
        oldPatient.setName(name);
        oldPatient.setSurname(surname);
        oldPatient.setAge(age);
        oldPatient.setHospitalId(hospPat);
        patientController.delete(id);
        patientController.update(oldPatient);
        System.out.println("updated");
    }

    private void updateHospital() throws SQLException {
        System.out.println("input a hospital id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new patient id");
        int idnew = new Scanner(System.in).nextInt();
        System.out.println("input a new hospital name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("input a new hospital number");
        int number = new Scanner(System.in).nextInt();
        System.out.println("input a new hospital adressId");
        int adressId = new Scanner(System.in).nextInt();
        AdressEntity hospAdress=adressController.getById(adressId);
        HospitalEntity oldHospital = hospitalController.getById(id);
        oldHospital.setId(idnew);
        oldHospital.setName(name);
        oldHospital.setNumber(number);
        oldHospital.setAdressId(hospAdress);
        hospitalController.delete(id);
        hospitalController.update(oldHospital);
        System.out.println("updated");
    }

    private void updateTracker() throws SQLException {
        System.out.println("input a tracker id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new patient id");
        int idnew = new Scanner(System.in).nextInt();
        System.out.println("input a new patient pressure");
        int pressure = new Scanner(System.in).nextInt();
        System.out.println("input a new patient temperature(double)");
        double temperature = new Scanner(System.in).nextDouble();
        System.out.println("input a new patient palpitation");
        int palpitation = new Scanner(System.in).nextInt();
        System.out.println("input a new patient diagnos");
        String diagnos = new Scanner(System.in).nextLine();
        System.out.println("input a new patientId");
        int patientId = new Scanner(System.in).nextInt();
        PatientEntity trePatient=patientController.getById(patientId);
        TrackerEntity oldTracker = trackerController.getById(id);
        oldTracker.setId(idnew);
        oldTracker.setPressure(pressure);
        oldTracker.setTemperature(temperature);
        oldTracker.setPalpitation(palpitation);
        oldTracker.setDiagnos(diagnos);
        oldTracker.setPatientId(trePatient);
        trackerController.delete(id);
        trackerController.update(oldTracker);
        System.out.println("updated");
    }

    private void updateShedule() throws SQLException {
        System.out.println("input a shedule id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new patient id");
        int idnew = new Scanner(System.in).nextInt();
        System.out.println("input a new doctor date");
        int date = new Scanner(System.in).nextInt();
        System.out.println("input a new doctor time");
        String time = new Scanner(System.in).nextLine();
        System.out.println("input a new doctor additional_info");
        String additionalInfo = new Scanner(System.in).nextLine();
        System.out.println("input a new doctor doctorId");
        int doctorId = new Scanner(System.in).nextInt();
        DoctorEntity sheDoctor=doctorController.getById(doctorId);
        SheduleEntity oldShedule = sheduleController.getById(id);
        oldShedule.setId(idnew);
        oldShedule.setData(date);
        oldShedule.setTime(time);
        oldShedule.setAdditionalInfo(additionalInfo);
        oldShedule.setDoctorId(sheDoctor);
        sheduleController.delete(id);
        sheduleController.update(oldShedule);
        System.out.println("updated");
    }

    private void deletePatient() throws SQLException {
        System.out.println("input a patient id you want to delete");
        int id = new Scanner(System.in).nextInt();
        patientController.delete(id);
        System.out.println("deleted");
    }

    private void deleteDoctor() throws SQLException {
        System.out.println("input a doctor id you want to delete");
        int id = new Scanner(System.in).nextInt();
        doctorController.delete(id);
        System.out.println("deleted");
    }

    private void deleteAdress() throws SQLException {
        System.out.println("input a adress id you want to delete");
        int id = new Scanner(System.in).nextInt();
        adressController.delete(id);
        System.out.println("deleted");
    }

    private void deleteHospital() throws SQLException {
        System.out.println("input a hospital id you want to delete");
        int id = new Scanner(System.in).nextInt();
        hospitalController.delete(id);
        System.out.println("deleted");
    }

    private void deleteTracker() throws SQLException {
        System.out.println("input a tracker id you want to delete");
        int id = new Scanner(System.in).nextInt();
        trackerController.delete(id);
        System.out.println("deleted");
    }

    private void deleteShedule() throws SQLException {
        System.out.println("input a shedule id you want to delete");
        int id = new Scanner(System.in).nextInt();
        sheduleController.delete(id);
        System.out.println("deleted");
    }


    private void outputMenu() {
        System.out.println("\nMenu");
        for (String key : menu.values())
            System.out.println(key);
    }

    public void show() {
        System.out.println("input something\n write M - for watchin menu\n write Q - for closing connection\n");
        String keyMenu;
        System.out.println("select point");
        do {
            keyMenu = new Scanner(System.in).nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputMenu();
                System.out.println("Select menu point.");
                keyMenu = new Scanner(System.in).nextLine().toUpperCase();

                try {
                    methodsMenu.get(keyMenu).print();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
            if (keyMenu.equalsIgnoreCase("Q")) {
                ConnectionManager.closeSession();
                System.out.println("you close connection");
                break;
            }
        } while (true);

    }
}
