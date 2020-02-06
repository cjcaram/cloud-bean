ALTER TABLE `analisis` 
CHANGE COLUMN `gramaje` `gramaje` INT(5) NULL DEFAULT NULL ;

ALTER TABLE `mercaderia` 
ADD COLUMN `grano_especie_id` INT(4) NULL DEFAULT NULL,
ADD COLUMN `cosecha` VARCHAR(32) NULL DEFAULT NULL,
ADD COLUMN `propietario` INT(11) NULL DEFAULT NULL;

ALTER TABLE `entrada` 
DROP COLUMN `cosecha`,
DROP COLUMN `ubicacion`,
DROP COLUMN `tipo_bolsa`,
DROP COLUMN `cantidad_bolsa`,
DROP COLUMN `grano_especie_id`;