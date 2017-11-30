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
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `Role_id_fk_idx` (`Role_id` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
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
  `canton_id` INT NOT NULL,
  `Lattitude` FLOAT NULL,
  `Longitude` FLOAT NULL,
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
-- Table `SBB_DB`.`train_types_numbers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`train_types_numbers` (
  `train_types_number_id` INT NOT NULL,
  `train_type_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`train_types_number_id`))
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
  `train_type_number` INT NULL,
  PRIMARY KEY (`TrainNumber`),
  INDEX `train_type_num_fk_idx` (`train_type_number` ASC),
  CONSTRAINT `train_type_number_fk`
  FOREIGN KEY (`train_type_number`)
  REFERENCES `SBB_DB`.`train_types_numbers` (`train_types_number_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Reserve_seats`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Reserve_seats` (
  `Reserve_id` INT NOT NULL,
  `TrainNumber` INT NOT NULL,
  `Travel_date` DATE NOT NULL,
  `station_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`Reserve_id`),
  INDEX `Train_number_FK_idx` (`TrainNumber` ASC),
  INDEX `user_id_fk_idx` (`user_id` ASC),
  INDEX `station_id_fk_idx` (`station_id` ASC),
  CONSTRAINT `Train_number_FK`
  FOREIGN KEY (`TrainNumber`)
  REFERENCES `SBB_DB`.`Trains` (`TrainNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_id_fk`
  FOREIGN KEY (`user_id`)
  REFERENCES `SBB_DB`.`Users` (`User_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `station_id_fk`
  FOREIGN KEY (`station_id`)
  REFERENCES `SBB_DB`.`Stations` (`Station_id`)
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


-- -----------------------------------------------------
-- Table `SBB_DB`.`Carriages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Carriages` (
  `car_id` INT NOT NULL,
  `car_name` VARCHAR(45) NULL,
  `Seats` INT NOT NULL DEFAULT 0,
  `car_price_rate` FLOAT NOT NULL DEFAULT 1,
  PRIMARY KEY (`car_id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Train_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Train_types` (
  `train_type_id` INT NOT NULL,
  `Car_id` INT NOT NULL,
  `car_number` INT NULL,
  `train_type_name` VARCHAR(45) NULL,
  PRIMARY KEY (`train_type_id`, `Car_id`),
  INDEX `car_id_fk_idx` (`Car_id` ASC),
  CONSTRAINT `car_id_fk`
  FOREIGN KEY (`Car_id`)
  REFERENCES `SBB_DB`.`Carriages` (`car_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `train_type_num_fk`
  FOREIGN KEY (`train_type_id`)
  REFERENCES `SBB_DB`.`train_types_numbers` (`train_types_number_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Sections`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Sections` (
  `section_id` INT NOT NULL,
  `Station_from_id` INT NOT NULL,
  `Station_to_id` INT NOT NULL,
  `Length` FLOAT NOT NULL,
  PRIMARY KEY (`section_id`),
  INDEX `station_from_fk_idx` (`Station_from_id` ASC),
  INDEX `station_to_fk_idx` (`Station_to_id` ASC),
  CONSTRAINT `station_from_fk`
  FOREIGN KEY (`Station_from_id`)
  REFERENCES `SBB_DB`.`Stations` (`Station_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `station_to_fk`
  FOREIGN KEY (`Station_to_id`)
  REFERENCES `SBB_DB`.`Stations` (`Station_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Routes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Routes` (
  `Route_id` INT NOT NULL,
  `Section_id` INT NOT NULL,
  `Train_number` INT NOT NULL,
  `Departure` TIME NOT NULL,
  `Arrival` TIME NOT NULL,
  PRIMARY KEY (`Route_id`),
  INDEX `section_fk_idx` (`Section_id` ASC),
  INDEX `train_id_fk_idx` (`Train_number` ASC),
  CONSTRAINT `section_fk`
  FOREIGN KEY (`Section_id`)
  REFERENCES `SBB_DB`.`Sections` (`section_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `train_id_fk`
  FOREIGN KEY (`Train_number`)
  REFERENCES `SBB_DB`.`Trains` (`TrainNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`seats_left_rate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`seats_left_rate` (
  `seat_left_id` INT NOT NULL,
  `seats_left_low` FLOAT NOT NULL,
  `seats_left_high` FLOAT NOT NULL,
  `seats_left_rate` FLOAT NOT NULL,
  PRIMARY KEY (`seat_left_id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`age_rate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`age_rate` (
  `age_rate_id` INT NOT NULL,
  `age_low` INT NOT NULL,
  `age_high` INT NOT NULL,
  `age_rate` FLOAT NOT NULL,
  PRIMARY KEY (`age_rate_id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`season_rates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`season_rates` (
  `season_rate_id` INT NOT NULL,
  `date_low` INT NOT NULL,
  `date_high` INT NOT NULL,
  `season_rate` FLOAT NOT NULL,
  PRIMARY KEY (`season_rate_id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`days_before_rate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`days_before_rate` (
  `days_before_id` INT NOT NULL,
  `days_low` INT NOT NULL,
  `days_high` INT NOT NULL,
  `days_before_rate` FLOAT NOT NULL,
  PRIMARY KEY (`days_before_id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`total_rate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`total_rate` (
  `total_rate_id` INT NOT NULL,
  `season_rate_id` INT NOT NULL,
  `days_before_rate_id` INT NOT NULL,
  `age_rate_id` INT NOT NULL,
  `seats_left_rate_id` INT NOT NULL,
  PRIMARY KEY (`total_rate_id`),
  INDEX `seats_left_fk_idx` (`seats_left_rate_id` ASC),
  INDEX `age_fk_idx` (`age_rate_id` ASC),
  INDEX `season_fk_idx` (`season_rate_id` ASC),
  INDEX `days_before_fk_idx` (`days_before_rate_id` ASC),
  CONSTRAINT `seats_left_fk`
  FOREIGN KEY (`seats_left_rate_id`)
  REFERENCES `SBB_DB`.`seats_left_rate` (`seat_left_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `age_fk`
  FOREIGN KEY (`age_rate_id`)
  REFERENCES `SBB_DB`.`age_rate` (`age_rate_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `season_fk`
  FOREIGN KEY (`season_rate_id`)
  REFERENCES `SBB_DB`.`season_rates` (`season_rate_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `days_before_fk`
  FOREIGN KEY (`days_before_rate_id`)
  REFERENCES `SBB_DB`.`days_before_rate` (`days_before_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Reserves`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Reserves` (
  `reserve_id` INT NOT NULL,
  `route_id` INT NOT NULL,
  `Travel_date` DATE NOT NULL,
  `user_id` INT NOT NULL,
  `car_id` INT NOT NULL,
  `total_price_rate` FLOAT NOT NULL,
  `total_rate_id` INT NULL,
  PRIMARY KEY (`reserve_id`),
  INDEX `route_id_fk_idx` (`route_id` ASC),
  INDEX `carriage_id_fk_idx` (`car_id` ASC),
  INDEX `passenger_fk_idx` (`user_id` ASC),
  INDEX `total_rate_fk_idx` (`total_rate_id` ASC),
  CONSTRAINT `route_id_fk`
  FOREIGN KEY (`route_id`)
  REFERENCES `SBB_DB`.`Routes` (`Route_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `carriage_id_fk`
  FOREIGN KEY (`car_id`)
  REFERENCES `SBB_DB`.`Carriages` (`car_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `passenger_fk`
  FOREIGN KEY (`user_id`)
  REFERENCES `SBB_DB`.`Users` (`User_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `total_rate_fk`
  FOREIGN KEY (`total_rate_id`)
  REFERENCES `SBB_DB`.`total_rate` (`total_rate_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Tickets` (
  `Ticket_id` INT NOT NULL,
  `total_price_rate` FLOAT NOT NULL,
  `user_id` INT NOT NULL,
  `Buy_date` DATE NOT NULL,
  `total_rate_id` INT NULL,
  PRIMARY KEY (`Ticket_id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Train_changes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Train_changes` (
  `change_id` INT NOT NULL,
  `trainNumber` INT NOT NULL,
  `travelDate` DATE NOT NULL,
  `Status` VARCHAR(45) NULL,
  `Delay` TIME NULL,
  PRIMARY KEY (`change_id`),
  INDEX `train_num_fk_idx` (`trainNumber` ASC),
  CONSTRAINT `train_num_fk`
  FOREIGN KEY (`trainNumber`)
  REFERENCES `SBB_DB`.`Trains` (`TrainNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SBB_DB`.`Token`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SBB_DB`.`Token` (
  `series` VARCHAR(50) NOT NULL,
  `value` VARCHAR(50) NULL,
  `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ip_address` VARCHAR(50) NULL,
  `user_agent` VARCHAR(200) NULL,
  `user_login` VARCHAR(50) NULL,
  PRIMARY KEY (`series`))
  ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
