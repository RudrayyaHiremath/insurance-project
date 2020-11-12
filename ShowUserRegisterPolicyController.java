package com.insurance.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.insurance.dto.CustomerInsuranceResponceDto;
import com.insurance.exception.CustomerNotFoundException;
import com.insurance.service.ShowCustomerRegisterInsuranceService;

@RestController
@RequestMapping("/insurance")
public class ShowUserRegisterPolicyController {

	@Autowired
	ShowCustomerRegisterInsuranceService showCustomerRegisterInsuranceService;

	@GetMapping("/showcustomeroptedinsurance")

	public ResponseEntity<List<CustomerInsuranceResponceDto>> getAllInsurance(@RequestParam int pageNumber, @RequestParam int pageSize,
			@Valid @RequestParam int userId)throws CustomerNotFoundException
	{
		List<CustomerInsuranceResponceDto> customerinsuranceresponcedto=showCustomerRegisterInsuranceService.getUserListofInsurance(pageNumber, pageSize, userId);
		return new ResponseEntity<List<CustomerInsuranceResponceDto>>(customerinsuranceresponcedto,HttpStatus.OK);
	}
}
