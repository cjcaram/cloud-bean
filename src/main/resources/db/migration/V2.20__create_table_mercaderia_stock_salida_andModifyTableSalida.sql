CREATE TABLE `mercaderia_stock_salida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mercaderia_stock_id` int(11),
  `salida_id` int(11),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

ALTER TABLE `salida` 
DROP COLUMN `mercaderia_id`;