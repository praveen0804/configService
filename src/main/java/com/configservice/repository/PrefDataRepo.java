package com.configservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.configservice.entity.PrefData;

@Repository
public interface PrefDataRepo extends JpaRepository<PrefData, Long> {

	

}
