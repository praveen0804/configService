package com.configservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.configservice.entity.UserPrefDetails;

@Repository
public interface UserPrefDetailsRepo extends JpaRepository<UserPrefDetails, Long> {

	

}
