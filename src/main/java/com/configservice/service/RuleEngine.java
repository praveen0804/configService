package com.configservice.service;

import com.configservice.Vo.PreferenceReqVo;

public interface RuleEngine {
	
	public boolean applyPref(PreferenceReqVo preference);

}
