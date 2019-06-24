package spring.biz.cloth.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.biz.cloth.vo.ClothHistoryVO;

@Component("historymybatis")
public class ClothHistoryDAO_MyBatis implements ClothHistoryDAO{

	@Autowired
	SqlSession sqlSession = null;
	
	public ClothHistoryDAO_MyBatis() {}
	
	@Override
	public int addClothHistory(ClothHistoryVO clothhistory) {
		return sqlSession.insert("clothHistoryMapper.addclothhistory", clothhistory) ;
	}
	
	@Override
	public List<ClothHistoryVO> getClothHistoryList(String clothid,String userid) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("clothid", clothid);
		map.put("userid", userid);
		return sqlSession.selectList("clothHistoryMapper.getclothhistorylist",map);
	}

	@Override
	public List<ClothHistoryVO> getClothDate(String userid, String kind) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("kind", kind);
		return sqlSession.selectList("clothHistoryMapper.getclothhistorydate", map);
	}
	
	
	
}
