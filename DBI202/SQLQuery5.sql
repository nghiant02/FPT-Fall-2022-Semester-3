--thong tin nhan vien phai nu phong ban so 1
use FUH_COMPANY

select empName,empSex,depNum
from tblEmployee
where empSex='F'and depNum=1



select empBirthdate,empAddress
from tblEmployee 
where empName='John B. Smith'



select empSalary
from tblEmployee
where depNum=5 and empSalary between 30000 and 40000



select*
from tblEmployee e,tblDepartment d
where e.depNum=d.depNum



--ten nv, ma nv, ten nguoi phu thuoc
select e.empName,e.empSSN,d.depName
from tblEmployee e,tblDependent d
where e.empSSN=d.empSSN



select empSSN
from tblEmployee 
except 
select empSSN
from tblDependent



select empName
from tblDependent d,tblEmployee e
where d.depSex=e.empSex and d.empSSN = e.empSSN



select empName
from tblEmployee 
where empSalary>all
(	select empSalary
	from tblEmployee
	where depNum=5
)