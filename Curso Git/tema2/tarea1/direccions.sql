DROP DATABASE if exists `direccions`;

CREATE DATABASE if not exists `direccions` ;

USE `direccions`;

CREATE TABLE IF NOT EXISTS `correos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=6 ;

INSERT INTO `correos` (`id`, `nome`, `email`) VALUES
(1, 'Alejandro Arias Roma', 'alear@gmail.com'),
(2, 'María Pumariños González', 'carresada@hotmail.com'),
(3, 'José Fernández Paz', 'jofepaz@idiomas.udea.edu.usc'),
(4, 'Gloria Núñez Abel', 'lebaze@edu.xunta.es'),
(5, 'Dora Castro Arias', 'artemisa@yahoo.com');

--
-- Conceder permiso ao usuario consulta en localhost sobre a base de datos
-- direccions coa contrasinal abc.
-- O usuario crearase se é que non existe.
--
GRANT SELECT ON direccions.* TO 'consulta'@'localhost' IDENTIFIED BY 'abc'; 