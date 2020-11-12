package com.insurance.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.CustomerRegistrationPolicy;

public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistrationPolicy, Integer> {

	public Page<CustomerRegistrationPolicy> findByuserRegistrationId(int userId, Pageable pageable);

}
