package tr.com.agem.hepsijet.requests.sendDeliveryAdvance;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced.CityRequest;
import tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced.CountryRequest;
import tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced.DistrictRequest;
import tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced.TownRequest;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//DeliveriesRequest için request
public class SenderAddressRequest {

	private String companyAddressId;
	private CountryRequest country;
	private CityRequest city;
	private TownRequest town;
	private DistrictRequest district;
	private String addressLine1;
	private String addressLine2;
	private String postalCode;
}