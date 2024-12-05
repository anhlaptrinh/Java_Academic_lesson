-- Nguyên tắc trong CSDL:
-- +Lệnh script phải viết hoa hết
-- +tên bảng, tên cột, tên database phải viết thường hết (chỉ sử dụng _ )
-- 1) Tạo cơ sở dữ liệu: CREATE DATABASE tên_tự_đặt
CREATE DATABASE vnexpress;
-- 2) Chỉ định database sẽ sử dụng: USE tên_database
USE vnexpress;
-- 3) Tạo bảng: CREATE TABLE tên_bảng(
-- 	tên_cột kiểu_dữ_liệu
-- )
CREATE TABLE danhmuc(
	id int auto_increment,
	ten varchar(255),
	primary key(id)

);
CREATE TABLE baiviet(
	id int auto_increment,
	tieude varchar(255),
	noidung text,
	hinhanh varchar(255),
	ngaytao timestamp,
	id_danhmuc int,
	-- cột id_danhmuc sẽ là khóa ngoại và dữ liệu của nó sẽ tham chiếu tới cột id của bảng danhmuc
-- 	foreign key(id_danhmuc) references danhmuc(id),
	primary key(id)
);

CREATE TABLE students(
	Id int  AUTO_INCREMENT PRIMARY KEY,
	full_name varchar(255) NOT NULL,
	gender varchar(10),
	age int,
	city varchar(255),
	weight double
);
-- Nguyên tắc đặt tên khóa ngoại: FK_têncột_tênbảngchứakhóangoại
ALTER TABLE baiviet ADD CONSTRAINT FK_id_danhmuc_baiviet 
FOREIGN KEY(id_danhmuc) REFERENCES danhmuc(id);
ALTER TABLE baiviet CONVERT TO CHARACTER SET utf8;
ALTER TABLE danhmuc CONVERT TO CHARACTER SET utf8;
-- xóa bảng: DROP tên_bảng
DROP TABLE baiviet;
DROP TABLE danhmuc;
-- Chỉnh sửa bảng: ALTER TABLE tên_bảng
-- thêm bảng: ADD COLUMN tên_cột kiểu_dữ_liệu
ALTER TABLE baiviet ADD COLUMN tacgia varchar(100);
-- Thêm dữ liệu vào bảng:
-- INSERT INTO tên_bảng(tên_cột,tên_cột...) VALUES (giá_trị, giá_trị)
INSERT INTO baiviet(tieude,noidung)VALUES('Vua Nệm vẫn chưa thoát lỗ','Hệ thống bán lẻ nệm lớn nhất cả nước lỗ gần 13 tỷ đồng trong nửa đầu năm.'
);
INSERT INTO baiviet(tieude,noidung)VALUES('Yêu cầu điều chỉnh bảng giá đất để tránh trục lợi khi đấu giá','Bộ Tài nguyên & Môi trường yêu cầu các tỉnh, thành phố điều chỉnh bảng giá.'
);
INSERT INTO baiviet(tieude,noidung)VALUES('Chủ tịch Tập đoàn dược Bảo Châu bị bắt','Bà Nguyễn Lan Hương, Chủ tịch HĐQT Công ty cổ phần Tập đoàn dược Bảo Châu, bị cáo buộc lập khống hợp đồng kinh tế, phát hành hóa đơn bất hợp pháp với tổng tiền ghi trên 367 tỷ đồng.'
);
INSERT INTO baiviet(tieude,noidung)VALUES('Yêu cầu điều chỉnh bảng giá đất để tránh trục lợi khi đấu giá','Bộ Tài nguyên & Môi trường yêu cầu các tỉnh, thành phố điều chỉnh bảng giá.'
);
INSERT INTO students (Id,full_name ,gender,age,city,weight)VALUES(1,'nguyen Van A',
'Nữ',18,'Đà Nẵng',68.81);
-- Lấy dữ liệu (query | truy vấn):
-- SELECT tên_cột
-- FROM tên_bảng
-- WHERE điều_kiện
SELECT * 
FROM baiviet

-- Xóa dữ liệu: DELETE FROM tên_bảng WHERE điều kiện
DELETE FROM baiviet WHERE tacgia='Nguyen Van A';
-- Cập nhật dữ liệu: UPDATE tên_bảng SET tên_cột = dữ liệu WHERE điều_kiện
UPDATE  baiviet SET hinhanh ='abc.jpg';

SELECT *
FROM baiviet 
JOIN danhmuc ON baiviet.id_danhmuc = danhmuc.id;

-- OnetoOne: Một dòng dữ liệu của bảng này chỉ lấy được 1 dòng dữ liệu của bảng kia
-- -> Khóa ngoại để ở bảng nào cũng được nhưng cột khóa ngoại sẽ đóng luôn vai trò là khóa chính

-- OnetoMany: Một dòng dữ liệu của bảng này sẽ lấy được nhiều dòng dữ liệu của bảng kia
-- ->Bảng nào được xác định là nhiều thì bảng đó giữ khóa ngoại.

-- ManytoOne: Ngược lại ở trên
-- ManytoMany: Nhiều dòng dữ liệu của bảng này sẽ lấy nhiều dòng dữ liệu của bảng kia
-- ->Sẽ phát sinh ra bảng trung gian. Bảng trung gian sẽ có 2 cột vừa là khóa chính vừa là khóa ngoại

