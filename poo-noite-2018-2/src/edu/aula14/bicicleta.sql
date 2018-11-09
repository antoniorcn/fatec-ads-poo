CREATE DATABASE bicicleta;

USE bicicleta;

CREATE TABLE locacao (
	id int NOT NULL AUTO_INCREMENT,
	nome_cliente char(100),
	modelo char(100),
	data date,
	preco float,
	PRIMARY KEY(id)
	);
	
show tables;
desc alunos;
select * from alunos;