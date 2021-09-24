package cz.vsb.kovacs.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
	
	@RequestMapping("/weather")
	public String getWeather() {
		return "Pocaci pro vsechna mesta";
	}
	
	@RequestMapping("/weather/{city}")                               // to co je ve složených závorkách je proměnná 
	public String getWeatherForCity(@PathVariable String city) {
		return "Pocasi pro mesto " + city;
	}


}
