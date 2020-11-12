package com.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insurance_policy")
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer insuranceId;

	private String insuranceName;

	private String insurancedescription;

	private Long insuranceTenure;

	private Long insuranceSumAssured;

	private Long insuranceEmiMonthly;

	private Long insuranceEmiYearly;

	private Long insuranceBenfitAmount;
	
	private Long toAccount;

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getInsurancedescription() {
		return insurancedescription;
	}

	public void setInsurancedescription(String insurancedescription) {
		this.insurancedescription = insurancedescription;
	}

	public Long getInsuranceTenure() {
		return insuranceTenure;
	}

	public void setInsuranceTenure(Long insuranceTenure) {
		this.insuranceTenure = insuranceTenure;
	}

	public Long getInsuranceSumAssured() {
		return insuranceSumAssured;
	}

	public void setInsuranceSumAssured(Long insuranceSumAssured) {
		this.insuranceSumAssured = insuranceSumAssured;
	}

	public Long getInsuranceEmiMonthly() {
		return insuranceEmiMonthly;
	}

	public void setInsuranceEmiMonthly(Long insuranceEmiMonthly) {
		this.insuranceEmiMonthly = insuranceEmiMonthly;
	}

	public Long getInsuranceEmiYearly() {
		return insuranceEmiYearly;
	}

	public void setInsuranceEmiYearly(Long insuranceEmiYearly) {
		this.insuranceEmiYearly = insuranceEmiYearly;
	}

	public Long getInsuranceBenfitAmount() {
		return insuranceBenfitAmount;
	}

	public void setInsuranceBenfitAmount(Long insuranceBenfitAmount) {
		this.insuranceBenfitAmount = insuranceBenfitAmount;
	}

	public Long getToAccount() {
		return toAccount;
	}

	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	

	

}