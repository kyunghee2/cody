package weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Weather {
	Map<String, String> map = new HashMap<String, String>();
	
	public static void main(String[] args) {
		Weather w = new Weather();
		String lat = "37.50065903853966";
		String lon = "127.03946862393614";
		System.out.println(w.getWeather(lat, lon));
	}
	
	private void tempToday(String lat, String lon)	{
		BufferedReader br = null;
		try	{
			String baseDate = "20190619";
			String baseTime = "0500";
			String serviceKey = "lWyXzvx6gba4CMkvCzEHrp%2FktvU3U4lreQYOIx9MO1yYn%2BMicRUNTEwYWOYxOfFYgxGEEHzw4YHuVW2mC80GRA%3D%3D";
			String[] xy = xyConv(lat, lon); 
			String tempAddress = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?serviceKey=" + serviceKey + "&base_date=" + baseDate + "&base_time=" + baseTime + "&nx="+ xy[0] + "&ny=" + xy[1] + "&_type=json";
			URL url = new URL(tempAddress);
			String line = "";
			String result = "";
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line=br.readLine())!=null)	{
				result = result + line + "\n";
			}
			
			JSONParser jsonParser = new JSONParser();
			JSONObject tempObj = (JSONObject)((JSONObject)((JSONObject)((JSONObject)jsonParser.parse(result)).get("response")).get("body")).get("items");
			JSONArray tempArray = (JSONArray)tempObj.get("item");
			
			for(Object obj: tempArray)	{
				JSONObject tempObject = (JSONObject) jsonParser.parse(obj.toString());
				if(tempObject.get("category").equals("POP"))	
					map.put("rainPercent",tempObject.get("fcstValue").toString());
				if(tempObject.get("category").equals("TMN"))
					map.put("tempMin",tempObject.get("fcstValue").toString());
				if(tempObject.get("category").equals("TMX"))
					map.put("tempMax",tempObject.get("fcstValue").toString());
				if(tempObject.get("category").equals("REH"))
					map.put("humidity",tempObject.get("fcstValue").toString());
				if(tempObject.get("category").equals("SKY"))
					switch(Integer.parseInt(tempObject.get("fcstValue").toString()))	{
					
					case 1:
						map.put("하늘 상태","1");
						break;
					case 3:
						map.put("하늘 상태","2");
						break;
					case 4:
						map.put("하늘 상태","3");
						break;
					default:
						map.put("하늘 상태","0");
					}					
			}		
			br.close();
		} catch(Exception e)	{
			e.printStackTrace();
		}
	}
	
	private void tempNow(String lat, String lon)	{
		BufferedReader br = null;
		try	{
			String baseDate = "20190619";
			String baseTime = "0500";
			String serviceKey = "lWyXzvx6gba4CMkvCzEHrp%2FktvU3U4lreQYOIx9MO1yYn%2BMicRUNTEwYWOYxOfFYgxGEEHzw4YHuVW2mC80GRA%3D%3D";
			String[] xy = xyConv(lat, lon);
			String tempAddress = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib?serviceKey=" + serviceKey + "&base_date=" + baseDate + "&base_time=" + baseTime + "&nx="+ xy[0] + "&ny=" + xy[1] + "&_type=json";
			URL url = new URL(tempAddress);
			String line = "";
			String result = "";
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line=br.readLine())!=null)	{
				result = result + line + "\n";
			}
			
			JSONParser jsonParser = new JSONParser();
			JSONObject tempObj = (JSONObject)((JSONObject)((JSONObject)((JSONObject)jsonParser.parse(result)).get("response")).get("body")).get("items");
			JSONArray tempArray = (JSONArray)tempObj.get("item");
			
			for(Object obj: tempArray)	{
				JSONObject tempObject = (JSONObject) jsonParser.parse(obj.toString());
				if(tempObject.get("category").equals("T1H"))	
					map.put("tempNow",tempObject.get("obsrValue").toString());
				if(tempObject.get("category").equals("RN1"))
					map.put("rainNow",tempObject.get("obsrValue").toString());
				if(tempObject.get("category").equals("WSD"))
					map.put("wind",tempObject.get("obsrValue").toString());
			}
			br.close();
		} catch(Exception e)	{
			e.printStackTrace();
		}
	}
	
	
	private void dust()	{
		BufferedReader br = null;
		try {
			String result = "";
			String line;
			JSONParser jsonParser = new JSONParser();
			Date date = new Date();
			String serviceKey = "lWyXzvx6gba4CMkvCzEHrp%2FktvU3U4lreQYOIx9MO1yYn%2BMicRUNTEwYWOYxOfFYgxGEEHzw4YHuVW2mC80GRA%3D%3D";
			String dustAddress = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?stationName=강남구&dataTerm=month&pageNo=1&numOfRows=10&ServiceKey="+serviceKey+"&ver=1.3&_returnType=json";
			URL urlDust = new URL(dustAddress);
			HttpURLConnection urlDustconnection = (HttpURLConnection) urlDust.openConnection();
			urlDustconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlDustconnection.getInputStream(), "UTF-8"));
			while ((line = br.readLine()) != null) {
				result = result + line + "\n";
			}

			JSONArray dustArray = (JSONArray) ((JSONObject) jsonParser.parse(result)).get("list");

			for (Object obj : dustArray) {
				JSONObject dustObject = (JSONObject) jsonParser.parse(obj.toString());
				if((dustObject.get("dataTime").toString().substring(11, 13)) != null)	{
					if (date.getHours() == Integer.parseInt(dustObject.get("dataTime").toString().substring(11, 13))) {
	
						map.put("pm10Value", dustObject.get("pm10Value").toString());
						map.put("pm10Grade", dustObject.get("pm10Grade").toString());
						map.put("pm25Value", dustObject.get("pm25Value").toString());
						map.put("pm25Grade", dustObject.get("pm25Grade").toString());
						map.put("dataTime", dustObject.get("dataTime").toString());
	
					}
				}				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getWeather(String lat, String lon)	{
		tempNow(lat, lon);
		tempToday(lat, lon);
		dust();
		return JSONObject.toJSONString(map);
	}
	
	private String[] xyConv(String lat, String lon)	{
		String[] xy = new String[2];
		double DEGRAD = Math.PI/180.0;
		double RADDEG = 180.0/Math.PI;
		double EARTH_RADIUS = 6371.00877;
		double GRID = 5.0;
		double SLAT1 = 30.0;
		double SLAT2 = 60.0;
		double OLON = 126.0;
		double OLAT = 38.0;
		int XO = 43;
		int YO = 136;
		
		double re = EARTH_RADIUS/GRID;
		double slat1 = SLAT1 * DEGRAD;
		double slat2 = SLAT2 * DEGRAD;
		double olon = OLON * DEGRAD;
		double olat = OLAT * DEGRAD;
		double sn = Math.tan(Math.PI * 0.25 + slat2 * 0.5)/ Math.tan(Math.PI * 0.25 + slat1 * 0.5);
		sn = Math.log(Math.cos(slat1) / Math.cos(slat2)) / Math.log(sn);
        double sf = Math.tan(Math.PI * 0.25 + slat1 * 0.5);
        sf = Math.pow(sf, sn) * Math.cos(slat1) / sn;
        double ro = Math.tan(Math.PI * 0.25 + olat * 0.5);
        ro = re * sf / Math.pow(ro, sn);
        xy[0] = lat;
        xy[1] = lon;
        
        double ra = Math.tan(Math.PI * 0.25 + Double.parseDouble((lat)) * DEGRAD * 0.5);
            ra = re * sf / Math.pow(ra, sn);
            double theta = Double.parseDouble(lon) * DEGRAD - olon;
            if (theta > Math.PI) theta -= 2.0 * Math.PI;
            if (theta < -Math.PI) theta += 2.0 * Math.PI;
            theta *= sn;
            xy[0] = (int)Math.floor(ra * Math.sin(theta) + XO + 0.5)+"";
            xy[1] = (int)Math.floor(ro - ra * Math.cos(theta) + YO + 0.5)+"";
        return xy;
	}

}
