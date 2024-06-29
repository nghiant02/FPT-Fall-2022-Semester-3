select * 
from tblDepartment

select top 5 empSSN,empName,year(empBirthdate)as'yearDate',empSalary
from tblEmployee
where empSalary>100000 and year(empBirthdate)>=1970
order by empSalary 

--delete
delete from tblDepartment
where mgrSSN is NULL

select distinct empSSN
from tblWorksOn
