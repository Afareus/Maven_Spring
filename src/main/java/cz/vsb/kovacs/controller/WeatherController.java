package cz.vsb.kovacs.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.vsb.kovacs.City;
import cz.vsb.kovacs.conector.weatherStrackConector;

@RestController
public class WeatherController {
	
	@RequestMapping("/weather")
	public String getWeather() {
		return "Pocaci pro vsechna mesta";
	}
	
	@RequestMapping("/weather/{city}")                               // to co je ve složených závorkách je proměnná 
	public String getWeatherForCity(@PathVariable String city) {
		City cityEnum = City.valueOf(city.toUpperCase()); 
		weatherStrackConector con = new weatherStrackConector();	
		return con.getWeatherForCity(cityEnum);
	}


}
