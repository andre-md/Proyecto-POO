-- ===========================================
--  CREACIÓN DE BASE DE DATOS
-- ===========================================
CREATE DATABASE GestionCanchas;
GO
USE BDCANCHAS;
GO

-- ===========================================
--  TABLA CLIENTES
-- ===========================================
CREATE TABLE Clientes (
    dni VARCHAR(15) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20)
);
GO

-- ===========================================
--  TABLA CANCHAS
-- ===========================================
CREATE TABLE Canchas (
    codigo VARCHAR(20) PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    precioh DECIMAL(10,2) NOT NULL
);
GO

-- ===========================================
--  TABLA RESERVAS
-- ===========================================
CREATE TABLE Reservas (
    idReserva VARCHAR(20) PRIMARY KEY,
    dni VARCHAR(15) NOT NULL,
    codigoCancha VARCHAR(20) NOT NULL,
    horaInicio DATETIME NOT NULL,
    horaFin DATETIME NOT NULL,
    pagoTotal DECIMAL(10,2),

    FOREIGN KEY (dni) REFERENCES Clientes(dni),
    FOREIGN KEY (codigoCancha) REFERENCES Canchas(codigo)
);
GO

-- ===========================================
--  TABLA PAGOS
-- ===========================================
CREATE TABLE Pagos (
    idPago INT IDENTITY(1,1) PRIMARY KEY,
    idReserva VARCHAR(20) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    metodoPago VARCHAR(40),
    fechaPago DATE NOT NULL,
    estado VARCHAR(20),
    observaciones VARCHAR(200),

    FOREIGN KEY (idReserva) REFERENCES Reservas(idReserva)
);
GO
