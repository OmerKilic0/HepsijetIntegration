package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum IntegrationStatus {
	
	NEO("1", "Neo"),
    ACCEPTED("2", "Accepted"),
    UPDATED("3", "Updated"),
    DELIVERED("4", "Delivered"),
    DELETED("5", "Deleted"),
    CANCELLED("6", "Cancelled"),
    RETURNED("7", "Returned"),
    OUT_FOR_DELIVERY("8", "Out For Delivery"),
    FAILED_ATTEMPT("9", "Failed Attempt"),
    APPOINTMENT_CANCELLED("10", "Appointment Cancelled"),
    ACCEPTED_BY_VENDOR("11", "Accepted By Vendor"),
    VENDOR_FAILED_ATTEMPT("12", "Vendor Failed Attempt"),
    WILL_BE_RETURNED("13", "Will Be Returned"),
    RECALLED("14", "Recalled");
    
    private String id;
	private String desc;
	
	private IntegrationStatus(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static IntegrationStatus integrationStatus(String id) {
		if (id == null) {
			return null;
		}
		
		for (IntegrationStatus type : IntegrationStatus.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching integration status for id: " + id);
	}
	
	public static String getId(IntegrationStatus integrationStatus) {
		return integrationStatus == null ? null : integrationStatus.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}