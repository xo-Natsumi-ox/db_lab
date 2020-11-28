CREATE SCHEMA IF NOT EXISTS db_shevchuk_connection DEFAULT CHARACTER SET utf8;
USE db_shevchuk_connection;

DROP TABLE IF EXISTS hospital_has_patient;
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
    id            INT          NOT NULL AUTO_INCREMENT,
    name          VARCHAR(100) NULL,
    number        INT          NULL,
    adress_id     INT          NOT NULL,
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
    hospital_id INT         NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB;

CREATE TABLE hospital_has_patient
(
    id          INT NOT NULL AUTO_INCREMENT,
    hospital_id INT NOT NULL,
    patient_id  INT NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_hospital_has_patient_patient1_idx (patient_id ASC) VISIBLE,
    INDEX fk_hospital_has_patient_hospital1_idx (hospital_id ASC) VISIBLE,
    CONSTRAINT fk_hospital_has_patient_hospital1
        FOREIGN KEY (hospital_id)
            REFERENCES hospital (id),
    CONSTRAINT fk_hospital_has_patient_patient1
        FOREIGN KEY (patient_id)
            REFERENCES patient (id)
)
    ENGINE = InnoDB;

CREATE TABLE doctor
(
    id              INT         NOT NULL AUTO_INCREMENT,
    name            VARCHAR(45) NULL,
    surname         VARCHAR(45) NULL,
    hospital_id     INT         NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_doctor_hospital1_idx (hospital_id ASC) VISIBLE,
    CONSTRAINT fk_doctor_hospital1
        FOREIGN KEY (hospital_id)
            REFERENCES hospital (id)
)
    ENGINE = InnoDB;

INSERT INTO patient (id, name, surname, age)
values (1, 'Diana', 'Shevchuk', 18),
       (2, 'Maria', 'Sparrow', 18),
       (3, 'Oleksandr', 'Madzhenkov', 18),
       (4, 'Mykola', 'Onyshkevych', 18),
       (5, 'Ivan', 'Tomay', 15),
       (6, 'Dmytro', 'Shevchuk', 24),
       (7, 'Kameron', 'Boyce', 20),
       (8, 'Anastasia', 'Kamenskykh', 33),
       (9, 'Yana', 'Verbova', 19),
       (10, 'Sharik', 'Zholtyi', 1);

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
INSERT INTO hospital_has_patient(id, hospital_id, patient_id)
values (1, 2, 7),
       (2, 5, 10),
       (3, 4, 1),
       (4, 4, 2),
       (5, 3, 5);