CREATE DATABASE db_qlbansach;

USE db_qlbansach;

CREATE TABLE khachhang(
	ma_kh int auto_increment,
	tai_khoan varchar(100),
	mat_khau varchar(10),
	email varchar(255),
	dia_chi varchar(255),
	dien_thoai varchar(10),
	gioi_tinh boolean,
	ngay_sinh timestamp,
	ho_ten varchar(100),
	primary key(ma_kh)
	
);

CREATE TABLE gom(
	ma_don_hang_donhang int,
	ma_sach_sach int,
	so_luong int,
	don_gia int
);

CREATE TABLE donhang(
	ma_don_hang int auto_increment,
	da_thanh_toan boolean,
	ngay_giao timestamp NULL,
	ngay_dat timestamp DEFAULT CURRENT_TIMESTAMP,
	tinh_trang_gh ENUM('Pending', 'Shipped', 'Delivered', 'Cancelled') DEFAULT 'Pending',
	ma_kh_khachhang int,
	primary key(ma_don_hang)	
);

CREATE TABLE chude(
	ma_chu_de int auto_increment,
	ten_chu_de varchar(255),
	primary key(ma_chu_de)
);

CREATE TABLE thamgia(
	ma_tac_gia_tacgia int,
	ma_sach_sach int,
	vai_tro varchar(255),
	vi_tri varchar(255)
	
);

CREATE TABLE nhaxuatban(
	ma_nsx int auto_increment PRIMARY KEY,
	ten_nsx varchar(100),
	dien_thoai varchar(10),
	dia_chi varchar(255)
);

CREATE TABLE tacgia(
	ma_tac_gia int auto_increment PRIMARY KEY,
	ten_tac_gia varchar(100),
	dien_thoai varchar(10),
	tieu_su text,
	dia_chi varchar(255)
);

CREATE TABLE sach(
	ma_sach int auto_increment PRIMARY KEY,
	ten_sach varchar(100),
	so_luong_ton int,
	ngay_cap_nhat timestamp,
	anh_bia varchar(255),
	mo_ta text,
	gia_ban double,
	ma_chu_de_chude int,
	ma_nsx_nhaxuatban int
);

-- khách hàng đặt đơn hàng
ALTER TABLE donhang
ADD CONSTRAINT FK_ma_kh_khachhang_donhang
FOREIGN KEY (ma_kh_khachhang) REFERENCES khachhang(ma_kh);

-- đơn hàng gồm sách
ALTER TABLE gom
ADD CONSTRAINT FK_ma_don_hang_donhang_gom
FOREIGN KEY (ma_don_hang_donhang) REFERENCES donhang(ma_don_hang),
ADD CONSTRAINT FK_ma_sach_sach_gom
FOREIGN KEY (ma_sach_sach) REFERENCES sach(ma_sach);

-- tác giả tham gia sách
ALTER TABLE thamgia
ADD CONSTRAINT FK_ma_tac_gia_tacgia_thamgia
FOREIGN KEY (ma_tac_gia_tacgia) REFERENCES tacgia(ma_tac_gia),
ADD CONSTRAINT FK_ma_sach_sach_thamgia
FOREIGN KEY (ma_sach_sach) REFERENCES sach(ma_sach);

-- chủ đề thuộc sách
ALTER TABLE sach
ADD CONSTRAINT FK_ma_chu_de_chude_sach
FOREIGN KEY (ma_chu_de_chude) REFERENCES chude(ma_chu_de),
-- sách thuộc nhà xuất bản
ADD CONSTRAINT FK_ma_nsx_nhaxuatban_sach
FOREIGN KEY (ma_nsx_nhaxuatban) REFERENCES nhaxuatban(ma_nsx);
