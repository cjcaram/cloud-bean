CREATE TABLE `responsible_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` INT NULL,
  `description` VARCHAR(256) NULL,
  PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
  
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('1', 'IVA Responsable Inscripto');
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('2', 'IVA Responsable no Inscripto');
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('3', 'IVA no Responsable');
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('4', 'IVA Sujeto Exento');
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('5', 'Consumidor Final');
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('6', 'Responsable Monotributo');
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('7', 'Sujeto no Categorizado');
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('8', 'Proveedor del Exterior');
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('9', 'Cliente del Exterior');
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('10', 'IVA Liberado – Ley Nº 19.640');
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('11', 'IVA Responsable Inscripto – Agente de Percepción');
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('12', 'Pequeño Contribuyente Eventual');
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('13', 'Monotributista Social');
INSERT INTO `responsible_type` (`code`, `description`) VALUES ('14', 'Pequeño Contribuyente Eventual Social');

