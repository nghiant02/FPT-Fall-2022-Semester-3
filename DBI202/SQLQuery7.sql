use FUH_COMPANY
begin
--khai bao bien
declare @name nvarchar(30),@salary decimal
--gan gia tri cho bien
select @name=empName,@salary=empSalary
from tblEmployee
where empSalary=(
select max(empSalary)
from tblEmployee
)
--xu ly
print 'Your name: '+@name
print 'Salary: '+convert (varchar,@salary)
end



begin
declare @name1 nvarchar(30),@salary1 decimal,@avgsalary decimal
select @name1 = empName,@salary1=empSalary
from tblEmployee
where empSSN='30121050027'
select @avgsalary=avg(empSalary)
from tblEmployee
where depNum=(
select depNum
from tblEmployee
where empSSN='30121050027'
)
if(@salary1>=@avgsalary)
print 'High salary'
else
print 'Low salary'
end



begin
select empSSN,empName,case empSex 
when 'F' then 'Nu' 
when 'M' then 'Nam' 
end as 'Gioi tinh'
from tblEmployee
end