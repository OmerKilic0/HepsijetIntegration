package tr.com.agem.hepsijet.responses.sendDeliveryOrderEnhanced;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.Status;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SendDeliveryOrderEnhanced {

	private DataResponse data;
	private String message;
	private Status status;
}