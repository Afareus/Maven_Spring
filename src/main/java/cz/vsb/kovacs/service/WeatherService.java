package cz.vsb.kovacs.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cz.vsb.kovacs.City;
import cz.vsb.kovacs.austra.dto.WeatherDto;
import cz.vsb.kovacs.austra.dto.WeatherstackDto;
import cz.vsb.kovacs.conector.weatherStrackConector;

@Service
public class WeatherService {

	public WeatherDto getWeatherForCity(City cityEnum) {
		weatherStrackConector con = new weatherStrackConector();
		String loc = con.getWeatherForCity(cityEnum);
		return transformDto(loc);
	}

	private WeatherDto transformDto(String loc) {
		WeatherDto wdto = new WeatherDto();
		wdto.setLocation(loc);
		return wdto;
	}
}
