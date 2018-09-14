CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(45) NOT NULL,
  `PSWD` varchar(128) NOT NULL,
  `MODIFICATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ROLE_ID` INT NOT NULL,
  `ACTIVE` BINARY(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_NAME_UNIQUE` (`USER_NAME`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
