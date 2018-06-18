cd \xampp\mysql\bin

mysql -u root

create database poonoite;

use poonoite;

create table alunos (
	nome char(50),
	ra char(20),
	nascimento date );
	
show databases;

show tables;

desc alunos;

select * from alunos;

insert into alunos (nome, ra, nascimento) values ('Antonio Carvalho', '000001', '1980-07-03');

create database selecoes;

use selecoes;

CREATE TABLE `selecao` (
  `pais` char(100) NOT NULL,
  `grupo` char(50) DEFAULT NULL,
  `ranking` int(11) DEFAULT NULL,
  `titulos` int(11) DEFAULT NULL,
  `confederacao` char(50) DEFAULT NULL,
  `tecnico` char(100) DEFAULT NULL,
  `estreia` date DEFAULT NULL,
  PRIMARY KEY (`pais`)
);