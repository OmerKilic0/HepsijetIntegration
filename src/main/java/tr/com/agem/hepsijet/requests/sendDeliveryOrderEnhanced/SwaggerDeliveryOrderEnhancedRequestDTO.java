package tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import tr.com.agem.hepsijet.enums.ServiceType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//sendDeliveryOrderEnhanced için request
public class SwaggerDeliveryOrderEnhancedRequestDTO {

	private CompanyRequest company;
	private CurrentXDockRequest currentXDock;
	private DeliveryRequest delivery;
	private List<DeliveryAmountListRequest> deliveryAmountList;
	private List<DeliveryContentRequest> deliveryContent;
	private List<ServiceType> serviceType;
}