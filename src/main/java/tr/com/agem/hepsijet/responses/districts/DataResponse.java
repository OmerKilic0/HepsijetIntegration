package tr.com.agem.hepsijet.responses.districts;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Districts için response
public class DataResponse {

	private List<AvailableDaysResponse> availableDays;
	private int id;
	private String name;
	private XDockResponse xDock;
	
}