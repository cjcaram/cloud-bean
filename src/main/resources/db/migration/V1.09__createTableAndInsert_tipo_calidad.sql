CREATE TABLE `tipo_calidad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo_calidad` VARCHAR(45) NOT NULL DEFAULT 'Natural',
  `detalle` VARCHAR(128) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `tipo_calidad` (`tipo_calidad`) VALUES ('EXPORTACION');
INSERT INTO `tipo_calidad` (`tipo_calidad`) VALUES ('NATURAL');
INSERT INTO `tipo_calidad` (`tipo_calidad`) VALUES ('DESCARTE');
INSERT INTO `tipo_calidad` (`tipo_calidad`) VALUES ('PADRON');
INSERT INTO `tipo_calidad` (`tipo_calidad`) VALUES ('SEGUNDILLA');
INSERT INTO `tipo_calidad` (`tipo_calidad`) VALUES ('RECUPERO ELECTRONICA 1');
INSERT INTO `tipo_calidad` (`tipo_calidad`) VALUES ('RECUPERO ELECTRONICA 2');
INSERT INTO `tipo_calidad` (`tipo_calidad`) VALUES ('RECUPERO VIBRADORA');
INSERT INTO `tipo_calidad` (`tipo_calidad`) VALUES ('TIERRA');
INSERT INTO `tipo_calidad` (`tipo_calidad`) VALUES ('VOLATIL');
INSERT INTO `tipo_calidad` (`tipo_calidad`) VALUES ('PAJA');
INSERT INTO `tipo_calidad` (`tipo_calidad`) VALUES ('BASURA');
INSERT INTO `tipo_calidad` (`tipo_calidad`) VALUES ('DESCARTE TARARA');