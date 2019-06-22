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
	public String getRecommendCloth( HttpServletRequest request) {
		
		Calendar calendar = Calendar.getInstance();

		int mon = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String d = mon + "" + day;
		int season = Integer.parseInt(d);
		
		Map<Integer, ClothVO> map1 = new HashMap<Integer, ClothVO>();
		Map<Integer, ClothVO> map2 = new HashMap<Integer, ClothVO>();
		UserVO vo = (UserVO) request.getSession().getAttribute("login");
		
		String userid = vo.getUserid();
		String js = null;
		
		if (season >= 316 && season <= 514) {
			System.out.println("봄");
			for (ClothVO clothvo : clothservice.recommendCloth(userid, "1", "1")) {
				map1.put(clothvo.getClothid(), clothvo);
				// System.out.println(vo);
			}
			int i = 0;
			for (int key : map1.keySet()) {
				map2.put(i, map1.get(key));
				i++;
				if (i == 5)
					break;
			}

			js = JSONObject.toJSONString(map2).toString();
			System.out.println(js);
		}
		else if (season >= 515 && season <= 915) {
			System.out.println("여름");
			for (ClothVO clothvo : clothservice.recommendCloth(userid, "1", "1")) {
				map1.put(clothvo.getClothid(), clothvo);
				// System.out.println(vo);
			}
			int i = 0;
			for (int key : map1.keySet()) {
				map2.put(i, map1.get(key));
				i++;
				if (i == 5)
					break;
			}

			 js = JSONObject.toJSONString(map2).toString();
			System.out.println(js);
			
			for (ClothVO clothvo : clothservice.recommendCloth(userid, "2", "1")) {
				map1.put(clothvo.getClothid(), clothvo);
				// System.out.println(vo);
			}
			int k = 0;
			for (int key : map1.keySet()) {
				map2.put(i, map1.get(key));
				k++;
				if (k == 5)
					break;
			}

			String js2 = JSONObject.toJSONString(map2).toString();
			System.out.println(js2);
			
			
		}
		else if (season >= 916 && season <= 1114) {
			System.out.println("가을");
			for (ClothVO clothvo : clothservice.recommendCloth(userid, "1", "3")) {
				map1.put(clothvo.getClothid(), clothvo);
				// System.out.println(vo);
			}
			int i = 0;
			for (int key : map1.keySet()) {
				map2.put(i, map1.get(key));
				i++;
				if (i == 5)
					break;
			}

			js = JSONObject.toJSONString(map2).toString();
			System.out.println(js);
		}
		else if (season >= 1115 && season <= 315) {
			System.out.println("겨울");
			for (ClothVO clothvo : clothservice.recommendCloth(userid, "1", "4")) {
				map1.put(clothvo.getClothid(), clothvo);
				// System.out.println(vo);
			}
			int i = 0;
			for (int key : map1.keySet()) {
				map2.put(i, map1.get(key));
				i++;
				if (i == 5)
					break;
			}

			js = JSONObject.toJSONString(map2).toString();
			System.out.println(js);
			
		}
		
		
		
		
		return js;
			
	}
}
