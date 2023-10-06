package tr.com.agem.hepsijet.responses.findAvailableDeliveryDates;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//XDockResponse için response
public class DaysResponse {

	private String date;
	private int returnedLimit;
}