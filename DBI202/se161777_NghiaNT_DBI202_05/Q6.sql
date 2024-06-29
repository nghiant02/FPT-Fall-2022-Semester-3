with t as (select e.Fname,e.Lname,e.Salary,d.Dname from EMPLOYEE e, DEPARTMENT d
where e.Dno = d.Dnumber
group by e.Fname,e.Lname,e.Salary,d.Dname)
select * from t t1 where t1.Salary = (select max(t2.Salary)
from t t2 where t1.Dname = t2.Dname)