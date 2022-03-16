#CREA LA DATABASE
create database basededatos;
use basededatos;

#LIMPIA LA DATABASE ENTERA
drop database basededatos;

#CREA LA TABLA MUNICIPALIDADES
CREATE TABLE municipalidades(
    id_municipalidad INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombreM VARCHAR(50) NOT NULL
);

#CREA LA TABLA EMPLEADOS CON RELACION 1-N CON LA TABLA MUNUCIPALIDADES
CREATE TABLE empleados(
    id_empleado INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    telefono VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    salario INT NOT NULL,
    antiguedad INT NOT NULL,
    puesto VARCHAR(50) NOT NULL,

    id_muni INT NOT NULL,
    CONSTRAINT fk_muni FOREIGN KEY(id_muni) REFERENCES municipalidades(id_municipalidad)
);

#INSERTA DATOS EN LA TABLA MUNICIPALIDADES
INSERT INTO municipalidades(nombreM) values("Municipalidad de General Pueyrredon");
INSERT INTO municipalidades(nombreM) values("Municipalidad de San Isidro");
INSERT INTO municipalidades(nombreM) values("Municipalidad de Merlo");
INSERT INTO municipalidades(nombreM) values("Municipalidad de Ituzaingo");

#INSERTA DATOS EN LA TABLA EMPLEADOS
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_muni)
values ("Jorge","Mariano",119829439,"email@gmail.com",55000,6,"Secretario Administrativo",2);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_muni)
values ("Damian","Salomon",119829439,"email@gmail.com",78500,10,"Sindicalista en Comunicados",3);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_muni)
values ("Sebastian","Hernesto",1238293646,"email@gmail.com",90500,14,"Co-Director de Fiscalizacion",4);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_muni)
values ("Lucas","Esteban",119829439,"email@gmail.com",55000,6,"Oficinista",1);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_muni)
values ("Sofia","Mirian",1234875436,"email@gmail.com",78500,10,"Comunicador",1);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_muni)
values ("Gustavo","Pablo",1238293646,"email@gmail.com",90500,14,"Fiscal",1);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_muni)
values ("Lopez","Ezequiel",119829439,"email@gmail.com",55000,6,"Desarrollador de base fiscal",3);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_muni)
values ("Yair","Salmon",1234875436,"email@gmail.com",78500,10,"Comisario Primero",2);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_muni)
values ("Mariana","Luz",2238293646,"email@gmail.com",125500,14,"Director",4);
INSERT INTO empleados (nombre,apellido,telefono,email,salario, antiguedad, puesto, id_muni)
values ("Hernesto","Barreda",2238293646,"email@gmail.com",90500,16,"Co-Fiscal",4);

#SELECCIONA LA TABLA DE MI PREFERENCIA
SELECT * FROM empleados;
SELECT * FROM municipalidades;

#PROBLEMATICA SCRIPT SQL
SELECT emp.nombre, emp.apellido, emp.telefono, emp.email, emp.puesto, muni.nombreM
FROM empleados AS emp JOIN municipalidades AS muni
ON emp.id_muni = muni.id_municipalidad
WHERE emp.salario>=70000 AND emp.antiguedad<=15 && emp.antiguedad>=10;
