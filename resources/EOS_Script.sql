USE [master]
GO
/****** Object:  Database [EOS_ADMIN]    Script Date: 15/03/2023 12:57:57 SA ******/
CREATE DATABASE [EOS_ADMIN]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'EOS_ADMIN', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\EOS_ADMIN.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'EOS_ADMIN_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\EOS_ADMIN_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [EOS_ADMIN] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [EOS_ADMIN].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [EOS_ADMIN] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET ARITHABORT OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [EOS_ADMIN] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [EOS_ADMIN] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [EOS_ADMIN] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET  ENABLE_BROKER 
GO
ALTER DATABASE [EOS_ADMIN] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [EOS_ADMIN] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [EOS_ADMIN] SET  MULTI_USER 
GO
ALTER DATABASE [EOS_ADMIN] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [EOS_ADMIN] SET DB_CHAINING OFF 
GO
ALTER DATABASE [EOS_ADMIN] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [EOS_ADMIN] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [EOS_ADMIN] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [EOS_ADMIN] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [EOS_ADMIN] SET QUERY_STORE = OFF
GO
USE [EOS_ADMIN]
GO
/****** Object:  Table [dbo].[BaiThi]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BaiThi](
	[MaBaiThi] [varchar](50) NOT NULL,
	[MaLoaiBaiThi] [int] NULL,
	[MaMon] [char](7) NOT NULL,
	[TGMoDe] [smalldatetime] NULL,
	[TGDongDe] [smalldatetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaBaiThi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BaiThi_CauHoi]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BaiThi_CauHoi](
	[MaBaiThi] [varchar](50) NOT NULL,
	[MaCauHoi] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaBaiThi] ASC,
	[MaCauHoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BaoCaoLoi]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BaoCaoLoi](
	[MaSo] [int] NOT NULL,
	[MoTa] [nvarchar](max) NULL,
	[TaiKhoanBaoCao] [varchar](100) NULL,
	[TrangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CauHoi]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CauHoi](
	[MaCauHoi] [int] NOT NULL,
	[NoiDung] [nvarchar](max) NULL,
	[HinhAnh] [varchar](250) NULL,
	[MaMon] [char](7) NOT NULL,
	[DoKho] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCauHoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CauHoi_ChiTiet]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CauHoi_ChiTiet](
	[MaCauHoi] [int] NOT NULL,
	[LoaiCauHoi] [int] NOT NULL,
	[A] [nvarchar](150) NULL,
	[B] [nvarchar](150) NULL,
	[C] [nvarchar](150) NULL,
	[D] [nvarchar](150) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCauHoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DapAn]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DapAn](
	[MaDapAn] [int] NOT NULL,
	[NoiDung] [char](1) NULL,
	[DungSai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDapAn] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GiaoVien]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GiaoVien](
	[MaNhanVien] [int] NOT NULL,
	[Ho] [nvarchar](50) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NULL,
	[SoDienThoai] [char](10) NULL,
	[AnhDaiDien] [varchar](max) NULL,
	[Mess] [nvarchar](max) NULL,
	[TenDangNhap] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiBaiThi]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiBaiThi](
	[MaLoaiBaiThi] [int] NOT NULL,
	[TenLoaiBaiThi] [nvarchar](100) NOT NULL,
	[SoCau] [int] NULL,
	[ThoiGianLamBai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoaiBaiThi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiCauHoi]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiCauHoi](
	[MaLoai] [int] NOT NULL,
	[TenLoai] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiTaiKhoan]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiTaiKhoan](
	[MaLoai] [int] NOT NULL,
	[TenLoai] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MonHoc]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MonHoc](
	[MaMon] [char](7) NOT NULL,
	[TenMon] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaMon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MonHoc_LoaiBaiThi]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MonHoc_LoaiBaiThi](
	[MaMon] [char](7) NOT NULL,
	[MaLoaiBaiThi] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaMon] ASC,
	[MaLoaiBaiThi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Nganh]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nganh](
	[MaNganh] [char](3) NOT NULL,
	[TenNganh] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNganh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SinhVien]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SinhVien](
	[MaSinhVien] [int] NOT NULL,
	[MaNganh] [char](3) NOT NULL,
	[Ho] [nvarchar](50) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NULL,
	[SoDienThoai] [char](10) NULL,
	[AnhDaiDien] [varchar](max) NULL,
	[Mess] [nvarchar](max) NULL,
	[TenDangNhap] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSinhVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SinhVien_BaiThi]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SinhVien_BaiThi](
	[MaSinhVien] [int] NOT NULL,
	[MaBaiThi] [varchar](50) NOT NULL,
	[TrangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSinhVien] ASC,
	[MaBaiThi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SinhVien_BaiThi_CauHoi_CauTraLoi]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SinhVien_BaiThi_CauHoi_CauTraLoi](
	[MaSinhVien] [int] NOT NULL,
	[MaBaiThi] [varchar](50) NOT NULL,
	[MaCauHoi] [int] NOT NULL,
	[CauTraLoi] [char](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSinhVien] ASC,
	[MaBaiThi] ASC,
	[MaCauHoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SinhVien_MonHoc]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SinhVien_MonHoc](
	[MaSinhVien] [int] NOT NULL,
	[MaMon] [char](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSinhVien] ASC,
	[MaMon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 15/03/2023 12:57:57 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TenDangNhap] [varchar](100) NOT NULL,
	[MatKhau] [varchar](100) NOT NULL,
	[CapDo] [int] NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BaiThi] ([MaBaiThi], [MaLoaiBaiThi], [MaMon], [TGMoDe], [TGDongDe]) VALUES (N'1', 1, N'1      ', CAST(N'2022-12-31T00:00:00' AS SmallDateTime), CAST(N'2023-03-01T00:00:00' AS SmallDateTime))
INSERT [dbo].[BaiThi] ([MaBaiThi], [MaLoaiBaiThi], [MaMon], [TGMoDe], [TGDongDe]) VALUES (N'3', 2, N'1      ', NULL, NULL)
INSERT [dbo].[BaiThi] ([MaBaiThi], [MaLoaiBaiThi], [MaMon], [TGMoDe], [TGDongDe]) VALUES (N'4', 3, N'1      ', CAST(N'1900-01-01T00:00:00' AS SmallDateTime), CAST(N'1900-01-01T00:00:00' AS SmallDateTime))
INSERT [dbo].[BaiThi] ([MaBaiThi], [MaLoaiBaiThi], [MaMon], [TGMoDe], [TGDongDe]) VALUES (N'5', 5, N'1      ', NULL, NULL)
INSERT [dbo].[BaiThi] ([MaBaiThi], [MaLoaiBaiThi], [MaMon], [TGMoDe], [TGDongDe]) VALUES (N'6', 4, N'2      ', CAST(N'1900-01-01T00:00:00' AS SmallDateTime), CAST(N'1900-01-01T00:00:00' AS SmallDateTime))
INSERT [dbo].[BaiThi] ([MaBaiThi], [MaLoaiBaiThi], [MaMon], [TGMoDe], [TGDongDe]) VALUES (N'7', 5, N'2      ', NULL, NULL)
GO
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'1', 1)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'1', 2)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'1', 3)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'1', 4)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'1', 5)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'1', 6)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'1', 7)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'1', 8)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'1', 9)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'1', 10)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'1', 11)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'1', 12)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'1', 13)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'2', 6)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'2', 7)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'2', 8)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'2', 9)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'2', 10)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'5', 1)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'5', 2)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'5', 3)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'5', 4)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'5', 5)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'5', 6)
INSERT [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi]) VALUES (N'5', 7)
GO
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (1, N'A T.V. show’s executives raised the fee for commercials following a report that the show received a “ No.1” rating in a survey of viewers. What type of the description is?
', N'lô gô.png', N'1      ', 3)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (2, N'Flip a coin three times, create the sample space of possible outcomes (H: Head, T: Tail).
', N'null', N'1      ', 2)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (3, N'A random number generator is set top generate integer random numbers between 0 and 9 inclusive following a uniform distribution. What is the probability of the random number generator generating a 6?
', N'null', N'1      ', 4)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (4, N'If you flip a coin three times, the possible outcomes are HHH HHT HTH HTT THH THT TTH TTT. What is the probability of getting at most one head?
', N'nul', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (5, N'The following table shows the political affiliation of voters in one city and their positions on stronger gun control laws. What is the probability that a voter who favors stronger gun control laws is a Republican?', N'null', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (6, N'Ms. Anne figures that there is a 40% chance that her company will set up a branch office in Ohio. If it does, she is 70% certain that she will be made manager of this new operation. What is the probability that Anne will be a Ohio branch office manager?', N'null', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (7, N'Given events A and B with probabilities P(A) = 0.5,P(B) = 0.4, and P(A and B) = 0.2, are A and B independent?', N'null', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (8, N'It was found that 60% of the workers were white, 30% were black and 10% are other races. Given that a worker was white, the probability that the worker had claimed bias was 30%. Given that a worker was black, the probability that the worker had claimed bias was 40%. Given that a worker was other race, the probability that the worker had claimed bias was 0%. If a randomly selected worker had claimed bias, what is the probability that the worker is white?', N'null', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (9, N'A basketball player has made 95% of his foul shots during the season. If he shoots 3 foul shots in tonight''s game, what is the probability that he makes all of the shots?', N'null', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (10, N'The random variable X represents the number of tests that a patient entering a hospital will have along with the corresponding probabilities. Find the mean and standard deviation for the random variable X.', N'null', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (11, N'Suppose that X has a discrete uniform distribution on the integers 2 to 5. Find V(4X).', N'null', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (12, N'According to a CNN poll taken in February of 2008, 67% of respondents disapproved of the overall job that President Bush was doing. Based on this poll, for samples of size 140, what is the mean number of American adults who disapprove of the overall job that President Bush is doing?', N'null', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (13, N'A batch contains 36 bacteria cells, in which 12 are not capable of cellular replication. Suppose you examine 7 bacteria cells selected at random, without replacement. What is the probability that exactly 3 of them are capable of cellular replication?', N'null', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (14, N'In a recent survey, 95% of the community favored building a police substation in their neighborhood. If 50 citizens are chosen, what is the probability that the number favoring the substation is exactly 42?', N'null', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (15, N'The number of weeds that remain living after a specific chemical has been applied averages 1.21 per square yard and follows a Poisson distribution. Based on this, what is the probability that a 1 square yard section will contain less than 5 weeds?', N'null', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (16, N'"The probability of a successful optical alignment in
the assembly of an optical data storage product is 0.7. Assume
the trials are independent. What is the probability that the first two successful alignments require exactly 4 trials?"
', N'null
', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (112, N'gẻghre', N'312917071_646019200351275_3168126813029487660_n.png', N'1      ', 1)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (115, N'jnryhtr', N'check.png', N'1      ', 6)
INSERT [dbo].[CauHoi] ([MaCauHoi], [NoiDung], [HinhAnh], [MaMon], [DoKho]) VALUES (222, N'fwewfew', N'few', N'1      ', 2)
GO
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (1, 1, N'Experiment', N'Observation study', N'Retrospective study', N'null')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (2, 1, N'HHH TTT THT HTH HHT TTH HTH', N'HHH HHT HTH HTT THH THT TTH TTT', N'HTT THT HTH HHH TTH TTT', N'HHH HTT HTH TTT HTT THH HHT THT')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (3, 1, N'0.07', N'1/10', N'1/9', N'1/2')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (4, 1, N'5/6', N'6/7', N'1/2', N'7/8')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (5, 1, N'0.214', N'0.420', N'0.211', N'0.257')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (6, 1, N'0.55', N'0.28', N'0.20', N'0.18')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (7, 1, N'no', N'yes', N'cannot be determined', N'')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (8, 1, N'0.4', N'0.6', N'0.7', N'0.3')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (9, 1, N'0.857', N'0.09', N'0.21', N'0.343')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (10, 1, N'mean: 1.47; standard deviation: 1.42', N'mean: 1.59; standard deviation: 1.09', N'mean: 1.59; standard deviation: 3.72', N'mean: 1.47; standard deviation: 1.19')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (11, 1, N'None of the other choices is correct', N'12.3', N'4.47', N'20')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (12, 1, N'134', N'67', N'44.22', N'93.8')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (13, 1, N'0.72', N'0.28', N'0.88', N'0.12')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (14, 1, N'0.0046', N'0.6218', N'0.0024', N'0.5501')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (15, 1, N'0.6324', N'0.9920', N'0.0998', N'0.5000')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (16, 1, N'0.132', N'0.005', N'0.402', N'0.017')
INSERT [dbo].[CauHoi_ChiTiet] ([MaCauHoi], [LoaiCauHoi], [A], [B], [C], [D]) VALUES (222, 1, N'few', N'few', N'fewf', N'ewfew')
GO
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (1, N'b', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (2, N'b', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (3, N'b', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (4, N'c', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (5, N'c', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (6, N'b', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (7, N'b', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (8, N'b', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (9, N'a', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (10, N'd', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (11, N'd', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (12, N'd', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (13, N'd', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (14, N'c', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (15, N'b', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (16, N'a', NULL)
INSERT [dbo].[DapAn] ([MaDapAn], [NoiDung], [DungSai]) VALUES (222, N'a', NULL)
GO
INSERT [dbo].[LoaiBaiThi] ([MaLoaiBaiThi], [TenLoaiBaiThi], [SoCau], [ThoiGianLamBai]) VALUES (1, N'Progress Test 1', 10, 30)
INSERT [dbo].[LoaiBaiThi] ([MaLoaiBaiThi], [TenLoaiBaiThi], [SoCau], [ThoiGianLamBai]) VALUES (2, N'Progress Test 2', 10, 30)
INSERT [dbo].[LoaiBaiThi] ([MaLoaiBaiThi], [TenLoaiBaiThi], [SoCau], [ThoiGianLamBai]) VALUES (3, N'Progress Test 3', 10, 30)
INSERT [dbo].[LoaiBaiThi] ([MaLoaiBaiThi], [TenLoaiBaiThi], [SoCau], [ThoiGianLamBai]) VALUES (4, N'Mid-term test', 20, 60)
INSERT [dbo].[LoaiBaiThi] ([MaLoaiBaiThi], [TenLoaiBaiThi], [SoCau], [ThoiGianLamBai]) VALUES (5, N'Final Exam', 20, 60)
GO
INSERT [dbo].[LoaiCauHoi] ([MaLoai], [TenLoai]) VALUES (1, N'Câu hỏi trắc nghiệm chọn 1 đáp án')
INSERT [dbo].[LoaiCauHoi] ([MaLoai], [TenLoai]) VALUES (2, N'Câu hỏi trắc nghiệm chọn nhiều đáp án')
GO
INSERT [dbo].[LoaiTaiKhoan] ([MaLoai], [TenLoai]) VALUES (1, N'Sinh Viên')
INSERT [dbo].[LoaiTaiKhoan] ([MaLoai], [TenLoai]) VALUES (2, N'Giáo Viên')
INSERT [dbo].[LoaiTaiKhoan] ([MaLoai], [TenLoai]) VALUES (3, N'Admin')
GO
INSERT [dbo].[MonHoc] ([MaMon], [TenMon]) VALUES (N'1      ', N'MAS291')
INSERT [dbo].[MonHoc] ([MaMon], [TenMon]) VALUES (N'2      ', N'PRJ301')
INSERT [dbo].[MonHoc] ([MaMon], [TenMon]) VALUES (N'3      ', N'IOT102')
INSERT [dbo].[MonHoc] ([MaMon], [TenMon]) VALUES (N'4      ', N'JPD123')
INSERT [dbo].[MonHoc] ([MaMon], [TenMon]) VALUES (N'5      ', N'CSD201')
INSERT [dbo].[MonHoc] ([MaMon], [TenMon]) VALUES (N'6      ', N'DBI202')
GO
INSERT [dbo].[MonHoc_LoaiBaiThi] ([MaMon], [MaLoaiBaiThi]) VALUES (N'1      ', 1)
INSERT [dbo].[MonHoc_LoaiBaiThi] ([MaMon], [MaLoaiBaiThi]) VALUES (N'1      ', 2)
INSERT [dbo].[MonHoc_LoaiBaiThi] ([MaMon], [MaLoaiBaiThi]) VALUES (N'1      ', 3)
INSERT [dbo].[MonHoc_LoaiBaiThi] ([MaMon], [MaLoaiBaiThi]) VALUES (N'1      ', 5)
INSERT [dbo].[MonHoc_LoaiBaiThi] ([MaMon], [MaLoaiBaiThi]) VALUES (N'2      ', 4)
INSERT [dbo].[MonHoc_LoaiBaiThi] ([MaMon], [MaLoaiBaiThi]) VALUES (N'2      ', 5)
GO
INSERT [dbo].[Nganh] ([MaNganh], [TenNganh]) VALUES (N'AI ', N'Trí tuệ nhân tạo')
INSERT [dbo].[Nganh] ([MaNganh], [TenNganh]) VALUES (N'IA ', N'An toàn thông tin')
INSERT [dbo].[Nganh] ([MaNganh], [TenNganh]) VALUES (N'SE ', N'Kỹ thuật phần mềm')
GO
INSERT [dbo].[SinhVien] ([MaSinhVien], [MaNganh], [Ho], [Ten], [NgaySinh], [SoDienThoai], [AnhDaiDien], [Mess], [TenDangNhap]) VALUES (1, N'SE ', N'Nguyễn', N'Trọng Phan', CAST(N'2003-02-10' AS Date), N'null      ', N'null', N'null', NULL)
INSERT [dbo].[SinhVien] ([MaSinhVien], [MaNganh], [Ho], [Ten], [NgaySinh], [SoDienThoai], [AnhDaiDien], [Mess], [TenDangNhap]) VALUES (2, N'SE ', N'Đoàn', N'Đức Quân', CAST(N'2003-04-23' AS Date), N'null      ', N'null', N'null', NULL)
INSERT [dbo].[SinhVien] ([MaSinhVien], [MaNganh], [Ho], [Ten], [NgaySinh], [SoDienThoai], [AnhDaiDien], [Mess], [TenDangNhap]) VALUES (4, N'IA ', N'Trần', N'Tiến Đạt', NULL, N'null      ', N'null', N'null', NULL)
INSERT [dbo].[SinhVien] ([MaSinhVien], [MaNganh], [Ho], [Ten], [NgaySinh], [SoDienThoai], [AnhDaiDien], [Mess], [TenDangNhap]) VALUES (5, N'AI ', N'Đỗ', N'Anh Tú', NULL, N'null      ', N'null', N'null', NULL)
INSERT [dbo].[SinhVien] ([MaSinhVien], [MaNganh], [Ho], [Ten], [NgaySinh], [SoDienThoai], [AnhDaiDien], [Mess], [TenDangNhap]) VALUES (6, N'AI ', N'Phạm', N'Quang Nhật', NULL, N'null      ', N'null', N'null', NULL)
INSERT [dbo].[SinhVien] ([MaSinhVien], [MaNganh], [Ho], [Ten], [NgaySinh], [SoDienThoai], [AnhDaiDien], [Mess], [TenDangNhap]) VALUES (7, N'IA ', N'Đặng', N'Thu Hà', NULL, N'null      ', N'null', N'null', NULL)
GO
INSERT [dbo].[SinhVien_BaiThi] ([MaSinhVien], [MaBaiThi], [TrangThai]) VALUES (1, N'1', 1)
INSERT [dbo].[SinhVien_BaiThi] ([MaSinhVien], [MaBaiThi], [TrangThai]) VALUES (1, N'3', 0)
INSERT [dbo].[SinhVien_BaiThi] ([MaSinhVien], [MaBaiThi], [TrangThai]) VALUES (1, N'4', 0)
INSERT [dbo].[SinhVien_BaiThi] ([MaSinhVien], [MaBaiThi], [TrangThai]) VALUES (1, N'5', 0)
INSERT [dbo].[SinhVien_BaiThi] ([MaSinhVien], [MaBaiThi], [TrangThai]) VALUES (1, N'6', 0)
INSERT [dbo].[SinhVien_BaiThi] ([MaSinhVien], [MaBaiThi], [TrangThai]) VALUES (1, N'7', 0)
INSERT [dbo].[SinhVien_BaiThi] ([MaSinhVien], [MaBaiThi], [TrangThai]) VALUES (2, N'6', 0)
INSERT [dbo].[SinhVien_BaiThi] ([MaSinhVien], [MaBaiThi], [TrangThai]) VALUES (2, N'7', 0)
GO
INSERT [dbo].[SinhVien_BaiThi_CauHoi_CauTraLoi] ([MaSinhVien], [MaBaiThi], [MaCauHoi], [CauTraLoi]) VALUES (1, N'1', 1, N'a')
INSERT [dbo].[SinhVien_BaiThi_CauHoi_CauTraLoi] ([MaSinhVien], [MaBaiThi], [MaCauHoi], [CauTraLoi]) VALUES (1, N'1', 2, N'b')
INSERT [dbo].[SinhVien_BaiThi_CauHoi_CauTraLoi] ([MaSinhVien], [MaBaiThi], [MaCauHoi], [CauTraLoi]) VALUES (1, N'1', 3, N'c')
INSERT [dbo].[SinhVien_BaiThi_CauHoi_CauTraLoi] ([MaSinhVien], [MaBaiThi], [MaCauHoi], [CauTraLoi]) VALUES (1, N'1', 4, N'd')
INSERT [dbo].[SinhVien_BaiThi_CauHoi_CauTraLoi] ([MaSinhVien], [MaBaiThi], [MaCauHoi], [CauTraLoi]) VALUES (1, N'1', 5, N'd')
INSERT [dbo].[SinhVien_BaiThi_CauHoi_CauTraLoi] ([MaSinhVien], [MaBaiThi], [MaCauHoi], [CauTraLoi]) VALUES (1, N'1', 6, N'c')
INSERT [dbo].[SinhVien_BaiThi_CauHoi_CauTraLoi] ([MaSinhVien], [MaBaiThi], [MaCauHoi], [CauTraLoi]) VALUES (1, N'1', 7, N'b')
INSERT [dbo].[SinhVien_BaiThi_CauHoi_CauTraLoi] ([MaSinhVien], [MaBaiThi], [MaCauHoi], [CauTraLoi]) VALUES (1, N'1', 8, N'a')
GO
INSERT [dbo].[SinhVien_MonHoc] ([MaSinhVien], [MaMon]) VALUES (1, N'1      ')
INSERT [dbo].[SinhVien_MonHoc] ([MaSinhVien], [MaMon]) VALUES (1, N'2      ')
INSERT [dbo].[SinhVien_MonHoc] ([MaSinhVien], [MaMon]) VALUES (2, N'2      ')
GO
INSERT [dbo].[TaiKhoan] ([TenDangNhap], [MatKhau], [CapDo]) VALUES (N'ad', N'123', 3)
INSERT [dbo].[TaiKhoan] ([TenDangNhap], [MatKhau], [CapDo]) VALUES (N'admin', N'123', 3)
INSERT [dbo].[TaiKhoan] ([TenDangNhap], [MatKhau], [CapDo]) VALUES (N'anh', N'113', 2)
INSERT [dbo].[TaiKhoan] ([TenDangNhap], [MatKhau], [CapDo]) VALUES (N'giang', N'113', 2)
INSERT [dbo].[TaiKhoan] ([TenDangNhap], [MatKhau], [CapDo]) VALUES (N'giaovien', N'1234', 2)
INSERT [dbo].[TaiKhoan] ([TenDangNhap], [MatKhau], [CapDo]) VALUES (N'QuanÐÐSE2', N'123', 1)
INSERT [dbo].[TaiKhoan] ([TenDangNhap], [MatKhau], [CapDo]) VALUES (N'sa', N'123', 3)
GO
ALTER TABLE [dbo].[BaoCaoLoi] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[CauHoi] ADD  DEFAULT ((1)) FOR [DoKho]
GO
ALTER TABLE [dbo].[CauHoi_ChiTiet] ADD  DEFAULT ('True') FOR [A]
GO
ALTER TABLE [dbo].[CauHoi_ChiTiet] ADD  DEFAULT ('False') FOR [B]
GO
ALTER TABLE [dbo].[SinhVien_BaiThi] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[BaiThi]  WITH CHECK ADD FOREIGN KEY([MaLoaiBaiThi])
REFERENCES [dbo].[LoaiBaiThi] ([MaLoaiBaiThi])
GO
ALTER TABLE [dbo].[BaiThi]  WITH CHECK ADD FOREIGN KEY([MaMon])
REFERENCES [dbo].[MonHoc] ([MaMon])
GO
ALTER TABLE [dbo].[BaiThi_CauHoi]  WITH CHECK ADD FOREIGN KEY([MaCauHoi])
REFERENCES [dbo].[CauHoi] ([MaCauHoi])
GO
ALTER TABLE [dbo].[BaoCaoLoi]  WITH CHECK ADD FOREIGN KEY([TaiKhoanBaoCao])
REFERENCES [dbo].[TaiKhoan] ([TenDangNhap])
GO
ALTER TABLE [dbo].[CauHoi]  WITH CHECK ADD FOREIGN KEY([MaMon])
REFERENCES [dbo].[MonHoc] ([MaMon])
GO
ALTER TABLE [dbo].[CauHoi_ChiTiet]  WITH CHECK ADD FOREIGN KEY([LoaiCauHoi])
REFERENCES [dbo].[LoaiCauHoi] ([MaLoai])
GO
ALTER TABLE [dbo].[CauHoi_ChiTiet]  WITH CHECK ADD FOREIGN KEY([MaCauHoi])
REFERENCES [dbo].[CauHoi] ([MaCauHoi])
GO
ALTER TABLE [dbo].[DapAn]  WITH CHECK ADD FOREIGN KEY([MaDapAn])
REFERENCES [dbo].[CauHoi] ([MaCauHoi])
GO
ALTER TABLE [dbo].[GiaoVien]  WITH CHECK ADD FOREIGN KEY([TenDangNhap])
REFERENCES [dbo].[TaiKhoan] ([TenDangNhap])
GO
ALTER TABLE [dbo].[MonHoc_LoaiBaiThi]  WITH CHECK ADD FOREIGN KEY([MaLoaiBaiThi])
REFERENCES [dbo].[LoaiBaiThi] ([MaLoaiBaiThi])
GO
ALTER TABLE [dbo].[MonHoc_LoaiBaiThi]  WITH CHECK ADD FOREIGN KEY([MaMon])
REFERENCES [dbo].[MonHoc] ([MaMon])
GO
ALTER TABLE [dbo].[SinhVien]  WITH CHECK ADD FOREIGN KEY([MaNganh])
REFERENCES [dbo].[Nganh] ([MaNganh])
GO
ALTER TABLE [dbo].[SinhVien]  WITH CHECK ADD FOREIGN KEY([TenDangNhap])
REFERENCES [dbo].[TaiKhoan] ([TenDangNhap])
GO
ALTER TABLE [dbo].[SinhVien_BaiThi]  WITH CHECK ADD FOREIGN KEY([MaSinhVien])
REFERENCES [dbo].[SinhVien] ([MaSinhVien])
GO
ALTER TABLE [dbo].[SinhVien_BaiThi_CauHoi_CauTraLoi]  WITH CHECK ADD FOREIGN KEY([MaBaiThi], [MaCauHoi])
REFERENCES [dbo].[BaiThi_CauHoi] ([MaBaiThi], [MaCauHoi])
GO
ALTER TABLE [dbo].[SinhVien_BaiThi_CauHoi_CauTraLoi]  WITH CHECK ADD FOREIGN KEY([MaSinhVien], [MaBaiThi])
REFERENCES [dbo].[SinhVien_BaiThi] ([MaSinhVien], [MaBaiThi])
GO
ALTER TABLE [dbo].[SinhVien_MonHoc]  WITH CHECK ADD FOREIGN KEY([MaMon])
REFERENCES [dbo].[MonHoc] ([MaMon])
GO
ALTER TABLE [dbo].[SinhVien_MonHoc]  WITH CHECK ADD FOREIGN KEY([MaSinhVien])
REFERENCES [dbo].[SinhVien] ([MaSinhVien])
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD FOREIGN KEY([CapDo])
REFERENCES [dbo].[LoaiTaiKhoan] ([MaLoai])
GO
USE [master]
GO
ALTER DATABASE [EOS_ADMIN] SET  READ_WRITE 
GO
