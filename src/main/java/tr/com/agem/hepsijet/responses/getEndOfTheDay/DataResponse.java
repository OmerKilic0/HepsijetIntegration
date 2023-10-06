package tr.com.agem.hepsijet.responses.getEndOfTheDay;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.LastIntegrationStatus;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//GetEndOfTheDay için response
public class DataResponse {

	private String customerDeliveryNo;
	private LastIntegrationStatus lastIntegrationStatus;
	private String transactionDateTime;
	private List<TransactionsResponse> transactions;
}