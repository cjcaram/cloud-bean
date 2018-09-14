CREATE TABLE `role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE` varchar(64) DEFAULT NULL,
  `DESCRIPTION` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


INSERT INTO `role` (`ROLE`, `DESCRIPTION`) VALUES ('ADMIN', 'Super Administrador');
INSERT INTO `role` (`ROLE`, `DESCRIPTION`) VALUES ('USER', 'Todas las facultades excepto ABM de usuarios');
INSERT INTO `role` (`ROLE`, `DESCRIPTION`) VALUES ('CLIENT', 'Solo se permiten consultas');

