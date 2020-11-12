package com.insurance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.insurance.dto.InsuranceListDto;
import com.insurance.entity.Insurance;
import com.insurance.exception.InsuranceNotFoundException;
import com.insurance.repository.InsuranceListRepository;
import com.insurance.service.InsuranceListService;

@Service
public class InsuranceListServiceImpl implements InsuranceListService 
{
	

	@Autowired 
	InsuranceListRepository insuranceListRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceListServiceImpl.class);
	
	@Override
	public List<InsuranceListDto> getListofInsurance(int pageNumber, int pageSize) throws InsuranceNotFoundException{
		Page<Insurance> insurance;
		List<InsuranceListDto> insuranceListDtos = new ArrayList<>();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		insurance = insuranceListRepository.findAll(pageable);
		
		/*
		 * for (Insurance policy : insurance) { InsuranceListDto insuranceListDto = new
		 * InsuranceListDto(); BeanUtils.copyProperties(policy, insuranceListDto);
		 * insuranceListDtos.add(insuranceListDto);
		 * 
		 * }
		 */
		 
		
		
		 
          insurance.stream().forEach(insurancePolicy ->
          {
          InsuranceListDto insurancePolicyDto=new InsuranceListDto();
		  BeanUtils.copyProperties(insurancePolicy, insurancePolicyDto);
		  insuranceListDtos.add(insurancePolicyDto);
		 });
          LOGGER.info("insurance List");

		return insuranceListDtos;
	}

}
