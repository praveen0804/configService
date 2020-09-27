package com.configservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.configservice.Vo.PreferenceReqVo;
import com.configservice.service.RuleEngine;

@RestController
public class PrefrenceControlller {
	
	@Autowired
	RuleEngine prefEngine;
	
	@RequestMapping(value="/apply/prefrence",method = RequestMethod.POST)
	public boolean getDiscount( @RequestBody PreferenceReqVo preference)
	{
		
		return prefEngine.applyPref(preference);
		
	}

}
