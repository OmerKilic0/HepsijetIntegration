package tr.com.agem.hepsijet.controller;

import java.util.Base64;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import tr.com.agem.hepsijet.controller.HepsijetClient;
import tr.com.agem.hepsijet.requests.barcodesLabel.BarcodeDTO;
import tr.com.agem.hepsijet.requests.deleteDeliveryAdvance.DeleteDeliveryOrderRequestDTO;
import tr.com.agem.hepsijet.requests.deleteDeliveryOrder.DeleteDeliveryRequestDTO;
import tr.com.agem.hepsijet.requests.deliveryUpdate.DeliveryUpdateRequestDTO;
import tr.com.agem.hepsijet.requests.getDeliveryTracking.SwaggerCustomerDeliveryNoListDTO;
import tr.com.agem.hepsijet.requests.getEndOfTheDay.EndOfTheDayRequestDTO;
import tr.com.agem.hepsijet.requests.sendDeliveryAdvance.OrderInfoDTO;
import tr.com.agem.hepsijet.requests.sendDeliveryOrderEnhanced.SwaggerDeliveryOrderEnhancedRequestDTO;
import tr.com.agem.hepsijet.requests.track.BarcodeListRequestDTO;
import tr.com.agem.hepsijet.requests.updateDeliveryDesi.DesiUpdateRequestDTO;
import tr.com.agem.hepsijet.responses.barcodesLabel.BarcodesLabel;
import tr.com.agem.hepsijet.responses.cities.Cities;
import tr.com.agem.hepsijet.responses.deleteDeliveryAdvance.DeleteDeliveryAdvance;
import tr.com.agem.hepsijet.responses.deleteDeliveryOrder.DeleteDeliveryOrder;
import tr.com.agem.hepsijet.responses.deliveryUpdate.DeliveryUpdate;
import tr.com.agem.hepsijet.responses.districts.Districts;
import tr.com.agem.hepsijet.responses.findAvailableDeliveryDates.FindAvailableDeliveryDates;
import tr.com.agem.hepsijet.responses.generateZplBarcode.GenerateZplBarcode;
import tr.com.agem.hepsijet.responses.getDeliveryTracking.GetDeliveryTracking;
import tr.com.agem.hepsijet.responses.getEndOfTheDay.GetEndOfTheDay;
import tr.com.agem.hepsijet.responses.sendDeliveryAdvance.SendDeliveryAdvance;
import tr.com.agem.hepsijet.responses.sendDeliveryOrderEnhanced.SendDeliveryOrderEnhanced;
import tr.com.agem.hepsijet.responses.token.HepsijetToken;
import tr.com.agem.hepsijet.responses.towns.Towns;
import tr.com.agem.hepsijet.responses.track.Track;
import tr.com.agem.hepsijet.responses.updateDeliveryDesi.UpdateDeliveryDesi;

public class HepsijetClient {

	private static HepsijetClient instance = null;
	
	public static synchronized HepsijetClient getInstance() {
		if (instance == null) {
			instance = new HepsijetClient();
		}
		return instance;
	}

	private static final Logger logger = Logger.getLogger(HepsijetClient.class);
	private OkHttpClient okhttp;
	private Config config;
	private ObjectMapper objectMapper;
	private String authorization = "";
	
	public HepsijetClient() {
		this.config = new Config();
		OkHttpClient client = new OkHttpClient().newBuilder()
		.readTimeout(30, TimeUnit.SECONDS)
		.writeTimeout(30, TimeUnit.SECONDS)
		.connectTimeout(30,TimeUnit.SECONDS)
		.build();
		this.okhttp = client;
		
		this.objectMapper = new ObjectMapper();
		this.objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		this.objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
	}
	
