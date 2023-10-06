package tr.com.agem.hepsijet.requests.deliveryUpdate;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//DeliveryUpdateRequestDTO için request
public class CompanyCustomerInfoRequest {

	private String companyCustomerId;
	private String email;
	private String firstName;
	private String gsm1;
	private String lastName;
}