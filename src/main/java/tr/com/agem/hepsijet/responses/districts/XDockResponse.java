package tr.com.agem.hepsijet.responses.districts;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//DataResponse için response
public class XDockResponse {

	private String abbreviationCode;
	private String addressCode;
	private int id;
	private String name;
}