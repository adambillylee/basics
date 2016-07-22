select sid as id, student.sname, count(sc.cid), sum(score)
from student
join sc
on student.id = sc.sid
group by id