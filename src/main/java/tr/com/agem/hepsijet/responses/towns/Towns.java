package tr.com.agem.hepsijet.responses.towns;

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
public class Towns {

	private List<DataResponse> data;
	private String message;
	private Status status;
}