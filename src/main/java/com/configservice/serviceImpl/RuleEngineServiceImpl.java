package com.configservice.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configservice.Vo.PreferenceReqVo;
import com.configservice.entity.PrefData;
import com.configservice.entity.PrefSpecificValue;
import com.configservice.entity.UserPrefDetails;
import com.configservice.repository.PrefDataRepo;
import com.configservice.repository.PrefSpecifcRepo;
import com.configservice.repository.UserPrefDetailsRepo;
import com.configservice.service.CriteriaService;
import com.configservice.service.RuleEngine;

@Service
public class RuleEngineServiceImpl  implements RuleEngine{


	@Autowired
	UserPrefDetailsRepo userPrefDetailsRepo;

	@Autowired
	CriteriaService criteriaService;

	@Autowired
	PrefSpecifcRepo prefSpecifcRepo;


	@Autowired
	PrefDataRepo prefDataRepo;


	@Override
	public boolean applyPref(PreferenceReqVo preference) {

		Optional<UserPrefDetails> userPrefDetails=userPrefDetailsRepo.findById(preference.getUserId());
		Optional<PrefData> prefData = prefDataRepo.findById(preference.getPrefId());
		
		if(userPrefDetails.isPresent())
		{
			System.out.println(userPrefDetails.get().toString());
			boolean isAllCriteriaSatisfied=criteriaService.isAllCriteraiSatisfied(userPrefDetails, preference.getPrefId(),prefData.get().getPref_default_value());
			if(isAllCriteriaSatisfied)
			{
				
				PrefSpecificValue prefSpecificValue=prefSpecifcRepo.findByUserIdAndPrefName(userPrefDetails.get().getUserId(),prefData.get().getPrefName());
				prefSpecificValue.setPrefValue(String.valueOf(preference.getPrefNewValue()));
				prefSpecifcRepo.save(prefSpecificValue);
				System.out.println("Prefrence :: "+prefData.get().getPrefName()+" Setting Value :: "+String.valueOf(preference.getPrefNewValue()));
				return true;
			}
			
		}


		return false;
	}




}
