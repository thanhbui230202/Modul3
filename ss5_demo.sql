create database ss5_demo;
use ss5_demo;
create table Products(
	Id int auto_increment primary key,
	productCode int,
	productName varchar(50),
	productPrice int,
	productAmount int,
	productDescription varchar(50),
	productStatus varchar(50)
);
insert into Products
values (1,121,'May giat',5,3,'Good','Con'),
	   (2,122,'Tu lanh',7,5,'Bad','Het'),
	   (3,123,'Quat',9,4,'OK','Con');
select*from products;
-- Bước 3
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index index_products
on Products(productCode);
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index composite_index
on Products(productName,productPrice);
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN SELECT * FROM Products WHERE productName = 'Tu lanh'; 
-- Bước 4
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view product_view as
select productCode, productName, productPrice, productStatus
from products;
select * from product_view;
-- Tiến hành sửa đổi view
CREATE OR REPLACE VIEW product_view AS
SELECT productCode, productName, productPrice, productStatus
FROM products
WHERE productName = 'Quat';
-- Tiến hành xoá view
drop view product_view;
-- Bước 5
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure select_products (in pro_id int(11))
begin
	select* from products where id = pro_id;
end //
delimiter ;
call select_products(1);
-- Tạo store procedure thêm một sản phẩm mới
delimiter //
create procedure add_products ()
begin
	insert into products values  (4,124,'Honda',15,5,'OK','Con');
end//
delimiter ;
call add_products;
select * from products;
-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure update_product (
in pro_id int, 
in pro_code int, 
in pro_name varchar(50), 
in pro_price int,
in pro_amount int,
in pro_des varchar(50),
in pro_status varchar(50)
)
begin
	update products
    set productCode = pro_code,
		productName = pro_name,
        productPrice = pro_price,
         productAmount = pro_amount,
        productDescription = pro_des,
       productStatus =  pro_status
     where pro_id = id;
end //
delimiter ;
call update_product(4,125,'Oto',15,5,'OK','Con');
select * from products;
drop procedure update_product;
-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_products (in pro_id int)
begin
	delete from products
	where pro_id = id;
end//
delimiter ;
call delete_products(4);
select * from products;