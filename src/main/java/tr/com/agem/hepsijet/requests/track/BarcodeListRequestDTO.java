package tr.com.agem.hepsijet.requests.track;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BarcodeListRequestDTO {

	private List<String> barcodes;
	private boolean isTrackAdded;
}