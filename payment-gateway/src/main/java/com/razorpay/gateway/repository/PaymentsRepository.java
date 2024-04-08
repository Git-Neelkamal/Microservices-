package com.razorpay.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.razorpay.gateway.entity.NetBankingUser;

@Repository
public interface PaymentsRepository extends JpaRepository<NetBankingUser,Long>{

	NetBankingUser findByUserNameAndPassword(String username, String password);

}
