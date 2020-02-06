ALTER TABLE `mercaderia_entrada` 
DROP COLUMN `id`,
CHANGE COLUMN `mercaderia_id` `mercaderia_id` INT(11) NOT NULL ,
CHANGE COLUMN `entrada_id` `entrada_id` INT(11) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`mercaderia_id`, `entrada_id`);

ALTER TABLE `mercaderia_proceso_in` 
DROP COLUMN `id`,
CHANGE COLUMN `mercaderia_id` `mercaderia_id` INT(11) NOT NULL ,
CHANGE COLUMN `proceso_id` `proceso_id` INT(11) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`mercaderia_id`, `proceso_id`);

ALTER TABLE `mercaderia_proceso_out` 
DROP COLUMN `id`,
CHANGE COLUMN `mercaderia_id` `mercaderia_id` INT(11) NOT NULL ,
CHANGE COLUMN `proceso_id` `proceso_id` INT(11) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`mercaderia_id`, `proceso_id`);

ALTER TABLE `mercaderia_salida` 
DROP COLUMN `id`,
CHANGE COLUMN `mercaderia_id` `mercaderia_id` INT(11) NOT NULL ,
CHANGE COLUMN `salida_id` `salida_id` INT(11) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`mercaderia_id`, `salida_id`);