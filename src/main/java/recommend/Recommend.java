package recommend;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.biz.cloth.service.ClothService;
import spring.biz.cloth.vo.ClothVO;
import weather.Weather;

public class Recommend {

	public static void main(String[] args) {

		String[] config = { "applicationContext.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		ClothService service = (ClothService) context.getBean("clothservice");
		// SimpleDateFormat format1 = new SimpleDateFormat("MM-dd");
		// SimpleDateFormat format2 = new SimpleDateFormat("MMdd");

		Calendar calendar = Calendar.getInstance();
		// String format_calendar = format1.format(calendar.getTime());
		// int format2_calendar = format2.format(calendar.get);
		int mon = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		// int[] a = {mon,day};

		// System.out.println(format_calendar);
		// System.out.println(format2_calendar);

		// int season = format2_calendar;

		String d = mon + "" + day;
		int season = Integer.parseInt(d);

		// System.out.println(mon);
		// System.out.println(day);
		// System.out.println(d);

		if (season >= 316 && season <= 514) {
			System.out.println("봄");

		}
		if (season >= 515 && season <= 915) {
			System.out.println("여름");
			List<ClothVO> list = new ArrayList<ClothVO>();
			List<ClothVO> list2 = new ArrayList<ClothVO>();
			for (ClothVO vo : service.getClothKind("a","1","1")) {
				//System.out.println(vo);
				list.add(vo);
			}
			System.out.println(list);
			Collections.shuffle(list);
			
			for(int i=0;i<5;i++) {
			ClothVO get_list = list.get(i);
			list2.add(get_list);
			}
			System.out.println(list2);
		}
		if (season >= 916 && season <= 1114) {
			System.out.println("가을");

		}
		if (season >= 1115 && season <= 315) {
			System.out.println("겨울");
			

		}
/*
		Weather weather = new Weather();
		String lat = "37.50065903853966";
		String lon = "127.03946862393614";
		System.out.println(weather.getWeather(lat, lon));
		// Map<String, String> map = new HashMap<String, String>();
		// map = weather.getWeather(lat, lon);

		String w_value = weather.getWeather(lat, lon);

		JSONParser parser = new JSONParser();

		try {
			JSONObject obj = (JSONObject) parser.parse(w_value);
			// 몇개의 오브젝트가 들어있는가?
            System.out.println("오브젝트의 갯수 : "+obj.size());
            // key set 받아오기 
            Set key = obj.keySet();
            // Iterator 설정
            Iterator<String> iter = key.iterator();
            // 각각 키 값 출력
            while(iter.hasNext())
            {
                String keyname = iter.next();
                System.out.println("key : "+keyname+" type : "+obj.get(
                                    keyname).getClass());
            }
		} catch (ParseException e) {
			e.printStackTrace();
		}
*/
		
	

		}

}
