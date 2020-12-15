CREATE SCHEMA IF NOT EXISTS db_shevchuk DEFAULT CHARACTER SET utf8;
USE db_shevchuk;

DROP TABLE IF EXISTS tracker;
DROP TABLE IF EXISTS shedule;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS hospital;
DROP TABLE IF EXISTS adress;


CREATE TABLE adress
(
    id              INT         NOT NULL AUTO_INCREMENT,
    city_or_village VARCHAR(45) NULL,
    street          VARCHAR(45) NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB;

CREATE TABLE hospital
(
    id        INT          NOT NULL AUTO_INCREMENT,
    name      VARCHAR(100) NULL,
    number    INT          NULL,
    adress_id INT          NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_hospital_adress1_idx (adress_id ASC) VISIBLE,
    CONSTRAINT fk_hospital_adress1
        FOREIGN KEY (adress_id)
            REFERENCES adress (id)
)
    ENGINE = InnoDB;

CREATE TABLE patient
(
    id          INT         NOT NULL AUTO_INCREMENT,
    name        VARCHAR(45) NOT NULL,
    surname     VARCHAR(45) NOT NULL,
    age         INT         NULL,
    hospital_id INT         NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_patient_hospital1_idx (hospital_id ASC) VISIBLE,
    CONSTRAINT fk_patient_hospital1
        FOREIGN KEY (hospital_id)
            REFERENCES hospital (id)
)
    ENGINE = InnoDB;

CREATE TABLE doctor
(
    id          INT         NOT NULL AUTO_INCREMENT,
    name        VARCHAR(45) NULL,
    surname     VARCHAR(45) NULL,
    hospital_id INT         NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_doctor_hospital1_idx (hospital_id ASC) VISIBLE,
    CONSTRAINT fk_doctor_hospital1
        FOREIGN KEY (hospital_id)
            REFERENCES hospital (id)
)
    ENGINE = InnoDB;

CREATE TABLE tracker
(
    id          INT         NOT NULL AUTO_INCREMENT,
    pressure    INT         NULL,
    temperature FLOAT       NULL,
    palpitation INT         NULL,
    diagnos     VARCHAR(45) NULL,
    patient_id  INT         NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_tracker_patient1_idx (patient_id ASC) VISIBLE,
    CONSTRAINT fk_tracker_patient1
        FOREIGN KEY (patient_id)
            REFERENCES patient (id)
)
    ENGINE = InnoDB;

CREATE TABLE shedule
(
    id              INT         NOT NULL AUTO_INCREMENT,
    data            INT        NULL,
    time            VARCHAR(45) NULL,
    additional_info VARCHAR(45) NULL,
    doctor_id       INT         NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_shedule_doctor1_idx (doctor_id ASC) VISIBLE,
    CONSTRAINT fk_shedule_doctor1
        FOREIGN KEY (doctor_id)
            REFERENCES doctor (id)
)
    ENGINE = InnoDB;

INSERT INTO adress(id, city_or_village, street)
values (1, 'lviv', 'chernigivska 7'),
       (2, 'lviv', 'pylypa orlyka 4'),
       (3, 'lviv', 'boy-zhelenskogo 14'),
       (4, 'lviv', 'generala chuprynky 45'),
       (5, 'lviv', 'ivana mikolaychuka 9');

INSERT INTO hospital(id, name, number, adress_id)
values (1, 'lviv regional clinical hospital', 1, 1),
       (2, 'municipal clinical hospital', 10, 3),
       (3, 'lviv city childrens clinicsl hospital', 1, 2),
       (4, 'communal city clinical ambulance hospital', 1, 5),
       (5, 'city clinical hospital', 5, 4);

INSERT INTO patient (id, name, surname, age,hospital_id)
values (1, 'Diana', 'Shevchuk', 18,1),
       (2, 'Maria', 'Sparrow', 18,2),
       (3, 'Oleksandr', 'Madzhenkov', 18,2),
       (4, 'Mykola', 'Onyshkevych', 18,1),
       (5, 'Ivan', 'Tomay', 15,3),
       (6, 'Dmytro', 'Shevchuk', 24,4),
       (7, 'Kameron', 'Boyce', 20,5),
       (8, 'Anastasia', 'Kamenskykh', 33,5),
       (9, 'Yana', 'Verbova', 19,3),
       (10, 'Sharik', 'Zholtyi', 1,4);

INSERT INTO doctor(id, name, surname, hospital_id)
values (1, 'aybolit', 'doctor', 1),
       (2, 'svitlana', 'stolyar', 5),
       (3, 'olga', 'babiy', 2),
       (4, 'oleg', 'trush', 3),
       (5, 'andriy', 'tomay', 2),
       (6, 'nadia', 'vysotska', 4),
       (7, 'oleg', 'melnyk', 5),
       (8, 'natalia', 'gaydey', 2),
       (9, 'dmytro', 'vasilievish', 1),
       (10, 'nazar', 'frant', 3);
