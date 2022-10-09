USE Testing_System_Assignment_5;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS p_Search_Department_Account;
DELIMITER $$
CREATE PROCEDURE p_Search_Department_Account(IN DepartmentSearch VARCHAR(50))
	BEGIN
		SELECT	A.AccountID, A.FullName, D.DepartmentName
		FROM	`Account` A
		JOIN	Department D ON	A.DepartmentID = D.DepartmentID
		WHERE	D.DepartmentName = DepartmentSearch;
	END $$
DELIMITER ;
CALL p_Search_Department_Account('Sale');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS p_Print_Account_In_Group;
DELIMITER $$
CREATE PROCEDURE p_Print_Account_In_Group(IN cp_GroupID INTEGER)
	BEGIN
		SELECT	G.GroupName, COUNT(A.AccountID) AS SL
		FROM	`Account` A
		JOIN	GroupAccount GA ON A.AccountID = GA.AccountID
		JOIN	`Group` G ON GA.GroupID = G.GroupID
		GROUP BY GA.GroupID
		HAVING	GA.GroupID = cp_GroupID;
	END $$
DELIMITER ;
CALL p_Print_Account_In_Group(1);

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS p_TypeQuestion_In_Month;
DELIMITER $$
CREATE PROCEDURE p_TypeQuestion_In_Month()
	BEGIN
		SELECT	TQ.TypeName, COUNT(Q.TypeID) AS SL
		FROM	TypeQuestion TQ
		JOIN	Question Q ON TQ.TypeID = Q.TypeID
		WHERE	MONTH(Q.CreateDate) = MONTH(NOW()) AND YEAR(Q.CreateDate) = YEAR(NOW());
    END $$
DELIMITER ;
CALL p_TypeQuestion_In_Month(); 

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS p_TypeQuestion_Q;
DELIMITER $$
CREATE PROCEDURE p_TypeQuestion_Q(OUT OUT_ID TINYINT)
	BEGIN
		WITH CTE_MAX_TypeQuestion AS (
			SELECT	TQ.TypeID, COUNT(Q.TypeID) AS SL
			FROM	TypeQuestion TQ
			JOIN	Question Q ON TQ.TypeID = Q.TypeID
			GROUP BY	Q.TypeID
		)
		SELECT	TypeID AS ID
        INTO	OUT_ID
		FROM	CTE_MAX_TypeQuestion 
		WHERE	SL	=	(SELECT MAX(SL) FROM CTE_MAX_TypeQuestion);
    END $$
DELIMITER ;
SET	@OUT_ID = 0;
CALL p_TypeQuestion_Q(@OUT_ID);
SELECT	@OUT_ID;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
SELECT	*
FROM	TypeQuestion
WHERE	TypeID = @OUT_ID;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
	-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào
DROP PROCEDURE IF EXISTS p_Enter_String;
DELIMITER $$
CREATE PROCEDURE p_Enter_String(IN cp_Chuoi VARCHAR(50))
	BEGIN
		SELECT	Username
		FROM	`Account` 
		WHERE	Username LIKE CONCAT('%',cp_Chuoi,'%')
        UNION
		SELECT	GroupName
        FROM	`Group`
		WHERE	GroupName LIKE CONCAT('%',cp_Chuoi,'%'); -- CONCAT dùng để ghép chuỗi
    END $$
DELIMITER ;
CALL p_Enter_String('a');
    
-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
	-- username sẽ giống email nhưng bỏ phần @..mail đi 
    -- positionID: sẽ có default là developer
	-- departmentID: sẽ được cho vào 1 phòng chờ 
    -- Sau đó in ra kết quả tạo thành công
    
