package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.biz.user.service.UserService;
import weather.Weather;

@Controller
public class WeatherController {
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/api/weather.do")
	public ResponseEntity<String> getWeatherFromAPI(String lat, String lon) {
		Weather w = new Weather();
		return new ResponseEntity<String>(w.getWeatherFromAPI(lat, lon), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/db/weather.do")
	public ResponseEntity<String> getWeatherFromDB() {
		Weather w = new Weather();
		return new ResponseEntity<String>(w.getWeatherFromDB(), HttpStatus.OK);
	}
}
