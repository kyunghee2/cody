package web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.biz.cloth.service.ClothHistoryService;
import spring.biz.cloth.vo.ClothHistoryVO;
import spring.biz.cloth.vo.ClothVO;

@Controller
public class ClothHistoryController {

	@Autowired
	ClothHistoryService clothHistoryService;

	// 옷 히스토리 저장
	@RequestMapping(value ="/clothes/clothhistoryadd.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addClothHistory(HttpServletRequest request) {
		String clothidlist = request.getParameter("clothidlist");
		String temp = request.getParameter("temp");
		String humidity = request.getParameter("humidity");
		String dust = request.getParameter("dust");
		String userid = request.getParameter("userid");
		
		String result="1";
		Map<String, String> map = new HashMap<String, String>();
		
		for(String clothid : clothidlist.split(",")) {
			
			ClothHistoryVO vo = new ClothHistoryVO();
			vo.setClothid(Integer.parseInt(clothid));	
			vo.setTemp(temp);	
			vo.setHumidity(humidity);	
			vo.setDust(dust);	
			vo.setUserid(userid);
			
			List<ClothHistoryVO> list = clothHistoryService.getClothHistoryList(clothid,userid);
			if(list.size()==0) {
				result = Integer.toString(clothHistoryService.addClothHistory(vo));		
			}
							
		}
		map.put("result", result);
		return map;
		//return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/clothes/cloth_recommend.do", method = RequestMethod.GET)
	@ResponseBody
	public Map<Integer, ClothVO> getRecommendCloth(HttpServletRequest request) {
		
		
		return null;
			
	}

}
