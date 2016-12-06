package com.pharmawizard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pharmawizard.domain.Category;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	 Category findByName(@Param("name") String name);
}
