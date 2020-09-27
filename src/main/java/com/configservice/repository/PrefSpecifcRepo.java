package com.configservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.configservice.entity.PrefSpecificValue;

@Repository
public interface PrefSpecifcRepo extends JpaRepository<PrefSpecificValue, Long> {

	PrefSpecificValue findByUserIdAndPrefName(Long userId, String prefName);
	PrefSpecificValue findByUserId(Long userId);

}
