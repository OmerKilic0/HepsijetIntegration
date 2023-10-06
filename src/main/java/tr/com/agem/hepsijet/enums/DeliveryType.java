package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DeliveryType {
	
	RETAIL("1", "Retail"),
	MARKET_PLACE("2", "Market Place"),
	RETURNED("3", "Returned"),
	INTERNAL_DELIVERY("4", "Infernal Delivery"),
	BANK_CONTRACT("5", "Bank Contract"),
	EXPRESS("6", "Express");
    
    private String id;
	private String desc;
	
	private DeliveryType(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static DeliveryType deliveryType(String id) {
		if (id == null) {
			return null;
		}
		
		for (DeliveryType type : DeliveryType.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching delivery type for id: " + id);
	}
	
	public static String getId(DeliveryType deliveryType) {
		return deliveryType == null ? null : deliveryType.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}