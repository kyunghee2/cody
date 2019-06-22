package web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.biz.cloth.service.ClothHistoryService;
import spring.biz.cloth.service.ClothService;
import spring.biz.cloth.vo.ClothVO;
import spring.biz.user.vo.UserVO;

@Controller
public class ReccomendController {
	
	
	@Autowired
	ClothService clothservice;
	@Autowired
	ClothHistoryService clothhistoryservice;
	
	@RequestMapping(value = "/clothes/cloth_recommend.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<Integer, ClothVO> getRecommendCloth(HttpServletRequest request) {
		
		return null;
			
	}
}
