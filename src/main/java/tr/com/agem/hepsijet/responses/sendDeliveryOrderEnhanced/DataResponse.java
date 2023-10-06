package tr.com.agem.hepsijet.responses.sendDeliveryOrderEnhanced;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//SendDeliveryOrderEnhanced için response
public class DataResponse {

	private String customerDeliveryNo;
	private List<ZplBarcodeDTOListResponse> zplBarcodeDTOList;
}