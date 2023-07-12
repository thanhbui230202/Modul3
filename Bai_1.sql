use student_management;
create table student(
	id int primary key,
    student_name varchar(45) null,
    age int null,
    country varchar(45) null
);
create table Class(
	id_class int primary key,
    class_name varchar(45)
);
select * from student_management