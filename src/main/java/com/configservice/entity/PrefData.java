package com.configservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="prefrence_data")
@Data
public class PrefData {
	

	@Id
	@Column(name = "pref_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prefId;

	@Column(name = "pref_name")
	private String prefName;

	@Column(name = "pref_type")
	private String prefType;
	
	
	@Column(name = "pref_criteriaid_list")
	private String criteriaIds ;
	
	@Column(name = "pref_default_value")
	private String pref_default_value ;
	

	public PrefData() {
		super();
	}

}
