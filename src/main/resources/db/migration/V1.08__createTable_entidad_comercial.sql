CREATE TABLE `entidad_comercial` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `cuit` VARCHAR(11) NULL,
  `ubicacion` INT NULL,
  `telefono` VARCHAR(45) NULL,
  `mail` VARCHAR(45) NULL,
  `observaciones` VARCHAR(256) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cuit_UNIQUE` (`cuit` ASC));