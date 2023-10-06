package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ServiceType {
	
	PUDO("1", "PUDO"),
	FULFILLMENTBYHB("2", "FULFILLMENTBYHB"),
	TMH("3", "TMH"),
	POD("4", "POD"),
	EGYGBYHB("5", "EGYGBHB"),
	TECHNICALBYHB("6", "TECHNICALBYHB");
	
	private String id;
	private String desc;
	
	private ServiceType(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static ServiceType serviceType(String id) {
		if (id == null) {
			return null;
		}
		
		for (ServiceType type : ServiceType.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching service type for id: " + id);
	}
	
	public static String getId(ServiceType serviceType) {
		return serviceType == null ? null : serviceType.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}