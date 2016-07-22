# get the student information
select id, sname
from student
where id in

# count # of courses of teacher abs's course that each student has taken, and select the student have taking all courses from teacher
(select student.id 
from student 
join sc on sc.sid = student.id 
join course on sc.cid = course.id 
join teacher on course.tid = teacher.id 
where teacher.tname = "abc" group by student.id 
having count(sid) = 

	## count the number of courses teacher abc teaches
	(select count(course.id) from course join teacher on teacher.id = course.tid where teacher.tname = "abc" group by tid)
	
)