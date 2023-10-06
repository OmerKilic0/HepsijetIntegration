package tr.com.agem.hepsijet.responses.track;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Track için response
public class DataResponse {

	private String barcode;
	private List<DetailsResponse> details;
	private String trackingUrl;
}