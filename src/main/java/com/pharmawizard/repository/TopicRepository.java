package com.pharmawizard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pharmawizard.domain.Topic;

@RepositoryRestResource
public interface TopicRepository extends JpaRepository<Topic, Long> {

}