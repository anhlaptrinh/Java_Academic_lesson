CREATE DATABASE cybersolf_shop;

USE cybersolf_shop;

-- Table sản phẩm
CREATE TABLE sanpham(
	ma_sp int auto_increment PRIMARY KEY,
	ten_sp varchar(255),
	gia double,
	ma_loai_sp_loaisanpham int
);

-- Table loại sản phẩm
CREATE TABLE loaisanpham(
	ma_loai_sp int auto_increment PRIMARY KEY,
	ten_loai_sp varchar(255) 
);

-- DROP TABLE chua 
ALTER TABLE sanpham
ADD CONSTRAINT FK_ma_loai_sp_loaisanpham_sanpham
FOREIGN KEY (ma_loai_sp_loaisanpham) REFERENCES loaisanpham(ma_loai_sp);

-- Table hóa đơn
CREATE TABLE hoadon(
	ma_hoa_don int auto_increment PRIMARY KEY,
	ngay_mua timestamp,
	ma_kh_khachhang int
);

-- Table khách hàng
CREATE TABLE khachhang(
	ma_kh int auto_increment PRIMARY KEY,
	dia_chi varchar(255),
	ho varchar(10),
	ten varchar(10),
	so_dt varchar(11),
	email varchar(100)
);

ALTER TABLE hoadon 
ADD CONSTRAINT FK_ma_kh_khachhang_hoadon
FOREIGN KEY (ma_kh_khachhang) REFERENCES khachhang(ma_kh);

-- Table chứa
CREATE TABLE chua(
	ma_hoa_don_hoadon int,
	ma_sp_sanpham int,
	so_luong int,
	gia_ban double
);
ALTER TABLE chua
ADD CONSTRAINT FK_ma_sp_sanpham_chua
FOREIGN KEY (ma_sp_sanpham) REFERENCES sanpham(ma_sp),
ADD CONSTRAINT FK_ma_hoa_don_hoadon_chua
FOREIGN KEY (ma_hoa_don_hoadon) REFERENCES hoadon(ma_hoa_don);


