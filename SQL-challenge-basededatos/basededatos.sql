#CREA LA DATABASE
create database basededatos;
use basededatos;

#LIMPIA LA DATABASE ENTERA
drop database basededatos;

#CREA LA TABLA MUNICIPALIDADES
CREATE TABLE municipalidades(
    id_muni INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombreM VARCHAR(50) NOT NULL
);

#CREA LA TABLA EMPLEADOS CON RELACION 1-N CON LA TABLA MUNUCIPALIDADES
CREATE TABLE empleados(
    id_emple INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    telefono VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    salario INT NOT NULL,
    antiguedad INT NOT NULL,
    puesto VARCHAR(50) NOT NULL,

    id_municipalidad INT NOT NULL,
    CONSTRAINT fk_muni FOREIGN KEY(id_municipalidad) REFERENCES municipalidades(id_muni)
);

#INSERTA DATOS EN LA TABLA MUNICIPALIDADES
INSERT INTO municipalidades(nombreM) values("Municipalidad de General Pueyrredon");
INSERT INTO municipalidades(nombreM) values("Municipalidad de San Isidro");
INSERT INTO municipalidades(nombreM) values("Municipalidad de Merlo");
INSERT INTO municipalidades(nombreM) values("Municipalidad de Ituzaingo");

#INSERTA DATOS EN LA TABLA EMPLEADOS
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_municipalidad)
values ("Jorge","Mariano",119829439,"email@gmail.com",55000,6,"Secretario Administrativo",2);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_municipalidad)
values ("Damian","Salomon",119829439,"email@gmail.com",78500,10,"Sindicalista en Comunicados",3);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_municipalidad)
values ("Sebastian","Hernesto",1238293646,"email@gmail.com",90500,14,"Co-Director de Fiscalizacion",4);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_municipalidad)
values ("Lucas","Esteban",119829439,"email@gmail.com",55000,6,"Oficinista",1);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_municipalidad)
values ("Sofia","Mirian",1234875436,"email@gmail.com",78500,10,"Comunicador",1);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_municipalidad)
values ("Gustavo","Pablo",1238293646,"email@gmail.com",90500,14,"Fiscal",1);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_municipalidad)
values ("Lopez","Ezequiel",119829439,"email@gmail.com",55000,6,"Desarrollador de base fiscal",3);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_municipalidad)
values ("Yair","Salmon",1234875436,"email@gmail.com",78500,10,"Comisario Primero",2);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_municipalidad)
values ("Mariana","Luz",2238293646,"email@gmail.com",125500,14,"Director",4);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_municipalidad)
values ("Hernesto","Barreda",2238293646,"email@gmail.com",90500,16,"Co-Fiscal",4);

#SELECCIONA LA TABLA DE MI PREFERENCIA
SELECT * FROM empleados;
SELECT * FROM municipalidades;

#PROBLEMATICA SCRIPT SQL
SELECT emp.nombre, emp.apellido, emp.telefono, emp.email, emp.puesto, m.nombreM
FROM empleados AS emp JOIN municipalidades AS m
ON emp.id_municipalidad = m.id_muni
WHERE emp.salario>=70000 AND emp.antiguedad<=15 && emp.antiguedad>=10;
