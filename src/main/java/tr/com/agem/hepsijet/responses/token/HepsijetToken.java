package tr.com.agem.hepsijet.responses.token;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import tr.com.agem.hepsijet.enums.Status;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HepsijetToken {

	private Status status;
	private DataResponse data;
}