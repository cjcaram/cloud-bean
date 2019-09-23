ALTER TABLE `mercaderia` 
CHANGE COLUMN `cantidad_bulto` `cantidad_bulto` INT(11) NULL DEFAULT NULL;

ALTER TABLE `mercaderia_stock` 
CHANGE COLUMN `cantidad_bulto` `cantidad_bulto` INT(11) NULL DEFAULT NULL;

ALTER TABLE `mercaderia_stock_audit` 
CHANGE COLUMN `cantidad_bulto` `cantidad_bulto` INT(11) NULL DEFAULT NULL;

ALTER TABLE `mercaderia_stock` 
ADD COLUMN `mercaderia_id` INT(11) NULL;

ALTER TABLE `mercaderia_stock_audit` 
ADD COLUMN `mercaderia_id` INT(11) NULL;