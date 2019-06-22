package spring.biz.cloth.dao;

import java.util.List;
import java.util.Map;

import spring.biz.cloth.vo.ClothVO;

public interface ClothDAO {

	int addCloth(ClothVO cloth);
	
	ClothVO getClothId(Integer clothid);
	
	List<ClothVO> getClothes(String userid, String kind, String season);
	
	int updateCloth(ClothVO vo);
	
	int removeCloth(Integer clothid);
	
	int multiRemoveCloth(Map<String, Object> map);
	
	List<ClothVO> recommendCloth(String userid, String kind, String season);
}
