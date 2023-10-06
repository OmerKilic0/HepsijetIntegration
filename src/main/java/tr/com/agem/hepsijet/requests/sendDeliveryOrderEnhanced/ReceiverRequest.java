package tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//DeliveryRequest için request
public class ReceiverRequest {

	private String companyCustomerId;
	private String email;
	private String firstName;
	private String lastName;
	private String phone1;
	private String phone2;
}