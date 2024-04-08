package com.razorpay.gateway.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="netbanking_data")
public class NetBankingUser {
	
	@Id
	private long accountNumber;
	private String userName;
	private String password;
	private String fullName;
	private long contact;
	private double balance;

}
