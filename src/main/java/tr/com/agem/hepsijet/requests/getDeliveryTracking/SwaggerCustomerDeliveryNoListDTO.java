package tr.com.agem.hepsijet.requests.getDeliveryTracking;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//getDeliveryTracking için request
public class SwaggerCustomerDeliveryNoListDTO {

	private List<DeliveriesRequest> deliveries;
}