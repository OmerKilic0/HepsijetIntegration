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
public class RecipientPersonInfoRequest {

	private String recipientPerson;
	private String recipientPersonEmail;
	private String recipientPersonPhone1;
	private String recipientPersonPhone2;
}