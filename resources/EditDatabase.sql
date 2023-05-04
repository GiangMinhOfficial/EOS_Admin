SELECT * FROM [dbo].[TaiKhoan]
SELECT * from [TaiKhoan] where TenDangNhap = 'sa' and MatKhau = '123'

ALTER TABLE [dbo].[SinhVien]
DROP COLUMN [MaMon]

SELECT * FROM [dbo].[SinhVien]

SELECT * FROM [dbo].[MonHoc]

DROP DATABASE [EOS_ADMIN]

SELECT * FROM [dbo].[BaiThi_CauHoi]

ALTER TABLE [dbo].[BaiThi_CauHoi]
ADD FOREIGN KEY([MaBaiThi]) REFERENCES `[dbo].[BaiThi]([MaBaiThi])

ALTER TABLE [dbo].[CauHoi]
ADD MaMon CHAR(7)

ALTER TABLE [dbo].[CauHoi]
ADD FOREIGN KEY(MaBaiThi) REFERENCES [dbo].[BaiThi]([MaBaiThi])

ALTER TABLE [dbo].[CauHoi]
DROP CONSTRAINT FK__CauHoi__MaBaiThi__6EF57B66

ALTER TABLE [dbo].[CauHoi]
DROP COLUMN mabaithi

SELECT * FROM [dbo].[CauHoi_ChiTiet]
SELECT * FROM [dbo].[BaiThi]
SELECT * FROM [dbo].[LoaiCauHoi]
SELECT * FROM [dbo].[CauHoi] WHERE [MaMon] = '2'
SELECT * FROM [dbo].[BaiThi_CauHoi] WHERE [MaBaiThi] = 1
SELECT * FROM [dbo].[MonHoc]
SELECT * FROM [dbo].[SinhVien]
SELECT * FROM [dbo].[Nganh]
SELECT * FROM [dbo].[SinhVien_BaiThi] WHERE [MaSinhVien] = 2
SELECT * FROM [dbo].[BaiThi]
select * from DapAn

--SELECT * FROM [dbo].[CauHoi] WHERE mabaithi = 

SELECT * FROM [dbo].[SinhVien_BaiThi_CauHoi]
SELECT * FROM [dbo].[SinhVien_BaiThi]
SELECT * FROM [dbo].[SinhVien_BaiThi_CauHoi_cautraloi] where masinhvien = 1 AND mabaithi = 1 and macauhoi = 1
SELECT * FROM [dbo].[DapAn] WHERE [MaDapAn] = 1

select * from taikhoan

-- 12/08/2023
drop table baithi

alter table sinhvien_baithi
drop constraint FK__SinhVien___MaBai__5AEE82B9

alter table baithi_cauhoi
drop constraint FK__BaiThi_Ca__MaBai__6E01572D

alter table SinhVien_BaiThi_CauHoi_CauTraLoi
drop constraint FK__SinhVien___MaBai__17036CC0

drop table MonHoc_LoaiBaiThi

select * from baithi where mamon = 1

SELECT * FROM baithi LIMIT 4 OFFSET 5

select count(*) from monhoc

select * from MonHoc
order by MaMon
offset 0 rows fetch next 5 rows only

select * from MonHoc where TenMon like '%d%'

select * from cauhoi where tenmon = 'mas291'
select * from monhoc

alter table cauhoi
alter column 

go
select * from CauHoi where mamon = 1
order by MaCauHoi
offset 0 rows fetch next 5 rows only

go
insert into CauHoi values(1, '')

select * from MonHoc where mamon = '1'

update MonHoc
set TenMon = ?
where MaMon = ?

delete from MonHoc
where mamon = 222

select * from monhoc_loaibaithi

delete from monhoc_loaibaithi
where mamon = 222

select * from cauhoi where macauhoi = 1 and mamon = 1

select * from CauHoi_ChiTiet

update CauHoi
set NoiDung = ?,
hinhanh = ?,
dokho = ?
where MaCauHoi = ?
go
update CauHoi_ChiTiet
set A = ?,
B = ?,
C = ?,
D = ?
where macauhoi = ?
go
update DapAn
set NoiDung = ?
where MaDapAn = ?

go
update CauHoi
set NoiDung = '',
HinhAnh = '',
DoKho = ''
from CauHoi ch, CauHoi_ChiTiet chct
where ch.MaCauHoi = chct.MaCauHoi

go
-- câu lệnh join 3 bảng là câu hỏi, câu hỏi chi tiết và đáp án 
with t as (select ch.*, chct.A, chct.B, chct.C, chct.D, chct.LoaiCauHoi, da.NoiDung noiDungDapAn, da.DungSai from CauHoi ch
join CauHoi_ChiTiet chct on ch.MaCauHoi = chct.MaCauHoi
join DapAn da on da.MaDapAn = ch.MaCauHoi)
update t
set t.NoiDung = ?,
t.HinhAnh = ?,
t.DoKho = ?,
t.A = ?,
t.B = ?,
t.C = ?,
t.D = ?,
t.noiDungDapAn = ?
where t.MaCauHoi = ?

go
update CauHoi
set MaMon = '999'
where MaCauHoi = 1

select * from CauHoi
select * from CauHoi_ChiTiet
select * from DapAn

insert into CauHoi (MaCauHoi, NoiDung, HinhAnh, MaMon, DoKho) values (?, ?, ?, ?)

insert into CauHoi_ChiTiet (A, B, C, D, LoaiCauHoi, MaCauHoi) values (?, ?, ?, ?, ?, ?)
 
insert into DapAn (NoiDung, MaDapAn) values(?, ?)

select * from LoaiCauHoi

delete from CauHoi where MaCauHoi = 999

select * from CauHoi where mamon = 1
                order by MaCauHoi
                offset 13 rows fetch next 5 rows only

				delete from cauhoi_chitiet where macauhoi = 2

delete from DapAn
where MaDapAn = 999

delete from CauHoi
where MaCauHoi = 1000

delete from cauhoi_chitiet where macauhoi = 1000

select * from CauHoi_ChiTiet

go
select * from baithi
where maloaibaithi in 
(select maLoaiBaiThi from LoaiBaiThi where TenLoaiBaiThi like '%pr%')

go
select * from LoaiBaiThi where TenLoaiBaiThi like '%pr%'

select * from baithi
select * from LoaiBaiThi

update baithi
set maloaibaithi = ?,
mamon = ?,
tgmode = ?,
tgdongde = ?
where mabaithi = ?

delete from baithi
where mabaithi = ?

insert into baithi values (?, ?, ?, ?, ?)

select * from baithi where mamon = 1

select * from cauhoi
select * from BaiThi_CauHoi

select * from CauHoi
where MaCauHoi not in
(select MaCauHoi from cauhoi
where MaCauHoi in (1, 2, 3)
and MaMon = 1)

insert into BaiThi_CauHoi values (1, 112)
select * from MonHoc

select * from CauHoi
where MaCauHoi in 
(select MaCauHoi from BaiThi_CauHoi where MaBaiThi = ?)
and NoiDung like '%?%'

select * from CauHoi
where MaCauHoi not in
(select MaCauHoi from BaiThi_CauHoi where MaBaiThi = 1)
and MaMon = 1
order by MaCauHoi
offset 1 rows fetch next 5 rows only

select * from BaiThi_CauHoi
insert into BaiThi_CauHoi values (?, ?)


select * from SinhVien
select * from SinhVien_BaiThi_CauHoi_CauTraLoi

select * from SinhVien sv
left join SinhVien_BaiThi_CauHoi_CauTraLoi sbcc on sv.MaSinhVien = sbcc.MaSinhVien

insert into SinhVien values (?, ?, ?, ?, ?, ?, ?, ?, ?)

select * from GiaoVien

alter table sinhvien
drop constraint FK__SinhVien__MaTaiK__4222D4EF

alter table taikhoan
drop constraint PK__TaiKhoan__2725087D0AE00053

alter table taikhoan
drop column MaSo

alter table taikhoan
alter column TenDangNhap VARCHAR(100) not null

alter table taikhoan
add constraint PK_TaiKhoan primary key(TenDangNhap)

alter table sinhvien
drop column mataikhoan

alter table sinhvien
add FOREIGN KEY (TenDangNhap) REFERENCES TaiKhoan(TenDangNhap)

select * from SinhVien
select * from TaiKhoan
select * from Nganh


insert into SinhVien values (?,?,?,?,?,?,?,?,?)

select * from LoaiBaiThi
select * from MonHoc

update SinhVien
set MaNganh = ?,
Ho = ?,
Ten = ?,
NgaySinh = ?,
SoDienThoai = ?,
AnhDaiDien = ?,
Mess = ?
where MaSinhVien = ?

select * from SinhVien
where Ho + ' ' + Ten like N'%trần%'

select * from SinhVien_BaiThi
select * from SinhVien_monhoc
select * from MonHoc_LoaiBaiThi

select * from BaiThi_CauHoi
select * from SinhVien_BaiThi_CauHoi_CauTraLoi
select * from SinhVien_BaiThi where masinhvien = 1
select * from sinhvien_baithi_cauhoi_cautraloi where masinhvien = 1 and mabaithi = 1
select * from SinhVien_BaiThi where masinhvien = 1

select * from CauHoi
select * from DapAn

delete from CauHoi where DapAn  = 112

select * from baithi 

select * from SinhVien_BaiThi where masinhvien = 1

alter table sinhvien_baithi
add constraint FK__BaiThi__MaBaiThi
FOREIGN KEY (MaBaiThi) REFERENCES [BaiThi](MaBaiThi)

select * from SinhVien_BaiThi where masinhvien = 1
select * from SinhVien_MonHoc where MaSinhVien = 1
select * from MonHoc_loaibaithi

alter table sinhvien_baithi
add TrangThai BIT default(0) not null

select * from SinhVien

select * from TaiKhoan

update TaiKhoan
set MatKhau = ?,
CapDo = ?
where TenDangNhap = ?

select * from SinhVien
select * from TaiKhoan where TenDangNhap like '%a%'

select * from MonHoc order by MaMon

--alter table cauhoi
--add check (dokho >= 1 and dokho <= 5)

select * from LoaiBaiThi
select * from SinhVien_BaiThi
select * from baithi
select * from SinhVien_BaiThi_CauHoi_CauTraLoi
select count(*) from BaiThi_CauHoi where mabaithi = 1
select * from LoaiBaiThi

select * from BaiThi_CauHoi
where MaBaiThi = 1
and MaCauHoi in 
(select MaCauHoi from CauHoi where NoiDung like '%tr%')

delete from BaiThi_CauHoi where MaCauHoi = 222

select * from CauHoi
where MaCauHoi in
(select MaCauHoi from BaiThi_CauHoi where MaBaiThi = 6)
and NoiDung like '%d%'

select * from SinhVien

select * from BaiThi_CauHoi

select * from baithi
select * from CauHoi

select * from BaiThi_CauHoi
select * from CauHoi_ChiTiet

select count(*) from BaiThi_CauHoi where MaBaiThi = 2

select * from SinhVien

select * from MonHoc_LoaiBaiThi
select * from LoaiBaiThi

select * from CauHoi
select * from CauHoi_ChiTiet
select * from DapAn

select * from TaiKhoan
select * from SinhVien

--alter table sinhvien
--add foreign key(tendangnhap) references taikhoan(tendangnhap)
--on delete cascade

select * from SinhVien_BaiThi where masinhvien = 1