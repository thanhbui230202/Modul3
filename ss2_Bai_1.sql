create database Bai2_1;
use Bai2_1;
create table NHACC(
	MANCC int auto_increment primary key,
    TenNCC varchar(255),
    DiaChi varchar(255),
    SDT int
);
create table PhieuXuat(
	SoPX int auto_increment primary key,
    NgayXuat date
);
create table VatTu(
	MaVTU int auto_increment primary key,
    TenVTU varchar(255)
);
create table PhieuNhap(
	SoPN int auto_increment primary key,
    NgayNhap date
);
create table DonDH(
	SoDH int auto_increment primary key,
    NgayDH date,
    MaNCC int,
    foreign key (MaNCC) references NHACC(MANCC)
);

create  table CTPX(
	SoPX int,
    MaVTU int,
    DGXUAT double,
    SLXuat int,
    primary key(SoPX, MaVTU),
    foreign key (SoPX) references PhieuXuat(SoPX),
    foreign key (MaVTU) references VatTu(MaVTU)
);
create table CTPN(
	  MaVTU int,
      SoPN int,
      DGNHAP double,
	  SLNHAP int,
      primary key(MaVTU, SoPN),
	  foreign key (SoPN) references PhieuNhap(SoPN),
	  foreign key (MaVTU) references VatTu(MaVTU)
);
create table CTDH(
	 MaVTU int,
     SoDH int,
     SLDH int,
     trangthai varchar(25),
     primary key(MaVTU,SoDH),
     foreign key(MaVTU) references VatTu(MaVTU),
     foreign key(SoDH) references DonDH(SoDH)
);
create table SDT(
	MANCC int primary key,
    SDT int,
    foreign key (MANCC) references NHACC(MANCC)
);