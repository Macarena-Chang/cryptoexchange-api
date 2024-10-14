CREATE SCHEMA `mydb` ;

use mydb;
CREATE TABLE pais (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

use mydb;
-- Create Mercado Table (with Foreign Key reference to País)
CREATE TABLE mercado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL UNIQUE,
    descripcion VARCHAR(255) NOT NULL,
    pais_id INT NOT NULL,
    FOREIGN KEY (pais_id) REFERENCES pais(id) ON DELETE CASCADE
);

-- Create Comitente Table
CREATE TABLE comitente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL UNIQUE
);

-- Create Join Table for Comitente and Mercado (Many-to-Many Relationship)
CREATE TABLE comitente_mercado (
    comitente_id INT NOT NULL,
    mercado_id INT NOT NULL,
    PRIMARY KEY (comitente_id, mercado_id),
    FOREIGN KEY (comitente_id) REFERENCES comitente(id) ON DELETE CASCADE,
    FOREIGN KEY (mercado_id) REFERENCES mercado(id) ON DELETE CASCADE
-- );

use mydb;
INSERT INTO pais (nombre) VALUES ('Argentina');
INSERT INTO pais (nombre) VALUES ('Uruguay');
