package tr.com.agem.hepsijet.responses.deleteDeliveryOrder;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.Status;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteDeliveryOrder {

	private Status status;
	private String message;
	private String cause;
}