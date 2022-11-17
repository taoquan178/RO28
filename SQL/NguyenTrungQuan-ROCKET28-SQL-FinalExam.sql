DROP DATABASE IF EXISTS Thi_Thuc_Hanh;
CREATE DATABASE Thi_Thuc_Hanh;
USE Thi_Thuc_Hanh;

DROP TABLE IF EXISTS `GiangVien`;
CREATE TABLE `GiangVien`(
	MaGV		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    HoTen		VARCHAR(100) NOT NULL,
    Luong		INT UNSIGNED NOT NULL
);

DROP TABLE IF EXISTS `SinhVien`;
CREATE TABLE `SinhVien`(
	MaSV		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    HoTen		VARCHAR(100) NOT NULL,
    NamSinh		DATETIME DEFAULT NOW() NOT NULL,
    QueQuan		VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS `DeTai`;
CREATE TABLE `DeTai`(
	MaDT			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TenDT			VARCHAR(100) NOT NULL UNIQUE KEY,
    KinhPhi			INT UNSIGNED NOT NULL,
    NoiThucTap		VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS `HuongDan`;
CREATE TABLE `HuongDan`(
	ID			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    MaSV		INT UNSIGNED NOT NULL,
    MaDT		INT UNSIGNED NOT NULL,
    MaGV		INT UNSIGNED NOT NULL,
    KetQua		TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(MaGV) REFERENCES `GiangVien`(MaGV) ON DELETE CASCADE,
	FOREIGN KEY(MaSV) REFERENCES `SinhVien`(MaSV) ON DELETE CASCADE,
    FOREIGN KEY(MaDT) REFERENCES `DeTai`(MaDT) ON DELETE CASCADE
);

INSERT INTO `GiangVien`	(HoTen,					Luong)
VALUES					('Nguyễn Trung Quân',	'5000000'),
						('Trần Văn Nam',		'4000000'),
                        ('Nguyễn Thu Thuỷ',		'3000000'),
                        ('Nguyễn Thị Bích',		'5000000');

INSERT INTO `SinhVien`	(HoTen,					NamSinh,		QueQuan)
VALUES					('Nguyễn Trung Hiếu',	'2001-05-29',	'Hà Nội'),
						('Trần Văn Phúc',		'2001-12-04',	'Hà Tây'),
                        ('Nguyễn Thị Oanh',		'2001-11-03',	'Thủ Đức'),
                        ('Lê Tuấn Anh',			'2001-06-11',	'TPHCM'),
                        ('Nguyễn Thị Trang',	'2001-02-02',	'Hà Nội');
                        
INSERT INTO `DeTai`		(TenDT,					KinhPhi,		NoiThucTap)
VALUES					('Công Nghệ Sinh Học',	2000000,		'Công Ty A'),
						('Công Nghệ Vân Tay',	2000000,		'Công Ty B'),
                        ('Nhận Diện Khuôn Mặt',	3000000,		'Công Ty C'),
                        ('Công Nghệ Chấm Công',	4000000,		'Công Ty D');
                        
INSERT INTO `HuongDan`	(MaSV,	MaDT,	MaGV,	KetQua)
VALUES					(1,		1,		1,		8),
						(2,		2,		2,		9),
                        (3,		3,		3,		9),
                        (4,		4,		4,		4);
                        
-- 2. Viết lệnh để
	-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
	-- b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’
-- Câu a
SELECT	SV.MaSV, SV.HoTen
FROM	`SinhVien` SV
LEFT JOIN	`HuongDan` HD ON SV.MaSV = HD.MaSV
WHERE	HD.MaSV IS NULL;

-- Câu b
SELECT	SV.MaSV, SV.HoTen, D.TenDT, COUNT(D.TenDT) AS SL_SV_Làm_Đề_Tài
FROM	`SinhVien` SV
JOIN	`HuongDan` HD ON SV.MaSV = HD.MaSV
JOIN	`DeTai` D ON HD.MaDT = D.MaDT
WHERE	D.TenDT = 'Công Nghệ Sinh Học';

-- 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
	-- mã số, họ tên và tên đề tài
	-- (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")
DROP VIEW IF EXISTS `SinhVienInfo`;
CREATE VIEW `SinhVienInfo` AS
SELECT		SV.MaSV,SV.HoTen
	,CASE WHEN D.TenDT IS NULL 
    THEN 'Chưa Có'
    ELSE D.TenDT END AS Tên_Đề_Tài
FROM		`HuongDan` HD
RIGHT JOIN	`SinhVien` SV ON SV.MaSV=HD.MaSV
LEFT JOIN	`DeTai` D ON D.MaDT = HD.MaDT;

-- cách khác
SELECT		SV.MaSV,SV.HoTen, IFNULL(D.TenDT,'Chưa Có')
FROM		`HuongDan` HD
RIGHT JOIN	`SinhVien` SV ON SV.MaSV=HD.MaSV
LEFT JOIN	`DeTai` D ON D.MaDT = HD.MaDT;

-- 4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900
	-- thì hiện ra thông báo "năm sinh phải > 1900"
DROP TRIGGER IF EXISTS ADD_Year_SV;
DELIMITER $$
CREATE TRIGGER ADD_Year_SV
BEFORE INSERT ON `SinhVien`
FOR EACH ROW
BEGIN
	IF (YEAR( NEW.NamSinh) <= 1900) THEN
	SIGNAL SQLSTATE '12345'
	SET MESSAGE_TEXT = 'Năm Sinh Phải > 1900';
	END IF;
END$$
DELIMITER ;

INSERT INTO `SinhVien`	(HoTen,					NamSinh,		QueQuan)
VALUES					('Nguyễn Trung Phụng',	'1900-05-29',	'Hà Nội');

-- 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
	-- tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi
-- sử dụng ON DELETE CASCADE
DELETE FROM `SinhVien`
WHERE MaSV = 1;