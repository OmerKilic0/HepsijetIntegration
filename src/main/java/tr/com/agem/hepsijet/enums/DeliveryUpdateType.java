package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DeliveryUpdateType {
	
	TOTAL_PARCEL("1", "Total Parcel"),
	PRODUCT_CODE("2", "Product Code"),
	COMPANY_CUSTOMER("3", "Company Customer"),
	RECIPIENT_PERSON("4", "Recipient Person"),
	COMPANY_ADDRESS("5", "Company Address"),
	RETURNED_APPOINTMENT_DATE("6", "Returned Appointment Date");
    
    private String id;
	private String desc;
	
	private DeliveryUpdateType(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static DeliveryUpdateType deliveryUpdateType(String id) {
		if (id == null) {
			return null;
		}
		
		for (DeliveryUpdateType type : DeliveryUpdateType.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching delivery update type for id: " + id);
	}
	
	public static String getId(DeliveryUpdateType deliveryUpdateType) {
		return deliveryUpdateType == null ? null : deliveryUpdateType.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}