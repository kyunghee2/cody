package spring.biz.cloth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.cloth.vo.ClothVO;

@Component("cmybatis")
public class ClothDAO_MyBatis implements ClothDAO{
	
	@Autowired
	SqlSession sqlSession=null;
	
	public ClothDAO_MyBatis() {
		//System.out.println("ClothDAO_MyBatis 호출");
	}

	@Override
	public int addCloth(ClothVO cloth) {
		return sqlSession.insert("clothMapper.addcloth", cloth);
	}

	@Override
	public ClothVO getClothId(Integer clothid) {
		return sqlSession.selectOne("clothMapper.getclothid", clothid);
	}

	@Override
	public List<ClothVO> getClothes(String userid, String kind, String season) {
		HashMap<String , String> map = new HashMap<String, String>();
	    map.put("userid", userid);
	    map.put("season", season);
	    map.put("kind", kind);
	    
		return sqlSession.selectList("clothMapper.getclothes",map);
	}

	@Override
	public int updateCloth(ClothVO vo) {
		return sqlSession.update("clothMapper.updatecloth", vo);
	}

	@Override
	public int removeCloth(Integer clothid) {
		return sqlSession.delete("clothMapper.removecloth", clothid);
	}

	@Override
	public int multiRemoveCloth(Map<String, Object> map) {
		return sqlSession.delete("clothMapper.multiremovecloth", map);
	}

	@Override
	public List<ClothVO> recommendCloth(String userid, String kind, String season) {
		HashMap<String , String> map = new HashMap<String, String>();
	    map.put("userid", userid);
	    map.put("season", season);
	    map.put("kind", kind);
		return sqlSession.selectList("clothMapper.recommendcloth",map);
	}
}
