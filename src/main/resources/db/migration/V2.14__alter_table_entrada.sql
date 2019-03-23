ALTER TABLE `entrada` 
CHANGE COLUMN `analisis_id` `analisis_id` INT(11) NULL ;

ALTER TABLE `entrada` 
ADD COLUMN `cosecha` VARCHAR(45) NULL;