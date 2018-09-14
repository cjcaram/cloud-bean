CREATE TABLE `origen_destino` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `origen` TINYINT(1) NULL,
  `destino` TINYINT(1) NULL,
  `establecimiento` VARCHAR(128) NULL,
  `localidad` VARCHAR(64) NULL,
  `provincia` VARCHAR(64) NULL,
  `direccion` VARCHAR(64) NOT NULL,
  `pais` VARCHAR(45) NULL,
  `codigo_postal` VARCHAR(9) NULL,
  `observaciones` VARCHAR(256) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UNIQUE_INDEX` (`establecimiento` ASC, `localidad` ASC, `direccion` ASC));

  