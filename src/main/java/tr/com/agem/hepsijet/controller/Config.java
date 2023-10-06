package tr.com.agem.hepsijet.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Config {
	
	private String token;
	private String sendDeliveryOrderEnhanced;
	private String deleteDeliveryOrder;
	private String sendDeliveryAdvance;
	private String deleteDeliveryAdvance;
	private String deliveryUpdate;
	private String barcodeLabel;
	private String updateDeliveryDesi;
	private String findAvailableDeliveryDates;
	private String generateZplBarcode;
	private String getDeliveryTracking;
	private String getEndOfTheDay;
	private String track;
	private String cities;
	private String towns;
	private String districts;

	public Config() {
		super();
		Properties properties = loadProperties();
		propertiesToConfig(properties);
	}
	
	private void propertiesToConfig(Properties properties) {
		setToken(properties.getProperty("hepsijet.token"));
		setSendDeliveryOrderEnhanced(properties.getProperty("hepsijet.sendDeliveryOrderEnhanced"));
		setSendDeliveryAdvance(properties.getProperty("hepsijet.sendDeliveryAdvance"));
		setDeleteDeliveryAdvance(properties.getProperty("hepsijet.deleteDeliveryAdvance"));
		setDeleteDeliveryOrder(properties.getProperty("hepsijet.deleteDeliveryOrder"));
		setDeliveryUpdate(properties.getProperty("hepsijet.deliveryUpdate"));
		setBarcodeLabel(properties.getProperty("hepsijet.barcodeLabel"));
		setUpdateDeliveryDesi(properties.getProperty("hepsijet.updateDeliveryDesi"));
		setFindAvailableDeliveryDates(properties.getProperty("hepsijet.findAvailableDeliveryDates"));
		setGenerateZplBarcode(properties.getProperty("hepsijet.generateZplBarcode"));
		setGetDeliveryTracking(properties.getProperty("hepsijet.getDeliveryTracking"));
		setGetEndOfTheDay(properties.getProperty("hepsijet.getEndOfTheDay"));		
		setTrack(properties.getProperty("hepsijet.track"));
		setCities(properties.getProperty("hepsijet.cities"));
		setTowns(properties.getProperty("hepsijet.towns"));
		setDistricts(properties.getProperty("hepsijet.districts"));
		
	}
	
	private Properties loadProperties() {
		Properties prop = new Properties();
		loadProperties(prop, null);
		
		String profiles = System.getProperty("spring.profiles.active");
		if (profiles != null && !profiles.isEmpty()) {
			String[] profilesArr = profiles.split(",");
			for (int i = 0; i < profilesArr.length; i++) {
				String profile = profilesArr[i];
				loadProperties(prop, profile);
			}
		}
		return prop;
	}
	
	private void loadProperties(Properties prop, String profile) {
		try {
			String fileName = "hepsijet-live";
			if (profile != null && !profile.isEmpty()) {
				fileName += "-" + profile;
			}
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName + ".properties");
			if (inputStream != null) {
				prop.load(inputStream);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
