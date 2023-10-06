package tr.com.agem.hepsijet.responses.barcodesLabel;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//BarcodesLabel için response
public class DataResponse {

	private List<String> emptyBarcodes;
	private List<String> labels;
}