package tr.com.agem.hepsijet.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DesiType {
	
	SMALL_SIZE("1", "Small Size"),
	MEDIUM_SIZE("2", "Medium Size"),
	LARGE_SIZE("3", "Large Size"),
	XL_SIZE("4", "XL Size"),
	XLARGE_SIZE_HUNDRED_ONE("5", "XLarge Size Hundred One");
    
    private String id;
	private String desc;
	
	private DesiType(String id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static DesiType desiType(String id) {
		if (id == null) {
			return null;
		}
		
		for (DesiType type : DesiType.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching desi type for id: " + id);
	}
	
	public static String getId(DesiType desiType) {
		return desiType == null ? null : desiType.getId();
	}
	
	@Override
	public String toString() {
		return desc;
	}
}