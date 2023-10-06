package tr.com.agem.hepsijet.requests.sendDeliveryAdvance;

import lombok.Getter;
import lombok.Setter;
import tr.com.agem.hepsijet.enums.DeliveryType;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//OrderInfoDTO için request
public class DeliveriesRequest {

	private DeliveryType deliveryType;
	private String deliveryDate;
	private int deliverySlot;
	private String deliveryStartTime;
	private String deliveryEndTime;
	private ProductRequest product;
	private double desi;
	private RecipientAddressRequest recipientAddressRequestv;
	private SenderCompanyRequest senderCompany;
	private SenderAddressRequest senderAddress;
	private String recipientAddressName;
	private String recipientPerson;
	private String recipientPersonPhone1;
	private String recipientPersonPhone2;
	private double weight;
	private double width;
	private double heigth;
	private double length;
	private double deliveryTotalPrice;
	private String deliveryLocationText;
	private int distributionType;
	private String applicationNo;
}