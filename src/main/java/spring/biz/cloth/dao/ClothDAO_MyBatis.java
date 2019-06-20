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
	public List<ClothVO> getClothList() {
		return sqlSession.selectList("clothMapper.getclothlist");
	}

	@Override
	public List<ClothVO> getCloth(String userid) {
		return sqlSession.selectList("clothMapper.getclothes", userid);
	}

	@Override
	public int updateCloth(ClothVO vo) {
		return sqlSession.update("clothMapper.updatecloth", vo);
	}

	@Override
	public int removeCloth(Integer clothid) {
		return sqlSession.update("clothMapper.removecloth", clothid);
	}

	@Override
	public List<ClothVO> getClothKind(String userid, String kind) {
		HashMap<String , String> map = new HashMap<String, String>();
	    map.put("userid", userid);
	    map.put("kind", kind);
		return sqlSession.selectList("clothMapper.getclotheskind",map);
	}

	

	
}
