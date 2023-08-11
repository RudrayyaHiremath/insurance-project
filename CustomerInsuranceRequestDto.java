#hello world
package com.insurance.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CustomerInsuranceRequestDto {
	@NotNull(message="Please enter valid account number")
	@Min(value=0, message="Please enter valid account number")
	private long fromAccount;
	public int lonid;
	@NotNull(message="User Id is mandatory")
    @Min(value=100, message="Enter valid  user Id")
    @Column(name = "userId")
	private int userId;
	
	List<InsuranceRequestDto> insuranceDetails = new ArrayList();

	public long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<InsuranceRequestDto> getInsuranceDetails() {
		return insuranceDetails;
	}

	public void setInsuranceDetails(List<InsuranceRequestDto> insuranceDetails) {
		this.insuranceDetails = insuranceDetails;
	}
	
	

}
