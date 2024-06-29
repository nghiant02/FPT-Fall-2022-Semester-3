use FUH_COMPANY

--1
select e.empSSN,e.empName,d.depNum,d.depName
from tblEmployee e, tblDepartment d
where d.depName=N'Phòng Nghiên cứu và phát triển' and e.empSSN = d.mgrSSN

--2
select p.proNum,p.proName,d.depNum,d.depName
from tblDepartment d, tblProject p
where d.depNum = p.depNum and d.depName=N'Phòng Nghiên cứu và phát triển'

--3
select p.proNum,p.proName,d.depName
from tblProject p, tblDepartment d
where p.proName = N'ProjectB' and p.depNum =d.depNum

--4
select e1.empSSN, e1.empName
from tblEmployee e1, tblEmployee e2 
where  e1.supervisorSSN = e2.empSSN and e2.empName=N'Mai Duy An'

--5
select e2.empSSN,e2.empName
from tblEmployee e1, tblEmployee e2
where e1.supervisorSSN=e2.empSSN and e1.empName=N'Mai Duy An'

--6
select l.locNum,l.locName
from tblProject p,tblLocation l
where p.locNum=l.locNum and p.proName=N'ProjectA'

--7
select p.proNum,p.proName
from tblLocation l,tblProject p
where l.locName = N'Tp Hồ Chí Minh' and p.locNum = l.locNum

--8
select d.depName,d.depBirthdate,e.empName
from tblEmployee e,tblDependent d
where e.empSSN=d.empSSN and DATEDIFF(YEAR,2022,d.depBirthdate) > 18

--9
select d.depName,d.depBirthdate,e.empName
from tblEmployee e,tblDependent d
where e.empSSN=d.empSSN and d.depSex='M'

--0
select d.depNum,d.depName,l.locName
from tblDepartment d, tblLocation l ,tblDepLocation dl
where d.depName=N'Phòng Nghiên cứu và phát triển' and d.depNum=dl.depNum and dl.locNum = l.locNum

--11
select p.proNum,p.proName, d.depName
from tblProject p, tblLocation l, tblDepartment d
where p.depNum=d.depNum and p.locNum = l.locNum and l.locName=N'Tp Hồ Chí Minh'

--12
select empName, a.depName, depRelationship
from tblDependent a, tblEmployee b, tblDepartment c
where a.empSSN=b.empSSN and b.depNum=c.depNum and a.depSex=N'F' and c.depName=N'Phòng Nghiên cứu và phát triển'

--13
select empName, a.depName, depRelationship
from tblDependent a, tblEmployee b, tblDepartment c
where a.empSSN=b.empSSN and b.depNum=c.depNum and (2022 - year(depBirthdate)) > 18 and c.depName=N'Phòng Nghiên cứu và phát triển'

--14
select depSex, count(depSex) as countDepSex
from tblDependent
group by depSex

--15
select depRelationship, count(depRelationship) as countDepRelationship
from tblDependent
group by depRelationship

--16
select b.depNum, b.depName, count(c.depName) as countDependent
from tblEmployee a, tblDepartment b, tblDependent c
where a.depNum=b.depNum and a.empSSN=c.empSSN
group by b.depNum, b.depName

--17
select b.depNum, b.depName, count(c.depName) as countDependent
from tblEmployee a, tblDepartment b, tblDependent c
where a.depNum=b.depNum and a.empSSN=c.empSSN
group by b.depNum, b.depName
having count(c.depName) <= all (select count(c.depName) as countDependent
from tblEmployee a, tblDepartment b, tblDependent c
where a.depNum=b.depNum and a.empSSN=c.empSSN
group by b.depNum, b.depName)

--18
select b.depNum, b.depName, count(c.depName) as countDependent
from tblEmployee a, tblDepartment b, tblDependent c
where a.depNum=b.depNum and a.empSSN=c.empSSN
group by b.depNum, b.depName
having count(c.depName) >=all(select count(c.depName) as countDependent
from tblEmployee a, tblDepartment b, tblDependent c
where a.depNum=b.depNum and a.empSSN=c.empSSN
group by b.depNum, b.depName)

