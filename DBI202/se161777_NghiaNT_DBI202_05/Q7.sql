select Dnumber,Dname from DEPARTMENT
where Dnumber not in(
select d.Dnumber from DEPARTMENT d inner join PROJECT p on d.Dnumber=p.Dnum
where p.Pname='ProductX')