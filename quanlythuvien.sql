create database managebook;
use managebook;
create table book(
	id varchar(50) primary key,
    name varchar(50),
	author varchar(50),
    descrip varchar(50),
    quantity int
);
create table student(
	id varchar(50) primary key,
    name varchar(50),
    class varchar(50)
);
create table the_muon_sach(
	id varchar(50) primary key,
    idsach varchar(50),
    idhs varchar(50),
    status boolean,
    datebegin date,
    dateend date,
    foreign key (idsach) references book(id),
    foreign key (idhs) references student(id)
);
drop database managebook;
select * from book