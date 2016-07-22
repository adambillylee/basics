## select student id not in
select id, sname
from student
where student.id not in

## set of student id have not taken class from abc
(select distinct(student.id)
from student
join sc
on sc.sid = student.id
join course
on course.id = sc.cid
join teacher
on teacher.id = course.tid
where teacher.tname = "abc");