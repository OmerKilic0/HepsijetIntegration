package tr.com.agem.hepsijet.responses.sendDeliveryAdvance;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.Status;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SendDeliveryAdvance {

	private Status status;
	private String message;
	private String cause;
}