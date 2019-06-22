package recommend;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.biz.cloth.service.ClothHistoryService;
import spring.biz.cloth.service.ClothService;
import spring.biz.cloth.vo.ClothHistoryVO;
import spring.biz.cloth.vo.ClothVO;
import weather.Weather;

public class Recommend {
	
	public static void main(String[] args) {

		Weather weather = new Weather();
		String[] config = { "applicationContext.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		ClothService service = (ClothService) context.getBean("clothservice");
		ClothHistoryService historyservice = (ClothHistoryService) context.getBean("clothhistoryservice");

		Calendar calendar = Calendar.getInstance();

		int mon = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String d = mon + "" + day;
		int season = Integer.parseInt(d);

		if (season >= 316 && season <= 514) {
			System.out.println("봄");

		}
		if (season >= 515 && season <= 915) {
			Map<Integer, ClothVO> map1 = new HashMap<Integer, ClothVO>();
			Map<Integer, ClothVO> map2 = new HashMap<Integer, ClothVO>();
			Map<Integer, ClothVO> map3 = new HashMap<Integer, ClothVO>();
			

			System.out.println("여름");
			List<ClothVO> list = new ArrayList<ClothVO>();
			List<ClothVO> list2 = new ArrayList<ClothVO>();
			for (ClothVO vo : service.recommendCloth("a", "1", "1")) {
				map1.put(vo.getClothid(), vo);
				// System.out.println(vo);
				list.add(vo);
			}

			String j = JSONObject.toJSONString(map1).toString();
			System.out.println(j);
			System.out.println(list);
			Collections.shuffle(list);
			/////////////////////////////////////////////////////////////////////////

			//Iterator<Integer> keys = map1.keySet().iterator();
			int i = 0;
			for (int key : map1.keySet()) {
				map2.put(i, map1.get(key));
				i++;
				if (i == 5)
					break;
			}
			System.out.println(map2);

			String js = JSONObject.toJSONString(map2).toString();
			System.out.println(js);

			//////////////////////////////////////////////////////////////////////////
			Object[] crunchifyKeys = map1.keySet().toArray();
			Object key = crunchifyKeys[new Random().nextInt(crunchifyKeys.length)];

			System.out.println("************ Random Value ************ \n" + key + " :: " + map1.get(key));

			List<Map.Entry<Integer, ClothVO>> map1list = new ArrayList<Map.Entry<Integer, ClothVO>>(map1.entrySet());

			// Bonus Crunchify Tips: How to Shuffle a List??
			// Each time you get a different order...
			System.out.println("\n************ Now Let's start shuffling list ************");
			Collections.shuffle(map1list);

			Map<Integer, ClothVO> mapentry = new HashMap<Integer, ClothVO>();
			for (Map.Entry<Integer, ClothVO> entry : map1list) {
				System.out.println(entry.getKey() + " :: " + entry.getValue());
				System.out.println("****************************************************");

			}
			// System.out.println(mapentry);
			// List<Map<Integer, ClothVO>> map2list = new
			// ArrayList<Map<Integer,ClothVO>>(map1.);
			// for (Map<Integer, ClothVO> entry2 : map1list) {

			// }
			//////////////////////////////////////////////////////////////////////////

			
			  System.out.println("-------shuffling------"); Object[] ready =
			  map1.keySet().toArray(); Object random = ready[new
			  Random().nextInt(ready.length)]; System.out.println(random);
			  
			  List<Map<Integer, ClothVO>> list3 = null; // this is what you have already
			  
			  // 랜덤 5개 선택하여 출력 
			  for(int i=0;i<5;i++) { //ClothVO get_list = map1.get(i);
			  ClothVO get_list = list.get(i); 
			  list2.add(get_list); 
			  list3.add((Map<Integer,ClothVO>) list2); }
			  System.out.println("====================================");
			  
			  
			  for (Map<Integer, ClothVO> map : list3) { for (Map.Entry<Integer, ClothVO>
			  entry : map.entrySet()) { Integer key = entry.getKey(); ClothVO value =
			  entry.getValue(); map3.putAll(map); } } System.out.println(map3);
			  //System.out.println(list2);
			 

			// 히스토리 regdate 추출
			// List<ClothHistoryVO> list3 = new ArrayList<ClothHistoryVO>();
			// for (ClothHistoryVO vo : historyservice.getClothDate("a", "1")) {
			// list3.add(vo);

			// }

		}
		if (season >= 916 && season <= 1114) {
			System.out.println("가을");
		}
		if (season >= 1115 && season <= 315) {
			System.out.println("겨울");
		}
	}
	
	
	public String getRecommend(String userid, String kind, String season) {
		
		
		
		return season;
	}
	

}
