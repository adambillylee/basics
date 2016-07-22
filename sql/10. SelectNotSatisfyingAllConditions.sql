select id, sname
from student
where id in
(select distinct(student.id) 
from student 
join sc on sc.sid = student.id join course on sc.cid = course.id 
group by student.id 
having count(sc.cid) <
	(select count(id) from course)
)