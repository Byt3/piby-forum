package com.pharmawizard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.pharmawizard.domain.PrivateMessage;

@RepositoryRestResource
public interface PrivateMessageRepository extends JpaRepository<PrivateMessage, Long>{

}