--19
select a.empSSN, a.empName, c.depName, sum(b.workHours) as sumWorkHours
from tblEmployee a, tblWorksOn b, tblDepartment c
where a.empSSN=b.empSSN and a.depNum= c.depNum
group by a.empSSN, a.empName, c.depName

--20
select c.depNum, c.depName, sum(b.workHours) as sumWorkHours
from tblEmployee a, tblWorksOn b, tblDepartment c
where a.empSSN=b.empSSN and a.depNum= c.depNum
group by c.depNum, c.depName

--21
select a.empSSN, a.empName, c.depName, sum(b.workHours) as sumWorkHours
from tblEmployee a, tblWorksOn b, tblDepartment c
where a.empSSN=b.empSSN and a.depNum= c.depNum
group by a.empSSN, a.empName, c.depName
having sum(b.workHours) <=all(select sum(b.workHours) as sumWorkHours
from tblEmployee a, tblWorksOn b, tblDepartment c
where a.empSSN=b.empSSN and a.depNum= c.depNum
group by a.empSSN, a.empName, c.depName)

--22
select a.empSSN, a.empName, c.depName, sum(b.workHours) as sumWorkHours
from tblEmployee a, tblWorksOn b, tblDepartment c
where a.empSSN=b.empSSN and a.depNum= c.depNum
group by a.empSSN, a.empName, c.depName
having sum(b.workHours) >=all (select sum(b.workHours) as sumWorkHours
from tblEmployee a, tblWorksOn b, tblDepartment c
where a.empSSN=b.empSSN and a.depNum= c.depNum
group by a.empSSN, a.empName, c.depName)

--23
select empSSN, empName, depName
from tblEmployee a, tblProject b, tblDepartment c
where a.depNum=b.depNum and a.depNum=c.depNum 
group by empSSN, empName, depName
having count(empSSN) =1

--24
select empSSN, empName, depName
from tblEmployee a, tblProject b, tblDepartment c
where a.depNum=b.depNum and a.depNum=c.depNum 
group by empSSN, empName, depName
having count(empSSN) =2

--25
select empSSN, empName, depName
from tblEmployee a, tblProject b, tblDepartment c
where a.depNum=b.depNum and a.depNum=c.depNum 
group by empSSN, empName, depName
having count(empSSN) >= 2

--32
select l.locName, count(d.depNum) as NumOfDepartment
from tblDepLocation d join tblLocation l on d.locNum = l.locNum
group by l.locName

--33
select d.depNum, d.depName, COUNT(dl.locNum) as NumOfLocation
from tblDepartment d join tblDepLocation dl on  d.depNum = dl.depNum
group by d.depNum, d.depName

--34
select d.depNum, d.depName, COUNT(dl.locNum) as NumOfLocation
from tblDepartment d join tblDepLocation dl on  d.depNum = dl.depNum
group by d.depNum, d.depName
having COUNT(dl.locNum) >= ALL (select COUNT(dl.locNum)
							    from tblDepartment d join tblDepLocation dl on  d.depNum = dl.depNum
								group by d.depNum, d.depName) 

--35
select d.depNum, d.depName, COUNT(dl.locNum) as NumOfLocation
from tblDepartment d join tblDepLocation dl on  d.depNum = dl.depNum
group by d.depNum, d.depName
having COUNT(dl.locNum) <= ALL (select COUNT(dl.locNum)
							    from tblDepartment d join tblDepLocation dl on  d.depNum = dl.depNum
								group by d.depNum, d.depName) 

--36
select l.locName, COUNT(d.depNum) as NumOfDepartment
from tblLocation l join tblDepLocation d on l.locNum = d.locNum
group by l.locName
having COUNT(d.depNum) >= ALL (select COUNT(d.depNum)
							   from tblLocation l join tblDepLocation d on l.locNum = d.locNum
                               group by l.locName)

--37
select l.locName, COUNT(d.depNum) as NumOfDepartment
from tblLocation l join tblDepLocation d on l.locNum = d.locNum
group by l.locName
having COUNT(d.depNum) <= ALL (select COUNT(d.depNum)
							   from tblLocation l join tblDepLocation d on l.locNum = d.locNum
                               group by l.locName)

