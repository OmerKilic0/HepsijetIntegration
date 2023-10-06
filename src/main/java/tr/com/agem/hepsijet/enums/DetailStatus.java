package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DetailStatus {
	
	HB_CALL_FAILED("1", "HB Call Failed"),
    XDOCK_SELECTION_REQUIRED("2", "XDock Selection Required"),
    CONTAINER_NOT_FOUND("3", "Container Not Found"),
    UNAUTHORIZED("4", "Unauthorized"),
    BAD_REQUEST("5", "Bad Request"),
    SERVER_ERROR("6", "Server Error"),
    SHOW_WARNING("7", "Show Warning"),
    SIBLING_PARCEL("8", "Sibling Parcel"),
    NOT_FOUND("9", "Not found"),
    FOUND("10", "Found"),
    SEAL_BARCODE_MISMATCH("11", "Seal Barcode Mismatch"),
    CAN_NOT_UNLOAD("12", "Can Not Unload"),
    SYSTEM_SLOT_NOT_SET("13", "System Slot Not Set"),
    UNCLOSED_SYSTEM_SLOT_FOR_PREVIOUS_DATE("14", "Unclosed System Slot For Previous Date"),
    MISSING_UNLOAD("15", "Missing Unload"),
    CANNOT_MODIFY_INFO("16", "Cannot Modify Info"),
    SMS_UNDELIVER("17", "SMS Undeliver"),
    ALREADY_ARRIVED("18", "Already Arrived"),
    BARCODE_EXIST("19", "Barcode Exist"),
    VALIDATION_ERROR("20", "Validation Error"),
    TOUR_CAN_NOT_BE_COMPLETED("21", "Tour Can Not Be Completed"),
    ASK_SEAL_AND_WAYBILLNO("22", "Ask Seal And WayBillNo"),
    ASK_ONLY_SEAL("23", "Ask Only Seal"),
    ASK_ONLY_WAYBILLNO("24", "Ask Only WayBillNo"),
    NOT_ASK_SEAL_AND_WAYBILLNO("25", "Not Ask Seal and WayBillNo"),
    FINALIZE_CONTAINER_LOAD("26", "Finalize Container Load"),
    FINALIZE_CONTAINER_UNLOAD("27", "Finalize Container Unload"),
    EXIST_DELIVERY_IN_CONTAINER("28", "Exist Delivery In Container"),
    UNLOAD_TOUR_OPTION_SELECTION_REQUIRED("29", "Unload Tour Option Selection Required"),
    UNLOAD_TOUR_MANUAL_OPTION_SELECTION_REQUIRED("30", "Unload Tour Manual Option Selection Required"),
    TOUR_CHANGED_UNLOADING("31", "Tour Changed Unloading"),
    TOUR_CHANGED_UNLOADING_AND_ALREADY_UNLOADED("32", "Tour Changed Unloading and Already Unloaded"),
    APPROVE_RING_ARRIVE_REQUIRED("33", "Approve Ring Arrive Reqiured"),
    UNLOAD_TOUR_SELECTION_REQUIRED("34", "Unload Tour Selection Required"),
    APPROVE_TOUR_ARRIVAL_REQUIRED("35", "Approve Tour Arrival Required"),
    DELIVERY_ALREADY_LOADED_INTO_CONTAINER("36", "Delivery Already Loaded Into Container"),
    SIBLING_PARCEL_PRINT("37", "Sibling Parcel Print");
    
    private String id;
	private String desc;
	
	private DetailStatus(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static DetailStatus detailStatus(String id) {
		if (id == null) {
			return null;
		}
		
		for (DetailStatus type : DetailStatus.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching detail status for id: " + id);
	}
	
	public static String getId(DetailStatus detailStatus) {
		return detailStatus == null ? null : detailStatus.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}