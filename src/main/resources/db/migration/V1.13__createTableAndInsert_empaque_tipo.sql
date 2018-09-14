CREATE TABLE `empaque_tipo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo_empaque` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `empaque_tipo` (`tipo_empaque`) VALUES ('Bolsa de 25 KG');
INSERT INTO `empaque_tipo` (`tipo_empaque`) VALUES ('Bolsa de 50 KG');
INSERT INTO `empaque_tipo` (`tipo_empaque`) VALUES ('Big Bag');
INSERT INTO `empaque_tipo` (`tipo_empaque`) VALUES ('Granel');
INSERT INTO `empaque_tipo` (`tipo_empaque`) VALUES ('Silo bolsa');
INSERT INTO `empaque_tipo` (`tipo_empaque`) VALUES ('Otro');