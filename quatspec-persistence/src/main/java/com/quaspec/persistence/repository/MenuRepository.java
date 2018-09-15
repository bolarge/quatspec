package com.quaspec.persistence.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.quaspec.persistence.domain.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {
	
	@Query("select c from Menu as c where c.profile.id=?1 order by c.displayIndex asc")
	Set<Menu> findAllActiveMenus(Long profleId);

}
