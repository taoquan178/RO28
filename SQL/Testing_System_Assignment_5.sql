DROP DATABASE IF EXISTS Testing_System_Assignment_5;	-- xoá database nếu nó đang tồn tại
CREATE DATABASE Testing_System_Assignment_5; 	-- tạo database
USE Testing_System_Assignment_5;	-- sử dụng database  vừa tạo

DROP TABLE IF EXISTS `Department`;	-- xoá bảng nếu nó tồn tại
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
    FOREIGN KEY(DepartmentID) REFERENCES `Department`(DepartmentID)	ON DELETE CASCADE, -- ON DELETE CASCADE khi xoá dữ liệu, các bản ghi liên quan trong table con cũng bị xoá
	FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID) ON DELETE CASCADE
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
    FOREIGN KEY(GroupID) REFERENCES `Group`(GroupID) ON DELETE CASCADE,
    FOREIGN KEY(AccountID) REFERENCES `Account`(AccountID) ON DELETE CASCADE
);	

DROP TABLE IF EXISTS `TypeQuestion`;
CREATE TABLE `TypeQuestion` (
	TypeID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName			ENUM('Essay', 'Multiple-Choice') NOT NULL UNIQUE KEY
);	

DROP TABLE IF EXISTS `CategoryQuestion`;
CREATE TABLE `CategoryQuestion` (
	CategoryID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName		ENUM('Java', 'ASP.NET', 'ADO.NET', 'SQL', 'Postman', 'Ruby', 'Python', 'C++', 'C Sharp', 'PHP') NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS `Question`;
CREATE TABLE `Question` (
	QuestionID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content				VARCHAR(100) NOT NULL,
    CategoryID			TINYINT UNSIGNED NOT NULL,
    TypeID				TINYINT UNSIGNED NOT NULL,
    CreatorID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES `CategoryQuestion`(CategoryID) ON DELETE CASCADE,
    FOREIGN KEY(TypeID) REFERENCES `TypeQuestion`(TypeID) ON DELETE CASCADE
    );

DROP TABLE IF EXISTS `Answer`;
CREATE TABLE `Answer` (
	AnswerID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content				VARCHAR(100) NOT NULL,
	QuestionID			TINYINT UNSIGNED NOT NULL,
    isCorrect			BOOLEAN NOT NULL,
    FOREIGN KEY(QuestionID) REFERENCES `Question`(QuestionID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `Exam`;
CREATE TABLE `Exam` (
	ExamID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`				VARCHAR(50) NOT NULL,
    Title				VARCHAR(50) NOT NULL UNIQUE KEY,
    CategoryID			TINYINT UNSIGNED NOT NULL,
    Duration			TINYINT UNSIGNED NOT NULL,
    CreatorID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES `CategoryQuestion`(CategoryID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `ExamQuestion`;
CREATE TABLE `ExamQuestion` (
	ExamID				TINYINT UNSIGNED NOT NULL,
    QuestionID			TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(ExamID) REFERENCES `Exam`(ExamID) ON DELETE CASCADE,
    FOREIGN KEY(QuestionID) REFERENCES `Question`(QuestionID) ON DELETE CASCADE
);

-- Thêm dữ liệu vào các bảng
INSERT INTO `Department`(DepartmentName)
VALUES 					('Marketing'),
						('Sale'),
						('Bảo vệ'),
						('Nhân sự'),
						('Kỹ thuật'),
						('Tài chính'),
						('Phó giám đốc'),
						('Giám đốc'),
						('Thư kí'),
						('No person'),
						('Bán hàng');
INSERT INTO `Position`	(PositionName)
VALUES 					('Dev'),
						('Test'),
						('Scrum Master'),
						('PM');
INSERT INTO `Account`(
        Email,
        Username,
        FullName,
        DepartmentID,
        PositionID,
        CreateDate
    )
VALUES (
        'Email1@gmail.com',
        'Username1',
        'Fullname1',
        5,
        1,
        '2020-03-05'
    ),
    (
        'Email2@gmail.com',
        'Username2',
        'Fullname2',
        1,
        2,
        '2020-03-05'
    ),
    (
        'Email3@gmail.com',
        'Username3',
        'Fullname3',
        2,
        2,
        '2020-03-07'
    ),
    (
        'Email4@gmail.com',
        'Username4',
        'Fullname4',
        3,
        4,
        '2020-03-08'
    ),
    (
        'Email5@gmail.com',
        'Username5',
        'Fullname5',
        4,
        4,
        '2020-03-10'
    ),
    (
        'Email6@gmail.com',
        'Username6',
        'Fullname6',
        6,
        3,
        '2020-04-05'
    ),
    (
        'Email7@gmail.com',
        'Username7',
        'Fullname7',
        2,
        2,
        NULL
    ),
    (
        'Email8@gmail.com',
        'Username8',
        'Fullname8',
        8,
        1,
        '2020-04-07'
    ),
    (
        'Email9@gmail.com',
        'Username9',
        'Fullname9',
        2,
        2,
        '2020-04-07'
    ),
    (
        'Email10@gmail.com',
        'Username10',
        'Fullname10',
        10,
        1,
        '2020-04-09'
    ),
    (
        'Email11@gmail.com',
        'Username11',
        'Fullname11',
        10,
        1,
        DEFAULT
    ),
    (
        'Email12@gmail.com',
        'Username12',
        'Fullname12',
        10,
        1,
        DEFAULT
    ),
        (
        'vandao178@gmail.com',
        'Dao',
        'Tran Van Dao',
        10,
        1,
        DEFAULT
    ),
            (
        'taoquan178@gmail.com',
        'quan',
        'Nguyễn Trung Quân',
        8,
        3,
        '2009-04-07'
    ),
        (
        'Email15@gmail.com',
        'Username15',
        'Fullname15',
        3,
        4,
        '2020-03-08'
    );
INSERT INTO `Group`(GroupName,			 CreatorID, 		CreateDate)
VALUES 				('Testing System', 	 5, 				'2019-03-05'),
					('Development', 	 1, 				'2020-03-07'),
					('VTI Sale 01', 	 2, 				'2020-03-09'),
					('VTI Sale 02', 	 3, 				'2020-03-10'),
					('VTI Sale 03', 	 4, 				'2020-03-28'),
					('VTI Creator', 	 6, 				'2020-04-06'),
					('VTI Marketing 01', 7, 				'2020-04-07'),
					('Management', 		 8, 				'2020-04-08'),
					('Chat with love',	 9, 				'2020-04-09'),
					('Vi Ti Ai', 		 10, 				'2020-04-10');
INSERT INTO `GroupAccount`	(GroupID,	 AccountID, 	JoinDate)
VALUES 						(1,			 1, 			'2019-03-05'),
							(1,			 2, 			'2020-03-07'),
							(3,			 3, 			'2020-03-09'),
							(3,			 4, 			'2020-03-10'),
							(5,			 5, 			'2020-03-28'),
							(1,			 3, 			'2020-04-06'),
							(1,			 7, 			'2020-04-07'),
							(8,			 3, 			'2020-04-08'),
							(1,			 9, 			'2020-04-09'),
							(10,		 10, 			'2020-04-10'),
							(2,			 3, 			'2020-04-08'),
							(2,			 9, 			'2020-04-09'),
							(1,			 11, 			'2020-03-07'),
							(3,			 12, 			'2020-03-09'),
							(3,			 13, 			'2020-03-10'),
							(5,			 14, 			'2020-03-28'),
							(4,			 15, 			'2020-04-06'),
							(4,			 5, 			'2020-04-07'),
							(4,			 4, 			'2020-04-08'),
							(4,			 3, 			'2020-04-09'),
							(4,			 2, 			'2020-04-10'),
							(4,			 1, 			'2020-04-08');
INSERT INTO TypeQuestion(TypeName)
VALUES ('Essay'),
    ('Multiple-Choice');
INSERT INTO CategoryQuestion(CategoryName)
VALUES 						('Java'),
							('ASP.NET'),
							('ADO.NET'),
							('SQL'),
							('Postman'),
							('Ruby'),
							('Python'),
							('C++'),
							('C Sharp'),
							('PHP');
INSERT INTO Question(Content,				CategoryID,		TypeID,		CreatorID,		CreateDate)
VALUES 				('Câu hỏi về Java', 	1, 				'1', 		'2', 			'2020-04-05'),
					('Câu Hỏi về PHP', 		10, 			'2', 		'2', 			'2020-04-05'),
    				('Hỏi về C#', 			9, 				'2', 		'3', 			'2020-04-06'),
    				('Hỏi về Ruby', 		6, 				'1', 		'4', 			'2020-04-06'),
    				('Hỏi về Postman', 		5, 				'1', 		'5', 			'2020-04-06'),
    				('Hỏi về ADO.NET', 		3, 				'2', 		'6', 			'2020-04-06'),
    				('Hỏi về ASP.NET', 		2, 				'1', 		'7', 			'2020-04-06'),
    				('Hỏi về C++', 			8, 				'1', 		'8', 			'2020-04-07'),
    				('Hỏi về SQL', 			4, 				'2', 		'9', 			'2020-04-07'),
    				('Hỏi về Python', 		7, 				'1', 		'14', 			'2020-04-07');
INSERT INTO Answer	(Content, 		QuestionID, isCorrect)
VALUES 				('Trả lời 01', 	1, 			0),
					('Trả lời 02', 	1, 			1),
					('Trả lời 03', 	1, 			0),
					('Trả lời 04', 	1, 			1),
					('Trả lời 05', 	2, 			1),
					('Trả lời 06', 	3, 			1),
					('Trả lời 07', 	4, 			0),
					('Trả lời 08', 	8, 			0),
					('Trả lời 09', 	9, 			1),
					('Trả lời 10', 	10, 		1);
INSERT INTO Exam (
        `Code`,
        Title,
        CategoryID,
        Duration,
        CreatorID,
        CreateDate
    )
VALUES (
		'VTIQ001',
		'Đề thi C#',
		1,
		60,
		'5',
		'2019-04-05'),
    (
        'VTIQ002',
        'Đề thi PHP',
        10,
        60,
        '2',
        '2019-04-05'
    ),
    (
        'VTIQ003',
        'Đề thi C++',
        9,
        120,
        '2',
        '2019-04-07'
    ),
    (
        'VTIQ004',
        'Đề thi Java',
        6,
        60,
        '3',
        '2020-04-08'
    ),
    (
        'VTIQ005',
        'Đề thi Ruby',
        5,
        120,
        '4',
        '2020-04-10'
    ),
    (
        'VTIQ006',
        'Đề thi Postman',
        3,
        60,
        '6',
        '2020-04-05'
    ),
    (
        'VTIQ007',
        'Đề thi SQL',
        2,
        60,
        '7',
        '2020-04-05'
    ),
    (
        'VTIQ008',
        'Đề thi Python',
        8,
        60,
        '8',
        '2020-04-07'
    ),
    (
        'VTIQ009',
        'Đề thi ADO.NET',
        4,
        90,
        '9',
        '2020-04-07'
    ),
    (
        'VTIQ010',
        'Đề thi ASP.NET',
        7,
        90,
        '10',
        '2020-04-08'
    );
    
INSERT INTO ExamQuestion	(ExamID,	 QuestionID)
VALUES 						(1, 		5),
							(2, 		10),
    						(3, 		4),
    						(4, 		3),
    						(5, 		7),
    						(6, 		10),
    						(7, 		2),
    						(8, 		10),
    						(7, 		9),
    						(8, 		8),
							(6, 		4),
    						(7, 		4),
    						(3, 		2),
    						(7, 		5),
    						(10, 		8);

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE VIEW VIEW_Sales_Department AS
	SELECT 	A.AccountID, D.DepartmentName, A.FullName, A.Email
	FROM	Department D
	JOIN	`Account` A ON D.DepartmentID = A.DepartmentID
	WHERE	D.DepartmentName = 'Sale';

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE VIEW VIEW_Accounts_That_Join_The_Most_Groups AS
WITH 	TCE_Accounts_That_Join_The_Most_Groups AS (
	SELECT	GA.AccountID, A.FullName, A.Email, COUNT(GA.AccountID) AS SL_Nhom_Tham_Gia
	FROM	`Account` A
	JOIN	GroupAccount GA ON A.AccountID = GA.AccountID
	GROUP BY	GA.AccountID
)
SELECT	*
FROM	TCE_Accounts_That_Join_The_Most_Groups
WHERE	SL_Nhom_Tham_Gia = (SELECT MAX(SL_Nhom_Tham_Gia) FROM TCE_Accounts_That_Join_The_Most_Groups);

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
CREATE OR REPLACE VIEW VIEW_Delete_Content AS
	SELECT	*
	FROM	Question
	WHERE	length(Content) > 300;

DELETE FROM VIEW_Delete_Content;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE VIEW	vw_Department_MAX_Staff AS
WITH	TCE_Department_MAX_Staff AS (
SELECT	A.DepartmentID, D.DepartmentName, COUNT(A.DepartmentID) AS SL_Nhân_Viên
FROM	`Account` A
JOIN	Department D ON	A.DepartmentID = D.DepartmentID
GROUP BY	A.DepartmentID
)
SELECT	*
FROM	TCE_Department_MAX_Staff
WHERE	SL_Nhân_Viên = (SELECT MAX(SL_Nhân_Viên) FROM TCE_Department_MAX_Staff);

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE VIEW vw_Question_Created_By_Nguyen AS
SELECT	Q.CreatorID, A.FullName, Q.Content, Q.CategoryID, Q.TypeID, Q.CreateDate
FROM	`Account` A
JOIN	Question Q	ON A.AccountID = Q.CreatorID
WHERE	A.FullName LIKE 'Nguyễn%';
