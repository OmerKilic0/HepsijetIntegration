package tr.com.agem.hepsijet.requests.deliveryUpdate;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//DeliveryUpdateRequestDTO için request
public class CompanyAddressInfoRequest {

	private String addressLine1;
	private String cityName;
	private String companyAddressId;
	private String countryName;
	private String districtName;
	private String townName;
}