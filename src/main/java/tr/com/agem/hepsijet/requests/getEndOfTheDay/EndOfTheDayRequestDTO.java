package tr.com.agem.hepsijet.requests.getEndOfTheDay;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EndOfTheDayRequestDTO {

	private String dateEnd;
	private String dateStart;
}