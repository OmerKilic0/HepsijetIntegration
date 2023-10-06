package tr.com.agem.hepsijet.requests.sendDeliveryAdvance;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoDTO {

	private String orderId;
	private String orderDate;
	private ReceiverRequest receiver;
	private List<DeliveriesRequest> deliveries;
}