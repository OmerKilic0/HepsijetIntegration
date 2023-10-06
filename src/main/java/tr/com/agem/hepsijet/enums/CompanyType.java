package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CompanyType {
	
	CUSTOMER("1", "Customer"),
	MERCHANT("2", "Merchant");
	
	private String id;
	private String desc;
	
	private CompanyType(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static CompanyType companyType(String id) {
		if (id == null) {
			return null;
		}
		
		for (CompanyType type : CompanyType.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching company type for id: " + id);
	}
	
	public static String getId(CompanyType companyType) {
		return companyType == null ? null : companyType.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}