package tr.com.agem.hepsijet.responses.deleteDeliveryAdvance;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.Status;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteDeliveryAdvance {

	private Status status;
	private String message;
	private String cause;
}