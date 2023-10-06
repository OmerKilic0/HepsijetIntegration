package tr.com.agem.hepsijet.responses.token;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse {

	private int id;
	private String username;
	private String firstname;
	private String lastname;
	private String language;
	private String token;
	private String department;
	private CompanyResponse company;
	private TenantResponse tenant;
	private List<String> userGroupCode;
	private List<String> authorities;
}