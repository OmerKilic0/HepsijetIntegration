package tr.com.agem.hepsijet.responses.track;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.Status;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Track {

	private Status status;
	private List<DataResponse> data;
}