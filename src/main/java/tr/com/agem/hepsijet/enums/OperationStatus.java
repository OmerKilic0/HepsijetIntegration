package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OperationStatus {
	
	IN_CUSTOMER("1", "In Customer"),
    IN_XDOCK("2", "In XDock"),
    IN_CONTAINER("3", "In Container"),
    IN_RING_VEHICLE("4", "In Ring Vehicle"),
    IN_RING_TRANSIT("5", "In Ring Transit"),
    IN_DELIVERY_VEHICLE("6", "In Delivery Vehicle"),
    IN_DELIVERY_TRANSIT("7", "In Delivery Transit"),
    IN_RECIPIENT("8", "In Recipient"),
    IN_VENDOR("9", "In Vendor");
    
    private String id;
	private String desc;
	
	private OperationStatus(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static OperationStatus operationStatus(String id) {
		if (id == null) {
			return null;
		}
		
		for (OperationStatus type : OperationStatus.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching operation status for id: " + id);
	}
	
	public static String getId(OperationStatus operationStatus) {
		return operationStatus == null ? null : operationStatus.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}