-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema FINANZASDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `FINANZASDB` ;

-- -----------------------------------------------------
-- Schema FINANZASDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FINANZASDB` DEFAULT CHARACTER SET utf8 ;
USE `FINANZASDB` ;

-- -----------------------------------------------------
-- Table `FINANZASDB`.`TIPOUSUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FINANZASDB`.`TIPOUSUARIO` (
  `idTipoUsuario` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL,
  `detalle` VARCHAR(150) NULL,
  PRIMARY KEY (`idTipoUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FINANZASDB`.`USUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FINANZASDB`.`USUARIO` (
  `idUSUARIO` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `username` VARCHAR(45) NOT NULL,
  `contrasenia` VARCHAR(45) NOT NULL,
  `fechaNacimiento` DATE NULL,
  `sexo` TINYINT(1) NULL,
  `foto` MEDIUMBLOB NULL,
  `dni` CHAR(8) NULL,
  `eliminado` TINYINT(1) NULL,
  `idTipoUsuario` INT NOT NULL,
  `nombreFoto` VARCHAR(100) NULL,
  PRIMARY KEY (`idUSUARIO`),
  INDEX `fk_USUARIO_TIPOUSUARIO_idx` (`idTipoUsuario` ASC),
  CONSTRAINT `fk_USUARIO_TIPOUSUARIO`
    FOREIGN KEY (`idTipoUsuario`)
    REFERENCES `FINANZASDB`.`TIPOUSUARIO` (`idTipoUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FINANZASDB`.`AFP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FINANZASDB`.`AFP` (
  `idAFP` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL,
  `descripcion` VARCHAR(200) NULL,
  PRIMARY KEY (`idAFP`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FINANZASDB`.`TIPOCOMISION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FINANZASDB`.`TIPOCOMISION` (
  `idTIPOCOMISION` INT NOT NULL,
  `titulo` VARCHAR(45) NULL,
  `descripcion` VARCHAR(500) NULL,
  PRIMARY KEY (`idTIPOCOMISION`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FINANZASDB`.`TIPOFONDO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FINANZASDB`.`TIPOFONDO` (
  `idTIPOFONDO` INT NOT NULL,
  `titulo` VARCHAR(45) NULL,
  `detalle` VARCHAR(500) NULL,
  `isActivo` TINYINT(1) NULL,
  `mayorA` INT NULL,
  PRIMARY KEY (`idTIPOFONDO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FINANZASDB`.`TIPOFONDOXAFP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FINANZASDB`.`TIPOFONDOXAFP` (
  `idTIPOFONDO` INT NOT NULL,
  `idAFP` INT NOT NULL,
  `rentabilidadSugerida` DOUBLE NULL,
  PRIMARY KEY (`idTIPOFONDO`, `idAFP`),
  INDEX `fk_TIPOFONDO_has_AFP_AFP1_idx` (`idAFP` ASC),
  INDEX `fk_TIPOFONDO_has_AFP_TIPOFONDO1_idx` (`idTIPOFONDO` ASC),
  CONSTRAINT `fk_TIPOFONDO_has_AFP_TIPOFONDO1`
    FOREIGN KEY (`idTIPOFONDO`)
    REFERENCES `FINANZASDB`.`TIPOFONDO` (`idTIPOFONDO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TIPOFONDO_has_AFP_AFP1`
    FOREIGN KEY (`idAFP`)
    REFERENCES `FINANZASDB`.`AFP` (`idAFP`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FINANZASDB`.`TIPOCOMISIONXAFP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FINANZASDB`.`TIPOCOMISIONXAFP` (
  `idTIPOCOMISION` INT NOT NULL,
  `idAFP` INT NOT NULL,
  `comisionSaldo` DOUBLE NULL,
  `comisionFlujo` DOUBLE NULL,
  PRIMARY KEY (`idTIPOCOMISION`, `idAFP`),
  INDEX `fk_TIPOCOMISION_has_AFP_AFP1_idx` (`idAFP` ASC),
  INDEX `fk_TIPOCOMISION_has_AFP_TIPOCOMISION1_idx` (`idTIPOCOMISION` ASC),
  CONSTRAINT `fk_TIPOCOMISION_has_AFP_TIPOCOMISION1`
    FOREIGN KEY (`idTIPOCOMISION`)
    REFERENCES `FINANZASDB`.`TIPOCOMISION` (`idTIPOCOMISION`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TIPOCOMISION_has_AFP_AFP1`
    FOREIGN KEY (`idAFP`)
    REFERENCES `FINANZASDB`.`AFP` (`idAFP`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FINANZASDB`.`LICITACION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FINANZASDB`.`LICITACION` (
  `idLICITACION` INT NOT NULL,
  `fechaDesde` DATE NULL,
  `fechaHasta` DATE NULL,
  `detalle` VARCHAR(500) NULL,
  `urlDetalle` VARCHAR(100) NULL,
  `idAFP` INT NOT NULL,
  PRIMARY KEY (`idLICITACION`),
  INDEX `fk_LICITACION_AFP1_idx` (`idAFP` ASC),
  CONSTRAINT `fk_LICITACION_AFP1`
    FOREIGN KEY (`idAFP`)
    REFERENCES `FINANZASDB`.`AFP` (`idAFP`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FINANZASDB`.`SIMULACION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FINANZASDB`.`SIMULACION` (
  `idSIMULACION` INT NOT NULL,
  `fechaCreacion` DATE NULL,
  `idUSUARIO` INT NOT NULL,
  `alias` VARCHAR(200) NULL,
  PRIMARY KEY (`idSIMULACION`),
  INDEX `fk_SIMULACION_USUARIO1_idx` (`idUSUARIO` ASC),
  CONSTRAINT `fk_SIMULACION_USUARIO1`
    FOREIGN KEY (`idUSUARIO`)
    REFERENCES `FINANZASDB`.`USUARIO` (`idUSUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FINANZASDB`.`SIMULACIONHITO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FINANZASDB`.`SIMULACIONHITO` (
  `idAFP` INT NOT NULL,
  `idTIPOFONDO` INT NOT NULL,
  `idTIPOCOMISION` INT NOT NULL,
  `fecha` DATE NULL,
  `tasaAportacionMesual` DOUBLE NULL,
  `saldoFinal` DOUBLE NULL,
  `rentabilidad` DOUBLE NULL,
  `densidad` DOUBLE NULL,
  `descripcion` VARCHAR(500) NULL,
  `idSimulacionHito` INT NOT NULL AUTO_INCREMENT,
  `idSIMULACION` INT NOT NULL,
  INDEX `fk_AFP_has_SIMULACION_AFP1_idx` (`idAFP` ASC),
  INDEX `fk_AFP_has_SIMULACION_TIPOFONDO1_idx` (`idTIPOFONDO` ASC),
  INDEX `fk_AFP_has_SIMULACION_TIPOCOMISION1_idx` (`idTIPOCOMISION` ASC),
  PRIMARY KEY (`idSimulacionHito`),
  INDEX `fk_SIMULACIONHITO_SIMULACION1_idx` (`idSIMULACION` ASC),
  CONSTRAINT `fk_AFP_has_SIMULACION_AFP1`
    FOREIGN KEY (`idAFP`)
    REFERENCES `FINANZASDB`.`AFP` (`idAFP`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AFP_has_SIMULACION_TIPOFONDO1`
    FOREIGN KEY (`idTIPOFONDO`)
    REFERENCES `FINANZASDB`.`TIPOFONDO` (`idTIPOFONDO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AFP_has_SIMULACION_TIPOCOMISION1`
    FOREIGN KEY (`idTIPOCOMISION`)
    REFERENCES `FINANZASDB`.`TIPOCOMISION` (`idTIPOCOMISION`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SIMULACIONHITO_SIMULACION1`
    FOREIGN KEY (`idSIMULACION`)
    REFERENCES `FINANZASDB`.`SIMULACION` (`idSIMULACION`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `FINANZASDB`.`TIPOUSUARIO`
-- -----------------------------------------------------
START TRANSACTION;
USE `FINANZASDB`;
INSERT INTO `FINANZASDB`.`TIPOUSUARIO` (`idTipoUsuario`, `titulo`, `detalle`) VALUES (DEFAULT, 'administrador', 'Usuario con todos los accesos al sistema.');
INSERT INTO `FINANZASDB`.`TIPOUSUARIO` (`idTipoUsuario`, `titulo`, `detalle`) VALUES (DEFAULT, 'consumidor', 'Usuario que hace uso de la aplicacion basicamente para calculos.');

COMMIT;


-- -----------------------------------------------------
-- Data for table `FINANZASDB`.`USUARIO`
-- -----------------------------------------------------
START TRANSACTION;
USE `FINANZASDB`;
INSERT INTO `FINANZASDB`.`USUARIO` (`idUSUARIO`, `nombres`, `apellidos`, `username`, `contrasenia`, `fechaNacimiento`, `sexo`, `foto`, `dni`, `eliminado`, `idTipoUsuario`, `nombreFoto`)
VALUES (DEFAULT, 'admin', 'superadmin', 'admin', 'admin', '1995-8-07', 1, NULL, '76963852', 0, 1, NULL);


INSERT INTO `finanzasdb`.`afp`
(`idAFP`,
`titulo`,
`descripcion`)
VALUES
(DEFAULT,'AFP HABITAT','AFP Habitat es una administradora de fondos de pensiones chilena, creada en 1981 y una de las mayores del Perú por número de cotizantes'),
(DEFAULT,'AFP INTEGRA','AFP Integra administra un fondo de pensiones que asciende a más de 47 mil millones de nuevos soles y posee una cartera de más de dos millones de afiliados.'),
(DEFAULT,'AFP PRIMA',' Cuenta con más de un millón de afiliados y administra un fondo de más de 37 mil millones de nuevos soles. Es respaldada por el Grupo Crédito.'),
(DEFAULT,'PROFUTURO AFP','La corporación se conforma en el Perú por: Profuturo AFP, Scotiabank, Crediscotia, Scotia Fondos y Scotia Bolsa.');


INSERT INTO `finanzasdb`.`tipofondo`
(`idTIPOFONDO`,
`titulo`,
`detalle`,
`isActivo`,
`mayorA`)
VALUES
(1,'Protección de capital','Posee un nivel de riesgo muy bajo, recomendable para personas de una edad igual o mayor a 65 años. Para las personas mayores de 65 años, el cambio al Fondo 0 es obligatorio. Solo podrán cambiarse al Fondo 1 o Fondo 2 mediante carta firmada.',false,65),
(2,'Preservación de capital','Posee un nivel de riesgo bajo, recomendable para personas próximas a jubilarse o personas que no tengan tolerancia al riesgo, pues su Fondo es menos sensible ante los movimientos de la economía. Para las personas mayores de 60 años, el cambio al Fondo 1 es obligatorio. Solo podrán cambiarse al Fondo 2 realizando una declaración a través de una carta firmada y entregada a la AFP.',true,50),
(3,'Mixto o Balanceado','Posee un nivel de riesgo moderado, recomendable para personas de mediana edad, cuya fecha de jubilación aún es lejana.Su rendimiento podría ser superior al del Fondo 1 en el largo plazo.',true,30),
(4,'Apreciación de capital','Posee un nivel de riesgo alto, con un tiempo de inversión más largo. Recomendable para personas con capacidad económica sólida, tolerantes al riesgo y también para personas jóvenes, cuya fecha de jubilación es lejana. Su rendimiento podría ser superior al de los Fondos 1 y/o 2 en el largo plazo.',true,17);


INSERT INTO `finanzasdb`.`tipocomision`
(`idTIPOCOMISION`,
`titulo`,
`descripcion`)
VALUES
(1,'FLUJO','Se aplica sobre el flujo, es decir sobre el sueldo declarado.'),
(2,'MIXTA','Es una comisión que se aplica tanto sobre el saldo como al flujo(sueldo).');


COMMIT;

