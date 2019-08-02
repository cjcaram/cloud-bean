ALTER TABLE `salida` 
  DROP COLUMN `calidad`,
  DROP COLUMN `grano_especie`,
  DROP COLUMN `parte_proceso_id`,
  DROP COLUMN `entrada_id`;

ALTER TABLE `mercaderia` 
  DROP COLUMN `propietario`,
  DROP COLUMN `grano_especie_id`;

ALTER TABLE `entrada_proceso` 
  CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT;