package cz.vsb.kovacs.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.vsb.kovacs.City;
import cz.vsb.kovacs.austra.dto.WeatherDto;
import cz.vsb.kovacs.conector.weatherStrackConector;
import cz.vsb.kovacs.service.WeatherService;

@RestController
public class WeatherController {
	
	@RequestMapping("/weather")
	public List<WeatherDto> getWeather() {
		List<WeatherDto> list = new ArrayList<WeatherDto>();
		WeatherService ws = new WeatherService();
		
		for (City city: City.values()) {
			list.add(ws.getWeatherForCity(city));
		}
		return list;
		
	}
	
	@RequestMapping("/weather/{city}")                               // to co je ve složených závorkách je proměnná 
	public WeatherDto getWeatherForCity(@PathVariable String city) {
		City cityEnum = City.valueOf(city.toUpperCase());
		WeatherService ws = new WeatherService();
		return ws.getWeatherForCity(cityEnum);
	}


}
