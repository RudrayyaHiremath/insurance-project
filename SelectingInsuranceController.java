package com.insurance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.dto.CustomerInsuranceRequestDto;
import com.insurance.exception.CustomerInsuranceNotFoundException;
import com.insurance.service.ChoosingInsuranceService;

@RestController
@RequestMapping("/chooseinsurances")
public class SelectingInsuranceController {

	@Autowired
	ChoosingInsuranceService ChoosingInsuranceService;
	
	@PostMapping("/selected")
	public ResponseEntity<String> saveInsurance (@Valid @RequestBody CustomerInsuranceRequestDto customerInsuranceRequestDto) throws CustomerInsuranceNotFoundException{
		ChoosingInsuranceService.registerUserInsurance(customerInsuranceRequestDto);
		return new ResponseEntity<String>( "Your insurance is Successfully Registerd",HttpStatus.ACCEPTED);
	}
}
