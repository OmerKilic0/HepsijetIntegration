package tr.com.agem.hepsijet.responses.getDeliveryTracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.Status;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDeliveryTracking {

	private DataResponse data;
	private String message;
	private Status status;
}