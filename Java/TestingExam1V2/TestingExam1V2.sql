DROP DATABASE IF EXISTS  TestingExam1v2;
CREATE DATABASE TestingExam1v2;
USE TestingExam1v2;

DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER`(
	`UserID` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `FullName` VARCHAR(100) NOT NULL,
    `Email` VARCHAR(100) NOT NULL UNIQUE,
    `Password` VARCHAR(100) NOT NULL,
    `TypeUser` ENUM('Admin','Employee') NOT NULL,
    `ExpInYear`  VARCHAR(100) NULL,
    `ProSkill` VARCHAR(100) NULL
);

INSERT INTO `User`(`FullName`, `Email`, `Password`, `TypeUser`, `ExpInYear`, `ProSkill`)
VALUE	('Nguyễn Trung Quân', 'taoquan178@gmail.com', '12345Quan', 'Admin', 5, ''),
		('Nguyễn Trung Hiếu', 'hieu458@gmail.com', '12345Hieu', 'Employee', '', 'SQL'),
        ('Nguyễn Trung Nam', 'nam123@gmail.com', '12345Nam', 'Employee', '', 'Java');
        
