package com.configservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="pref_criteria")
@Data
public class PrefCriteria {
	

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "criteria_id")
	private Long criteriaId;

	@Column(name = "pref_criteria_condition")
	private String prefCriteraiCondition;
	

	public PrefCriteria() {
		super();
	}

}
