/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  jasie
 * Created: 11/04/2018
 */

CREATE DATABASE Escuela;
USE Escuela;
CREATE TABLE Alumno (idAlumno int NOT NULL PRIMARY KEY,
             nombre varchar (25) NOT NULL,
             ape_paterno varchar (20) NOT NULL,
             ape_materno varchar (20) NOT NULL,
             fechaNacimiento date NOT NULL,
             direccion varchar (30) NOT NULL,
             telefono int NOT NULL,
             correo varchar (30) NOT NULL,
             contrasena enum('texto', 'sha1', 'md5'));

CREATE TABLE Docente (idDocente int NOT NULL PRIMARY KEY,
             nombre varchar (25) NOT NULL,
             ape_paterno varchar (20) NOT NULL,
             ape_materno varchar (20) NOT NULL,
             fechaNacimiento date NOT NULL,
             direccion varchar (30) NOT NULL,
             telefono int NOT NULL,
             correo varchar (30) NOT NULL,
             contrasena enum('texto', 'sha1', 'md5'));

CREATE TABLE Asignatura(idAsignatura int NOT NULL PRIMARY KEY,
             nombre varchar(30) NOT NULL,
             creditos int NOT NULL,
             unidades int NOT NULL);

--Alumno (idAlumno,nombre,ape_paterno,ape_materno,fechaNacimiento,
--direccion,telefono,correo,contrasena) VALUES (?,?,?,?,?,?,?,?,?)