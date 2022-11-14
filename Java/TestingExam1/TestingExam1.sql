DROP DATABASE IF EXISTS TestingExam1;
CREATE DATABASE TestingExam1;
USE TestingExam1;

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`(
	UserID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    FullName VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE KEY NOT NULL,
    `Password` VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS `Admin`;
CREATE TABLE `Admin`(
	ExpInYear TINYINT UNSIGNED NOT NULL,
    UserID INT UNSIGNED NOT NULL,
	FOREIGN KEY(UserID) REFERENCES `User`(UserID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `Employee`;
CREATE TABLE `Employee`(
	ProSkill VARCHAR(100),
    UserID INT UNSIGNED NOT NULL,
    FOREIGN KEY(UserID) REFERENCES `User`(UserID) ON DELETE CASCADE
);

INSERT INTO `User`(FullName,	Email,	`Password`)
VALUE	('Nguyễn Trung Quân', 'taoquan178@gmail.com', '12346Quan'),
		('Nguyễn Trung Quân1', 'taoquan179@gmail.com', '12346Quan1'),
        ('Nguyễn Trung Quân2', 'taoquan180@gmail.com', '12346Quan2');

INSERT INTO `Admin`(ExpInYear,	UserID)
VALUE	(2, 1);


INSERT INTO `Employee`(ProSkill,	UserID)
VALUE	('Java',2),
        ('Ruby',3);
        
SELECT * FROM `User` T1 JOIN `Admin` T2 ON T1.UserID = T2.UserID ORDER BY T1.UserID;

SELECT * FROM `User` T1 JOIN `Employee` T2 ON T1.UserID = T2.UserID ORDER BY T1.UserID;

SELECT T1.UserID, T1.FullName, T1.Email, T1.`Password`, T2.ExpInYear, T3.ProSkill
FROM `User` T1
LEFT JOIN `Admin` T2 ON T2.UserID = T1.UserID
LEFT JOIN `Employee` T3 ON T3.UserID = T1.UserID;

SELECT * FROM `Employee`;
DELETE FROM `User` WHERE UserID = 2;