package tr.com.agem.hepsijet.responses.barcodesLabel;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.DetailStatus;
import tr.com.agem.hepsijet.enums.Status;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BarcodesLabel {

	private String cause;
	private DataResponse data;
	private DetailStatus detailStatus;
	private String errorCode;
	private String message;
	private ParamsResponse params;
	private Status status;
}