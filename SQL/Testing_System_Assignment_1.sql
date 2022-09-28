-- xoá database nếu nó đang tồn tại
DROP DATABASE IF EXISTS Testing_System_Assignment_1;

-- tạo database
CREATE DATABASE Testing_System_Assignment_1;

-- sử dụng database  vừa tạo
USE Testing_System_Assignment_1;

-- xoá bảng nếu nó tồn tại
DROP TABLE IF EXISTS `Department`;	

-- tạo bảng
CREATE TABLE `Department` (
	DepartmentID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, -- AUTO_INCREMENT tự động tăng dần , TINYINT giới hạn từ -128 ~ 127, TINYINT UNSIaccountaccountGNED giới hạn từ 0~255
    DepartmentName		VARCHAR(50) NOT NULL UNIQUE KEY  -- NOT NULL không được để trống, UNIQUE key không được trùng nhau
);

DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position` (
	PositionID			TINYINT UNSIGNED AUTO_INCREMENT  PRIMARY KEY,
    PositionName		ENUM('Dev', 'Test', 'Scrum Master', 'PM')  NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
	AccountID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email				VARCHAR(50) NOT NULL UNIQUE KEY,
    Username			VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName			VARCHAR(50) NOT NULL,
    DepartmentID		TINYINT UNSIGNED ,
    PositionID			TINYINT UNSIGNED,
    CreateDate			DATE,
    
    FOREIGN KEY(DepartmentID) REFERENCES `Department`(DepartmentID),
	FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID)

);	

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group` (
	GroupID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName 			VARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID			TINYINT UNSIGNED,
    CreateDate			DATETIME
);	

DROP TABLE IF EXISTS `GroupAccount`;
CREATE TABLE `GroupAccount` (
	GroupID				TINYINT UNSIGNED,
    AccountID			TINYINT UNSIGNED,
    JoinDate			DATETIME,
    
    FOREIGN KEY(GroupID) REFERENCES `Group`(GroupID),
    FOREIGN KEY(AccountID) REFERENCES `Account`(AccountID)
);	

DROP TABLE IF EXISTS `TypeQuestion`;
CREATE TABLE `TypeQuestion` (
	TypeID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName			ENUM('Essay', 'Multiple-Choice') UNIQUE KEY
);	

DROP TABLE IF EXISTS `CategoryQuestion`;
CREATE TABLE `CategoryQuestion` (
	CategoryID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName		ENUM('Java', '.NET', 'SQL', 'Postman', 'Ruby') UNIQUE KEY
);

DROP TABLE IF EXISTS `Question`;
CREATE TABLE `Question` (
	QuestionID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content				VARCHAR(100),
    CategoryID			TINYINT UNSIGNED,
    TypeID				TINYINT UNSIGNED,
    CreatorID			TINYINT UNSIGNED,
    CreateDate			DATETIME,
    
    FOREIGN KEY(CategoryID) REFERENCES `CategoryQuestion`(CategoryID),
    FOREIGN KEY(TypeID) REFERENCES `TypeQuestion`(TypeID)
    );

DROP TABLE IF EXISTS `Answer`;
CREATE TABLE `Answer` (
	AnswerID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content				VARCHAR(100),
	QuestionID			TINYINT UNSIGNED,
    isCorrect			BOOLEAN,
    
    FOREIGN KEY(QuestionID) REFERENCES `Question`(QuestionID)
);

DROP TABLE IF EXISTS `Exam`;
CREATE TABLE `Exam` (
	ExamID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`				TINYINT UNSIGNED,
    Title				VARCHAR(50) NOT NULL UNIQUE KEY,
    CategoryID			TINYINT UNSIGNED,
    Duration			TINYINT UNSIGNED,
    CreatorID			TINYINT UNSIGNED,
    CreateDate			DATETIME,
    
    FOREIGN KEY(CategoryID) REFERENCES `CategoryQuestion`(CategoryID)
);

DROP TABLE IF EXISTS `ExamQuestion`;
CREATE TABLE `ExamQuestion` (
	ExamID				TINYINT UNSIGNED,
    QuestionID			TINYINT UNSIGNED,
    
    FOREIGN KEY(ExamID) REFERENCES `Exam`(ExamID),
    FOREIGN KEY(QuestionID) REFERENCES `Question`(QuestionID)
);
