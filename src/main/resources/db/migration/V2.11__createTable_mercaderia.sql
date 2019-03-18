CREATE TABLE `mercaderia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `propietario` INT NULL,
  `tipo_calidad_id` INT NULL,
  `tipo_bolsa_id` INT NULL,
  `cantidad_bulto` DECIMAL(4,2) NULL,
  `cantidad_kg` INT NULL,
  `ubicacion` VARCHAR(128) NULL,
  `gramaje` INT NULL,
  `obs` VARCHAR(256) NULL,
  `proceso_id` INT NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));
