package com.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "policy_details")
public class CustomerRegistrationPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private int selectedPolicyId;

	private String selectedPolicyName;

	private Long selectedPolicySumAssured;
	
	private int userRegistrationId;

	private String status;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSelectedPolicyId() {
		return selectedPolicyId;
	}

	public void setSelectedPolicyId(int selectedPolicyId) {
		this.selectedPolicyId = selectedPolicyId;
	}

	public String getSelectedPolicyName() {
		return selectedPolicyName;
	}

	public void setSelectedPolicyName(String selectedPolicyName) {
		this.selectedPolicyName = selectedPolicyName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSelectedPolicySumAssured() {
		return selectedPolicySumAssured;
	}

	public void setSelectedPolicySumAssured(Long selectedPolicySumAssured) {
		this.selectedPolicySumAssured = selectedPolicySumAssured;
	}

	public int getUserRegistrationId() {
		return userRegistrationId;
	}

	public void setUserRegistrationId(int userRegistrationId) {
		this.userRegistrationId = userRegistrationId;
	}

}
