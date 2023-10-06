package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Currency {
	
	TRY("1", "TRY"),
	USD("2", "USD");
	
	private String id;
	private String desc;
	
	private Currency(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static Currency currency(String id) {
		if (id == null) {
			return null;
		}
		
		for (Currency type : Currency.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching currency for id: " + id);
	}
	
	public static String getId(Currency currency) {
		return currency == null ? null : currency.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}