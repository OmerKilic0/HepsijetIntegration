package tr.com.agem.hepsijet.requests.barcodesLabel;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BarcodeDTO {

	private List<String> barcodes;
}