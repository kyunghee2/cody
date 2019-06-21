package spring.biz.cloth.dao;

import java.util.List;
import java.util.Map;

import spring.biz.cloth.vo.ClothVO;

public interface ClothDAO {

	int addCloth(ClothVO cloth);
	
	ClothVO getClothId(Integer clothid);
	 
	List<ClothVO> getClothList();
	
	List<ClothVO> getCloth(String userid);
	
	List<ClothVO> getClothKind(String userid, String season, String kind);
	
	int updateCloth(ClothVO vo);
	
	int removeCloth(Integer clothid);
	
	int multiRemoveCloth(Map<String, Object> map);
	
	
}
