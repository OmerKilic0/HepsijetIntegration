package tr.com.agem.hepsijet.responses.deliveryUpdate;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.Status;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryUpdate {

	private String message;
	private Status status;
}