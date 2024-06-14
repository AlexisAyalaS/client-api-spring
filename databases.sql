CREATE DATABASE IF NOT EXISTS mi_primer_api_spring_db_prod;
USE mi_primer_api_spring_db_prod;

CREATE TABLE clientes (
    id_client INT UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at DATETIME NOT NULL,
    PRIMARY KEY (id_client)
);

INSERT INTO clientes(name, last_name, email, created_at) VALUES
('Juan', 'Perez', 'juan@email.com', NOW()),
('María', 'Gomez', 'maria@email.com', NOW()),
('Mateo', 'Navarro', 'mateo@email.com', NOW());

CREATE DATABASE IF NOT EXISTS mi_primer_api_spring_db_dev;
USE mi_primer_api_spring_db_dev;

CREATE TABLE clientes (
    id_client INT UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at DATETIME NOT NULL,
    PRIMARY KEY (id_client)
);

INSERT INTO clientes(name, last_name, email, created_at) VALUES
('Juan', 'Perez', 'juan@email.com', NOW()),
('María', 'Gomez', 'maria@email.com', NOW()),
('Pedro', 'Martinez', 'pedro@email.com', NOW()),
('Ana', 'Lopez', 'ana@email.com', NOW()),
('Carlos', 'Rodriguez', 'carlos@email.com', NOW()),
('Laura', 'Sanchez', 'laura@email.com', NOW()),
('Diego', 'Garcia', 'diego@email.com', NOW()),
('Sofia', 'Hernandez', 'sofia@email.com', NOW()),
('Luis', 'Diaz', 'luis@email.com', NOW()),
('Martina', 'Torres', 'martina@email.com', NOW()),
('Javier', 'Ruiz', 'javier@email.com', NOW()),
('Valentina', 'Flores', 'valentina@email.com', NOW()),
('Miguel', 'Alvarez', 'miguel@email.com', NOW()),
('Elena', 'Romero', 'elena@email.com', NOW()),
('David', 'Santos', 'david@email.com', NOW()),
('Adriana', 'Vargas', 'adriana@email.com', NOW()),
('Oscar', 'Molina', 'oscar@email.com', NOW()),
('Natalia', 'Jimenez', 'natalia@email.com', NOW()),
('Julia', 'Gutierrez', 'julia@email.com', NOW()),
('Mateo', 'Navarro', 'mateo@email.com', NOW());
