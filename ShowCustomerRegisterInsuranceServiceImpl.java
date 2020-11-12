package com.insurance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.insurance.dto.CustomerInsuranceResponceDto;
import com.insurance.entity.CustomerRegistrationPolicy;
import com.insurance.repository.CustomerRegistrationRepository;
import com.insurance.service.ShowCustomerRegisterInsuranceService;

@Service
public class ShowCustomerRegisterInsuranceServiceImpl implements ShowCustomerRegisterInsuranceService {

	
	@Autowired
	CustomerRegistrationRepository customerRegistrationRepository;
	
	@Override
	public List<CustomerInsuranceResponceDto> getUserListofInsurance(int pageNumber, int pageSize, int userId) {
		Page<CustomerRegistrationPolicy> userRegistration;
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		userRegistration = customerRegistrationRepository.findByuserRegistrationId(userId,pageable );
		List<CustomerInsuranceResponceDto> customerInsuranceResponceDtos = new ArrayList<>();
		CustomerInsuranceResponceDto customerInsuranceResponceDto = new CustomerInsuranceResponceDto();
		for( CustomerRegistrationPolicy userRegistrations : userRegistration) {
			customerInsuranceResponceDto = new CustomerInsuranceResponceDto();
			BeanUtils.copyProperties(userRegistrations, customerInsuranceResponceDto);
			customerInsuranceResponceDtos.add(customerInsuranceResponceDto);
		}
		
		return customerInsuranceResponceDtos;
	}

}





