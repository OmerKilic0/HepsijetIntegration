package tr.com.agem.hepsijet.responses.findAvailableDeliveryDates;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//FindAvailableDeliveryDates için response
public class DataResponse {

	private String cityName;
	private List<TownsResponse> towns;
}