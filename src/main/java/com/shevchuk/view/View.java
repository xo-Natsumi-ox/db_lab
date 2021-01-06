package com.shevchuk.view;

import com.shevchuk.controller.implementation.AdressController;
import com.shevchuk.controller.implementation.DoctorController;
import com.shevchuk.controller.implementation.HospitalController;
import com.shevchuk.controller.implementation.PatientController;
import com.shevchuk.model.AdressEntity;
import com.shevchuk.model.DoctorEntity;
import com.shevchuk.model.HospitalEntity;
import com.shevchuk.model.PatientEntity;

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
    private static final Scanner INPUT = new Scanner(System.in);


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

    }

    private void findAllPatients() {
        System.out.println("getAllPatients" + "\n");
        System.out.println(patientController.findAll());
    }

    private void findAllDoctors() {

        System.out.println("getAllDoctors" + "\n");
        System.out.println(doctorController.findAll());
    }

    private void findAllAdresses() {

        System.out.println("getAllAdresses" + "\n");
        System.out.println(adressController.findAll());
    }

    private void findAllHospitals() {

        System.out.println("getAllHospitals" + "\n");
        System.out.println(hospitalController.findAll());
    }


    private void findPatientById() {
        System.out.println("input id patient you want to find ");
        int id = new Scanner(System.in).nextInt();
        System.out.println(patientController.findById(id));
    }

    private void findDoctorById() {
        System.out.println("input id doctor you want to find ");
        int id = INPUT.nextInt();
        System.out.println(doctorController.findById(id));

    }

    private void findAdressById() {
        System.out.println("input id adress you want to find ");
        int id = INPUT.nextInt();
        System.out.println(adressController.findById(id));
    }

    private void findHospitalById() {
        System.out.println("input id hospital you want to find ");
        int id = INPUT.nextInt();
        System.out.println(hospitalController.findById(id));
    }


    private void createAdress() {
        System.out.println("input a new adress city or village");
        String cityOrVillage = INPUT.nextLine();
        System.out.println("input a new adress street");
        String street = INPUT.nextLine();
        AdressEntity entity = new AdressEntity(cityOrVillage, street);
        adressController.create(entity);
        System.out.println("created");
    }

    private void createDoctor() {
        System.out.println("input a new doctor name");
        String name = INPUT.nextLine();
        System.out.println("input a new doctor surname");
        String surname = INPUT.nextLine();
        System.out.println("input a new doctor hospitalId");
        int hospitalId = INPUT.nextInt();
        HospitalEntity hospDoc = hospitalController.findById(hospitalId);
        DoctorEntity entity = new DoctorEntity(name, surname, hospDoc);
        doctorController.create(entity);
        System.out.println("created");
    }

    private void createPatient() {
        System.out.println("input a new patient name");
        String name = INPUT.nextLine();
        System.out.println("input a new patient surname");
        String surname = INPUT.nextLine();
        System.out.println("input a new patient age");
        int age = INPUT.nextInt();
        System.out.println("input a new hospital hospitalId");
        int hospitalId = INPUT.nextInt();
        HospitalEntity hospPat = hospitalController.findById(hospitalId);
        PatientEntity entity = new PatientEntity(name, surname, age, hospPat);
        patientController.create(entity);
        System.out.println("created");
    }

    private void createHospital() {
        System.out.println("input a new hospital name");
        String name = INPUT.nextLine();
        System.out.println("input a new hospital number");
        int number = INPUT.nextInt();
        System.out.println("input a new hospital adressId");
        int adressId = INPUT.nextInt();
        AdressEntity hospAdress = adressController.findById(adressId);
        HospitalEntity entity = new HospitalEntity(name, number, hospAdress);
        hospitalController.create(entity);
        System.out.println("created");
    }


    private void updateAdress() {
        System.out.println("input a adress id");
        int id = INPUT.nextInt();
        System.out.println("input a new adress city or village");
        INPUT.nextLine();
        String cityOrVillage = INPUT.nextLine();
        System.out.println("input a new adress street");
        String street = INPUT.nextLine();
        AdressEntity oldAdress = adressController.findById(id);
        oldAdress.setCityOrVillage(cityOrVillage);
        oldAdress.setStreet(street);
        adressController.update(oldAdress);
        System.out.println("updated");
    }

    private void updateDoctor() {
        System.out.println("input a doctor id");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("input a new doctor name");
        String name = INPUT.nextLine();
        System.out.println("input a new doctor surname");
        String surname = INPUT.nextLine();
        System.out.println("input a new hospital hospitalId");
        int hospitalId = INPUT.nextInt();
        HospitalEntity hospDoc = hospitalController.findById(hospitalId);
        DoctorEntity oldDoctor = doctorController.findById(id);
        oldDoctor.setName(name);
        oldDoctor.setSurname(surname);
        oldDoctor.setHospitalId(hospDoc);
        doctorController.update(oldDoctor);
        System.out.println("updated");

    }

    private void updatePatient() {
        System.out.println("input a patient id");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("input a new patient name");
        String name = INPUT.nextLine();
        System.out.println("input a new patient surname");
        String surname = INPUT.nextLine();
        System.out.println("input a new patient age");
        int age = INPUT.nextInt();
        System.out.println("input a new hospital hospitalId");
        int hospitalId = INPUT.nextInt();
        HospitalEntity hospPat = hospitalController.findById(hospitalId);
        PatientEntity oldPatient = patientController.findById(id);
        oldPatient.setName(name);
        oldPatient.setSurname(surname);
        oldPatient.setAge(age);
        oldPatient.setHospitalId(hospPat);
        patientController.update(oldPatient);
        System.out.println("updated");

    }

    private void updateHospital() {
        System.out.println("input a hospital id");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("input a new hospital name");
        String name = INPUT.nextLine();
        System.out.println("input a new hospital number");
        int number = INPUT.nextInt();
        System.out.println("input a new hospital adressId");
        int adressId = INPUT.nextInt();
        AdressEntity hospAdress = adressController.findById(adressId);
        HospitalEntity oldHospital = hospitalController.findById(id);
        oldHospital.setName(name);
        oldHospital.setNumber(number);
        oldHospital.setAdressId(hospAdress);
        hospitalController.update(oldHospital);
        System.out.println("updated");

    }


    private void deletePatient() {
        System.out.println("input a patient id you want to delete");
        int id = INPUT.nextInt();
        patientController.delete(id);
        System.out.println("deleted");
    }

    private void deleteDoctor() {
        System.out.println("input a doctor id you want to delete");
        int id = INPUT.nextInt();
        doctorController.delete(id);
        System.out.println("deleted");

    }

    private void deleteAdress() {
        System.out.println("input a adress id you want to delete");
        int id = INPUT.nextInt();
        adressController.delete(id);
        System.out.println("deleted");

    }

    private void deleteHospital() {
        System.out.println("input a hospital id you want to delete");
        int id = INPUT.nextInt();
        hospitalController.delete(id);
        System.out.println("deleted");

    }


    private void outputMenu() {
        System.out.println("\nMenu");
        for (String key : menu.values()) {
            System.out.println(key);
        }
    }

    public void show() {
        System.out.println(" M - menu\n Q - exit\n");
        String keyMenu;
        System.out.println("select point");
        do {
            keyMenu = INPUT.nextLine().toUpperCase();

            if (keyMenu.equalsIgnoreCase("M")) {
                outputMenu();
                System.out.println("Select menu point.");
                keyMenu = INPUT.nextLine().toUpperCase();

                methodsMenu.get(keyMenu).print();
            }
            if (keyMenu.equalsIgnoreCase("Q")) {
                System.out.println("good bye");
                break;
            }
        } while (true);
    }
}
