select distinct(concat(t2.sid, " , ", t2.sname))
from (select sid, sname, cid from sc join student on sc.sid = student.id where sid = 1) t1, (select sid, sname, cid from sc join student on sc.sid = student.id where sid != 1) t2
where t1.cid = t2.cid;