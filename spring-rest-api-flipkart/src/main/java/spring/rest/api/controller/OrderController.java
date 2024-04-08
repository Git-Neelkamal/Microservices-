package spring.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.rest.api.dto.payment.PaymentDataDto;
import spring.rest.api.service.OrderService;

@RestController
public class OrderController {
	
	
	@Autowired
	OrderService orderService;
	
	
	@RequestMapping("/order/payment/{amount}")
	public String makePaymentForOrder(@PathVariable String amount) {
		
		
		return orderService.makePaymentFoOrder( amount);
		
		
	}

}
