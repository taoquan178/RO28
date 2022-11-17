DROP DATABASE IF EXISTS On_Tap;
CREATE DATABASE On_Tap;
USE On_Tap;

DROP TABLE IF EXISTS `CUSTOMER`;
CREATE TABLE `CUSTOMER`(
	CustomerID	INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`		VARCHAR(100),
    Phone		INT UNSIGNED NOT NULL,
    Email		VARCHAR(100) NOT NULL UNIQUE KEY,
    Address		VARCHAR(255) NOT NULL,
    Note		VARCHAR(255) NULL
);

DROP TABLE IF EXISTS `CAR`;
CREATE TABLE `CAR`(
	CarID	VARCHAR(50) PRIMARY KEY,
    Maker	ENUM('HONDA','TOYOTA','NISSAN') NOT NULL,
    Model	VARCHAR(100) NOT NULL UNIQUE KEY,
    `Year`	DATETIME DEFAULT NOW(),
    Color	ENUM('black','white','yellow') NOT NULL,
    Note	VARCHAR(255) NULL
);

DROP TABLE IF EXISTS `CAR_ORDER`;
CREATE TABLE `CAR_ORDER`(
	OrderID			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CustomerID		INT UNSIGNED NOT NULL,
    CarID			VARCHAR(50) NOT NULL,
    Amount			INT UNSIGNED NOT NULL CHECK(Amount >= 1), 
    SalePrice		BIGINT UNSIGNED NOT NULL,
    OrderDate		DATETIME DEFAULT NOW() NOT NULL,
    DeliveryDate	DATETIME DEFAULT NOW() NOT NULL,
    DeliveryAddress	VARCHAR(255) NOT NULL,
    Staus			ENUM('0','1','2') NOT NULL,
    Note			VARCHAR(255) NULL,
    FOREIGN KEY(CustomerID) REFERENCES `CUSTOMER`(CustomerID) ON DELETE CASCADE,
    FOREIGN KEY(CarID) REFERENCES `CAR`(CarID) ON DELETE CASCADE
);


INSERT INTO `CUSTOMER`	(`Name`,				Phone,				Email,						Address,	Note)
VALUES					('Nguyễn Trung Quân',	'0969490511',		'taoquan178@gmail.com',		'Hà Nội',	'Khách mua nhiều'),
						('Trần Văn Nam',		'0934567891',		'vannam55@gmail.com',		'Hà Tây',	'Khách mua ít'),
                        ('Nguyễn Thu Thuỷ',		'0955567891',		'thuthuy123@gmail.com',		'Thủ Đức',	'Khách giàu'),
                        ('Nguyễn Thị Bích',		'0955987491',		'bichnguyen54@gmail.com',	'Hà Nội',	'Khách khó tính'),
                        ('Nguyễn Phú Tài',		'0965879825',		'phutai87@gmail.com',		'TPHCM',	'Khách khó tính');

INSERT INTO `CAR`		(CarID,		Maker,			Model,				`Year`,			Color,		Note)
VALUES					('M1',		'HONDA',		'Siêu xe 1',		'2019-05-07',	'black',	'Siêu xe sang chảnh'),
						('M2',		'TOYOTA',		'Siêu xe 2',		'2019-06-12',	'white',	'Xe du lịch'),
                        ('M3',		'HONDA',		'Siêu xe 3',		'2020-03-20',	'black',	'Siêu xe địa hình'),
                        ('M4',		'TOYOTA',		'Siêu xe 4',		'2021-02-08',	'yellow',	'Siêu xe sang chảnh'),
                        ('M5',		'NISSAN',		'Siêu xe 5',		'2022-01-07',	'yellow',	'Siêu xe sưu tập');
						
INSERT INTO `CAR_ORDER`	(CustomerID,	CarID,	Amount,		SalePrice,		OrderDate,		DeliveryDate,	DeliveryAddress,	Staus,	Note)
VALUES					('1',			'M1',	'5',		'500000000',	'2020-05-07',	'2020-07-07',	'Hà Nội',			'2',	'Giao Hàng cẩn thận'),
						('2',			'M3',	'1',		'100000000',	'2020-11-03',	'2020-12-26',	'Hà Tây',			'2',	'Giao hàng nhanh'),
                        ('3',			'M2',	'3',		'300000000',	'2021-07-04',	'2021-09-04',	'Thủ Đức',			'1',	'giao hàng cẩn thận'),
                        ('4',			'M5',	'2',		'200000000',	'2022-08-05',	'2022-10-05',	'Hà Nội',			'1',	'Thêm 1 thùng hoa trong xe'),
                        ('5',			'M4',	'1',		'100000000',	'2022-09-06',	'2022-10-05',	'TPHCM',			'2',	'Giao nhanh trong 1 tháng'),
                        ('1',			'M2',	'1',		'100000000',	'2022-06-07',	'2022-08-08',	'Hà Nội',			'1',	'Giao Hàng cẩn thận'),
						('2',			'M5',	'1',		'100000000',	'2022-07-03',	'2022-10-02',	'Hà Tây',			'0',	'Xe tặng bạn');

-- 2. Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã mua và sắp sếp tăng dần theo số lượng oto đã mua.
SELECT C.`Name`, CO.CarID, SUM(CO.Amount) AS SL
FROM	`CUSTOMER` C
JOIN	`CAR_ORDER` CO ON C.CustomerID = CO.CustomerID
WHERE	CO.Staus = '1'
GROUP BY  C.CustomerID
ORDER BY	SL ASC;

-- 3. Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều oto nhất trong năm nay.
WITH CTE_Maker_Of_Year AS(
	SELECT	C.Maker, SUM(CO.Amount) AS SL
    FROM	`CAR` C
    JOIN	`CAR_ORDER` CO ON C.CarID = CO.CarID
    WHERE	YEAR(CO.OrderDate ) = YEAR(NOW()) AND  CO.Staus = '1'
    GROUP BY	CO.CustomerID
)
SELECT	*
FROM	CTE_Maker_Of_Year
WHERE	SL = (SELECT MAX(SL) FROM CTE_Maker_Of_Year);

-- 4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của những năm trước. In ra số lượng bản ghi đã bị xóa
DROP PROCEDURE IF EXISTS Delete_Staus_By2;
DELIMITER $$
CREATE PROCEDURE Delete_Staus_By2()
BEGIN
	DECLARE V_Staus INT;
	SELECT	COUNT(OrderID) 
    INTO	V_Staus
	FROM	`CAR_ORDER`
	WHERE	YEAR(DeliveryDate) < YEAR(NOW()) AND Staus = '2';
    
    SELECT	V_Staus AS Số_Bản_Ghi_Đã_Xoá;
    
    DELETE	FROM `CAR_ORDER`
    WHERE	YEAR(DeliveryDate) < YEAR(NOW()) AND Staus = '2';
END$$
DELIMITER ;
CALL Delete_Staus_By2();

-- 5. Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn hàng đã đặt hàng bao gồm:
	-- tên của khách hàng, mã đơn hàng, số lượng oto và tên hãng sản xuất
DROP PROCEDURE IF EXISTS Status_Oder_Car;
DELIMITER $$
CREATE PROCEDURE Status_Oder_Car(IN	P_ID INT)
BEGIN
	SELECT	C.`Name`, CO.OrderID, CO.Amount, CR.Maker
	FROM	`CUSTOMER` C
	JOIN	`CAR_ORDER` CO ON C.CustomerID = CO.CustomerID
	JOIN	`CAR` CR ON CR.CarID = CO.CarID
	WHERE	C.CustomerID = P_ID;
END$$
DELIMITER ;
CALL Status_Oder_Car(3);

-- 6. Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ
	-- vào database (DeliveryDate < OrderDate + 15)
DROP TRIGGER IF EXISTS Thoi_Gian_Giao_Hang;
DELIMITER $$
CREATE TRIGGER Thoi_Gian_Giao_Hang
BEFORE INSERT ON `CAR_ORDER`
FOR EACH ROW
BEGIN
    IF	(NEW.DeliveryDate < DATE_ADD(NEW.OrderDate, INTERVAL 15 DAY)) THEN
		SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Ngày nhận hàng phải bé hơn ngày đặt hàng 15 ngày';
	END IF;
END$$
DELIMITER ;

INSERT INTO `CAR_ORDER`	(CustomerID,	CarID,	Amount,		SalePrice,		OrderDate,		DeliveryDate,	DeliveryAddress,	Staus,	Note)
VALUES					('1',			'M4',	'2',		'200000000',	'2022-10-12',	'2022-10-15',	'Hà Nội',			'0',	'Giao Hàng cẩn thận');

