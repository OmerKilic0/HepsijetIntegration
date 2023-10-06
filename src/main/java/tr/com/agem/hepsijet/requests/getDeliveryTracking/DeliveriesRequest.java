package tr.com.agem.hepsijet.requests.getDeliveryTracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//SwaggerCustomerDeliveryNoListDTO için request
public class DeliveriesRequest {

	private String customerDeliveryNo;
}