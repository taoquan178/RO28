-- xoá database nếu nó đang tồn tại
DROP DATABASE IF EXISTS Testing_System_Assignment_2;

-- tạo database
CREATE DATABASE Testing_System_Assignment_2;

-- sử dụng database  vừa tạo
USE Testing_System_Assignment_2;

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

INSERT INTO `Department` (DepartmentID, DepartmentName)
VALUES 					 (1,			N'sale'),
						 (2,			N'marketing'),
						 (3,			N'bảo vệ'),
						 (4,			N'nhân sự'),
						 (5,			N'kỹ thuật'),
						 (6,			N'tài chính'),
                         (7,			N'phó giám đốc'),
                         (8,			N'giám đốc'),
                         (9,			N'thư ký'),
                         (10,			N'bán hàng');

INSERT INTO `Position`	 (PositionID,	PositionName)
VALUES 					 (1,			N'Dev'),
						 (2,			N'Test'),
						 (3,			N'PM'),
						 (4,			N'Scrum Master');

INSERT INTO `Account` 	 (AccountID,	Email, 								Username, 		FullName, 					DepartmentID,		 PositionID,		 CreateDate)
VALUES 					 (1,			'taoquan178@gmail.com',				'quan',			N'Nguyễn Trung Quân',		'4',				 '1',				 '2021-03-05'),
						 (2,			'vanhieu111@gmail.com',				'hieu',			N'Nguyễn Văn Hiếu',			'2',				 '2',				 '2021-01-07'),
                         (3,			'trantoan4@gmail.com',				'toan',			N'Trần Đức Toàn',			'3',				 '3',				 '2021-02-09'),
                         (4,			'hien11@gmail.com',					'hien',			N'Nguyễn Thị Hiền',			'4',				 '4',				 '2021-02-09'),
						 (5,			'nam88@gmail.com',					'nam',			N'Nguyễn Văn Nam',			'1',				 '2',				 '2021-03-11'),
						 (6,			'ngothitruong55@gmail.com',			'truong',		N'Ngô Thị Trường',			'6',				 '1',				 '2021-03-12'),
						 (7,			'nguyenngocminh5556@gmail.com',		'minh',			N'Nguyễn Ngọc Minh',		'5',				 '1',				 '2021-04-22'),
                         (8,			'linh654@gmail.com',				'linh',			N'Nguyễn Diệu Linh',		'8',				 '4',				 '2021-04-22'),
                         (9,			'phuong671@gmail.com',				'phuong',		N'Nguyễn Thu Phương',		'10',				 '3',				 '2021-05-24'),
                         (10,			'duc654@gmail.com',					'duc',			N'Trần Minh Đức',			'9',				 '2',				 '2021-05-26');


INSERT INTO `Group` 	 (GroupID, 		GroupName, 			CreatorID, 			 CreateDate)
VALUES 					 (1,			N'Nhóm 1',			'1',				 '2021-06-06'),
						 (2,			N'nhóm 2',			'2',				 '2021-06-09'),
                         (3,			N'nhóm 3',			'3',				 '2021-06-12'),	
                         (4,			N'nhóm 4',			'4',				 '2021-06-16'),
						 (5,			N'nhóm 5',			'5',				 '2021-07-03'),
                         (6,			N'nhóm 6',			'6',				 '2021-07-04'),
                         (7,			N'nhóm 7',			'7',				 '2021-07-05'),
                         (8,			N'nhóm 8',			'8',				 '2021-08-01'),
                         (9,			N'nhóm 9',			'9',				 '2021-08-03'),
                         (10,			N'nhóm 10',			'10',				 '2021-08-03');

INSERT INTO `GroupAccount` 	 (GroupID, 		AccountID, 			 JoinDate)
VALUES 						 (1,			'1',				 '2021-06-10'),
						 	 (1,			'3',				 '2021-06-11'),
							 (2,			'2',				 '2021-09-12'),
							 (2,			'4',				 '2021-10-22'),
							 (3,			'7',				 '2021-07-12'),
							 (3,			'6',				 '2021-07-13'),
                             (4,			'5',				 '2021-07-05'),
                             (4,			'10',				 '2021-07-11'),
                             (5,			'9',				 '2021-07-05'),
                             (5,			'8',				 '2021-07-05');
                             
