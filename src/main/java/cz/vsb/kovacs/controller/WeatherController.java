package cz.vsb.kovacs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
	
	@RequestMapping("/getWeather")
	public String getWeather() {
		return "Pocaci pro vsechna mesta";
	}
	
	@RequestMapping("/getWeatherForCity")
	public String getWeatherForCity() {
		return "Pocasi pro mesto";
	}


}
