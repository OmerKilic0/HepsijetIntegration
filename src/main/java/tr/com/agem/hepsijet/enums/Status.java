package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Status {
	
	OK("1", "Ok"),
    FAIL("2", "Fail"),
    UNKNOWN("3", "Unknown"),
    INFO("4", "Info"),
    WARNING("5", "Warning"),
    PARTIALLY_OK("6", "Partially Ok");

	private String id;
	private String desc;
	
	private Status(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static Status status(String id) {
		if (id == null) {
			return null;
		}
		
		for (Status type : Status.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching status for id: " + id);
	}
	
	public static String getId(Status status) {
		return status == null ? null : status.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}