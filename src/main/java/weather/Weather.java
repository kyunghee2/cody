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
    public static void main(String[] args) {
        BufferedReader br = null;
        try{      
        	String tempURL = ""; 	
            String dustURL = "http://openapi.airkorea.or.kr/"
                    + "openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty"
                    + "?stationName=강남구&dataTerm=month&pageNo=1&numOfRows=10&ServiceKey=lWyXzvx6gba4CMkvCzEHrp%2FktvU3U4lreQYOIx9MO1yYn%2BMicRUNTEwYWOYxOfFYgxGEEHzw4YHuVW2mC80GRA%3D%3D&ver=1.3&_returnType=json";
            URL url = new URL(dustURL);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
            Map<String, String> map = new HashMap<String, String>();
            String result = "";
            String line;
            String data = "";
            
            Date date = new Date();
            while((line = br.readLine()) != null) {
                result = result + line + "\n";
            }
            
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray  = (JSONArray)((JSONObject)jsonParser.parse(result)).get("list");
            
            for(Object obj: jsonArray)	{
            	JSONObject jsonObject = (JSONObject) jsonParser.parse(obj.toString());
            	if(date.getHours() == Integer.parseInt(jsonObject.get("dataTime").toString().substring(11, 13)))	{
            		           		
            		map.put("pm10Value",jsonObject.get("pm10Value").toString());
            		map.put("pm10Grade",jsonObject.get("pm10Grade").toString());
            		map.put("pm25Value",jsonObject.get("pm25Value").toString());
            		map.put("pm25Grade",jsonObject.get("pm25Grade").toString());
            		map.put("dataTime", jsonObject.get("dataTime").toString());

            	}            		
            }
            
            data = JSONObject.toJSONString(map);
    		System.out.println(data); 
    		
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
}


