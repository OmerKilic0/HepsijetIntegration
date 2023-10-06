package tr.com.agem.hepsijet;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.fasterxml.jackson.core.JsonProcessingException;

import tr.com.agem.hepsijet.controller.HepsijetClient;
import tr.com.agem.hepsijet.requests.barcodesLabel.BarcodeDTO;
import tr.com.agem.hepsijet.requests.deleteDeliveryAdvance.DeleteDeliveryOrderRequestDTO;
import tr.com.agem.hepsijet.requests.deleteDeliveryOrder.DeleteDeliveryRequestDTO;
import tr.com.agem.hepsijet.requests.deliveryUpdate.DeliveryUpdateRequestDTO;
import tr.com.agem.hepsijet.requests.getDeliveryTracking.DeliveriesRequest;
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

import java.util.ArrayList;
import java.util.List;

public class HepsijetClientTest {

	static {
		System.setProperty("profile", "live");
	}
	
	String username = "defneruyaintegration";
	String password = "85838643";
	String token = "e1e20e09-9027-4600-94e7-3c10164e0aa1";
	
	@Test
	public void HepsijetClient_getToken() {
		HepsijetClient client = HepsijetClient.getInstance();
		HepsijetToken token = client.getToken(username, password);
		this.token = token.getData().getToken();
		System.out.println(this.token);
		Assertions.assertNotNull(token);
	}
	
	@Test
	public void HepsijetClient_sendDeliveryOrderEnhanced() throws JsonProcessingException {
		HepsijetClient client = HepsijetClient.getInstance();
		SwaggerDeliveryOrderEnhancedRequestDTO swaggerDeliveryOrderEnhancedRequestDTO = new SwaggerDeliveryOrderEnhancedRequestDTO();
		SendDeliveryOrderEnhanced sendDeliveryOrderEnhanced = client.sendDeliveryOrderEnhanced(token, swaggerDeliveryOrderEnhancedRequestDTO);
		Assertions.assertNotNull(sendDeliveryOrderEnhanced);
	}
	
	@Test
	public void HepsijetClient_deleteDeliveryOrder() throws JsonProcessingException {
		HepsijetClient client = HepsijetClient.getInstance();
		DeleteDeliveryRequestDTO deleteDeliveryRequestDTO = new DeleteDeliveryRequestDTO("IPTAL");
		DeleteDeliveryOrder deleteDeliveryOrder = client.deleteDeliveryOrder(token, "HJET123456789", deleteDeliveryRequestDTO);
		Assertions.assertNotNull(deleteDeliveryOrder);
	}
	
	@Test
	public void HepsijetClient_sendDeliveryAdvance() throws JsonProcessingException {
		HepsijetClient client = HepsijetClient.getInstance();
		OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
		SendDeliveryAdvance sendDeliveryAdvance = client.sendDeliveryAdvance(token, orderInfoDTO);
		Assertions.assertNotNull(sendDeliveryAdvance);
	}
	
	@Test
	public void HepsijetClient_deleteDeliveryAdvance() throws JsonProcessingException {
		HepsijetClient client = HepsijetClient.getInstance();
		DeleteDeliveryOrderRequestDTO deleteDeliveryOrderRequestDTO = new DeleteDeliveryOrderRequestDTO("Delete reason");
		DeleteDeliveryAdvance deleteDeliveryAdvance = client.deleteDeliveryAdvance(token, "HJET123456", deleteDeliveryOrderRequestDTO);
		Assertions.assertNotNull(deleteDeliveryAdvance);
	}
	
	@Test
	public void HepsijetClient_deliveryUpdate() throws JsonProcessingException {
		HepsijetClient client = HepsijetClient.getInstance();
		DeliveryUpdateRequestDTO deliveryUpdateRequestDTO = new DeliveryUpdateRequestDTO(null, null, "", null, null, null, "", null, 0);
		DeliveryUpdate deliveryUpdate = client.deliveryUpdate(token, deliveryUpdateRequestDTO);
		Assertions.assertNotNull(deliveryUpdate);
	}
	
