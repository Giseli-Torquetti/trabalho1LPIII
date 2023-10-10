
-- Criar o banco de dados sistema_hotel, se ele ainda não existir
CREATE DATABASE IF NOT EXISTS sistema_hotel;

-- Usar o banco de dados sistema_hotel
USE sistema_hotel;

-- Tabela Quartos: informações sobre os quartos do hotel
CREATE TABLE IF NOT EXISTS Quartos (
    quarto_id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    preço_diária DECIMAL(10, 2) NOT NULL
);

-- Tabela Clientes: informações sobre os clientes do hotel
CREATE TABLE IF NOT EXISTS Clientes (
    cliente_id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

-- Tabela Reservas: informações sobre as reservas de quartos
CREATE TABLE IF NOT EXISTS Reservas (
    reserva_id INT AUTO_INCREMENT PRIMARY KEY,
    quarto_id INT NOT NULL,
    cliente_id INT NOT NULL,
    data_checkin DATE NOT NULL,
    data_checkout DATE NOT NULL,
    FOREIGN KEY (quarto_id) REFERENCES Quartos(quarto_id),
    FOREIGN KEY (cliente_id) REFERENCES Clientes(cliente_id)
);

-- Inserindo registros na tabela tipo_quartos
INSERT INTO tipo_quartos (id, descricao) VALUES (1, 'Quarto de Solteiro');
INSERT INTO tipo_quartos (id, descricao) VALUES (2, 'Quarto de Casal');
INSERT INTO tipo_quartos (id, descricao) VALUES (3, 'Suíte Luxo');
INSERT INTO tipo_quartos (id, descricao) VALUES (4, 'Quarto Familiar');
INSERT INTO tipo_quartos (id, descricao) VALUES (5, 'Suíte Júnior');
INSERT INTO tipo_quartos (id, descricao) VALUES (6, 'Quarto Executivo');
INSERT INTO tipo_quartos (id, descricao) VALUES (7, 'Quarto com Vista para o Mar');
INSERT INTO tipo_quartos (id, descricao) VALUES (8, 'Suíte Presidencial');
INSERT INTO tipo_quartos (id, descricao) VALUES (9, 'Quarto Adaptado');
INSERT INTO tipo_quartos (id, descricao) VALUES (10, 'Quarto de Luxo');


-- Inserindo registros na tabela quartos e relacionando com tipo_quartos
INSERT INTO quartos (id, numero, preco_diaria, tipo_quartos_id) VALUES (1, '101', 100.00, 1);
INSERT INTO quartos (id, numero, preco_diaria, tipo_quartos_id) VALUES (2, '102', 120.00, 2);
INSERT INTO quartos (id, numero, preco_diaria, tipo_quartos_id) VALUES (3, '201', 90.00, 1);
INSERT INTO quartos (id, numero, preco_diaria, tipo_quartos_id) VALUES (4, '202', 110.00, 2);
INSERT INTO quartos (id, numero, preco_diaria, tipo_quartos_id) VALUES (5, '301', 150.00, 3);
INSERT INTO quartos (id, numero, preco_diaria, tipo_quartos_id) VALUES (6, '302', 180.00, 3);
INSERT INTO quartos (id, numero, preco_diaria, tipo_quartos_id) VALUES (7, '401', 80.00, 1);
INSERT INTO quartos (id, numero, preco_diaria, tipo_quartos_id) VALUES (8, '402', 100.00, 2);
INSERT INTO quartos (id, numero, preco_diaria, tipo_quartos_id) VALUES (9, '501', 200.00, 3);
INSERT INTO quartos (id, numero, preco_diaria, tipo_quartos_id) VALUES (10, '502', 220.00, 3);

-- Inserindo registros na tabela clientes
INSERT INTO clientes (id, nome, email, telefone) VALUES (1, 'João Silva', 'joao@example.com', '(11) 1234-5678');
INSERT INTO clientes (id, nome, email, telefone) VALUES (2, 'Maria Santos', 'maria@example.com', '(22) 9876-5432');
INSERT INTO clientes (id, nome, email, telefone) VALUES (3, 'Pedro Oliveira', 'pedro@example.com', '(33) 5555-5555');
INSERT INTO clientes (id, nome, email, telefone) VALUES (4, 'Ana Souza', 'ana@example.com', '(44) 7777-7777');
INSERT INTO clientes (id, nome, email, telefone) VALUES (5, 'Lucas Fernandes', 'lucas@example.com', '(55) 9999-9999');
INSERT INTO clientes (id, nome, email, telefone) VALUES (6, 'Isabela Lima', 'isabela@example.com', '(66) 1111-1111');
INSERT INTO clientes (id, nome, email, telefone) VALUES (7, 'Fernando Costa', 'fernando@example.com', '(77) 2222-2222');
INSERT INTO clientes (id, nome, email, telefone) VALUES (8, 'Mariana Oliveira', 'mariana@example.com', '(88) 3333-3333');
INSERT INTO clientes (id, nome, email, telefone) VALUES (9, 'Rafael Rodrigues', 'rafael@example.com', '(99) 4444-4444');
INSERT INTO clientes (id, nome, email, telefone) VALUES (10, 'Carolina Santos', 'carolina@example.com', '(10) 6666-6666');




