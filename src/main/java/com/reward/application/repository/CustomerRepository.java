package com.reward.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reward.application.entity.CustomerEntity;
/**
 * Repository for Customer entity.
 * Provides CRUD operations and custom queries.
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

}
