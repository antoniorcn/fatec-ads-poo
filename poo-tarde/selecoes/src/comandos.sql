cd c:\xampp\mysql\bin
mysql -u root

CREATE DATABASE selecoes;

USE selecoes;

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