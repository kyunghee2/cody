package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.biz.user.service.UserService;
import weather.Weather;

@Controller
public class WeatherController {
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/weather.do", method = RequestMethod.GET)
	public String weatherJSON(String lat, String lon) {	
		Weather w = new Weather();
		return w.getWeather(lat, lon);
	}
	
}
