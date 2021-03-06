package com.pharmawizard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pharmawizard.domain.Comment;

@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
