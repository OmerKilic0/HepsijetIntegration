package tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import tr.com.agem.hepsijet.enums.Currency;
import tr.com.agem.hepsijet.enums.Type;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//SwaggerDeliveryOrderEnhancedRequestDTO için request
public class DeliveryAmountListRequest {

	private int amount;
	private Currency currency;
	private String description;
	private Type type;
}