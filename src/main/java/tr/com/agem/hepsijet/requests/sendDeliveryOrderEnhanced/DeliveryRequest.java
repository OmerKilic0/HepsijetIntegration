package tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.DeliveryType;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//SwaggerDeliveryOrderEnhancedRequestDTO için request
public class DeliveryRequest {

	private String customerDeliveryNo;
	private String customerOrderId;
	private String deliveryDateOriginal;
	private boolean deliveryPom;
	private int deliverySlotOriginal;
	private DeliveryType deliveryType;
	private int desi;
	private ProductRequest productRequest;
	private ReceiverRequest receiverRequest;
	private RecipientAddressRequest recipientAddress;
	private String recipientPerson;
	private String recipientPersonPhone1;
	private String recipientPersonPhone2;
	private ReturnReasonRequest returnReason;
	private SenderAddressRequest senderAddress;
	private int totalParcels;
}