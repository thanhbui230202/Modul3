create database QuanLyBanHang;
use QuanLyBanHang;
create table Customer(
	cID int primary key,
    cName varchar(25),
    cAge int
);
create table oder(
	oID int primary key,
    cID int,
    oDate date,
    oTotalPrice double,
    foreign key (cID) references Customer(cID) 
);
create table Product(
	pID int primary key,
    pName varchar(255),
    pPrice double
);
create table OrderDetail(
	oID int,
    pID int,
    odQTY varchar(255),
    primary key(oID,pID),
    foreign key(oID) references oder(oID),
    foreign key(pID) references Product(pID)
);
insert into customer(cID,cName,cAge)
values(1,'Minh Quan',10),
	  (2,'Ngoc Oanh',20),
      (3,'Hong Ha',50);
insert into oder(oID,cID,oDate,oTotalPrice)
values(1,1,'2006-03-21',Null),
	  (2,2,'2006-03-23',Null),
		(3,1,'2006-03-16',Null);
insert into product(pID,pName,pPrice)
values(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);
insert into orderdetail(oID,pID,odQTY)
values(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

