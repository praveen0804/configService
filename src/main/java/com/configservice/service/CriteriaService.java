package com.configservice.service;

import java.util.Optional;

import com.configservice.entity.UserPrefDetails;

public interface CriteriaService {
	
	public boolean isAllCriteraiSatisfied(Optional<UserPrefDetails> userPrefDetails ,long prefId,String prefDefaultValue);

}
