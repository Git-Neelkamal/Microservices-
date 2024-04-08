package com.razorpay.gateway.dto;

import lombok.Data;

@Data
public class NetBankingUserDto {
	
	private long accountNumber;
	private String userName;
	private String password;
	private String fullName;
	private long contact;
	private double balance;

}
