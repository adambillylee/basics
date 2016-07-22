## top 3 in each department
select e1.salary, e1.name, department.name
from employee e1 join department on e1.departmentid = department.id
where (
	# for each salary, find number of salaries >= itself in its department
	select count(e2.salary) from employee e2 
	# control the comparison within department by leting department id equal
	where e2.salary > e1.salary and e1.departmentid = e2.departmentid
) < 2