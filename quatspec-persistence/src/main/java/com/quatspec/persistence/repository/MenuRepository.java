package com.quatspec.persistence.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.quatspec.persistence.domain.Menu;

@Transactional
public interface MenuRepository extends CrudRepository<Menu, Long> {
	
	@Query("select c from Menu as c where c.profile.id=?1 order by c.displayIndex asc")
	Set<Menu> findAllActiveMenus(Long profleId);

}
