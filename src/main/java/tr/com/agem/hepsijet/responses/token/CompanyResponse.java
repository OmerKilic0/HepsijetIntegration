package tr.com.agem.hepsijet.responses.token;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//HepsijetToken için response
public class CompanyResponse {

	private int id;
	private String name;
	private String companyCompanyId;
	private String companyType;
	private String abbreviationCode;
	private String corporateName;
	private CompanyExtensionResponse companyExtension;
}