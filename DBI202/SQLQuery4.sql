use FUH_COMPANY
select empAddress,empName
from tblEmployee
where depNum=1

select empName
from tblEmployee
where empSSN = 30121050037

select top 5 empName,empSalary
from tblEmployee
order by empSalary desc