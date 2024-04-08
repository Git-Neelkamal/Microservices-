package spring.rest.api.service;

import java.net.http.HttpHeaders;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import spring.rest.api.dto.payment.PaymentDataDto;

@Service
public class OrderService {

	public String makePaymentFoOrder(String amount) {

		//send User Information : UserName, Password, Amount
		//send to Payment Application
		//Call API of payment
		//Flipkart->payment Service
		

		
		//http://localhost:9988/payment/netbanking/pay
		
		String url="http://localhost:9988/payment/netbanking/pay";
		PaymentDataDto paymentData=new PaymentDataDto("KamalB","kamal123",Double.parseDouble(amount));
		
		org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<PaymentDataDto> httpEntity= new HttpEntity<PaymentDataDto>(paymentData, headers);
		
		//org.springframework.http.HttpHeaders headers= new org.springframework.http.HttpHeaders();
	//	headers.add("content-type", "application/xml");
		
		RestTemplate restTemplate=new RestTemplate();
		
		
	
	ResponseEntity<String>  response =	restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		
		String responsebody= response.getBody();
	org.springframework.http.HttpHeaders responseHeaders=response .getHeaders();
		
		HttpStatusCode code=response.getStatusCode();
		
		System.out.println(responsebody);
		System.out.println(responseHeaders);
		System.out.println(code);
		
		return responsebody;
	}

	

}
