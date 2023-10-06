package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TransactionType {
	
	RECEIVE_ORDER("1", "Receive Order"),
    TAKE_CUSTODY("2", "Take Custody"),
    TAKE_CUSTODY_INTEGRATION("3", "Take Custody Integration"),
    DELETE("4", "Delete"),
    CANCEL("5", "Cancel"),
    UPDATE_PARCEL("6", "Update Parcel"),
    LOAD_DELIVERY("7", "Load Delivery"),
    LOAD_CONTAINER("8", "Load Container"),
    LOAD_RING_VEHICLE("9", "Load Ring Vehicle"),
    APPROVE_RING_DEPART("10", "Approve Ring Depart"),
    APPROVE_RING_ARRIVE("11", "Approve Ring Arrive"),
    UNLOAD_RING_VEHICLE("12", "Unload Ring Vehicle"),
    UNLOAD_CONTAINER("13", "Unload Container"),
    APPROVE_COURIER_DEPART("14", "Approve Courier Depart"),
    DELIVERY_ATTEMPT("15", "Delivery Attempt"),
    TRANSFER_CUSTODY("16", "Transfer Custody"),
    SET_MISSING("17", "Set Missing"),
    SET_DAMAGED("18", "Set Damaged"),
    FINALIZE_SLOT("19", "Finalize Slot"),
    DISPATCH("20", "Dispatch"),
    SHIFT_SLOT("21", "Shift Slot"),
    INTEGRATION_JOB_ACCEPT("22", "Integration Job Accept"),
    INTEGRATION_JOB_OFD("23", "Integration Job OFD"),
    INTEGRATION_JOB_FAILED_ATTEMPT("24", "Integration Job Failed Attempt"),
    INTEGRATION_JOB_DELIVERED("25", "Integration Job Delivered"),
    NON_DISPATCH("26", "Non Dispatch"),
    DELIVERY_REVERT("27", "Delivery Revert"),
    INTEGRATION_RETURN("28", "Integration Return"),
    MANUAL_COURIER_ASSIGN("29", "Manual Courier Assign"),
    MANUAL_DISTRICT_ASSIGN("30", "Manual District Assign"),
    TRANSFER_ALL_DELIVERIES("31", "Transfer All Deliveries"),
    RETURN("32", "Return"),
    DISPATCH_ASSIGN("33", "Dispatch Assign"),
    INTEGRATION_UPDATE("34", "Integration Update"),
    CHUTE_UPDATE("35", "Chute Update"),
    COLLECT_ATTEMPT("36", "Collect Attempt"),
    MODIFY_ADDRESS("37", "Modify Address"),
    WAITING_FOR_RETURN("38", "Waiting For Return"),
    ADDRESS_CLEAN_RESOLVE_DISTRICT("39", "Address Clean Resolve District"),
    PREPARE_FOR_DELIVERY("40", "Prepare For Delivery"),
    RETURN_ATTEMPT("41", "Return Attempt"),
    TAKE_CUSTODY_KEEP("42", "Take Custody Keep"),
    TAKE_CUSTODY_REDIRECT("43", "Take Custody Redirect"),
    DESI_UPDATE("44", "Desi Update"),
    OUT_FOR_DELIVERY_JOB("45", "Out For Delivery Job"),
    SIGN_ATTEMPT("46", "Sign Attempt"),
    SET_APPOINTMENT_DATE("47", "Set Appointment Date"),
    UPDATE_DELIVERY_STATUS("48", "Update Delivery Status"),
    MARK_AS_UNDELIVERED("49", "Mark As Undelivered"),
    DISPOSE_CONTRACT("50", "Dispose Contract"),
    EXPIRE_CONTRACT("51", "Expire Contract"),
    TRANSFER_TOUR("52", "Transfer Tour"),
    DELIVERY_ATTEMPT_REVERT("53", "Delivery Attempt Revert"),
    NO_ATTEMPT("54", "No Attempt"),
    SET_SERVICE("55", "Set Service"),
    RESET_SERVICE("56", "Reset Service"),
    FINALIZE_DELIVERY("57", "Finalize Delivery"),
    TAKE_CUSTODY_VENDOR("58", "Take Custody Vendor"),
    VENDOR_DELIVERY_ATTEMPT("59", "Vendor Delivery Attempt"),
    MARK_FOR_VENDOR("60", "Mark For Vendor"),
    COMPLETE_VENDOR_TRANSFER("61", "Complete Vendor Transfer"),
    PAYMENT_ATTEMPT("62", "Payment Attempt"),
    UPDATE_PAYMENT_TYPE("63", "Update Payment Type"),
    RECALL_DELIVERY("64", "Recall Delivery"),
    SET_RECALL_STATUS("65", "Set Recall Status"),
    LOAD_INTO_CONTAINER("66", "Load Into Container"),
    UNLOAD_FROM_CONTAINER("67", "Unload From Container"),
    CALCULATE_DESI("68", "Calculate Desi"),
    DELIVERY_UPDATE("69", "Delivery Update"),
    PRINT_BARCODE("70", "Print Barcode"),
    MANUAL_COURIER_OUT_OF_ZONE_ASSIGN("71", "Manual Courier Out Of Zone Assign"),
    ADDRESS_CHANGE_REQUEST("72", "Address Change Request"),
    ADDRESS_CHANGE_FIRST_SCAN("73", "Address Change First Scan"),
    DELIVERY_WAREHOUSE_UPDATE("74", "Delivery Warehouse Update"),
    TAKE_CUSTODY_ACCEPT("75", "Take Custody Accept"),
    RECALCULATED_DISTRIBUTION_ZONE("76", "Recalculated Distribution Zone"),
    SET_PROMISED_DATE_WITH_JOB("77", "Set Promised Date With Job");
    
    private String id;
	private String desc;
	
	private TransactionType(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static TransactionType transactionType(String id) {
		if (id == null) {
			return null;
		}
		
		for (TransactionType type : TransactionType.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching transaction type for id: " + id);
	}
	
	public static String getId(TransactionType transactionType) {
		return transactionType == null ? null : transactionType.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}