CREATE DATABASE GestionCanchas;

USE GestionCanchas;

CREATE TABLE Clientes (
    idCliente INT auto_increment PRIMARY KEY,
    dni VARCHAR(15) UNIQUE NOT NULL,      -- Clave candidata única
    nombres VARCHAR(200) NOT NULL,        -- Nombre completo (Nombres y/o Apellidos)
    telefono VARCHAR(20)
);


-- ===========================================
--  TABLA CANCHAS (Ajustada)
-- 
-- Cambios: 
-- 1. idCancha como PRIMARY KEY autoincrementable.
-- 2. Codigo (VARCHAR) como UNIQUE para mantener el identificador original.
-- ===========================================
CREATE TABLE Canchas (
    idCancha INT auto_increment PRIMARY KEY,
    codigo VARCHAR(20) UNIQUE NOT NULL, -- Identificador de la cancha, pero no la PK
    tipo VARCHAR(50) NOT NULL,
    precioh DECIMAL(10,2) NOT NULL
);


-- ===========================================
--  TABLA RESERVAS (Ajustada)
-- 
-- Cambios: 
-- 1. idReserva ahora es INT IDENTITY (consistencia).
-- 2. Las FOREIGN KEYs ahora referencian los IDs artificiales.
-- ===========================================
CREATE TABLE Reservas (
    idReserva INT auto_increment PRIMARY KEY, -- Clave primaria INT
    idCliente INT NOT NULL,                  -- Foreign Key referenciando idCliente
    idCancha INT NOT NULL,                   -- Foreign Key referenciando idCancha
    horaInicio DATETIME NOT NULL,
    horaFin DATETIME NOT NULL,
    pagoTotal DECIMAL(10,2),

    FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente),
    FOREIGN KEY (idCancha) REFERENCES Canchas(idCancha)
);


-- ===========================================
--  TABLA PAGOS (Ajustada)
-- 
-- Cambios:
-- 1. La FK idReserva ahora es INT para coincidir con la PK de Reservas.
-- ===========================================
CREATE TABLE Pagos (
    idPago INT auto_increment PRIMARY KEY,
    idReserva INT NOT NULL,               -- Foreign Key referenciando idReserva (INT)
    monto DECIMAL(10,2) NOT NULL,
    metodoPago VARCHAR(40),
    fechaPago DATE NOT NULL,
    estado VARCHAR(20),
    observaciones VARCHAR(200),

    FOREIGN KEY (idReserva) REFERENCES Reservas(idReserva)
);

select *from Clientes;