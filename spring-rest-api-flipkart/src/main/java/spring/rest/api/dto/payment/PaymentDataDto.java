package spring.rest.api.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class PaymentDataDto {
	
	private String userName;
	private String password;
	private double amount;
	

}
