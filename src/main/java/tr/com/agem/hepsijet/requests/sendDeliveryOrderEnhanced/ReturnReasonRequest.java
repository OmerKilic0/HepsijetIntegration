package tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced;

import tr.com.agem.hepsijet.enums.ReturnReasonType;

//DeliveryRequest için request
public class ReturnReasonRequest {

	private int attemptLimit;
	private int id;
	private boolean isPhotoNeccessary;
	private String key;
	private int order;
	private boolean photoNeccessary;
	private boolean reasonEffect;
	private ReturnReasonType type;
	private String value;
	
	public int getAttemptLimit() {
		return attemptLimit;
	}
	public void setAttemptLimit(int attemptLimit) {
		this.attemptLimit = attemptLimit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean getIsPhotoNeccessary() {
		return isPhotoNeccessary;
	}
	public void setIsPhotoNeccessary(boolean isPhotoNeccessary) {
		this.isPhotoNeccessary = isPhotoNeccessary;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public boolean getPhotoNeccessary() {
		return photoNeccessary;
	}
	public void setPhotoNeccessary(boolean photoNeccessary) {
		this.photoNeccessary = photoNeccessary;
	}
	public boolean isReasonEffect() {
		return reasonEffect;
	}
	public void setReasonEffect(boolean reasonEffect) {
		this.reasonEffect = reasonEffect;
	}
	public ReturnReasonType getType() {
		return type;
	}
	public void setType(ReturnReasonType type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public ReturnReasonRequest() {
		super();
	}
	public ReturnReasonRequest(int attemptLimit, int id, boolean isPhotoNeccessary, String key, int order,
			boolean photoNeccessary, boolean reasonEffect, ReturnReasonType type, String value) {
		super();
		this.attemptLimit = attemptLimit;
		this.id = id;
		this.isPhotoNeccessary = isPhotoNeccessary;
		this.key = key;
		this.order = order;
		this.photoNeccessary = photoNeccessary;
		this.reasonEffect = reasonEffect;
		this.type = type;
		this.value = value;
	}
}