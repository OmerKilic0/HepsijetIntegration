package tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//DeliveryRequest için request
public class RecipientAddressRequest {

	private String addressLabel;
	private String addressLine1;
	private CityRequest city;
	private String companyAddressId;
	private CountryRequest country;
	private DistrictRequest district;
	private TownRequest town;
}