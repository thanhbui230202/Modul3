create database if not exists furama;
use furama;
create table position (
position_id int auto_increment primary key,
position_name varchar(45)
);
create table education_degree (
education_degree_id int auto_increment primary key,
education_degree_name varchar(45)
);
create table division (
division_id int auto_increment primary key,
division_name varchar(45)
);
create table user (
username varchar(255) primary key,
password varchar(255)
);
create table employee (
employee_id int primary key,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_id_card varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45) not null,
employee_email varchar(45),
employee_address varchar(45),
position_id int not null,
education_degree_id int not null,
division_id int not null,
username varchar(255),
foreign key (position_id) references position (position_id),
foreign key (education_degree_id) references education_degree(education_degree_id),
foreign key (division_id) references division(division_id),
foreign key (username) references user(username)
);
create table role (
role_id int primary key,
role_name varchar(255)
);
create table user_role (
role_id int,
username varchar(255),
foreign key(role_id) references role(role_id),
foreign key (username) references user(username)
);
create table customer_type (
customer_type_id int auto_increment primary key,
customer_type_name varchar(45)
);
create table customer (
customer_id int primary key,
customer_type_id int not null,
customer_name varchar(45) not null,
customer_birthday date not null,
customer_gender bit(1) not null,
customer_id_card varchar(45) not null,
customer_phone varchar(45) Not null,
customer_email varchar(45),
customer_address varchar(45),
foreign key(customer_type_id) references customer_type (customer_type_id)
);
create table service_type (
service_type_id int auto_increment primary key,
service_type_name varchar(45)
);
create table rent_type (
 rent_type_id int auto_increment primary key,
 rent_type_name varchar(45),
 rent_type_cost double
 );
 create table service (
 service_id int primary key,
 service_name varchar(45) not null,
 service_area int,
 service_cost double not null,
 service_max_people int,
 rent_type_id int not null,
 service_type_id int not null,
 standard_room varchar(45),
 description_other_convenience varchar(45),
 pool_area double,
 number_of_floors int,
 foreign key (rent_type_id) references rent_type(rent_type_id),
 foreign key (service_type_id) references service_type(service_type_id)
 );
create table contract (
contract_id int primary key,
contract_start_day datetime not null,
contract_end_day datetime not null,
contract_deposit double not null,
contract_total_money double not null,
employee_id int not null,
customer_id int not null,
service_id int not null,
foreign key (employee_id) references employee(employee_id),
foreign key (customer_id) references customer(customer_id),
foreign key (service_id) references service(service_id)
);
create table attach_service (
attach_service_id int auto_increment primary key,
attach_service_name varchar(45) not null,
attach_service_cost double not null,
attach_service_unit int not null,
attach_service_status varchar(45)
);
create table contract_detail (
contract_detail_id int auto_increment primary key,
contract_id int not null,
attach_service_id int not null,
quantity int not null,
foreign key (contract_id) references contract(contract_id),
foreign key (attach_service_id) references attach_service(attach_service_id)
);


