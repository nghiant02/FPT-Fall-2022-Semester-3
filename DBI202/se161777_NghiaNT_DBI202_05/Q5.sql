select a.Dno AS Dnumber,a.Dname,b.NumberOfEmployee from
(select distinct e.Dno,d.Dname from EMPLOYEE e, DEPARTMENT d
where e.Dno = d.Dnumber
group by e.Dno,d.Dname
having count(distinct Ssn) > 5) as a
join
(select Dno,count(ssn) as NumberOfEmployee from EMPLOYEE
where Salary > 40000
group by Dno) as b
on a.Dno = b.Dno