package com.razorpay.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.number.money.MonetaryAmountFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.gateway.dto.NetBankingUserDto;
import com.razorpay.gateway.dto.PaymentsInfo;
import com.razorpay.gateway.dto.UserCredentialDto;
import com.razorpay.gateway.entity.NetBankingUser;
import com.razorpay.gateway.repository.PaymentsRepository;
import com.razorpay.gateway.service.PaymentsService;

import java.util.*;


@RestController

public class PaymentController {
	
	
	@Autowired
	PaymentsService paymentsService;
	
	
	@PostMapping(path="/netbanking/register" )
	public String netBankingRegister(@RequestBody NetBankingUserDto request) {
		
		return paymentsService.netBankingRegister(request);
		
	}
	
	
	@PostMapping(path="/netbanking/pay" )
	public String makePayments(@RequestBody UserCredentialDto request) {
		
		//login: verify user is available or not
		// IfAction availabelAction Then deduct amount, if not send response as invalid credentials
		
		
		
		
		return paymentsService.makePayment(request);
		
	}
	@GetMapping("/payments")
	public List<PaymentsInfo> getPaymentsInfo(){
		
		
		return paymentsService.getPaymentsInfo();
		
		
	}
	
	
	
	
	
	
	
	

}
