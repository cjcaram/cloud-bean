ALTER TABLE `mercaderia_stock_salida` 
CHANGE COLUMN `mercaderia_stock_id` `mercaderia_id` INT(11) NULL DEFAULT NULL , RENAME TO  `mercaderia_salida` ;

ALTER TABLE `mercaderia` 
DROP COLUMN `proceso_id`;

CREATE TABLE `mercaderia_entrada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mercaderia_id` int(11) DEFAULT NULL,
  `entrada_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `mercaderia_proceso_in` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mercaderia_id` int(11) DEFAULT NULL,
  `proceso_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `mercaderia_proceso_out` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mercaderia_id` int(11) DEFAULT NULL,
  `proceso_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE `entrada_proceso`;



