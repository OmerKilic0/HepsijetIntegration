package tr.com.agem.hepsijet.requests.sendDeliveryAdvance;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced.CityRequest;
import tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced.CountryRequest;
import tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced.DistrictRequest;
import tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced.TownRequest;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipientAddressRequest {

	private String companyAddressId;
	private CountryRequest country;
	private CityRequest city;
	private TownRequest town;
	private DistrictRequest district;
	private String addressLine1;
	private String addressLine2;
	private String postalCode;
}