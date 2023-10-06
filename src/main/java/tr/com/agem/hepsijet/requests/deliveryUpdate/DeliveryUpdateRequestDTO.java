package tr.com.agem.hepsijet.requests.deliveryUpdate;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.DeliveryUpdateType;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryUpdateRequestDTO {

	private CompanyAddressInfoRequest companyAddressInfo;
	private CompanyCustomerInfoRequest companyCustomerInfo;
	private String customerDeliveryNo;
	private DeliveryUpdateType deliveryUpdateType;
	private ProductCodeInfoRequest productCodeInfo;
	private RecipientPersonInfoRequest recipientPersonInfo;
	private String returnedAppointmentDate;
	private TotalParcelInfoRequest totalParcelInfo;
	private int totalParcel;
}