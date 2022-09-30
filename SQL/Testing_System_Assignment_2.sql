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
	DepartmentID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, -- AUTO_INCREMENT tự động tăng dần , TINYINT giới hạn từ -128 ~ 127, TINYINT UNSIGNED giới hạn từ 0~255
    DepartmentName		VARCHAR(50) NOT NULL UNIQUE KEY  -- NOT NULL không được để trống, UNIQUE KEY không được có 2 dữ liệu trùng nhau
);

DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position` (
	PositionID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName		ENUM('Dev', 'Test', 'Scrum Master', 'PM')  NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
	AccountID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email				VARCHAR(50) NOT NULL UNIQUE KEY,
    Username			VARCHAR(50) NOT NULL,
    FullName			VARCHAR(100) NOT NULL,
    DepartmentID		TINYINT UNSIGNED NOT NULL,
    PositionID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW(),
    FOREIGN KEY(DepartmentID) REFERENCES `Department`(DepartmentID),
	FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID)
);	

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group` (
	GroupID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName 			VARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW()
);	

DROP TABLE IF EXISTS `GroupAccount`;
CREATE TABLE `GroupAccount` (
	GroupID				TINYINT UNSIGNED NOT NULL,
    AccountID			TINYINT UNSIGNED NOT NULL,
    JoinDate			DATETIME DEFAULT NOW(),
    FOREIGN KEY(GroupID) REFERENCES `Group`(GroupID),
    FOREIGN KEY(AccountID) REFERENCES `Account`(AccountID)
);	

DROP TABLE IF EXISTS `TypeQuestion`;
CREATE TABLE `TypeQuestion` (
	TypeID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName			ENUM('Essay', 'Multiple-Choice') NOT NULL UNIQUE KEY
);	

