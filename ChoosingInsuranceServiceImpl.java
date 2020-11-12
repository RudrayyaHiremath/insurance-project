package com.insurance.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insurance.dto.InsuranceRequestDto;
import com.insurance.dto.CustomerInsuranceRequestDto;
import com.insurance.dto.CustomerTransactionRequestDto;
import com.insurance.entity.Insurance;
import com.insurance.exception.CustomerInsuranceNotFoundException;
import com.insurance.exception.CustomerNotFoundException;
import com.insurance.entity.Customer;
import com.insurance.entity.CustomerRegistrationPolicy;
import com.insurance.feignclients.DBSBankClient;
import com.insurance.repository.InsuranceListRepository;
import com.insurance.repository.CustomerRegistrationRepository;
import com.insurance.repository.CustomerRepository;
import com.insurance.service.ChoosingInsuranceService;

@Service
public class ChoosingInsuranceServiceImpl implements ChoosingInsuranceService {

	@Autowired
	InsuranceListRepository insuranceListRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ChoosingInsuranceServiceImpl.class);
	
	
	@Autowired
	CustomerRegistrationRepository customerRegistrationRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	DBSBankClient dBSBankClient;

	@Override
	@Transactional
	public void registerUserInsurance(CustomerInsuranceRequestDto customerInsuranceRequestDto)throws CustomerInsuranceNotFoundException  {

		long fromAccount = customerInsuranceRequestDto.getFromAccount();

		int userId = customerInsuranceRequestDto.getUserId();
		userId=customerInsuranceRequestDto.getUserId();
			

		List<InsuranceRequestDto> userList = new ArrayList();

		for (InsuranceRequestDto policy : customerInsuranceRequestDto.getInsuranceDetails()) {

			userList.add(policy);

		}

		boolean validuser = this.checkValidUser(userId);

		long totalFundTransfer = 0;
		if (validuser) {

			for (InsuranceRequestDto policy : userList) {
				Optional<Insurance> insurance;
				int insuranceId = policy.getInsuranceId();
				insurance = insuranceListRepository.findById(insuranceId);

				if (insurance.isPresent()) {
					Insurance insurances = insurance.get();

					Insurance insurancedto = insurance.get();
					boolean monthlypay = policy.getMonthlyEmi();
					boolean yearpay = policy.getYearlyEmi();
					long toAccount = insurancedto.getToAccount();
					long transferfund;

					if (yearpay) {
						transferfund = insurancedto.getInsuranceEmiYearly();
						totalFundTransfer = (totalFundTransfer + transferfund);
						CustomerTransactionRequestDto customerTransactionRequestDto = new CustomerTransactionRequestDto();
						customerTransactionRequestDto.setToAccount(insurancedto.getToAccount());
						customerTransactionRequestDto.setFromAccounNumber(fromAccount);
						customerTransactionRequestDto.setAmount(totalFundTransfer);
						customerTransactionRequestDto.setRemarks("yearlyemi");
						dBSBankClient.fundTransfer(customerTransactionRequestDto);

					} else {
						transferfund = insurancedto.getInsuranceEmiMonthly();
						totalFundTransfer = (totalFundTransfer + transferfund);
						CustomerTransactionRequestDto customerTransactionRequestDto = new CustomerTransactionRequestDto();
						customerTransactionRequestDto.setToAccount(insurancedto.getToAccount());
						customerTransactionRequestDto.setFromAccounNumber(fromAccount);
						customerTransactionRequestDto.setAmount(totalFundTransfer);
						customerTransactionRequestDto.setRemarks("monthlyemi");
						dBSBankClient.fundTransfer(customerTransactionRequestDto);

					}

					CustomerRegistrationPolicy userRegistration = new CustomerRegistrationPolicy();
					userRegistration.setSelectedPolicyId(insurancedto.getInsuranceId());
					userRegistration.setSelectedPolicyName(insurancedto.getInsuranceName());
					userRegistration.setSelectedPolicySumAssured(insurancedto.getInsuranceSumAssured());
					userRegistration.setStatus("success");
					userRegistration.setUserRegistrationId(userId);
					
					customerRegistrationRepository.save(userRegistration);

				}

			}
	}
		}
	
	private boolean checkValidUser(int userId) {
		Optional<Customer> optionalUser = customerRepository.findById(userId);
		if (optionalUser.isPresent()) {
			return true;
		}
		return false;
	}
}
