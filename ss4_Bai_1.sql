use quanlysinhvien;
SELECT Address, COUNT(StudentId) AS 'Số lượng học viên'
FROM Student
GROUP BY Address;
-- 
SELECT S.StudentId,S.StudentName, AVG(Mark)FROM Student S 
join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select s1.subID, s1.subname,s1.status,s1.credit from subject s1
where s1.credit in ( select MAX(sub.credit) from subject sub );
--  Hiển thị các thông tin môn học có điểm thi lớn nhất.
select m.markID, m.subid,m.studentid,m.mark,m.examtimes from mark m
where m.mark in (select max(m1.mark) from mark m1);
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
SELECT S.StudentId,S.StudentName, AVG(Mark) as 'DTB' FROM Student S 
join Mark m on S.StudentId = m.StudentId
GROUP BY S.StudentId, S.StudentName
order by AVG(mark) desc;