DROP TABLE IF EXISTS `CategoryQuestion`;
CREATE TABLE `CategoryQuestion` (
	CategoryID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName		ENUM('Java', '.NET', 'SQL', 'Postman', 'Ruby') NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `Question`;
CREATE TABLE `Question` (
	QuestionID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content				VARCHAR(100) NOT NULL,
    CategoryID			TINYINT UNSIGNED NOT NULL,
    TypeID				TINYINT UNSIGNED NOT NULL,
    CreatorID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES `CategoryQuestion`(CategoryID),
    FOREIGN KEY(TypeID) REFERENCES `TypeQuestion`(TypeID)
    );

DROP TABLE IF EXISTS `Answer`;
CREATE TABLE `Answer` (
	AnswerID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content				VARCHAR(100) NOT NULL,
	QuestionID			TINYINT UNSIGNED NOT NULL,
    isCorrect			BOOLEAN NOT NULL,
    FOREIGN KEY(QuestionID) REFERENCES `Question`(QuestionID)
);

DROP TABLE IF EXISTS `Exam`;
CREATE TABLE `Exam` (
	ExamID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`				TINYINT UNSIGNED NOT NULL,
    Title				VARCHAR(50) NOT NULL UNIQUE KEY,
    CategoryID			TINYINT UNSIGNED NOT NULL,
    Duration			TINYINT UNSIGNED NOT NULL,
    CreatorID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES `CategoryQuestion`(CategoryID)
);

DROP TABLE IF EXISTS `ExamQuestion`;
CREATE TABLE `ExamQuestion` (
	ExamID				TINYINT UNSIGNED NOT NULL,
    QuestionID			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(ExamID) REFERENCES `Exam`(ExamID),
    FOREIGN KEY(QuestionID) REFERENCES `Question`(QuestionID)
);

INSERT INTO `Department` (DepartmentName)
VALUES 					 ('Sale'),
						 ('Marketing'),
						 ('Bảo vệ'),
						 ('Nhân sự'),
						 ('Kỹ thuật'),
						 ('Tài chính'),
                         ('Phó giám đốc'),
                         ('Giám đốc'),
                         ('Thư ký'),
                         ('Bán hàng');

INSERT INTO `Position`	 (PositionName)
VALUES 					 ('Dev'),
						 ('Test'),
						 ('PM'),
						 ('Scrum Master');

INSERT INTO `Account` 	 (Email, 								Username, 		FullName, 					DepartmentID,		 PositionID,		 CreateDate)
VALUES 					 ('taoquan178@gmail.com',				'quan',			'Nguyễn Trung Quân',		'4',				 '1',				 '2021-03-05'),
						 ('vanhieu111@gmail.com',				'hieu',			'Nguyễn Văn Hiếu',			'2',				 '2',				 '2021-01-07'),
                         ('trantoan4@gmail.com',				'toan',			'Trần Đức Toàn',			'3',				 '3',				 '2021-02-09'),
                         ('hien11@gmail.com',					'hien',			'Nguyễn Thị Hiền',			'4',				 '4',				 '2021-02-09'),
						 ('nam88@gmail.com',					'nam',			'Nguyễn Văn Nam',			'1',				 '2',				 '2021-03-11'),
						 ('ngothitruong55@gmail.com',			'truong',		'Ngô Thị Trường',			'6',				 '1',				 '2021-03-12'),
						 ('nguyenngocminh5556@gmail.com',		'minh',			'Nguyễn Ngọc Minh',			'5',				 '1',				 '2021-04-22'),
                         ('linh654@gmail.com',					'linh',			'Nguyễn Diệu Linh',			'8',				 '4',				 '2021-04-22'),
                         ('phuong671@gmail.com',				'phuong',		'Nguyễn Thu Phương',		'10',				 '3',				 '2021-05-24'),
                         ('duc654@gmail.com',					'duc',			'Trần Minh Đức',			'9',				 '2',				 '2021-05-26');


INSERT INTO `Group` 	 (GroupName, 			CreatorID, 			 CreateDate)
VALUES 					 ('Nhóm 1',			'1',				 '2021-06-06'),
						 ('nhóm 2',			'2',				 '2021-06-09'),
                         ('nhóm 3',			'3',				 '2021-06-12'),	
                         ('nhóm 4',			'4',				 '2021-06-16'),
						 ('nhóm 5',			'5',				 '2021-07-03'),
                         ('nhóm 6',			'6',				 '2021-07-04'),
                         ('nhóm 7',			'7',				 '2021-07-05'),
                         ('nhóm 8',			'8',				 '2021-08-01'),
                         ('nhóm 9',			'9',				 '2021-08-03'),
                         ('nhóm 10',		'10',				 '2021-08-03');

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

INSERT INTO `TypeQuestion`	 (TypeName)
VALUES 						 ('Essay'),
						 	 ('Multiple-Choice');

INSERT INTO `CategoryQuestion`	 (CategoryName)
VALUES 							 ('Java'),
							 	 ('.NET'),
								 ('SQL'),
								 ('Postman'),
								 ('Ruby');

INSERT INTO `Question` 	 (Content, 						CategoryID, 		TypeID, 	 CreatorID,			 CreateDate)
VALUES 					 ('Câu hỏi Postman',				'4',				'1',		 '1',				 '2021-10-06'),
						 ('Câu hỏi SQL',					'3',				'2',		 '2',				 '2021-10-07'),
                         ('Câu hỏi SQL 2',					'3',				'1',		 '3',				 '2021-10-12'),
                         ('Câu hỏi Postman 2',				'4',				'1',		 '4',				 '2021-11-22'),
						 ('Câu hỏi Ruby',					'5',				'2',		 '5',				 '2021-11-22'),
						 ('Câu hỏi SQL 3',					'3',				'2',		 '6',				 '2021-11-23'),
						 ('Câu hỏi SQL 4',					'3',				'2',		 '7',				 '2021-11-24'),
                         ('Câu hỏi C++',					'2',				'1',		 '8',				 '2021-12-20'),
                         ('Câu hỏi Java', 					'1',				'1',		 '9',				 '2021-12-21'),
                         ('Câu hỏi .NET',					'2',				'1',		 '10',				 '2021-12-22');

INSERT INTO `Answer` 	 (Content, 							QuestionID, 		 isCorrect)
VALUES 					 ('Câu trả lời 1',					'3',				 FALSE),
						 ('Câu trả lời 2',					'2',				 TRUE),
                         ('Câu trả lời 3',					'8',				 FALSE),	
                         ('Câu trả lời 4',					'6',				 TRUE),
						 ('Câu trả lời 5',					'9',				 FALSE),
                         ('Câu trả lời 6',					'7',				 TRUE),
                         ('Câu trả lời 7',					'1',				 TRUE),
                         ('Câu trả lời 8',					'10',				 FALSE),
                         ('Câu trả lời 9',					'5',				 FALSE),
                         ('Câu trả lời 10',					'4',				 TRUE);
                         
INSERT INTO `Exam` 		 (`Code`, 			Title, 						CategoryID, 		Duration,			 CreatorID,			 CreateDate)
VALUES 					 ('1',				'Kiểm Tra Java',			'1',				'60',				 '1',				 '2020-01-01'),
						 ('2',				'Kiểm Tra .NET',			'4',				'60',				 '2',				 '2020-01-02'),
                         ('3',				'Kiểm Tra SQL',				'5',				'60',				 '3',				 '2020-01-03'),
                         ('4',				'Kiểm Tra Postman',			'2',				'60',				 '4',				 '2020-01-04'),
						 ('5',				'Kiểm Tra Ruby',			'3',				'60',				 '5',				 '2020-01-05'),
                         ('6',				'Kiểm Tra C++',				'4',				'60',				 '6',				 '2020-01-06'),
                         ('7',				'Kiểm Tra C#',				'1',				'60',				 '7',				 '2020-01-07'),
                         ('8',				'Kiểm Tra JavaScript',		'2',				'60',				 '8',				 '2020-01-08'),
                         ('9',				'Kiểm Tra VR',				'3',				'60',				 '9',				 '2020-01-09'),
                         ('10',				'Kiểm Tra React JS',		'5',				'60',				 '10',				 '2020-01-10');

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
