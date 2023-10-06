package tr.com.agem.hepsijet.requests.updateDeliveryDesi;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.DesiType;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DesiUpdateRequestDTO {

	private String barcode;
	private DesiType desiType;
}