--Q2
SELECT *
FROM EMPLOYEE e
WHERE e.Dno = 5 AND e.Salary BETWEEN 30000 AND 40000
--Q3
select e1.Fname, e1.Lname, e2.Fname, e2.Lname
from EMPLOYEE e1
join EMPLOYEE e2 on e1.Super_ssn = e2.Ssn
order by e1.Fname DESC
--Q4
select e.Fname, e.Lname
from EMPLOYEE e
join [DEPENDENT] d on e.Ssn = d.Essn
where e.Fname = d.Dependent_name and e.Sex = d.Sex
--Q5
select a.Dno,a.Dname,b.NumberOfEmployee from
(select distinct e.Dno,d.Dname from EMPLOYEE e, DEPARTMENT d
where e.Dno = d.Dnumber
group by e.Dno,d.Dname
having count(distinct Ssn) > 5) as a
join
(select Dno,count(ssn) as NumberOfEmployee from EMPLOYEE
where Salary > 40000
group by Dno) as b
on a.Dno = b.Dno
--Q6
with t as (select e.Fname,e.Lname,e.Salary,d.Dname from EMPLOYEE e, DEPARTMENT d
where e.Dno = d.Dnumber
group by e.Fname,e.Lname,e.Salary,d.Dname)
select * from t t1 where t1.Salary = (select max(t2.Salary)
from t t2 where t1.Dname = t2.Dname)
--Q7
select Dnumber,Dname from DEPARTMENT
where Dnumber not in(
select d.Dnumber from DEPARTMENT d inner join PROJECT p on d.Dnumber=p.Dnum
where p.Pname='ProductX')
--Q8
create proc proc_CountEmp (@depNo int, @numOfEmps int output)
as
begin
	set @numOfEmps =	(select count(*)
						from DEPARTMENT d
						join EMPLOYEE e on e.Dno = d.Dnumber
						where d.Dnumber = @depNo)
END
