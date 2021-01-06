CREATE SCHEMA IF NOT EXISTS lab6db DEFAULT CHARACTER SET utf8;
USE lab6db;

DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS hospital;
DROP TABLE IF EXISTS adress;


CREATE TABLE adress
(
    id              INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    city_or_village VARCHAR(45) NULL,
    street          VARCHAR(45) NULL
)
    ENGINE = InnoDB;

CREATE TABLE hospital
(
    id        INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(100) NULL,
    number    INT          NULL,
    adress_id INT          NOT NULL
)
    ENGINE = InnoDB;
ALTER TABLE hospital
    ADD CONSTRAINT fk_hospital_adress1
        FOREIGN KEY (adress_id)
            REFERENCES adress (id);


CREATE TABLE patient
(
    id          INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(45) NOT NULL,
    surname     VARCHAR(45) NOT NULL,
    age         INT         NULL,
    hospital_id INT         NOT NULL
)
    ENGINE = InnoDB;
ALTER TABLE patient
    ADD CONSTRAINT fk_patient_hospital1
        FOREIGN KEY (hospital_id)
            REFERENCES hospital (id);

CREATE TABLE doctor
(
    id          INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(45) NULL,
    surname     VARCHAR(45) NULL,
    hospital_id INT         NOT NULL
)
    ENGINE = InnoDB;
ALTER TABLE doctor
    ADD CONSTRAINT fk_doctor_hospital1
        FOREIGN KEY (hospital_id)
            REFERENCES hospital (id);

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

INSERT INTO patient (id, name, surname, age, hospital_id)
values (1, 'Diana', 'Shevchuk', 18, 1),
       (2, 'Maria', 'Sparrow', 18, 2),
       (3, 'Oleksandr', 'Madzhenkov', 18, 2),
       (4, 'Mykola', 'Onyshkevych', 18, 1),
       (5, 'Ivan', 'Tomay', 15, 3),
       (6, 'Dmytro', 'Shevchuk', 24, 4),
       (7, 'Kameron', 'Boyce', 20, 5),
       (8, 'Anastasia', 'Kamenskykh', 33, 5),
       (9, 'Yana', 'Verbova', 19, 3),
       (10, 'Sharik', 'Zholtyi', 1, 4);

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
