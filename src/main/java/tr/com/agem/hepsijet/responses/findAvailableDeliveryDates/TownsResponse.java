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
//DataResponse için response
public class TownsResponse {

	private String townName;
	private List<XDockResponse> xDock;
}