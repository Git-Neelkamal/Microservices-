package com.razorpay.gateway.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razorpay.gateway.dto.NetBankingUserDto;
import com.razorpay.gateway.dto.PaymentsInfo;
import com.razorpay.gateway.dto.UserCredentialDto;
import com.razorpay.gateway.entity.NetBankingUser;
import com.razorpay.gateway.repository.PaymentsRepository;

@Service
public class PaymentsService {
	
	@Autowired
	
	PaymentsRepository paymentsRepository;

	public String netBankingRegister(NetBankingUserDto request) {
		
		NetBankingUser user= NetBankingUser.builder().
	accountNumber(request.getAccountNumber()).
	contact(request.getContact()).
	fullName(request.getFullName()).
	userName(request.getUserName()).
	password(request.getPassword()).
	balance(request.getBalance()).
	
	build();
		
		paymentsRepository.save(user);
		
		return "registration success";
		
		
	}

	public String makePayment(UserCredentialDto request) {
		
		
		NetBankingUser userInfo= this.getAccountOnValidation(request.getUserName(), request.getPassword());
		
		if(userInfo==null) {
			return "Invalid credentials";
			
		}
		
		return "payment Success";
	}
	
	private NetBankingUser getAccountOnValidation(String userName, String password) {
		
		
		
		return paymentsRepository.findByUserNameAndPassword(userName,password);
		
		
		
	}

	public List<PaymentsInfo> getPaymentsInfo() {
		
		
		
	List<NetBankingUser> allPayments=	paymentsRepository.findAll();
//convert all payment entity objects to  List<PaymentsInfo>
	List<PaymentsInfo> payments= allPayments.stream().map(user->{
		
		
		return	PaymentsInfo.builder().
		fullName(user.getFullName()).
		accountNumber(user.getAccountNumber()).
		balance(user.getBalance()).contact(user.getContact()).build();
		
		
		
	}).collect(Collectors.toList());
	
	return payments;
	}
	

}
