package tr.com.agem.hepsijet.responses.getDeliveryTracking;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.DeliveryStatus;
import tr.com.agem.hepsijet.enums.DeliveryType;
import tr.com.agem.hepsijet.enums.OperationStatus;
import tr.com.agem.hepsijet.enums.TransactionType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//GetDeliveryTracking için response
public class DataResponse {

	private String arrivalBranch;
	private String barcode;
	private CompanyResponse company;
	private String currentLocation;
	private String customerDeliveryNo;
	private DeliveryStatus deliveryStatus;
	private DeliveryType deliveryType;
	private String lastTransaction;
	private OperationStatus operationStatus;
	private String receiver;
	private String recipientName;
	private String sender;
	private TransactionType transactionType;
	private List<TransactionsResponse> transactions;
}