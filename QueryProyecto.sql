CREATE DATABASE GestionCanchas;
GO
USE GestionCanchas;
GO

-- ===========================================
--  TABLA CLIENTES (Ajustada)
-- 
-- Cambios: 
-- 1. idCliente como PRIMARY KEY autoincrementable.
-- 2. DNI como UNIQUE para asegurar que no se repita.
-- 3. Añadidos 'apellido' y 'email' para el modelo POO.
-- ===========================================
CREATE TABLE Clientes (
    idCliente INT IDENTITY(1,1) PRIMARY KEY,
    dni VARCHAR(15) UNIQUE NOT NULL,      -- Clave candidata única
    nombres VARCHAR(200) NOT NULL,        -- Nombre completo (Nombres y/o Apellidos)
    telefono VARCHAR(20)
);
GO

-- ===========================================
--  TABLA CANCHAS (Ajustada)
-- 
-- Cambios: 
-- 1. idCancha como PRIMARY KEY autoincrementable.
-- 2. Codigo (VARCHAR) como UNIQUE para mantener el identificador original.
-- ===========================================
CREATE TABLE Canchas (
    idCancha INT IDENTITY(1,1) PRIMARY KEY,
    codigo VARCHAR(20) UNIQUE NOT NULL, -- Identificador de la cancha, pero no la PK
    tipo VARCHAR(50) NOT NULL,
    precioh DECIMAL(10,2) NOT NULL
);
GO

-- ===========================================
--  TABLA RESERVAS (Ajustada)
-- 
-- Cambios: 
-- 1. idReserva ahora es INT IDENTITY (consistencia).
-- 2. Las FOREIGN KEYs ahora referencian los IDs artificiales.
-- ===========================================
CREATE TABLE Reservas (
    idReserva INT IDENTITY(1,1) PRIMARY KEY, -- Clave primaria INT
    idCliente INT NOT NULL,                  -- Foreign Key referenciando idCliente
    idCancha INT NOT NULL,                   -- Foreign Key referenciando idCancha
    horaInicio DATETIME NOT NULL,
    horaFin DATETIME NOT NULL,
    pagoTotal DECIMAL(10,2),

    FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente),
    FOREIGN KEY (idCancha) REFERENCES Canchas(idCancha)
);
GO

-- ===========================================
--  TABLA PAGOS (Ajustada)
-- 
-- Cambios:
-- 1. La FK idReserva ahora es INT para coincidir con la PK de Reservas.
-- ===========================================
CREATE TABLE Pagos (
    idPago INT IDENTITY(1,1) PRIMARY KEY,
    idReserva INT NOT NULL,               -- Foreign Key referenciando idReserva (INT)
    monto DECIMAL(10,2) NOT NULL,
    metodoPago VARCHAR(40),
    fechaPago DATE NOT NULL,
    estado VARCHAR(20),
    observaciones VARCHAR(200),

    FOREIGN KEY (idReserva) REFERENCES Reservas(idReserva)
);