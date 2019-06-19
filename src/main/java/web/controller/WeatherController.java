//package web.controller;
//
//import java.io.UnsupportedEncodingException;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.sun.tracing.dtrace.ModuleAttributes;
//
//import spring.biz.user.dao.UserDAO;
//import spring.biz.user.dao.UserDAO_JDBC;
//import spring.biz.user.service.UserService;
//import spring.biz.user.service.UserServiceImpl;
//import spring.biz.user.vo.UserVO;
//import util.AES256Util;
//import weather.Weather;
//import web.validator.UserValidator;
//
//@Controller
//public class WeatherController {
//	@Autowired
//	UserService service;
//	
//	@RequestMapping(value = "/weather.do", method = RequestMethod.GET)
//	public String weatherJSON(String lat, String lon) {	
//		Weather w = new Weather();
//		return w.getWeather(lat, lon);
//	}
//	
//}
