package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DeliveryStatus {
	
	NEO("1", "Neo"),
    MISSING("2", "Missing"),
    DAMAGED("3", "Damaged"),
    READY("4", "Ready"),
    TRANSFERRING("5", "Transferring"),
    DISPATCHING("6", "Dispatching"),
    DELIVERING("7", "Delivering"),
    DELIVERED("8", "Delivered"),
    RETRY("9", "Retry"),
    UNDELIVERED("10", "Undelivered"),
    UNDELIVERABLE("11", "Undeliverable"),
    REFUSED("12", "Refused"),
    CANCELLED("13", "Cancelled"),
    DELETED("14", "Deleted"),
    RETURNED("15", "Returned"),
    MISSING_CONTENT("16", "Missing Content"),
    PARTIALLY_DELIVERED("17", "Partially Delivered"),
    WAITING_FOR_DISPATCH("18", "Waiting For Dispatch"),
    BACK_TO_WAREHOUSE("19", "Back To Warehouse"),
    COLLECTING("20", "Collecting"),
    COLLECTED("21", "Collected"),
    UNABLE_TO_COLLECT("22", "Unable To Collect"),
    NEO_COLLECT("23", "Neo Collect"),
    TRANSFERRING_COLLECT("24", "Transfering Collect"),
    READY_FOR_DELIVERY("25", "Ready For Delivery"),
    MARK_FOR_RETURN("26", "Mark For Return"),
    TRANSFERRING_RETURN("27", "Transferring Return"),
    SIGNED("28", "Signed"),
    NOT_SIGNED("29", "Not Signed"),
    PENDING_SIGNATURE("30", "Pending Signature"),
    PRINTED_OUT("31", "Printed Out"),
    SIGNING("32", "Signing"),
    EXPIRED("33", "Expired"),
    DISPOSED("34", "Disposed"),
    MISSING_DOCUMENT("35", "Missing Document"),
    COMPLETE_REQUEST("36", "Complete Request"),
    PROCESSED("37", "Processed"),
    TRANSFERRED_VENDOR("38", "Transferred Vendor"),
    MARKED_FOR_VENDOR("39", "Marked For Vendor"),
    READY_FOR_VENDOR("40", "Ready For Vendor"),
    TRANSFERRING_TRANSFER("41", "Transferring Transfer");
    
    private String id;
	private String desc;
	
	private DeliveryStatus(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static DeliveryStatus deliveryStatus(String id) {
		if (id == null) {
			return null;
		}
		
		for (DeliveryStatus type : DeliveryStatus.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching delivery status for id: " + id);
	}
	
	public static String getId(DeliveryStatus deliveryStatus) {
		return deliveryStatus == null ? null : deliveryStatus.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}