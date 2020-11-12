package com.insurance.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value=CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException customerNotFoundException){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setErrorCode("302");
		errorResponse.setErrorMessage(customerNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(value=CustomerInsuranceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomerInsuranceNotFoundException(CustomerInsuranceNotFoundException customerInsuranceNotFoundException){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setErrorCode("408");
		errorResponse.setErrorMessage(customerInsuranceNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(value=InsuranceCompanyNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleInsuranceCompanyNotFoundException(InsuranceCompanyNotFoundException insuranceCompanyNotFoundException){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setErrorCode("304");
		errorResponse.setErrorMessage(insuranceCompanyNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}
	@Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException argInvalidException,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode("409");
        String allFieldErrors = argInvalidException.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getDefaultMessage()).collect(Collectors.joining(", "));
        response.setErrorMessage(allFieldErrors);
        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }
	

}
