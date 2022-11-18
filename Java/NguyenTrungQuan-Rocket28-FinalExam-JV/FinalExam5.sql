DROP DATABASE IF EXISTS FinalExam5;
CREATE DATABASE FinalExam5;
USE FinalExam5;

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`(
	`UserID` INT AUTO_INCREMENT PRIMARY KEY,
    `FullName` VARCHAR(100) NOT NULL,
    `Email` VARCHAR(100) UNIQUE NOT NULL,
    `Password` VARCHAR(100) NOT NULL,
    `TypeUser` ENUM('Admin','Employee','Manager') NOT NULL,
    `ExpInYear` INT NULL,
    `ProSkill` VARCHAR(100) NULL,
    `ProjectID` INT NULL
);

INSERT INTO `User` (`FullName`,`Email`,`Password`,`TypeUser`) 
VALUES 	('Nguyễn Trung Quân', 'taoquan178@gmail.com','12345Quan','Admin'),
		('Trần Thảo Yến', 'thaoyen178@gmail.com','12345Yen','Admin');

INSERT INTO `User` (`FullName`,`Email`,`Password`,`TypeUser`,`ProSkill`,`ProjectID`) 
VALUES 	('Nguyễn Trung Toàn', 'trungtoan123@gmail.com','12345Toan','Employee','SQL',2),
		('Nguyễn Trung Hiếu', 'trung hieu123@gmail.com','12345Hieu','Employee','Java',1);
        
INSERT INTO `User` (`FullName`,`Email`,`Password`,`TypeUser`,`ExpInYear`,`ProjectID`) 
VALUES 	('Trần Văn Phúc', 'vanphuc123@gmail.com','12345Phuc','Manager',4,1),
		('Lê Tuấn Anh', 'tuananh123@gmail.com','12345Anh','Manager',5,2);     

