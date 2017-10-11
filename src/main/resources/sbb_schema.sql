-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Railways
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Railways
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Railways` DEFAULT CHARACTER SET utf8 ;
USE `Railways` ;

-- -----------------------------------------------------
-- Table `Railways`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Railways`.`Users` (
  `User_id` INT NOT NULL AUTO_INCREMENT,
  `Pass_first_name` VARCHAR(45) NOT NULL,
  `Pass_last_name` VARCHAR(45) NOT NULL,
  `Birthday` DATE NOT NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `phone_Number` VARCHAR(12) NULL,
  `is_Admin` TINYINT NULL,
  PRIMARY KEY (`User_id`),
  UNIQUE INDEX `Passenger_id_UNIQUE` (`User_id` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Railways`.`Carriages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Railways`.`Carriages` (
  `Carriage_id` INT NOT NULL,
  `Carriage_Name` VARCHAR(45) NULL,
  `Seats` INT NOT NULL,
  PRIMARY KEY (`Carriage_id`),
  UNIQUE INDEX `Carriage_id_UNIQUE` (`Carriage_id` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Railways`.`Tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Railways`.`Tickets` (
  `Ticket_id` INT NOT NULL AUTO_INCREMENT,
  `Passenger_id` INT NULL,
  `Carriage_id` INT NULL,
  PRIMARY KEY (`Ticket_id`),
  INDEX `Passenger_id_idx` (`Passenger_id` ASC),
  INDEX `Carriage_id_idx` (`Carriage_id` ASC),
  CONSTRAINT `Passenger_id`
  FOREIGN KEY (`Passenger_id`)
  REFERENCES `Railways`.`Users` (`User_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Carriage_id`
  FOREIGN KEY (`Carriage_id`)
  REFERENCES `Railways`.`Carriages` (`Carriage_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Railways`.`Cantons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Railways`.`Cantons` (
  `Canton_id` INT NOT NULL,
  `Canton_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Canton_id`),
  UNIQUE INDEX `Canton_id_UNIQUE` (`Canton_id` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Railways`.`Stations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Railways`.`Stations` (
  `Station_id` INT NOT NULL AUTO_INCREMENT,
  `Station_name` VARCHAR(45) NOT NULL,
  `is_NODE` TINYINT NULL DEFAULT 0,
  `canton_id` INT NOT NULL,
  PRIMARY KEY (`Station_id`),
  UNIQUE INDEX `Station_id_UNIQUE` (`Station_id` ASC),
  INDEX `canton_ID_FK_idx` (`canton_id` ASC),
  CONSTRAINT `canton_ID_FK`
  FOREIGN KEY (`canton_id`)
  REFERENCES `Railways`.`Cantons` (`Canton_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Railways`.`train_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Railways`.`train_types` (
  `train_id_type` INT NOT NULL,
  `Carriage_id` INT NOT NULL,
  `Carriage_Number` INT NOT NULL,
  PRIMARY KEY (`train_id_type`, `Carriage_Number`, `Carriage_id`),
  INDEX `Carriage_id_idx` (`Carriage_id` ASC),
  CONSTRAINT `Carriage_id_key`
  FOREIGN KEY (`Carriage_id`)
  REFERENCES `Railways`.`Carriages` (`Carriage_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Railways`.`Trains`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Railways`.`Trains` (
  `TrainNumber` INT NOT NULL,
  `Train_Name` VARCHAR(45) NULL,
  `Depart_MON` TINYINT NULL,
  `Depart_TUE` TINYINT NULL,
  `Depart_WED` TINYINT NULL,
  `Depart_THU` TINYINT NULL,
  `Depart_FRI` TINYINT NULL,
  `Depart_SAT` TINYINT NULL,
  `Depart_SUN` TINYINT NULL,
  `train_type_id` INT NULL,
  PRIMARY KEY (`TrainNumber`),
  INDEX `train_type_id_idx` (`train_type_id` ASC),
  CONSTRAINT `train_type_id_key`
  FOREIGN KEY (`train_type_id`)
  REFERENCES `Railways`.`train_types` (`train_id_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Railways`.`Railroad_Hauls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Railways`.`Railroad_Hauls` (
  `Haul_Id` INT NOT NULL,
  `Station_One_ID` INT NULL,
  `Station_Two_ID` INT NULL,
  PRIMARY KEY (`Haul_Id`),
  INDEX `Station_id_idx` (`Station_One_ID` ASC),
  INDEX `Station_id_idx1` (`Station_Two_ID` ASC),
  CONSTRAINT `Station_id_FK1`
  FOREIGN KEY (`Station_One_ID`)
  REFERENCES `Railways`.`Stations` (`Station_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Station_id_FK2`
  FOREIGN KEY (`Station_Two_ID`)
  REFERENCES `Railways`.`Stations` (`Station_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Railways`.`Reserve_seats`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Railways`.`Reserve_seats` (
  `Run_id` INT NOT NULL,
  `Haul_id` INT NOT NULL,
  `Ticket_id` INT NOT NULL,
  `TrainNumber` INT NULL,
  `Delay` TIME NULL,
  `Day` DATE NULL,
  PRIMARY KEY (`Ticket_id`, `Haul_id`, `Run_id`),
  INDEX `Haul_id_idx` (`Haul_id` ASC),
  CONSTRAINT `Haul_id`
  FOREIGN KEY (`Haul_id`)
  REFERENCES `Railways`.`Railroad_Hauls` (`Haul_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Ticket_id`
  FOREIGN KEY (`Ticket_id`)
  REFERENCES `Railways`.`Tickets` (`Ticket_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Railways`.`Timetable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Railways`.`Timetable` (
  `TrainNumber` INT NOT NULL,
  `Station_id` INT NOT NULL,
  `Arrival` TIME NOT NULL,
  `Departure` TIME NOT NULL,
  PRIMARY KEY (`TrainNumber`, `Station_id`, `Departure`, `Arrival`),
  INDEX `Station_id_idx` (`Station_id` ASC),
  CONSTRAINT `TrainNumber`
  FOREIGN KEY (`TrainNumber`)
  REFERENCES `Railways`.`Trains` (`TrainNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Station_id`
  FOREIGN KEY (`Station_id`)
  REFERENCES `Railways`.`Stations` (`Station_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
