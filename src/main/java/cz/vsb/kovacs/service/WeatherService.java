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
		WeatherstackDto wsDto = con.getWeatherForCity(cityEnum);
		return transformDto(wsDto);
	}

	private WeatherDto transformDto(WeatherstackDto wsDto) {
		WeatherDto wdto = new WeatherDto();
		wdto.setLocation(wsDto.getLocation().getName());
		wdto.setRel_humidity(wsDto.getCurrent().getHumidity());
		wdto.setTemp_celsius(wsDto.getCurrent().getTemperature());
		wdto.setTimestamp(wsDto.getCurrent().getObservation_time());
		wdto.setWeatherDescription(wsDto.getCurrent().getWeather_descriptions().get(0));
		wdto.setWindDirection(wsDto.getCurrent().getWind_dir());
		wdto.setWindSpeed_mps(wsDto.getCurrent().getWind_speed());
		return wdto;
	}
}
