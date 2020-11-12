package com.insurance.dto;

public class CustomerInsuranceResponceDto {
	
    private int userId;

	private int selectedPolicyId;
    
    private String selectedPolicyName;
    
    private Long selectedPolicySumAssured;
    
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

	public Long getSelectedPolicySumAssured() {
		return selectedPolicySumAssured;
	}

	public void setSelectedPolicySumAssured(Long selectedPolicySumAssured) {
		this.selectedPolicySumAssured = selectedPolicySumAssured;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    

}