DROP PROCEDURE IF EXISTS p_Add_Account;
DELIMITER $$
CREATE PROCEDURE p_Add_Account (IN CP_FullName VARCHAR(50), IN cp_Email VARCHAR(50))
	BEGIN
		-- SUBSTRING_INDEX trả về chuỗi con của chuỗi trước số lần xuất hiện của dấu phân cách. (Dấu phân cách ở dây là '@')
		DECLARE	cp_Username			VARCHAR(50) DEFAULT SUBSTRING_INDEX(cp_Email,'@','1'); 
		DECLARE	cp_DepartmentID		TINYINT UNSIGNED DEFAULT 10;
		DECLARE	cp_PositionID		TINYINT UNSIGNED DEFAULT 1;
		DECLARE cp_CreateDate		DATETIME DEFAULT NOW();
        
        INSERT INTO	`Account`	(Email,		Username,		FullName,		DepartmentID,		PositionID,		CreateDate)
        VALUES					(cp_Email,	cp_Username,	CP_FullName,	cp_DepartmentID,	cp_PositionID,	cp_CreateDate);
    END $$
DELIMITER ;
CAll	p_Add_Account('Trần Hán Thăng','hanthang@gmail.com');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
	-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DROP PROCEDURE IF EXISTS p_MaxLength_EssayOrMultipleChoice;
DELIMITER $$
CREATE PROCEDURE p_MaxLength_EssayOrMultipleChoice(IN p_TypeName VARCHAR(50))
    BEGIN
		SELECT	q.Content, tq.TypeName, MAX(length(q.Content)) AS Độ_Dài
		FROM	question q
		JOIN	typequestion tq ON q.TypeID = tq.TypeID
		WHERE	tq.TypeName = p_TypeName;
    END $$
DELIMITER ;
CALL p_MaxLength_EssayOrMultipleChoice('Multiple-Choice');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS ip_Delete_Exam;
DELIMITER $$
CREATE PROCEDURE p_Delete_Exam(IN p_ExamID TINYINT)
    BEGIN
		DELETE FROM	exam
		WHERE	ExamID = p_ExamID;
    END $$
DELIMITER ;
CALL p_Delete_Exam(10);

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
	-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
-- DROP PROCEDURE IF EXISTS SP_DeleteExamBefore3Year;
-- DELIMITER $$
-- CREATE PROCEDURE SP_DeleteExamBefore3Year()
-- BEGIN
-- 	-- Khai báo biến sử dụng trong chương trình
-- 	DECLARE v_ExamID TINYINT UNSIGNED;
-- 	DECLARE v_CountExam TINYINT UNSIGNED DEFAULT 0;
-- 	DECLARE v_CountExamquestion TINYINT UNSIGNED DEFAULT 0;
-- 	DECLARE i TINYINT UNSIGNED DEFAULT 1;
-- 	DECLARE v_print_Del_info_Exam VARCHAR(50) ;
--     
-- 	-- Tạo bảng tạm
-- 	DROP TABLE IF EXISTS ExamIDBefore3Year_Temp;
-- 	CREATE TABLE ExamIDBefore3Year_Temp(ID INT PRIMARY KEY AUTO_INCREMENT,	ExamID INT);
--     
-- 	-- Insert dữ liệu bảng tạm
-- 	INSERT INTO ExamIDBefore3Year_Temp(ExamID)
-- 	SELECT e.ExamID 
--     FROM exam e 
--     WHERE (year(now()) - year(e.CreateDate)) >2;
--     
-- 	-- Lấy số lượng số Exam và ExamQuestion cần xóa.
-- 	SELECT count(1) 
--     INTO v_CountExam 
--     FROM ExamIDBefore3Year_Temp;
--     
-- 	SELECT count(1) 
--     INTO v_CountExamquestion 
--     FROM examquestion ex
-- 	INNER JOIN ExamIDBefore3Year_Temp et ON ex.ExamID = et.ExamID;
--     
-- 	-- Thực hiện xóa trên bảng Exam và ExamQuestion sử dụng Procedure đã tạo ở Question9 bên trên
-- 	WHILE (i <= v_CountExam) DO
-- 		SELECT ExamID INTO v_ExamID FROM ExamIDBefore3Year_Temp WHERE ID=i;
-- 		CALL sp_DeleteExamWithID(v_ExamID);
-- 		SET i = i +1;
-- 	END WHILE;
--     
-- -- In câu thông báo
-- 	SELECT CONCAT("DELETE ",v_CountExam," IN Exam AND ", v_CountExamquestion ," IN	ExamQuestion") INTO v_print_Del_info_Exam;
-- 	SIGNAL SQLSTATE '45000'
-- 	SET MESSAGE_TEXT = v_print_Del_info_Exam ;
--     
-- 	-- Xóa bảng tạm sau khi hoàn thành
-- 	DROP TABLE IF EXISTS ExamIDBefore3Year_Temp;
-- END$$
-- DELIMITER ;
-- Call SP_DeleteExamBefore3Year();

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
	-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
	-- chuyển về phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS p_Delete_Department;
