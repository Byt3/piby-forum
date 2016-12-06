package com.pharmawizard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.pharmawizard.domain.Inbox;

@RepositoryRestResource
public interface InboxRepository extends JpaRepository<Inbox, Long>{

}
