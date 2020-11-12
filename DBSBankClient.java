package com.insurance.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.insurance.dto.CustomerTransactionRequestDto;

//@FeignClient(value="dbsbank-service",url="http://localhost:8011/bank/bank/fundTransfer")
@FeignClient(name = "http://DBSBANK-SERVICE/bank/bank")

public interface DBSBankClient {

	@PostMapping("/fundTransfer")
	public String fundTransfer(@RequestBody CustomerTransactionRequestDto transactionRequestDto);

	

}
