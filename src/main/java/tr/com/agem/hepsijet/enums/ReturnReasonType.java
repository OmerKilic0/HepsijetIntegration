package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ReturnReasonType {
	
	CANCEL_REASON("1", "Cancel Reason"),
    RETURN_REASON("2", "Return Reason"),
    FAILED_ATTEMPT_REASON("3", "Failed Attempt Reason"),
    NON_DELIVERY_REASON("4", "Non Delivery Reason"),
    DELIVERY_PERSON_TYPE("5", "Delivery Person Type"),
    DAMAGE_TYPE("6", "Damage Type"),
    VEHICLE_BRAND("7", "Vehicle Brand"),
    RECIPIENT_PERSON_TYPE("8", "Recipient Person Type"),
    VEHICLE_MODEL("9", "Vehicle Model"),
    SHIFT_SLOT_REASON("10", "Shift Slot Reason"),
    NON_RETURN_REASON("11", "Non Return Reason"),
    CUSTODY_CAUSE("12", "Custody Cause"),
    CUSTODY_CAUSE_DETAIL("13", "Custody Cause Detail"),
    TRANSFER_WAREHOUSE("14", "Transfer WareHouse"),
    TRANSFER_OTHER_XDOCK("15", "Transfer Other XDock"),
    TO_XDOCK_FOR_RETRY("16", "To XDock For Retry"),
    UNDELIVERED_RETURN("17", "Undelivered Return"),
    UNSEAL_MANUAL_REASON("18", "Unseal Manual Reason"),
    TO_XDOCK("19", "To XDock"),
    RETURN_DELIVERY("20", "Return Delivery"),
    KEEP_IN_XDOCK("21", "Keep In XDock"),
    TO_COMPANY("22", "To Company"),
    TRANSFER_TO_WAREHOUSE("23", "Transfer To Warehouse"),
    TRANSFER_TO_OTHER_XDOCK("24", "Transfer To Other XDock"),
    CUSTODY_CAUSE_WAREHOUSE("25", "Custody Cause WareHouse"),
    KEEP_IN_WAREHOUSE("26", "Keep In Warehouse"),
    DESI_SIZE("27", "Desi Size"),
    DEMAND_CATEGORY("28", "Demand Category"),
    NON_SIGNATURE_REASON("29", "Non Signature Reason"),
    UNPROCESSED("30", "Unprocessed"),
    PUDO_NON_DELIVERY_REASON("31", "Pudo Non Delivery Reason"),
    PAYMENT_TYPE("32", "Payment Type"),
    ROUTE_RELATED_ERROR_OPTION("33", "Route Related Error Option"),
    KEEP_IN_XDOCK_2_HOURS("34", "Keep In XDock 2 Hours"),
    TMH_RETURN_REASON("35", "TMH Return Reason"),
    STOP_ROUTE_GROUP_REASON("36", "Stop Route Group Reason");
    
    private String id;
	private String desc;
	
	private ReturnReasonType(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static ReturnReasonType returnReasonType(String id) {
		if (id == null) {
			return null;
		}
		
		for (ReturnReasonType type : ReturnReasonType.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching type for id: " + id);
	}
	
	public static String getId(ReturnReasonType returnReasonType) {
		return returnReasonType == null ? null : returnReasonType.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}