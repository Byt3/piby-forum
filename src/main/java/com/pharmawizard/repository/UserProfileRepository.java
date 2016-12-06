package com.pharmawizard.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pharmawizard.domain.UserProfile;

@RepositoryRestResource
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	UserProfile findByUsername(@Param("username") String username);


}
