create database product_manage;
use product_manage;
create table product(
	id int primary key,
    name varchar(50),
    quantity int,
    price int,
    date_realease date,
    description varchar(50),
    category varchar(50)
);
select * from product;
drop table product;