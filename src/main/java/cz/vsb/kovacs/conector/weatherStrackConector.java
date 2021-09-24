package cz.vsb.kovacs.conector;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cz.vsb.kovacs.City;


public class weatherStrackConector {

	private static String baseUrl = "http://api.weatherstack.com/";
	private static String urlParams = "current?access_key=";
	private static String apiKey = "da223c0631c80400f3e7ed08a1a33fc9";
	private static String url = baseUrl+urlParams+apiKey+"&query=";
	
	
	public String getWeatherForCity(City city) {
		 URI uri = null;
		 RestTemplate template = new RestTemplate(); 
		 try {
			 uri = new URI(url + city.toString()); 
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		 ResponseEntity<String> response = template.getForEntity(uri, String.class);
		 return response.getBody();
	}
}
