package com.razorpay.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentsInfo {
	

	private long accountNumber;
	private String fullName;
	private long contact;
	private double balance;

}
