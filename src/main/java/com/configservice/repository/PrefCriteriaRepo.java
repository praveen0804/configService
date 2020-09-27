package com.configservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.configservice.entity.PrefCriteria;

@Repository
public interface PrefCriteriaRepo extends JpaRepository<PrefCriteria, Long> {

	PrefCriteria findByCriteriaId(Long criteriaID);

}
