package com.employeemanagement.zcontroller;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.employeemanagement.entity.Loan;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@CrossOrigin
public class WebClientController {

	private final String GET_ALL_LOANS = "http://localhost:8081/api/admin/getLoans";

	
	@Autowired
	private WebClient.Builder webClientBuilder;

	private static final String ALL_LOAN = "loans";
	
	Logger logger = LogManager.getLogger(WebClientController.class);
	
	/**
	 * Returns existing List of Loans From Admin Service
	 * 
	 * @return List<Loan>
	 */
	@GetMapping("/getLoans")
	@CircuitBreaker(name= "ALL_LOAN" ,fallbackMethod = "getLoanFallback")
	public List<Loan> viewLoanDTOs() {

		Loan[] arrayOfLoans = webClientBuilder.build().get().uri(GET_ALL_LOANS).retrieve().bodyToMono(Loan[].class)
                .block();
        logger.info("Succesfully External Service Called");
        return Arrays.asList(arrayOfLoans);
		

	}
	
	public List<Loan> getLoanFallback(Exception e){
		List<Loan> loans= Arrays.asList(new Loan(0l,"Home Loan","Abc","asdfghjk",(float) 0.0));
		
		return loans;
	}
	
	

}
