package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Type {
	
	PRODUCT_AMOUNT("1", "Product Amount"),
	DELIVERY_AMOUNT("2", "Delivery Amount"),
	SERVICE_AMOUNT("3", "Service Amount"),
	OTHER("4", "Other");
	
	private String id;
	private String desc;
	
	private Type(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static Type type(String id) {
		if (id == null) {
			return null;
		}
		
		for (Type type : Type.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching type for id: " + id);
	}
	
	public static String getId(Type type) {
		return type == null ? null : type.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}