package com.shevchuk.view;

import com.shevchuk.connection.ConnectionManager;
import com.shevchuk.controller.implementation.*;
import com.shevchuk.model.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final AdressController adressController = new AdressController();
    private final DoctorController doctorController = new DoctorController();
    private final HospitalController hospitalController = new HospitalController();
    private final PatientController patientController = new PatientController();
    private final SheduleController sheduleController = new SheduleController();
    private final TrackerController trackerController = new TrackerController();


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

        methodsMenu.put("11", this::findAllAdresses);
        methodsMenu.put("12", this::findAdressById);
        methodsMenu.put("13", this::createAdress);
        methodsMenu.put("14", this::updateAdress);
        methodsMenu.put("15", this::deleteAdress);

        methodsMenu.put("21", this::findAllDoctors);
        methodsMenu.put("22", this::findDoctorById);
        methodsMenu.put("23", this::createDoctor);
        methodsMenu.put("24", this::updateDoctor);
        methodsMenu.put("25", this::deleteDoctor);

        methodsMenu.put("31", this::findAllPatients);
        methodsMenu.put("32", this::findPatientById);
        methodsMenu.put("33", this::createPatient);
        methodsMenu.put("34", this::updatePatient);
        methodsMenu.put("35", this::deletePatient);

        methodsMenu.put("41", this::findAllHospitals);
        methodsMenu.put("42", this::findHospitalById);
        methodsMenu.put("43", this::createHospital);
        methodsMenu.put("44", this::updateHospital);
        methodsMenu.put("45", this::deleteHospital);

        methodsMenu.put("51", this::findAllTrackers);
        methodsMenu.put("52", this::findTrackerById);
        methodsMenu.put("53", this::createTracker);
        methodsMenu.put("54", this::updateTracker);
        methodsMenu.put("55", this::deleteTracker);

        methodsMenu.put("61", this::findAllShedules);
        methodsMenu.put("62", this::findSheduleById);
        methodsMenu.put("63", this::createShedule);
        methodsMenu.put("64", this::updateShedule);
        methodsMenu.put("65", this::deleteShedule);
    }

    private void findAllPatients() {
        System.out.println("getAllPatients" + "\n");
        patientController.findAll();
    }

    private void findAllDoctors() {

        System.out.println("getAllDoctors" + "\n");
        doctorController.findAll();
    }

    private void findAllAdresses() {

        System.out.println("getAllAdresses" + "\n");
        adressController.findAll();
    }

    private void findAllHospitals() {

        System.out.println("getAllHospitals" + "\n");
        hospitalController.findAll();
    }

    private void findAllTrackers() {

        System.out.println("getAllTrackers" + "\n");
        trackerController.findAll();
    }

    private void findAllShedules() {

        System.out.println("getAllShedules" + "\n");
        sheduleController.findAll();
    }

    private void findPatientById() {
        System.out.println("input id patient you want to find ");
        int id = new Scanner(System.in).nextInt();
        patientController.findById(id);
    }

    private void findDoctorById() {
        System.out.println("input id doctor you want to find ");
        int id = new Scanner(System.in).nextInt();
        doctorController.findById(id);

    }

    private void findAdressById() {
        System.out.println("input id adress you want to find ");
        int id = new Scanner(System.in).nextInt();
        adressController.findById(id);
    }

    private void findHospitalById() {
        System.out.println("input id hospital you want to find ");
        int id = new Scanner(System.in).nextInt();
        hospitalController.findById(id);

    }

    private void findTrackerById() {
        System.out.println("input id tracker you want to find ");
        int id = new Scanner(System.in).nextInt();
        trackerController.findById(id);

    }

    private void findSheduleById() {
        System.out.println("input id shedule you want to find ");
        int id = new Scanner(System.in).nextInt();
        sheduleController.findById(id);

    }

    private void createAdress() {
        System.out.println("input a new adress id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new adress city or village");
        String cityOrVillage = new Scanner(System.in).nextLine();
        System.out.println("input a new adress street");
        String street = new Scanner(System.in).nextLine();
        AdressEntity entity = new AdressEntity(id, cityOrVillage, street);
        adressController.create(entity);
    }

    private void createDoctor() {
        System.out.println("input a new doctor id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new doctor name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("input a new doctor surname");
        String surname = new Scanner(System.in).nextLine();
        int hospitalId = new Scanner(System.in).nextInt();
        HospitalEntity hospDoc = hospitalController.getEntityById(hospitalId);
        DoctorEntity entity = new DoctorEntity(id, name, surname, hospDoc);
        doctorController.create(entity);
    }

    private void createPatient() {
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
        HospitalEntity hospPat = hospitalController.getEntityById(hospitalId);
        PatientEntity entity = new PatientEntity(id, name, surname, age, hospPat);
        patientController.create(entity);
    }

    private void createHospital() {
        System.out.println("input a new hospital id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new hospital name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("input a new hospital number");
        int number = new Scanner(System.in).nextInt();
        System.out.println("input a new hospital adressId");
        int adressId = new Scanner(System.in).nextInt();
        AdressEntity hospAdress = adressController.getEntityById(adressId);
        HospitalEntity entity = new HospitalEntity(id, name, number, hospAdress);
        hospitalController.create(entity);
    }

    private void createTracker() {
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
        PatientEntity trePatient = patientController.getEntityById(patientId);
        TrackerEntity entity = new TrackerEntity(id, pressure, temperature, palpitation, diagnos, trePatient);
        trackerController.create(entity);
    }

    private void createShedule() {
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
        DoctorEntity sheDoctor = doctorController.getEntityById(doctorId);
        SheduleEntity entity = new SheduleEntity(id, date, time, additionalInfo, sheDoctor);
        sheduleController.create(entity);
    }

    private void updateAdress() {
        System.out.println("input a adress id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new adress city or village");
        String cityOrVillage = new Scanner(System.in).nextLine();
        System.out.println("input a new adress street");
        String street = new Scanner(System.in).nextLine();
        AdressEntity oldAdress = adressController.getEntityById(id);
        oldAdress.setCityOrVillage(cityOrVillage);
        oldAdress.setStreet(street);
        adressController.update(oldAdress);
    }

    private void updateDoctor() {
        System.out.println("input a doctor id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new doctor name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("input a new doctor surname");
        String surname = new Scanner(System.in).nextLine();
        System.out.println("input a new hospital hospitalId");
        int hospitalId = new Scanner(System.in).nextInt();
        HospitalEntity hospDoc = hospitalController.getEntityById(hospitalId);
        DoctorEntity oldDoctor = doctorController.getEntityById(id);
        oldDoctor.setName(name);
        oldDoctor.setSurname(surname);
        oldDoctor.setHospitalId(hospDoc);
        doctorController.update(oldDoctor);
    }

    private void updatePatient() {
        System.out.println("input a patient id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new patient name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("input a new patient surname");
        String surname = new Scanner(System.in).nextLine();
        System.out.println("input a new patient age");
        int age = new Scanner(System.in).nextInt();
        System.out.println("input a new hospital hospitalId");
        int hospitalId = new Scanner(System.in).nextInt();
        HospitalEntity hospPat = hospitalController.getEntityById(hospitalId);
        PatientEntity oldPatient = patientController.getEntityById(id);
        oldPatient.setName(name);
        oldPatient.setSurname(surname);
        oldPatient.setAge(age);
        oldPatient.setHospitalId(hospPat);
        patientController.update(oldPatient);
    }

    private void updateHospital() {
        System.out.println("input a hospital id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new hospital name");
        String name = new Scanner(System.in).nextLine();
        System.out.println("input a new hospital number");
        int number = new Scanner(System.in).nextInt();
        System.out.println("input a new hospital adressId");
        int adressId = new Scanner(System.in).nextInt();
        AdressEntity hospAdress = adressController.getEntityById(adressId);
        HospitalEntity oldHospital = hospitalController.getEntityById(id);
        oldHospital.setName(name);
        oldHospital.setNumber(number);
        oldHospital.setAdressId(hospAdress);
        hospitalController.update(oldHospital);
    }

    private void updateTracker() {
        System.out.println("input a tracker id");
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
        PatientEntity trePatient = patientController.getEntityById(patientId);
        TrackerEntity oldTracker = trackerController.getEntityById(id);
        oldTracker.setPressure(pressure);
        oldTracker.setTemperature(temperature);
        oldTracker.setPalpitation(palpitation);
        oldTracker.setDiagnos(diagnos);
        oldTracker.setPatientId(trePatient);
        trackerController.update(oldTracker);
    }

    private void updateShedule() {
        System.out.println("input a shedule id");
        int id = new Scanner(System.in).nextInt();
        System.out.println("input a new doctor date");
        int date = new Scanner(System.in).nextInt();
        System.out.println("input a new doctor time");
        String time = new Scanner(System.in).nextLine();
        System.out.println("input a new doctor additional_info");
        String additionalInfo = new Scanner(System.in).nextLine();
        System.out.println("input a new doctor doctorId");
        int doctorId = new Scanner(System.in).nextInt();
        DoctorEntity sheDoctor = doctorController.getEntityById(doctorId);
        SheduleEntity oldShedule = sheduleController.getEntityById(id);
        oldShedule.setData(date);
        oldShedule.setTime(time);
        oldShedule.setAdditionalInfo(additionalInfo);
        oldShedule.setDoctorId(sheDoctor);
        sheduleController.update(oldShedule);
    }

    private void deletePatient() {
        System.out.println("input a patient id you want to delete");
        int id = new Scanner(System.in).nextInt();
        patientController.delete(id);
    }

    private void deleteDoctor() {
        System.out.println("input a doctor id you want to delete");
        int id = new Scanner(System.in).nextInt();
        doctorController.delete(id);
    }

    private void deleteAdress() {
        System.out.println("input a adress id you want to delete");
        int id = new Scanner(System.in).nextInt();
        adressController.delete(id);
    }

    private void deleteHospital() {
        System.out.println("input a hospital id you want to delete");
        int id = new Scanner(System.in).nextInt();
        hospitalController.delete(id);
    }

    private void deleteTracker() {
        System.out.println("input a tracker id you want to delete");
        int id = new Scanner(System.in).nextInt();
        trackerController.delete(id);
    }

    private void deleteShedule() {
        System.out.println("input a shedule id you want to delete");
        int id = new Scanner(System.in).nextInt();
        sheduleController.delete(id);
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

                methodsMenu.get(keyMenu).print();
            }
            if (keyMenu.equalsIgnoreCase("Q")) {
                ConnectionManager.closeSession();
                System.out.println("you close connection");
                break;
            }
        } while (true);
    }
}