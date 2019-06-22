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
	
	@RequestMapping(value = "/weather.do")
	public ResponseEntity<String> getWeather(String lat, String lon) {
		return new ResponseEntity<String>(new Weather().getWeatherFromAPI(lat, lon), HttpStatus.OK);
	}
	
//	public ResponseEntity<String> getWeatherFromDB(String lat, String lon)	{
//		Weather w = new Weather();
//		w.getWeather(lat, lon);
//		
//	}
	
}
