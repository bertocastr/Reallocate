CREATE DATABASE reallocate

GRANT ALL ON reallocate.* TO reallocate@'%' IDIENTIFIED BY 'bertocastr'
GRANT ALL ON reallocate.* TO reallocate@localhost IDIENTIFIED BY 'bertocastr'

USE reallocate;

CREATE TABLE `Employee` (
	`name` TEXT NOT NULL,
	`surname` TEXT NOT NULL,
	`address` TEXT NOT NULL,
	`salary` FLOAT(2) NOT NULL,
	`idoffice` TEXT NOT NULL,
	`idemployee` TEXT NOT NULL,
	PRIMARY KEY(`idemployee`)
) ENGINE=INNODB;
CREATE TABLE `Office` (
	`employee_idemployee` TEXT NOT NULL,
	KEY(`employee_idemployee`),
	`name` TEXT NOT NULL,
	`street` TEXT NOT NULL,
	`phone` INTEGER NOT NULL,
	`zip` INTEGER NOT NULL,
	`id` TEXT NOT NULL,
	PRIMARY KEY(`employee_idemployee`,`id`)
) ENGINE=INNODB;
CREATE TABLE `Bank` (
	`id` INTEGER NOT NULL,
	PRIMARY KEY(`id`)
) ENGINE=INNODB;


ALTER TABLE `Office` ADD CONSTRAINT `office_employee_employee_idemployee` FOREIGN KEY (`employee_idemployee`) REFERENCES `Employee`(`idemployee`) ON DELETE NO ACTION ON UPDATE CASCADE;