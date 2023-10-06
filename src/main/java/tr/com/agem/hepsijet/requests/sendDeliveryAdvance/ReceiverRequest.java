package tr.com.agem.hepsijet.requests.sendDeliveryAdvance;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//OrderInfoDTO için request
public class ReceiverRequest {

	private String companyCustomerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone1;
	private String phone2;
	private String citizenshipId;
}