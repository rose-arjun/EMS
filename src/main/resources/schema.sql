--CREATE DATABASE IF NOT EXISTS ems;
--
--USE ems;

CREATE TABLE IF NOT EXISTS employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ename VARCHAR(50),
    designation VARCHAR(50),
    dept VARCHAR(50)
);