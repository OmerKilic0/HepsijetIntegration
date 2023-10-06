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
//TownsResponse için response
public class XDockResponse {

	private List<DaysResponse> days;
	private String xDockName;
}