package tr.com.agem.hepsijet.responses.getDeliveryTracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.CompanyType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//DataResponse için response
public class CompanyResponse {

	private String abbreviationCode;
	private String companyCompanyId;
	private CompanyType companyType;
	private String corporateName;
	private int id;
	private String name;
	private int rowVersion;
}