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
public class ProductCodeInfoRequest {

	private String deliveryDateOriginal;
	private String deliveryEndTime;
	private int deliverySlot;
	private String deliveryStartTime;
	private String productCode;
}