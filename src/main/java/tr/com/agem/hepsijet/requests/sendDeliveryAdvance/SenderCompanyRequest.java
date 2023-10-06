package tr.com.agem.hepsijet.requests.sendDeliveryAdvance;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//DeliveriesRequest için request
public class SenderCompanyRequest {

	private String Name;
	private String companyId;
	private String abbreviationCode;
	private String accountId;
	private List<String> contactEmails;
}