use FUH_COMPANY

--Retrieve a list of employees and the projects they are working on, ordered by department and, within each department, ordered alphabetically byname, then Salary desc.
select empName, proName, empSalary
from tblDepartment d,tblEmployee e,tblProject p,tblWorksOn w
where p.proNum = w.proNum and w.empSSN = e.empSSN and e.depNum=d.depNum
order by d.depName,e.empName asc,e.empSalary desc


--Write a query that displays employee number without dependents
select*
from tblEmployee 
where empSSN not in(select empSSN from tblDependent)


--tong so h lam cua nv
select e.empSSN,e.empName, sum(workHours) as sumworkHours
from tblEmployee e, tblWorksOn w 
where e.empSSN=w.empSSN
group by e.empSSN,e.empName
having sum(workHours)>40


-- Find the sum of the salaries of all employees of the ‘Research’ department,
-- as well as the maximum salary, the minimum salary, and the aver- age salary in this department.
select d.depName,sum(empSalary)as SumSalary,max(empSalary)as MaxSalary,min(empSalary)as MinSalary,avg(empSalary)as AvgSalary
from tblDepartment d, tblEmployee e 
group by d.depName
having d.depName=N'Phòng Nghiên cứu và phát triển';
-- For each department, retrieve the department number, 
-- the number of employees in the department, and their average salary.
select d.depNum,count(empName)as countname,avg(empSalary)as avgsalary
from tblDepartment d join tblEmployee e on d.depNum=e.depNum
group by d.depNum



-- For each project on which more than two employees work,
-- retrieve the project number, the project name, and the number of employees who work on the project.
select p.proNum,p.proName, count(e.empSSN)as countssn
from tblEmployee e join tblProject p on p.depNum=e.depNum
group by p.proNum,p.proName
having count(e.empSSN)>2
-- Write a query to display Dnumber, Dname, NumOfEmployees For each department that has more than five employees,
-- where NumOfEmployees is the count of employees who are making more than $40,000 belonging to each department.
-- Display the results in descending order of NumOfEmployees
select d.depNum, d.depName, Count (e.empSSN) as NumOfEmployees
from tblDepartment d join tblEmployee e on d.depNum = e.depNum
where e.empSalary > 40000
group by d.depNum, d.depName
having Count (e.empSSN)>5
