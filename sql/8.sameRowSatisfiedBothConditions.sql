select t1.sname
from (select student.sname, student.id, score from student join sc on sc.sid = student.id join course where course.id = sc.cid and course.cname = "a") t1,
(select student.sname, student.id, score from student join sc on sc.sid = student.id join course where course.id = sc.cid and course.cname = "b") t2
where t1.score > t2.score and t1.id = t2.id;