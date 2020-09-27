package com.configservice.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configservice.entity.PrefCriteria;
import com.configservice.entity.PrefData;
import com.configservice.entity.UserPrefDetails;
import com.configservice.promotion.ConfigServiceConstants;
import com.configservice.repository.PrefCriteriaRepo;
import com.configservice.repository.PrefDataRepo;
import com.configservice.repository.PrefSpecifcRepo;
import com.configservice.service.CriteriaService;

@Service
public class CriteriaServiceImpl  implements CriteriaService{

	@Autowired 
	PrefDataRepo prefDataRepo;

	@Autowired
	PrefCriteriaRepo prefCriteriaRepo;


	@Autowired
	PrefSpecifcRepo prefSpecifcRepo;




	@Override
	public boolean isAllCriteraiSatisfied(Optional<UserPrefDetails> userPrefDetails, long prefId,String prefDefaultValue) {


		Optional<PrefData> prefData =prefDataRepo.findById(prefId);
		boolean isAllCriteriaSatisfied=true;
		if(prefData.isPresent())
		{

			for(String criteraiId:prefData.get().getCriteriaIds().split(":"))
			{

				System.out.println(prefData.get().toString());

				PrefCriteria prefCriteria =prefCriteriaRepo.findByCriteriaId(Long.valueOf(criteraiId));
				if(!checkCriteriaForPref(prefCriteria,userPrefDetails,prefDefaultValue))
				{
					return false;

				}


			}



		}

		return isAllCriteriaSatisfied;
	}




	private boolean checkCriteriaForPref(PrefCriteria prefCriteria,Optional<UserPrefDetails> userPrefDetails,String prefDefaultValue) {

		String prefName=prefCriteria.getPrefCriteraiCondition().split(":")[0];
		String operation=prefCriteria.getPrefCriteraiCondition().split(":")[1];
		String prefValue=prefCriteria.getPrefCriteraiCondition().split(":")[2];

		String existingPrefValue=prefSpecifcRepo.findByUserIdAndPrefName(userPrefDetails.get().getUserId(), prefName).getPrefValue();
        boolean isCriteriaSatIsfied=true;
        
        //WE CAN ALSO USER A COMPONENT FOR EACH OPERATION AND AVOID SWITCH CASE CONDITION
		switch(operation)
		{

		case ConfigServiceConstants.GREATER_THEN:
        System.out.println("IN GE Criteria!!!");
			if(Long.valueOf(existingPrefValue)<Long.valueOf(prefValue))
			{
				isCriteriaSatIsfied=false;
			}
			break;
		
			
		case ConfigServiceConstants.LESS_THEN:
			 System.out.println("IN LE Criteria!!!");

			if(Long.valueOf(existingPrefValue)>Long.valueOf(prefValue))
			{
				isCriteriaSatIsfied=false;
			}
			break;
	
		case ConfigServiceConstants.EQUALS_LONG:
			 System.out.println("IN EG Criteria!!!");

			if(!Long.valueOf(existingPrefValue).equals(Long.valueOf(prefValue)))
			{
				isCriteriaSatIsfied=false;
			}
			break;
			
		case ConfigServiceConstants.DEFAULT:
			 System.out.println("IN DEFAULT Criteria!!!");

			if(!existingPrefValue.equals(prefDefaultValue))
			{
				isCriteriaSatIsfied=false;
			}
			break;
			
		case ConfigServiceConstants.EQUALS_STRING:
			 System.out.println("IN EQUALS Criteria!!!");

			if(!existingPrefValue.equals(prefValue))
			{
				isCriteriaSatIsfied=false;
			}
			break;	


		}
		System.out.println("checkCriteriaForPref() ::isCriteriaSatIsfied:: "+isCriteriaSatIsfied);
		return isCriteriaSatIsfied;

	}
}
