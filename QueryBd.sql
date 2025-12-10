CREATE DATABASE GestionCanchas;

USE GestionCanchas;

CREATE TABLE Clientes (
    idCliente INT auto_increment PRIMARY KEY,
    dni VARCHAR(15) UNIQUE NOT NULL,      
    nombres VARCHAR(200) NOT NULL,        
    telefono VARCHAR(20)
);


CREATE TABLE Canchas (
    idCancha INT auto_increment PRIMARY KEY,
    codigo VARCHAR(20) UNIQUE NOT NULL, 
    tipo VARCHAR(50) NOT NULL,
    precioh DECIMAL(10,2) NOT NULL
);


CREATE TABLE Reservas (
    idReserva INT AUTO_INCREMENT PRIMARY KEY,
    idCliente INT NOT NULL,
    idCancha INT NOT NULL,
    horas INT NOT NULL,
    fecha DATE NOT NULL,
    metodoPago VARCHAR(20),
    pagoTotal DECIMAL(10,2) NOT NULL,

    FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente),
    FOREIGN KEY (idCancha) REFERENCES Canchas(idCancha)
);

select *from Reservas;