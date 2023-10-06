package tr.com.agem.hepsijet.responses.track;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.IntegrationStatus;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//DataResponse için response
public class DetailsResponse {

	private String deliveredPerson;
	private IntegrationStatus integrationStatus;
	private String nonDeliveryReason;
	private String transactionDate;
	private String transactionLocation;
}