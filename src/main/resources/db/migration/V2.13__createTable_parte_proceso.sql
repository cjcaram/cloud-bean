CREATE TABLE `proceso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `proceso_numero` INT NULL,
  `nombre_referencia` VARCHAR(45) NULL,
  `fecha` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `grano_especie_id` INT NULL,
  `obs` VARCHAR(256) NULL,
  PRIMARY KEY (`id`));
