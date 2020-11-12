package com.insurance.service;

import java.util.List;

import com.insurance.dto.CustomerInsuranceResponceDto;

public interface ShowCustomerRegisterInsuranceService {

	public List<CustomerInsuranceResponceDto> getUserListofInsurance(int pageNumber, int pageSize, int userId);

}
