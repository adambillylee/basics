select t1.id
from (select student.id, sc.score from student join sc on student.id = sc.sid where sc.cid = 1) t1, 
	(select student.id, sc.score from student join sc on student.id = sc.sid where sc.cid = 2) t2
where t1.score > t2.score and t1.id = t2.id;