--38
select e.empSSN, e.empName, COUNT(d.depName) as NumOfDependent
from tblEmployee e join tblDependent d on e.empSSN = d.empSSN
group by e.empSSN, e.empName
having COUNT(d.depName) >= ALL (select COUNT(d.depName)
								from tblEmployee e join tblDependent d on e.empSSN = d.empSSN
								group by e.empSSN, e.empName)
--39
select e.empSSN, e.empName, COUNT(d.depName) as NumOfDependent
from tblEmployee e join tblDependent d on e.empSSN = d.empSSN
group by e.empSSN, e.empName
having COUNT(d.depName) <= ALL (select COUNT(d.depName)
								from tblEmployee e join tblDependent d on e.empSSN = d.empSSN
								group by e.empSSN, e.empName)
--40
select e.empSSN, e.empName, d.depName
from tblEmployee e join tblDepartment d on e.depNum= d.depNum
where empSSN not in (select empSSN from tblDependent)
group by e.empSSN, e.empName, d.depName

--41
select d.depNum, d.depName
from tblEmployee e join tblDepartment d on e.depNum= d.depNum
where empSSN not in (select empSSN from tblDependent)
group by d.depNum, d.depName

--42
select empSSN,empName,depName
from tblEmployee e join tblDepartment d on d.depNum=e.depNum
where e.depNum not in (select depNum from tblProject)

--43
select mgrSSN,depName
from tblDepartment
where depNum not in(select depNum from tblProject)

--44
select d.mgrSSN,depName
from tblDepartment d,tblProject p
where d.depNum=p.depNum and d.depNum not in(select depNum from tblProject where proName='ProjectA')

--45
select d.mgrSSN,d.depName,count(proNum) as countpronum
from tblDepartment d join tblProject  p on d.depNum=p.depNum
group by d.depName,d.mgrSSN

--46
select d.mgrSSN,d.depName,count(proNum) as countpronum
from tblDepartment d join tblProject  p on d.depNum=p.depNum
group by d.depName,d.mgrSSN
having count(proNum) <=all(select count(proNum) as countpronum
from tblDepartment d join tblProject  p on d.depNum=p.depNum
group by d.depName,d.mgrSSN)

--47
select d.mgrSSN,d.depName,count(proNum) as countpronum
from tblDepartment d join tblProject  p on d.depNum=p.depNum
group by d.depName,d.mgrSSN
having count(proNum) >=all (select count(proNum) as countpronum
from tblDepartment d join tblProject  p on d.depNum=p.depNum
group by d.depName,d.mgrSSN)

--48
select d.mgrSSN, d.depName, count (empSSN) as CountEmployee, p.proName
from tblDepartment d, tblProject p, tblEmployee e 
where d.depNum = p.depNum and d.depNum = e.depNum
group by d.mgrSSN, d.depName, p.proName
having count(empSSN) > 5

--49
select e.empSSN, e.empName
from tblEmployee e, tblDepartment d
where  e.depNum = d.depNum and d.depName = N'Phòng Nghiên cứu và phát triển' and e.empSSN not in (select empSSN from tblDependent)

--50
select e.empSSN, e.empName, sum(w.workHours) as SumWorkHours
from tblEmployee e join tblWorksOn w on e.empSSN = w.empSSN
where e.empSSN not in (select empSSN from tblDependent)
group by e.empSSN, e.empName

--51
select e.empSSN, e.empName, count (d.depName) as CountDependent, sum(w.workHours) as SumWorkHours
from tblEmployee e, tblWorksOn w, tblDependent d
where e.empSSN = w.empSSN and e.empSSN = d.empSSN
group by e.empSSN, e.empName
having count (d.depName) > 3

--52
select e.empSSN, e.empName, sum(w.workHours) as SumWorkHours
from tblEmployee e join tblWorksOn w on e.empSSN = w.empSSN
where e.supervisorSSN = (select empSSN from tblEmployee where empName = N'Mai Duy An')
group by e.empSSN, e.empName