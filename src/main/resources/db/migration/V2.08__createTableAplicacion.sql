CREATE TABLE `aplicacion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `APLICACION_NRO` int(11) DEFAULT NULL,
  `APPLICACION_TIPO` int(11) DEFAULT NULL,
  `LOTE_ID` int(11) DEFAULT NULL,
  `CANT_HA` int(11) DEFAULT NULL,
  `FECHA_APLICACION` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
