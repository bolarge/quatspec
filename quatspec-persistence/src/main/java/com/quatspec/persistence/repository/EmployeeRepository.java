package com.quatspec.persistence.repository;

import javax.transaction.Transactional;

import com.quatspec.persistence.domain.Employee;


@Transactional
public interface EmployeeRepository extends UserBaseRepository<Employee>{

	//@Query("select e from User as e Profile as p where p.id=?2 and p Member of e.profiles and p.status=true")
	//select c from Profile as c, User as u where u.id=:USERID and c MEMBER OF u.profiles and c.status=true"
	//@Query("select c from Profile as c, User as u where u.id=:userId and c MEMBER OF u.profiles and c.status=true")	
	//Employee getByUserNameAndProfile(String userName, Long profileId);
	
	//Employee findByUserNameAndProfiles(String userName, Long profileId);

}
