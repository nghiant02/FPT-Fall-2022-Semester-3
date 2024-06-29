create proc proc_CountEmp (@depNo int, @numOfEmps int output)
as
begin
	set @numOfEmps =	(select count(*)
						from DEPARTMENT d
						join EMPLOYEE e on e.Dno = d.Dnumber
						where d.Dnumber = @depNo)
END

