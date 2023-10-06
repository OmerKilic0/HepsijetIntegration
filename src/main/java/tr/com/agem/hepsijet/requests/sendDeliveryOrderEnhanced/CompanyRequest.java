package tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//SwaggerDeliveryOrderEnhancedRequestDTO için request
public class CompanyRequest {

	private String abbreviationCode;
	private String name;
}