	@Test
	public void HepsijetClient_barcodesLabel() throws JsonProcessingException {
		HepsijetClient client = HepsijetClient.getInstance();
		List<String> barcodes = new ArrayList<>();
		barcodes.add("HJT1000000000");
		barcodes.add("HJT1000000001");
		BarcodeDTO barcodeDTO = new BarcodeDTO(barcodes);
		BarcodesLabel barcodesLabel = client.barcodesLabel(token, "PDF", barcodeDTO);
		Assertions.assertNotNull(barcodesLabel);
	}
	
	@Test
	public void HepsijetClient_updateDeliveryDesi() throws JsonProcessingException {
		HepsijetClient client = HepsijetClient.getInstance();
		DesiUpdateRequestDTO desiUpdateRequestDTO = new DesiUpdateRequestDTO();
		UpdateDeliveryDesi updateDeliveryDesi = client.updateDeliveryDesi(token, desiUpdateRequestDTO);
		Assertions.assertNotNull(updateDeliveryDesi);
	}
	
	@Test
	public void HepsijetClient_findAvailableDeliveryDates() {
		HepsijetClient client = HepsijetClient.getInstance();
		FindAvailableDeliveryDates findAvailableDeliveryDates = client.findAvailableDeliveryDates(token, "", "", "", "", "");
		Assertions.assertNotNull(findAvailableDeliveryDates);
	}
	
	@Test
	public void HepsijetClient_generateZplBarcode() {
		HepsijetClient client = HepsijetClient.getInstance();
		GenerateZplBarcode generateZplBarcode = client.generateZplBarcode(token, "1111111", 1);
		Assertions.assertNotNull(generateZplBarcode);
	}
	
	@Test
	public void HepsijetClient_getDeliveryTracking() throws JsonProcessingException {
		HepsijetClient client = HepsijetClient.getInstance();
		DeliveriesRequest delivery = new DeliveriesRequest("CustomerDeliveryNo");
		List<DeliveriesRequest> deliveries = new ArrayList<>();
		deliveries.add(delivery);
		SwaggerCustomerDeliveryNoListDTO swaggerCustomerDeliveryNoListDTO = new SwaggerCustomerDeliveryNoListDTO(deliveries);
		GetDeliveryTracking getDeliveryTracking = client.getDeliveryTracking(token, swaggerCustomerDeliveryNoListDTO);
		Assertions.assertNotNull(getDeliveryTracking);
	}
	
	@Test
	public void HepsijetClient_getEndOfTheDay() throws JsonProcessingException {
		HepsijetClient client = HepsijetClient.getInstance();
		EndOfTheDayRequestDTO endOfTheDayRequestDTO = new EndOfTheDayRequestDTO("2023-08-07T07:19:19.837Z", "2023-08-07T07:19:19.837Z");
		GetEndOfTheDay getEndOfTheDay = client.getEndOfTheDay(token, endOfTheDayRequestDTO);
		Assertions.assertNotNull(getEndOfTheDay);
	}
	
	@Test
	public void HepsijetClient_track() throws JsonProcessingException {
		HepsijetClient client = HepsijetClient.getInstance();
		List<String> barcodes = new ArrayList<>();
		barcodes.add("HJT1000000000");
		barcodes.add("HJT1000000001");
		BarcodeListRequestDTO barcodeListRequestDTO = new BarcodeListRequestDTO(barcodes, true);
		Track track = client.track(token, barcodeListRequestDTO);
		Assertions.assertNotNull(track);
	}
	
	@Test
	public void HepsijetClient_cities() {
		HepsijetClient client = HepsijetClient.getInstance();
		Cities cities = client.cities(token);
		Assertions.assertNotNull(cities);
	}
	
	@Test
	public void HepsijetClient_towns() {
		HepsijetClient client = HepsijetClient.getInstance();
		Towns towns = client.towns(token, 34);
		Assertions.assertNotNull(towns);
	}
	
	@Test
	public void HepsijetClient_districts() {
		HepsijetClient client = HepsijetClient.getInstance();
		Districts districts = client.districts(token, 34);
		Assertions.assertNotNull(districts);
	}
}