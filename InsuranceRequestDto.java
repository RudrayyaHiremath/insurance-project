package com.insurance.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class InsuranceRequestDto {
	@NotNull(message="insuranceId is Mandatory")
	@Max(value = 20,message="Please Enter the Valid insuranceId")
	private Integer insuranceId;

	private Boolean monthlyEmi;

	private Boolean yearlyEmi;

	public Integer getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}

	public Boolean getMonthlyEmi() {
		return monthlyEmi;
	}

	public void setMonthlyEmi(Boolean monthlyEmi) {
		this.monthlyEmi = monthlyEmi;
	}

	public Boolean getYearlyEmi() {
		return yearlyEmi;
	}

	public void setYearlyEmi(Boolean yearlyEmi) {
		this.yearlyEmi = yearlyEmi;
	}

}
