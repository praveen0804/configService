package com.configservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="pref_specific_values")
@Data
public class PrefSpecificValue {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "pref_name")
	private String prefName;

	@Column(name = "pref_value")
	private String prefValue;
	

	public PrefSpecificValue() {
		super();
	}

}
