package cz.vsb.kovacs.conector;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class weatherStrackConector {

	private static String baseUrl = "http://api.weatherstack.com/";
	private static String urlParams = "current?access_key=";
	private static String apiKey = "da223c0631c80400f3e7ed08a1a33fc9";
	private static String url = baseUrl+urlParams+apiKey+"&query=";
	
	
	public String getWeatherForCity(String city) {
		 URI uri = null;
		 RestTemplate template = new RestTemplate(); 
		 try {
			 uri = new URI(url + city); 
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		 ResponseEntity<String> response = template.getForEntity(uri, String.class);
		 return response.getBody();
	}
}
