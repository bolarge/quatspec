package com.quatspec.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quatspec.persistence.domain.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
	
	@Query("select p from Profile as p where LOWER(p.name)=?1")
	Profile findByName(String name);
	
	@Query("select c from Profile as c, User as u where u.id=?1 and c MEMBER OF u.profiles and c.status=true")
	List<Profile> findProfileByUserId(Long userId);
	
	//@Query("select fd from FixedDepositDetails fd where fd.tenure = ?1 and fd.fdAmount <= ?2 and fd.active = ?3")
	//List<FixedDepositDetails> findByCustomQuery(int tenure, int fdAmount, String active);

}
