CREATE DATABASE escola;

USE escola;

CREATE TABLE alunos (
	id long,
	nome char(100),
	ra char(10),
	nascimento date,
	email varchar(100),
	curso varchar(30),
	altura float
	);
	
show tables;
desc alunos;
select * from alunos;