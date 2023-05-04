--DROP DATABASE [EOS_ADMIN]
--use eos_admin
--CREATE DATABASE [EOS_ADMIN]
--USE [JAVAWEB2022] 
CREATE TABLE Nganh
(
	MaNganh CHAR(3) PRIMARY KEY,
	TenNganh NVARCHAR(100) NOT NULL
)

CREATE TABLE LoaiTaiKhoan
(
	MaLoai INT PRIMARY KEY,
	TenLoai NVARCHAR(50) NOT NULL
)

CREATE TABLE LoaiCauHoi
(
	MaLoai INT PRIMARY KEY,
	TenLoai NVARCHAR(100) NOT NULL
)

CREATE TABLE MonHoc
(
	MaMon CHAR(7) PRIMARY KEY,
	TenMon NVARCHAR(100) NOT NULL,
)

create table LoaiBaiThi
(
	MaLoaiBaiThi int primary key,
	TenLoaiBaiThi nvarchar(100) not null,
	--MaMon CHAR(7) REFERENCES [dbo].[MonHoc]([MaMon]) NOT NULL,
	SoCau int,
	ThoiGianLamBai int,
	--TGMoDe smalldatetime,
	--TGDongDe smalldatetime
)

create table MonHoc_LoaiBaiThi
(
	MaMon CHAR(7) references MonHoc(MaMon),
	MaLoaiBaiThi int references LoaiBaiThi(MaLoaiBaiThi),
	primary key(MaMon, MaLoaiBaiThi)
)

CREATE TABLE TaiKhoan
(
	TenDangNhap VARCHAR(100) PRIMARY KEY,
	MatKhau VARCHAR(100) NOT NULL,
	CapDo INT REFERENCES [dbo].[LoaiTaiKhoan]([MaLoai]) NOT NULL -- quyền truy cập vào eos
)

CREATE TABLE SinhVien
(
	MaSinhVien INT PRIMARY KEY,
	MaNganh CHAR(3) REFERENCES [dbo].[Nganh]([MaNganh]) NOT NULL,
	Ho NVARCHAR(50) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	NgaySinh DATE,
	SoDienThoai CHAR(10),
	AnhDaiDien VARCHAR(MAX),
	Mess NVARCHAR(MAX),
	TenDangNhap VARCHAR(100) references TaiKhoan(TenDangNhap),
	-- QuyenTruyCap BIT DEFAULT(1), -- quyền làm bài thi
)

CREATE TABLE GiaoVien
(
	MaNhanVien INT PRIMARY KEY,
	Ho NVARCHAR(50) NOT NULL,
	Ten NVARCHAR(50) NOT NULL,
	NgaySinh DATE,
	SoDienThoai CHAR(10),
	AnhDaiDien VARCHAR(MAX),
	Mess NVARCHAR(MAX),
	TenDangNhap VARCHAR(100) references TaiKhoan(TenDangNhap),
)

CREATE TABLE BaiThi
(
	MaBaiThi VARCHAR(50) PRIMARY KEY,
	MaLoaiBaiThi int references LoaiBaiThi(MaLoaiBaiThi),
	MaMon CHAR(7) REFERENCES [dbo].[MonHoc]([MaMon]) NOT NULL,
	TGMoDe SMALLDATETIME,
	TGDongDe SMALLDATETIME,

	--MaSinhVien INT REFERENCES [dbo].[SinhVien]([MaSinhVien]) NOT NULL, -- danh sách các sinh viên
	--ThoiGianLamBai INT,
	--SoCau INT, 
	--MaCauHoi INT REFERENCES [dbo].[CauHoi]([MaCauHoi]) NOT NULL, -- dùng list để lưu danh sách các câu hỏi
	--TongSoCau INT,
	--CauHoi INT REFERENCES [dbo].[BaiThi_CauHoi](MaBaiThi)
)

CREATE TABLE CauHoi
(
	MaCauHoi INT PRIMARY KEY,
	NoiDung NVARCHAR(MAX),
	HinhAnh VARCHAR(250),
	MaMon CHAR(7) REFERENCES [dbo].[MonHoc]([MaMon]) NOT NULL,
	DoKho INT DEFAULT(1),
)

CREATE TABLE CauHoi_ChiTiet
(
	MaCauHoi INT PRIMARY KEY REFERENCES [dbo].[CauHoi]([MaCauHoi]),
	LoaiCauHoi INT REFERENCES [dbo].[LoaiCauHoi]([MaLoai]) NOT NULL,
	A NVARCHAR(150) DEFAULT('True'),
	B NVARCHAR(150) DEFAULT('False'),
	C NVARCHAR(150),
	D NVARCHAR(150),
)

CREATE TABLE DapAn
(
	MaDapAn INT PRIMARY KEY REFERENCES [dbo].[CauHoi]([MaCauHoi]) NOT NULL,
	NoiDung CHAR(1), -- 1 ký tự, có thể là A hoặc B hoặc C hoặc D
	DungSai BIT, -- nếu là câu hỏi true false
)

CREATE TABLE BaiThi_CauHoi
(
	MaBaiThi VARCHAR(50) REFERENCES [dbo].[BaiThi]([MaBaiThi]) NOT NULL,
	MaCauHoi INT REFERENCES [dbo].[CauHoi]([MaCauHoi]) NOT NULL, 
	PRIMARY KEY([MaBaiThi], [MaCauHoi])
)

CREATE TABLE SinhVien_BaiThi -- sinh viên được phép làm những bài thi nào
(
	MaSinhVien INT REFERENCES [dbo].[SinhVien]([MaSinhVien]) NOT NULL,
	MaBaiThi VARCHAR(50) REFERENCES [dbo].[BaiThi]([MaBaiThi]) NOT NULL,
	TrangThai BIT default(0),
	PRIMARY KEY([MaSinhVien], [MaBaiThi])
)

--CREATE TABLE SinhVien_BaiThi_CauHoi
--(
--	MaSinhVien INT REFERENCES [dbo].[SinhVien]([MaSinhVien]),
--	MaBaiThi VARCHAR(50),
--	MaCauHoi INT,
--	FOREIGN KEY([MaBaiThi], [MaCauHoi]) REFERENCES [dbo].[BaiThi_CauHoi]([MaBaiThi], [MaCauHoi]),
--	PRIMARY KEY([MaSinhVien], [MaBaiThi], [MaCauHoi])
--)

create table SinhVien_MonHoc
(
	MaSinhVien INT REFERENCES [dbo].[SinhVien]([MaSinhVien]),
	MaMon CHAR(7) references MonHoc(MaMon),
	primary key(MaSinhVien, MaMon)
)

CREATE TABLE BaoCaoLoi
(
	MaSo INT PRIMARY KEY,
	MoTa NVARCHAR(MAX),
	TaiKhoanBaoCao VARCHAR(100) references TaiKhoan(TenDangNhap), -- tài khoản đã báo cáo lỗi
	TrangThai BIT DEFAULT(0)
)

CREATE TABLE SinhVien_BaiThi_CauHoi_CauTraLoi
(
	MaSinhVien INT,
	MaBaiThi VARCHAR(50),
	MaCauHoi INT,
	CauTraLoi CHAR(1),
	FOREIGN KEY(MaBaiThi, MaCauHoi) REFERENCES BaiThi_CauHoi(MaBaiThi, MaCauHoi),
	FOREIGN KEY(MaSinhVien, MaBaiThi) REFERENCES SinhVien_BaiThi(MaSinhVien, MaBaiThi),
	PRIMARY KEY([MaSinhVien], [MaBaiThi], [MaCauHoi])
)
