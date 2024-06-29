select e.Fname, e.Lname
from EMPLOYEE e
join [DEPENDENT] d on e.Ssn = d.Essn
where e.Fname = d.Dependent_name and e.Sex = d.Sex