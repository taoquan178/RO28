DROP DATABASE IF EXISTS Extra_Assignment_1_2_VN;
CREATE DATABASE Extra_Assignment_1_2_VN;
USE Extra_Assignment_1_2_VN;

-- Exercise 1:Design a table
DROP TABLE IF EXISTS `Trainee`;
CREATE TABLE `Trainee` (
	TraineeID			SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    Full_Name			VARCHAR(100) NOT NULL,
    Birth_Date			DATE NOT NULL,
    Gender				ENUM('Male','Female','Unknown') NOT NULL UNIQUE KEY,
    ET_IQ				SMALLINT UNSIGNED NOT NULL CHECK (ET_IQ >= 0 AND ET_IQ <=20 ),
    ET_Gmath			SMALLINT UNSIGNED NOT NULL CHECK (ET_Gmath >= 0 AND ET_Gmath <= 20),
    ET_English			SMALLINT UNSIGNED NOT NULL CHECK (ET_English >= 50 AND ET_English <= 50),
    Training_Class		SMALLINT UNSIGNED NOT NULL,
    Evaluation_Notes	TEXT
);

ALTER TABLE `Trainee`
ADD VTI_Account	VARCHAR(255) NOT NULL UNIQUE KEY;

-- Exercise 2: Data Types
DROP TABLE IF EXISTS `TraineeOne`;
CREATE TABLE `TraineeOne`(
	TraineeOneID		SMALLINT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    TraineeOneName		VARCHAR(100) NOT NULL,
    `Code`				VARCHAR(100) NOT NULL UNIQUE KEY,
    ModifiedDate		DATETIME DEFAULT NOW()
);

DROP TABLE IF EXISTS `TraineeTwo`;
CREATE TABLE `TraineeTwo`(
	TraineeTwoID 		SMALLINT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    TraineeTwoName		VARCHAR(100) NOT NULL,
    BirthDate			DATE NOT NULL,
    Gender				ENUM('Male','Female','NULL'),
    IsDeletedFlag		bit
);