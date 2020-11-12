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

import com.insurance.dto.InsuranceListDto;
import com.insurance.exception.InsuranceCompanyNotFoundException;
import com.insurance.service.InsuranceListService;

@RestController
@RequestMapping("/insurance")
public class InsuranceListController {
	
	@Autowired
	InsuranceListService insuranceListService;
	
	@GetMapping("/insurancelist")
	public ResponseEntity<List<InsuranceListDto>> getAllInsurance(@RequestParam int pageNumber, @RequestParam int pageSize) throws InsuranceCompanyNotFoundException 
	{
		List<InsuranceListDto> insurancelistdto=insuranceListService.getListofInsurance(pageNumber, pageSize);
		return new ResponseEntity<List<InsuranceListDto>>(insurancelistdto,HttpStatus.OK);
	
}	
}
