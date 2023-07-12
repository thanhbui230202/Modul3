create database QuanLySinhVien;
use QuanLySinhVien;
create table Class(
	ClassID int auto_increment primary key,
    ClassName varchar(60) not null,
    StartDate datetime not null,
    Status Bit
);
create table Student(
	StudentID int auto_increment primary key,
    StudentName varchar(30) not null,
    Address varchar(50),
    Phone varchar(20),
    Status Bit,
    ClassID int not null,
    foreign key (ClassID) references Class(ClassID)
);
create table Subject(
	SubID int auto_increment primary key,
    SubName varchar(30) not null,
    Credit tinyint not null default(1) check(Credit >=1),
    Status bit default 1
);
create table Mark(
	MarkID int auto_increment primary key,
    SubID int not null ,
    StudentId int not null,
    Mark float default 0 check (Mark between 0 and 100),
    ExamTimes tinyint default 1,
    unique key(SubID,StudentID),
    foreign key (SubID) references Subject(SubID),
    foreign key (StudentID) references Student(StudentID)
);
insert into Class
values(1,'A1','2008-12-20',1),
	  (2,'A2','2008-12-22',1),
      (3,'B3',curdate(),0);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);
INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
select * from Student
where StudentName like 'h%';
select * from class
where month(StartDate) =12; 
select * from subject
where credit between 3 and 5;

update student
set ClassID = 2
where StudentName = 'Hung';
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select StudentName, SubName, Mark from mark
join student on student.studentid = mark.studentid
join subject on subject.subid = mark.subid
order by Mark desc, studentname;