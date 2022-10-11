USE Testing_System_Assignment_5;

-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước

DROP TRIGGER IF EXISTS  Trg_AddGroup_MoreThan_1Year;
DELIMITER $$
CREATE TRIGGER Trg_AddGroup_MoreThan_1Year
BEFORE INSERT ON `group` 
FOR EACH ROW 
BEGIN
	DECLARE v_CreateDate DATETIME;
    -- date_sub trả về một ngày mà sau đó một khoảng thời gian/ngày nhất định đã bị trừ
    SET v_CreateDate = DATE_SUB(NOW(), INTERVAL 1 YEAR );
--     CASE
-- 		WHEN NEW.CreateDate <= v_CreateDate THEN 'Thành Công'
--         ELSE 'Không thành công, thời gian phải lớn 1 năm trước'
--     END AS CASE_CreateDate;
	IF (NEW.CreateDate <= v_CreateDate) THEN 
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Không thành công, thời gian phải lớn 1 năm trước';
    END IF;
END$$
DELIMITER ;
INSERT INTO	`group` (GroupName,	CreatorID, CreateDate)
VALUES				('Phòng Chờ', 11, '2012-03-05');

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
	-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user"
DROP TRIGGER IF EXISTS Trg_NoMone_User;
DELIMITER $$
CREATE TRIGGER Trg_NoMone_User
BEFORE INSERT ON `account` 
FOR EACH ROW
BEGIN
	DECLARE v_DepartmentID TINYINT;
    SET	v_DepartmentID = 3;
    IF	(NEW.DepartmentID = v_DepartmentID) THEN
		SIGNAL SQLSTATE '12345'	
		SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
    END IF;
END$$
DELIMITER ;
INSERT INTO `Account`(Email, Username, FullName, DepartmentID, PositionID, CreateDate)
VALUES (
        'trannam511@gmail.com',
        'nam',
        'Trần Văn Nam',
        3,
        1,
        '2022-03-05'
    );

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS Trg_Max5_Group;
DELIMITER $$
CREATE TRIGGER Trg_Max5_Group
BEFORE INSERT ON `groupaccount` 
FOR EACH ROW
BEGIN
	DECLARE v_GroupID TINYINT;
	SELECT	COUNT(GA.GroupID) INTO v_GroupID
    FROM	`groupaccount` GA
    WHERE	GA.GroupID = NEW.GroupID;
    IF	(v_GroupID > 5) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Group đã đủ 5 User';
    END IF;
END$$
DELIMITER ;
INSERT INTO `GroupAccount`	(GroupID,	 AccountID, 	JoinDate)
VALUES 						(1,			 15, 			'2019-03-05');

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS Trg_Answer_Max10Question;
DELIMITER $$
CREATE TRIGGER Trg_Answer_Max10Question
BEFORE INSERT ON `answer` 
FOR EACH ROW
BEGIN
	DECLARE v_QuestionID TINYINT;
	SELECT	COUNT(an.QuestionID) INTO v_QuestionID
    FROM	`answer` an
    WHERE	an.QuestionID = NEW.QuestionID;
    IF	(v_QuestionID > 10) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'bài thi đã đủ 10 Question';
    END IF;
END$$
DELIMITER ;
INSERT INTO Answer	(Content, QuestionID, isCorrect)
VALUES 				('Trả lời 01', 1, 0);

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
	-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
	-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó
DROP TRIGGER IF EXISTS Trg_NotDelete_AccountAdmin;
DELIMITER $$
CREATE TRIGGER Trg_NotDelete_AccountAdmin
BEFORE DELETE ON `account` 
FOR EACH ROW
BEGIN
	DECLARE v_email VARCHAR(50);
    SET v_email = 'admin@gmail.com';
    IF	(OlD.Email = v_email) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Không thể xoá User này';
    END IF;
END$$
DELIMITER ;
DELETE FROM	`account` 
WHERE	Email = 'admin@gmail.com';

INSERT INTO `Account`(Email, Username, FullName, DepartmentID, PositionID, CreateDate)
VALUES (
        'admin@gmail.com',
        'quan',
        'Nguyễn Trung Quân',
        8,
        3,
        '2022-03-05'
    );

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, 
	-- hãy tạo trigger cho phép người dùng khi tạo account không điền
	-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
DROP TRIGGER IF EXISTS Trg_department_waiting_Department;
DELIMITER $$
CREATE TRIGGER Trg_department_waiting_Department
BEFORE INSERT ON `account` 
FOR EACH ROW
BEGIN
    IF	(NEW.DepartmentID IS NULL) THEN
		SET NEW.DepartmentID = 12;
    END IF;
