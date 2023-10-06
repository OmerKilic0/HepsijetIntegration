package tr.com.agem.hepsijet.responses.getDeliveryTracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.DeliveryStatus;
import tr.com.agem.hepsijet.enums.OperationStatus;
import tr.com.agem.hepsijet.enums.TransactionType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//DataRequest için response
public class TransactionsResponse {

	private DeliveryStatus deliveryStatus;
	private String location;
	private OperationStatus operationStatus;
	private String transaction;
	private String transactionDateTime;
	private TransactionType transactionType;
}