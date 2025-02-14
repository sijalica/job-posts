package com.jobposts.demo.repository;

import com.jobposts.demo.entities.UsersType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersTypeRepository extends JpaRepository<UsersType, Integer> {
}
