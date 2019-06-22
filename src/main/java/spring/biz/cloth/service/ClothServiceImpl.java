package spring.biz.cloth.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.cloth.dao.ClothDAO;
import spring.biz.cloth.vo.ClothVO;
import spring.biz.user.vo.UserVO;

@Service("clothservice")
public class ClothServiceImpl implements ClothService {

	@Resource(name = "cmybatis")
	ClothDAO dao;

	@Autowired
	ApplicationContext context;

	public ClothServiceImpl() {

	}

	public ClothServiceImpl(ClothDAO dao) {
		this.dao = dao;
	}

	public ClothDAO getDao() {
		return dao;
	}

	public void setDao(ClothDAO dao) {
		this.dao = dao;
	}

	public int addCloth(ClothVO cloth) {
		return dao.addCloth(cloth);
	}

	@Override
	public ClothVO getClothId(Integer clothid) {
		return dao.getClothId(clothid);
	}

	@Override
	public List<ClothVO> getClothes(String userid, String kind, String season) {
		return dao.getClothes(userid, kind, season);
	}

	@Override
	public int updateCloth(ClothVO vo) {
		return dao.updateCloth(vo);
	}

	@Override
	public int removeCloth(Integer clothid) {
		return dao.removeCloth(clothid);
	}

	@Override
	public int multiRemoveCloth(Map<String, Object> map) {
		return dao.multiRemoveCloth(map);
	}

	@Override
	public List<ClothVO> recommendCloth(String userid,String kind) {
	//public List<ClothVO> recommendCloth(String userid, String kind, String season) {
		//return dao.recommendCloth(userid, kind, season);
		Calendar calendar = Calendar.getInstance();

		int mon = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String d = mon + "" + day;
		int season = Integer.parseInt(d);
		String season2="";
		
		//Map<Integer, ClothVO> map1 = new HashMap<Integer, ClothVO>();
		//Map<Integer, ClothVO> map2 = new HashMap<Integer, ClothVO>();
		List<ClothVO> list=new ArrayList<ClothVO>();		
		String js = null;
		
		if (season >= 316 && season <= 514) {
			System.out.println("봄");
			season2="1";
		}
		else if (season >= 515 && season <= 915) {
			System.out.println("여름");
			season2="1";		
		}
		else if (season >= 916 && season <= 1114) {
			System.out.println("가을");
			season2="3";
		}
		else if (season >= 1115 && season <= 315) {
			System.out.println("겨울");
			season2="4";
		}
		
		for (ClothVO clothvo : dao.recommendCloth(userid, kind, season2)) {
			//map1.put(clothvo.getClothid(), clothvo);
			list.add(clothvo);			
		}
		
		
		return list;
		
	}
}
