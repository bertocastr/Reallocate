CREATE DATABASE reallocate;

GRANT ALL ON reallocate.* TO 'springappuser'@'%' IDENTIFIED BY 'pspringappuser';
GRANT ALL ON reallocate.* TO 'springappuser'@'localhost' IDENTIFIED BY 'pspringappuser';

FLUSH PRIVILEGES;

USE reallocate;

CREATE TABLE `Bank` (
	`idBank` INTEGER NOT NULL,
	PRIMARY KEY(`idBank`)
) ENGINE=INNODB;

CREATE TABLE `Office` (
	`name` varchar(20) NOT NULL,
	`street` varchar(30) NOT NULL,
	`phone` INTEGER NOT NULL,
	`zip` INTEGER NOT NULL,
	`bank_idbank` INTEGER NOT NULL,
	KEY (bank_idbank),
	`idOffice` varchar(20) NOT NULL,
	PRIMARY KEY(`idOffice`)
) ENGINE=INNODB;

CREATE TABLE `Employee` (
	`name` varchar(20) NOT NULL,
	`surname` varchar(20) NOT NULL,
	`address` varchar(30) NOT NULL,
	`salary` FLOAT(2) NOT NULL,
	`office_idoffice` varchar(20) NOT NULL,
	KEY (office_idoffice),
	`idemployee` varchar(20) NOT NULL,
	PRIMARY KEY(`idemployee`)
) ENGINE=INNODB;



ALTER TABLE `Employee` ADD CONSTRAINT `office_employee_employee_idemployee` FOREIGN KEY (`office_idoffice`) REFERENCES `Office`(`idOffice`) ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE `Office` ADD CONSTRAINT `office_bank_bank_idoffice` FOREIGN KEY (`bank_idbank`) REFERENCES `Bank`(`idBank`) ON DELETE NO ACTION ON UPDATE CASCADE;