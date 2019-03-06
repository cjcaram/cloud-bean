ALTER TABLE `salida` 
ADD COLUMN `numero_salida` INT NOT NULL,
ADD COLUMN `chofer` VARCHAR(128) NULL,
ADD COLUMN `tipo_bolsa` INT NULL,
ADD COLUMN `cantidad_bolsa` INT NULL;
