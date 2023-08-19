create database benhan;
use benhan;
create table benh_an(
	mabenhan varchar(50)  primary key,
    tenbenhan varchar(50)
);
create table benh_nhan(
	mabenhnhan varchar(50) primary key,
	mabenhan varchar(50),
    name varchar(50),
    datebegin date,
    dateend date,
    lydo varchar(50),
	foreign key (mabenhan) references benh_an(mabenhan)
);
select * from benh_nhan;
drop database benhan;