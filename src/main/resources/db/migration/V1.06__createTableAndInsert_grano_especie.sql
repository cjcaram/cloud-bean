CREATE TABLE `grano_especie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `variedad` varchar(45) DEFAULT NULL,
  `descripcion` nvarchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `grano_especie` (`nombre`) VALUES ('ALUBIA');
INSERT INTO `grano_especie` (`nombre`) VALUES ('NEGRO');
INSERT INTO `grano_especie` (`nombre`) VALUES ('CRANBERRY');
INSERT INTO `grano_especie` (`nombre`) VALUES ('DRK');
INSERT INTO `grano_especie` (`nombre`) VALUES ('LRK');
INSERT INTO `grano_especie` (`nombre`) VALUES ('MUNGO');
INSERT INTO `grano_especie` (`nombre`) VALUES ('IMPERIO');
INSERT INTO `grano_especie` (`nombre`) VALUES ('GARBANZO');
INSERT INTO `grano_especie` (`nombre`) VALUES ('GRAT NORTH');
INSERT INTO `grano_especie` (`nombre`) VALUES ('ADZUKI');
INSERT INTO `grano_especie` (`nombre`) VALUES ('PALLARES');
INSERT INTO `grano_especie` (`nombre`) VALUES ('CHIA');
INSERT INTO `grano_especie` (`nombre`) VALUES ('MAIZ');
INSERT INTO `grano_especie` (`nombre`) VALUES ('CANELA');
INSERT INTO `grano_especie` (`nombre`) VALUES ('OVAL');