package tr.com.agem.hepsijet.responses.token;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//CompanyResponse için response
public class CompanyExtensionResponse {

	private int id;
	private boolean ringDepartureEmailNeeded;
	private String transferCenterResponsibleEmails;
	private boolean reportEmail;
	private boolean printBarcode;
	private boolean companyFlag;
	private boolean companyAlternativeReceiverFlag;
	private boolean siblingSupport;
	private boolean printBarcodeAccept;
	private boolean lateDelivery;
	private boolean addressChange;
	private boolean portalCompany;
}