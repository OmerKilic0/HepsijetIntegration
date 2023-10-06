package tr.com.agem.hepsijet.responses.districts;

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
public class Districts {

	private List<DataResponse> data;
	private String message;
	private Status status;
}