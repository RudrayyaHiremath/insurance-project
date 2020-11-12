package com.insurance.service;

import java.util.List;

import com.insurance.dto.InsuranceListDto;

public interface InsuranceListService {

	public List <InsuranceListDto> getListofInsurance( int pageNumber, int pageSize );
}
