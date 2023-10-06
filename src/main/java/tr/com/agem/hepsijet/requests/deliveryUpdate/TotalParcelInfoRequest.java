package tr.com.agem.hepsijet.requests.deliveryUpdate;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//DeliveryUpdateRequestDTO için request
public class TotalParcelInfoRequest {

	private List<Double> desi;
}