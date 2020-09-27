package com.configservice.Vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PreferenceReqVo {
	
	@JsonProperty
	long userId;
	@JsonProperty
	long prefId;
	@JsonProperty
	Object  prefOldValue;
	@JsonProperty
	Object  prefNewValue;
	
}