DELIMITER $$
CREATE PROCEDURE p_Delete_Department(IN p_DepartmentName VARCHAR(50))
BEGIN
	DECLARE	id_Department VARCHAR(50);
	SELECT	DepartmentID 
    INTO	id_Department
	FROM	department
	WHERE	DepartmentName = p_DepartmentName;
	
	UPDATE	`account` a 
    SET		a.DepartmentID = '10' 
    WHERE	a.DepartmentID = id_Department;
    
	DELETE FROM	department d 
    WHERE	d.DepartmentName = p_DepartmentName;
END$$
DELIMITER ;
Call p_Delete_Department('Bảo vệ');

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE IF EXISTS p_CountQuesInMonth;
DELIMITER $$
CREATE PROCEDURE p_CountQuesInMonth()
BEGIN
	WITH CTE_12Months AS (
		SELECT 1 AS Thang
		UNION SELECT 2 AS Thang
		UNION SELECT 3 AS Thang
		UNION SELECT 4 AS Thang
		UNION SELECT 5 AS Thang
		UNION SELECT 6 AS Thang
		UNION SELECT 7 AS Thang
		UNION SELECT 8 AS Thang
		UNION SELECT 9 AS Thang
		UNION SELECT 10 AS Thang
		UNION SELECT 11 AS Thang
		UNION SELECT 12 AS Thang
	)
	SELECT M.Thang, count(month(Q.CreateDate)) AS SL 
    FROM CTE_12Months M
	LEFT JOIN (
		SELECT * 
        FROM question Q1 
        WHERE year(Q1.CreateDate) = year(now()) 	) Q 	ON M.Thang = month(Q.CreateDate)
	GROUP BY M.Thang;
END$$
DELIMITER ;
Call p_CountQuesInMonth();

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
	-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
DROP PROCEDURE IF EXISTS sp_CountQuesBefore6Month;
DELIMITER $$
CREATE PROCEDURE sp_CountQuesBefore6Month()
BEGIN
	WITH CTE_Talbe_6MonthBefore AS (
			SELECT MONTH (DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS MONTH,
			YEAR(DATE_SUB(NOW(), INTERVAL 5 MONTH)) AS `YEAR`
		UNION
			SELECT MONTH (DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS MONTH,
			YEAR(DATE_SUB(NOW(), INTERVAL 4 MONTH)) AS `YEAR`
		UNION
			SELECT MONTH (DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS MONTH,
			YEAR(DATE_SUB(NOW(), INTERVAL 3 MONTH)) AS `YEAR`
		UNION
			SELECT MONTH (DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS MONTH,
			YEAR(DATE_SUB(NOW(), INTERVAL 2 MONTH)) AS `YEAR`UNION
			SELECT MONTH (DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS MONTH,
			YEAR(DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS `YEAR`
		UNION
			SELECT MONTH (NOW()) AS MONTH, YEAR(NOW()) AS `YEAR`
	)
	SELECT M.MONTH,M.YEAR
		,CASE
			WHEN COUNT(QuestionID) = 0 
			THEN 'không có câu hỏi nào trong tháng'
			ELSE COUNT(QuestionID)
		END AS SL
	FROM CTE_Talbe_6MonthBefore M
	LEFT JOIN (
		SELECT * 
        FROM question 
        WHERE CreateDate >= DATE_SUB(NOW(), INTERVAL 6 MONTH) AND CreateDate <= now()) AS Sub_Question ON M.MONTH = MONTH(CreateDate)
	GROUP BY M.MONTH
	ORDER BY M.MONTH ASC;
END$$
DELIMITER ;
CALL sp_CountQuesBefore6Month();