-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SBB_DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SBB_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SBB_DB` DEFAULT CHARACTER SET utf8 ;
USE `SBB_DB` ;

-- -----------------------------------------------------
-- Table `SBB_DB`.`ROLE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`ROLE` (
  `Role_id` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Role_id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Users` (
  `User_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `phone_Number` VARCHAR(12) NULL,
  `Role_id` INT NOT NULL,
  PRIMARY KEY (`User_id`),
  UNIQUE INDEX `Passenger_id_UNIQUE` (`User_id` ASC),
  INDEX `Role_id_fk_idx` (`Role_id` ASC),
  CONSTRAINT `Role_id_fk`
  FOREIGN KEY (`Role_id`)
  REFERENCES `SBB_DB`.`ROLE` (`Role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Cantons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Cantons` (
  `Canton_id` INT NOT NULL AUTO_INCREMENT,
  `Canton_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Canton_id`),
  UNIQUE INDEX `Canton_id_UNIQUE` (`Canton_id` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Stations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Stations` (
  `Station_id` INT NOT NULL,
  `Station_name` VARCHAR(45) NOT NULL,
  `is_NODE` TINYINT NULL DEFAULT 0,
  `canton_id` INT NOT NULL,
  PRIMARY KEY (`Station_id`),
  UNIQUE INDEX `Station_id_UNIQUE` (`Station_id` ASC),
  INDEX `canton_ID_FK_idx` (`canton_id` ASC),
  CONSTRAINT `canton_ID_FK`
  FOREIGN KEY (`canton_id`)
  REFERENCES `SBB_DB`.`Cantons` (`Canton_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Trains`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Trains` (
  `TrainNumber` INT NOT NULL,
  `Train_Name` VARCHAR(45) NULL,
  `Depart_MON` TINYINT NULL,
  `Depart_TUE` TINYINT NULL,
  `Depart_WED` TINYINT NULL,
  `Depart_THU` TINYINT NULL,
  `Depart_FRI` TINYINT NULL,
  `Depart_SAT` TINYINT NULL,
  `Depart_SUN` TINYINT NULL,
  `Capacity` INT NULL,
  PRIMARY KEY (`TrainNumber`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Timetable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Timetable` (
  `Timetable_id` INT NOT NULL,
  `TrainNumber` INT NOT NULL,
  `Station_id` INT NOT NULL,
  `Arrival` TIME NULL,
  `Departure` TIME NULL,
  PRIMARY KEY (`Timetable_id`),
  INDEX `Station_id_idx` (`Station_id` ASC),
  UNIQUE INDEX `timetable_unique` (`TrainNumber` ASC, `Station_id` ASC),
  CONSTRAINT `TrainNumber`
  FOREIGN KEY (`TrainNumber`)
  REFERENCES `SBB_DB`.`Trains` (`TrainNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Station_id`
  FOREIGN KEY (`Station_id`)
  REFERENCES `SBB_DB`.`Stations` (`Station_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Reserve_seats`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Reserve_seats` (
  `reserve_id` INT NOT NULL,
  `User_id` INT NOT NULL,
  `TrainNumber` INT NOT NULL,
  `Travel_date` DATE NOT NULL,
  `Timetable_id` INT NOT NULL,
  PRIMARY KEY (`reserve_id`),
  INDEX `Train_number_FK_idx` (`TrainNumber` ASC),
  INDEX `Timetable_id_fk_idx` (`Timetable_id` ASC),
  INDEX `User_id_fk_idx` (`User_id` ASC),
  CONSTRAINT `Train_number_FK`
  FOREIGN KEY (`TrainNumber`)
  REFERENCES `SBB_DB`.`Trains` (`TrainNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Timetable_id_fk`
  FOREIGN KEY (`Timetable_id`)
  REFERENCES `SBB_DB`.`Timetable` (`Timetable_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `User_id_fk`
  FOREIGN KEY (`User_id`)
  REFERENCES `SBB_DB`.`Users` (`User_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
