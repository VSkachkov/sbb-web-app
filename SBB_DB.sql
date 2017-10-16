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
-- Table `SBB_DB`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Users` (
  `User_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `phone_Number` VARCHAR(12) NULL,
  `is_Admin` TINYINT NULL,
  PRIMARY KEY (`User_id`),
  UNIQUE INDEX `Passenger_id_UNIQUE` (`User_id` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Carriages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Carriages` (
  `Carriage_id` INT NOT NULL,
  `Carriage_Name` VARCHAR(45) NULL,
  `Seats` INT NOT NULL,
  `Carriage_price_rate` FLOAT NOT NULL,
  PRIMARY KEY (`Carriage_id`),
  UNIQUE INDEX `Carriage_id_UNIQUE` (`Carriage_id` ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`dynamic_pricing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`dynamic_pricing` (
  `day_price_id` INT NOT NULL,
  `day_low` INT NOT NULL,
  `day_high` INT NOT NULL,
  `price_rate` FLOAT NOT NULL,
  PRIMARY KEY (`day_price_id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Tickets` (
  `Ticket_id` INT NOT NULL AUTO_INCREMENT,
  `Passenger_id` INT NOT NULL,
  `Carriage_id` INT NOT NULL,
  `Buy_date` DATE NOT NULL,
  `day_price_rate` INT NULL,
  PRIMARY KEY (`Ticket_id`),
  INDEX `Passenger_id_idx` (`Passenger_id` ASC),
  INDEX `Carriage_id_idx` (`Carriage_id` ASC),
  INDEX `price_rate_key_idx` (`day_price_rate` ASC),
  CONSTRAINT `Passenger_id`
  FOREIGN KEY (`Passenger_id`)
  REFERENCES `SBB_DB`.`Users` (`User_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Carriage_id`
  FOREIGN KEY (`Carriage_id`)
  REFERENCES `SBB_DB`.`Carriages` (`Carriage_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `price_rate_key`
  FOREIGN KEY (`day_price_rate`)
  REFERENCES `SBB_DB`.`dynamic_pricing` (`day_price_id`)
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
-- Table `SBB_DB`.`train_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`train_types` (
  `train_type_id` INT NOT NULL,
  `Carriage_id` INT NOT NULL,
  `Carriage_Number` INT NOT NULL,
  PRIMARY KEY (`train_type_id`, `Carriage_Number`, `Carriage_id`),
  INDEX `Carriage_id_idx` (`Carriage_id` ASC),
  CONSTRAINT `Carriage_id_key`
  FOREIGN KEY (`Carriage_id`)
  REFERENCES `SBB_DB`.`Carriages` (`Carriage_id`)
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
  `train_type_id` INT NULL,
  PRIMARY KEY (`TrainNumber`),
  INDEX `train_type_id_idx` (`train_type_id` ASC),
  CONSTRAINT `train_type_id_key`
  FOREIGN KEY (`train_type_id`)
  REFERENCES `SBB_DB`.`train_types` (`train_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Railroad_Hauls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Railroad_Hauls` (
  `Haul_Id` INT NOT NULL AUTO_INCREMENT,
  `Station_One_ID` INT NOT NULL,
  `Station_Two_ID` INT NOT NULL,
  `price_index` FLOAT NOT NULL,
  PRIMARY KEY (`Haul_Id`),
  INDEX `Station_id_idx` (`Station_One_ID` ASC),
  INDEX `Station_id_idx1` (`Station_Two_ID` ASC),
  CONSTRAINT `Station_id_FK1`
  FOREIGN KEY (`Station_One_ID`)
  REFERENCES `SBB_DB`.`Stations` (`Station_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Station_id_FK2`
  FOREIGN KEY (`Station_Two_ID`)
  REFERENCES `SBB_DB`.`Stations` (`Station_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Reserve_seats`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Reserve_seats` (
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
  REFERENCES `SBB_DB`.`Railroad_Hauls` (`Haul_Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Ticket_id`
  FOREIGN KEY (`Ticket_id`)
  REFERENCES `SBB_DB`.`Tickets` (`Ticket_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
