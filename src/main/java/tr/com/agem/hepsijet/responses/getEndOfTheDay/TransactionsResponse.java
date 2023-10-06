package tr.com.agem.hepsijet.responses.getEndOfTheDay;

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
public class TransactionsResponse {

	private IntegrationStatus integrationStatus;
	private String requestMessage;
	private String timeStamp;
}