INSERT INTO `TypeQuestion`	 (TypeID,		TypeName)
VALUES 						 (1,			N'Essay'),
						 	 (2,			N'Multiple-Choice');

INSERT INTO `CategoryQuestion`	 (CategoryID,		CategoryName)
VALUES 							 (1,				N'Java'),
							 	 (2,				N'.NET'),
								 (3,				N'SQL'),
								 (4,				N'Postman'),
								 (5,				N'Ruby');

INSERT INTO `Question` 	 (QuestionID, 		Content, 						CategoryID, 		TypeID, 	 CreatorID,			 CreateDate)
VALUES 					 (1,				N'Câu hỏi Postman',				'4',				'1',		 '1',				 '2021-10-06'),
						 (2,				N'Câu hỏi SQL',					'3',				'2',		 '2',				 '2021-10-07'),
                         (3,				N'Câu hỏi SQL 2',				'3',				'1',		 '3',				 '2021-10-12'),
                         (4,				N'Câu hỏi Postman 2',			'4',				'1',		 '4',				 '2021-11-22'),
						 (5,				N'Câu hỏi Ruby',				'5',				'2',		 '5',				 '2021-11-22'),
						 (6,				N'Câu hỏi SQL 3',				'3',				'2',		 '6',				 '2021-11-23'),
						 (7,				N'Câu hỏi SQL 4',				'3',				'2',		 '7',				 '2021-11-24'),
                         (8,				N'Câu hỏi C++',					'2',				'1',		 '8',				 '2021-12-20'),
                         (9,				N'Câu hỏi Java', 				'1',				'1',		 '9',				 '2021-12-21'),
                         (10,				N'Câu hỏi .NET',				'2',				'1',		 '10',				 '2021-12-22');

INSERT INTO `Answer` 	 (AnswerID, 	Content, 							QuestionID, 		 isCorrect)
VALUES 					 (1,			N'Câu trả lời 1',					'3',				 FALSE),
						 (2,			N'Câu trả lời 2',					'2',				 TRUE),
                         (3,			N'Câu trả lời 3',					'8',				 FALSE),	
                         (4,			N'Câu trả lời 4',					'6',				 TRUE),
						 (5,			N'Câu trả lời 5',					'9',				 FALSE),
                         (6,			N'Câu trả lời 6',					'7',				 TRUE),
                         (7,			N'Câu trả lời 7',					'1',				 TRUE),
                         (8,			N'Câu trả lời 8',					'10',				 FALSE),
                         (9,			N'Câu trả lời 9',					'5',				 FALSE),
                         (10,			N'Câu trả lời 10',					'4',				 TRUE);
                         
INSERT INTO `Exam` 		 (ExamID,		`Code`, 			Title, 						CategoryID, 		Duration,			 CreatorID,			 CreateDate)
VALUES 					 (1,			'1',				N'Kiểm Tra Java',			'1',				'60',				 '1',				 '2020-01-01'),
						 (2,			'2',				N'Kiểm Tra .NET',			'4',				'60',				 '2',				 '2020-01-02'),
                         (3,			'3',				N'Kiểm Tra SQL',			'5',				'60',				 '3',				 '2020-01-03'),
                         (4,			'4',				N'Kiểm Tra Postman',		'2',				'60',				 '4',				 '2020-01-04'),
						 (5,			'5',				N'Kiểm Tra Ruby',			'3',				'60',				 '5',				 '2020-01-05'),
                         (6,			'6',				N'Kiểm Tra C++',			'4',				'60',				 '6',				 '2020-01-06'),
                         (7,			'7',				N'Kiểm Tra C#',				'1',				'60',				 '7',				 '2020-01-07'),
                         (8,			'8',				N'Kiểm Tra JavaScript',		'2',				'60',				 '8',				 '2020-01-08'),
                         (9,			'9',				N'Kiểm Tra VR',				'3',				'60',				 '9',				 '2020-01-09'),
                         (10,			'10',				N'Kiểm Tra React JS',		'5',				'60',				 '10',				 '2020-01-10');


INSERT INTO `ExamQuestion`	 (ExamID,		QuestionID)
VALUES 						 (1,			'9'),
						 	 (2,			'10'),
                             (3,			'6'),
                             (4,			'1'),
                             (5,			'2'),
                             (6,			'3'),
                             (7,			'5'),
                             (8,			'4'),
                             (9,			'7'),
                             (10,			'8');