END$$
DELIMITER ;
INSERT INTO `Department`(DepartmentName)
VALUES 					('waiting Department');
INSERT INTO `Account`(Email, Username, FullName, DepartmentID, PositionID, CreateDate)
VALUES (
        'vantuangmail.com',
        'Tuan',
        'Nguyễn Văn Tuấn',
		NULL,
        5,
        '2022-03-05'
    );
    
-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
	-- question, trong đó có tối đa 2 đáp án đúng
DROP TRIGGER IF EXISTS Trg_Max4Answer;
DELIMITER $$
CREATE TRIGGER Trg_Max4Answer
BEFORE INSERT ON `answer`
FOR EACH ROW
BEGIN
	DECLARE v_CountAnsInQUes TINYINT;
	DECLARE v_CountAnsIsCorrects TINYINT;
    -- tổng số QuestionID của mỗi answerID
	SELECT count(A.QuestionID) 
    INTO v_CountAnsInQUes 
    FROM answer A 
    WHERE A.QuestionID = NEW.QuestionID;
    
	SELECT count(A.isCorrect)
    INTO v_CountAnsIsCorrects 
    FROM answer A 
    WHERE A.QuestionID = NEW.QuestionID AND A.isCorrect = NEW.isCorrect;
    
	IF (v_CountAnsInQUes >= 4 ) OR (v_CountAnsIsCorrects >= 2) THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Đã đủ 4 answers cho Question có 2 đáp án đúng!';
	END IF;
END $$
DELIMITER ;
INSERT INTO Answer	(Content, QuestionID, isCorrect)
VALUES 				('Trả lời 9', 	9, 0);

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
	-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
	-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
-- DROP TRIGGER IF EXISTS Trg_gender;
-- DELIMITER $$
-- CREATE TRIGGER Trg_gender
-- BEFORE INSERT ON `account` 
-- FOR EACH ROW
-- BEGIN
-- 	IF	NEW.Gender = 'Nam' THEN
-- 		SET NEW.Gender = 'M';
-- 		ELSEIF NEW.Gender = 'Nu' THEN
-- 		SET NEW.Gender = 'F';
-- 		ELSEIF NEW.Gender = 'Chưa xác định' THEN
-- 		SET NEW.Gender = 'U';
-- 	END	IF ;
-- END$$
-- DELIMITER ;

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS Trg_NotDelete_Exam;
DELIMITER $$
CREATE TRIGGER Trg_NotDelete_Exam
BEFORE DELETE ON `exam` 
FOR EACH ROW
BEGIN
	DECLARE v_DayNow DATETIME;
    SET v_DayNow = DATE_SUB(NOW(), INTERVAL 2 DAY);
    IF	(OLD.CreateDate > v_DayNow) THEN 
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Không thành công, thời gian phải lớn hơn 2 ngày';
    END IF;
END$$
DELIMITER ;
INSERT INTO Exam (
        `Code`,
        Title,
        CategoryID,
        Duration,
        CreatorID,
        CreateDate
    )
VALUES (
		'VTIQ011',
		'Đề thi 11',
		1,
		60,
		'5',
		'2022-10-11');
DELETE FROM `exam`
WHERE	`Code` = 'VTIQ011';

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
	-- question khi question đó chưa nằm trong exam nào
    
-- Question 12: Lấy ra thông tin exam trong đó:
	-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
	-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
	-- Duration > 60 thì sẽ đổi thành giá trị "Long time"
SELECT ExamID, `Code`, Title 
	,CASE
		WHEN Duration <= 30 THEN 'Short time'
		WHEN Duration <= 60 THEN 'Medium time'
		ELSE 'Longtime'
	END AS Thời_Gian
    ,CategoryID, CreatorID, CreateDate
FROM exam ;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
	-- là the_number_user_amount và mang giá trị được quy định như sau:
	-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
	-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
	-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
SELECT GroupID, COUNT(GroupID) AS SL
	,CASE
		WHEN COUNT(GroupID) <= 5 THEN 'few'
		WHEN COUNT(GroupID) <= 20 THEN 'normal'
		ELSE 'higher'
	END AS the_number_user_amount
FROM groupaccount 
GROUP BY GroupID;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
	-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
SELECT	d.DepartmentID,d.DepartmentName, COUNT(a.AccountID) SL
	,CASE
		WHEN a.DepartmentID = d.DepartmentID THEN 'Có user'
        ELSE 'không có user'
	END AS Phòng_Ban
FROM	`account` a
RIGHT JOIN 	department d ON d.DepartmentID = a.DepartmentID
GROUP BY	d.departmentID;