	public HepsijetToken getToken(String username, String password) {
		String url = this.config.getToken();
		HepsijetToken returnItem = null;
		
		authorization = basicAuth(username, password);
		Builder builder = createBaseRequestBuilder(url, null, authorization);
		Request request = builder
		.get()
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.string(), new TypeReference<HepsijetToken>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Hepsijet token alınırken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public SendDeliveryOrderEnhanced sendDeliveryOrderEnhanced(String token, SwaggerDeliveryOrderEnhancedRequestDTO swaggerDeliveryOrderEnhancedRequestDTO) throws JsonProcessingException {
		String url = this.config.getSendDeliveryOrderEnhanced();
		SendDeliveryOrderEnhanced returnItem = null;
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(swaggerDeliveryOrderEnhancedRequestDTO);
		
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
    	Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.post(requestBody)
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<SendDeliveryOrderEnhanced>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Gönderiler Hepsijet'e iletilirken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public DeleteDeliveryOrder deleteDeliveryOrder(String token, String deliveryNo, DeleteDeliveryRequestDTO deleteDeliveryRequestDTO) throws JsonProcessingException {
		String baseUrl = this.config.getDeleteDeliveryOrder();
		String url = baseUrl + deliveryNo;
		DeleteDeliveryOrder returnItem = null;
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(deleteDeliveryRequestDTO);
		
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
    	Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.post(requestBody)
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<DeleteDeliveryOrder>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Gönderi iptal edilirken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public SendDeliveryAdvance sendDeliveryAdvance(String token, OrderInfoDTO orderInfoDTO) throws JsonProcessingException {
		String url = this.config.getSendDeliveryAdvance();
		SendDeliveryAdvance returnItem = null;
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(orderInfoDTO);
		
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
    	Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.post(requestBody)
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<SendDeliveryAdvance>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Merchant kaydı oluşturulurken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public DeleteDeliveryAdvance deleteDeliveryAdvance(String token, String customerOrderId, DeleteDeliveryOrderRequestDTO deleteDeliveryOrderRequestDTO) throws JsonProcessingException {
		String baseUrl = this.config.getDeleteDeliveryAdvance();
		String url = baseUrl + customerOrderId;
		DeleteDeliveryAdvance returnItem = null;
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(deleteDeliveryOrderRequestDTO);
		
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
    	Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.post(requestBody)
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<DeleteDeliveryAdvance>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Merchant kaydı silinirken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public DeliveryUpdate deliveryUpdate(String token, DeliveryUpdateRequestDTO deliveryUpdateRequestDTO) throws JsonProcessingException {
		String url = this.config.getDeliveryUpdate();
		DeliveryUpdate returnItem = null;
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(deliveryUpdateRequestDTO);
		
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
    	Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.post(requestBody)
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<DeliveryUpdate>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Teslimat bilgileri güncellenirken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public BarcodesLabel barcodesLabel(String token, String format, BarcodeDTO barcodeDTO) throws JsonProcessingException {
//		String url = this.config.getBarcodeLabel();
		String baseUrl = this.config.getBarcodeLabel();
		String url = baseUrl + "?format=" + format;
		BarcodesLabel returnItem = null;
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(barcodeDTO);
		
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
    	Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.post(requestBody)
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<BarcodesLabel>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Barcode formatı değiştirilirken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public UpdateDeliveryDesi updateDeliveryDesi(String token, DesiUpdateRequestDTO desiUpdateRequestDTO) throws JsonProcessingException {
		String url = this.config.getUpdateDeliveryDesi();
		UpdateDeliveryDesi returnItem = null;
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(desiUpdateRequestDTO);
		
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
    	Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.post(requestBody)
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<UpdateDeliveryDesi>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Teslimat desisi güncellenirken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public FindAvailableDeliveryDates findAvailableDeliveryDates(String token, String startDate, String endDate, String deliveryType, String city, String town) {
		String baseUrl = this.config.getFindAvailableDeliveryDates();
		String url = baseUrl + "?startDate=" + startDate + "&endDate=" + endDate + "&deliveryType=" + deliveryType + "&city=" + city + "&town=" + town;
		FindAvailableDeliveryDates returnItem = null;
		
		Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.get()
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<FindAvailableDeliveryDates>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Günler listelenirken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public GenerateZplBarcode generateZplBarcode(String token, String barcode, int totalParcel) {
		String baseUrl = this.config.getGenerateZplBarcode();
		String url = baseUrl + barcode + "/" + totalParcel;
		GenerateZplBarcode returnItem = null;
		
		Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.get()
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<GenerateZplBarcode>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Zpl barcode oluşturulurken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public GetDeliveryTracking getDeliveryTracking(String token, SwaggerCustomerDeliveryNoListDTO swaggerCustomerDeliveryNoListDTO) throws JsonProcessingException {
		String url = this.config.getGetDeliveryTracking();
		GetDeliveryTracking returnItem = null;
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(swaggerCustomerDeliveryNoListDTO);
		
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
    	Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.post(requestBody)
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<GetDeliveryTracking>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Gönderiye ait bilgiler getirilirken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public GetEndOfTheDay getEndOfTheDay(String token, EndOfTheDayRequestDTO endOfTheDayRequestDTO) throws JsonProcessingException {
		String url = this.config.getGetEndOfTheDay();
		GetEndOfTheDay returnItem = null;
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(endOfTheDayRequestDTO);
		
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
    	Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.post(requestBody)
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<GetEndOfTheDay>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Gönderiye ait bilgiler getirilirken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public Track track(String token, BarcodeListRequestDTO barcodeListRequestDTO) throws JsonProcessingException {
		String url = this.config.getTrack();
		Track returnItem = null;
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(barcodeListRequestDTO);
		
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
    	Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.post(requestBody)
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<Track>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Gönderiye ait bilgiler getirilirken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public Cities cities(String token) {
		String url = this.config.getCities();
		Cities returnItem = null;
		
		Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.get()
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<Cities>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Dağıtım alanları getirilirken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public Towns towns(String token, int id) {
		String baseUrl = this.config.getTowns();
		String url = baseUrl + id + "/towns";
		Towns returnItem = null;
		
		Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.get()
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<Towns>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Dağıtım alanları getirilirken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	public Districts districts(String token, int id) {
		String baseUrl = this.config.getDistricts();
		String url = baseUrl + id + "/districts";
		Districts returnItem = null;
		
		Builder builder = createBaseRequestBuilder(url, token, null);
		Request request = builder
		.get()
		.build();
		Response response = null;
		
		try {
			response = okhttp.newCall(request).execute();
			if(response.isSuccessful()) {
				ResponseBody body = response.body();
				returnItem = objectMapper.readValue(body.bytes(), new TypeReference<Districts>() {});
				return returnItem;
			}
		}
		catch(Exception e) {
			logger.error("Dağıtım alanları getirilirken beklenmedik hata oluştu!! Code: " + response.code() + ", Message: " + response.message(), e);
		}
		finally {
			if(response != null){
				response.close();
			}
		}
		return returnItem;
	}
	
	private String basicAuth(String username, String password) {
		String basic = username + ":" + password;
		String auth = Base64.getEncoder().encodeToString(basic.getBytes());
		return auth;
	}
	
	private Builder createBaseRequestBuilder(String url, String token, String authorization) {
		Builder builder = new Request.Builder()
				.url(url)
				.addHeader("content-type", "application/json")
				.addHeader("accept", "application/json");
		if (token != null) {
			builder.addHeader("X-Auth-Token", token);
		}
		if (authorization != null) {
			builder.addHeader("Authorization", "Basic " + authorization);
		}
		return builder;
	}
}