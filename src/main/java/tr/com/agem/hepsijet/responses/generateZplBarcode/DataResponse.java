package tr.com.agem.hepsijet.responses.generateZplBarcode;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//GenerateZplBarcode için response
public class DataResponse {

	private String barcodePrintDate;
	private String deliveryDateOriginal;
	private String deliveryDatePromised;
	private String deliveryEndTime;
	private boolean deliveryPom;
	private String deliveryStartTime;
	private String desiSize;
	private String distributionZoneName;
	private int parcelNo;
	private String productName;
	private String receiver;
	private String receiverAddress;
	private String receiverCity;
	private String receiverDistrict;
	private String receiverTown;
	private String receiverXDock;
	private String sender;
	private String senderXDock;
	private String serviceList;
	private int totalParcels;
	private String transferXdockName;
	private String zplBarcode;
}