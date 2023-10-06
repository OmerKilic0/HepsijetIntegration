package tr.com.agem.hepsijet.responses.updateDeliveryDesi;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import tr.com.agem.hepsijet.enums.DetailStatus;
import tr.com.agem.hepsijet.enums.Status;
import tr.com.agem.hepsijet.responses.barcodesLabel.ParamsResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDeliveryDesi {

	private String cause;
	private DetailStatus detailStatus;
	private String errorCode;
	private String message;
	private ParamsResponse params;
	private Status status;
}