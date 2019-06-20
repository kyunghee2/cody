package spring.biz.cloth.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.biz.cloth.vo.ClothVO;

@Component("cmybatis")
public class ClothDAO_MyBatis implements ClothDAO{
	
	@Autowired
	SqlSession sqlSession=null;
	
	public ClothDAO_MyBatis() {
		//System.out.println("UserDAO_MyBatis 호출");
	}

	public int addCloth(ClothVO cloth) {
		return sqlSession.insert("clothMapper.addcloth", cloth);
	}

	public List<ClothVO> getClothList() {
		return sqlSession.selectList("clothMapper.getclothlist");
	}

	public List<ClothVO> getCloth(String userid) {
		return sqlSession.selectList("clothMapper.getclothes", userid);
	}
	
	public List<ClothVO> getClothKind(String userid, String kind) {
		HashMap<String , String> map = new HashMap<String, String>();
	    map.put(userid, kind);
	    return sqlSession.selectList("clothMapper.getclotheskind", map);
	}

	public int updateCloth(String userid) {
		return sqlSession.update("clothMapper.updatecloth", userid);
	}

	public int removeCloth(Integer clothid) {
		return sqlSession.update("clothMapper.removecloth", clothid);
	}	
}
