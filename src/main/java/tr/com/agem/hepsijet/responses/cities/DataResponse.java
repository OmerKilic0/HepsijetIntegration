package tr.com.agem.hepsijet.responses.cities;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Cities için response
public class DataResponse {

	private int id;
	private String name;
	private int order;
}