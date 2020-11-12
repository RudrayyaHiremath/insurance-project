package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entity.Insurance;

@Repository
public interface InsuranceListRepository extends JpaRepository<Insurance, Integer> {

}
