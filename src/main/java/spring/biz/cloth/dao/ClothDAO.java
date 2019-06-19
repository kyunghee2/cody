package spring.biz.cloth.dao;

import java.util.List;

import spring.biz.cloth.vo.ClothVO;

public interface ClothDAO {

	int addCloth(ClothVO cloth);
	 
	List<ClothVO> getClothList();
	
	List<ClothVO> getCloth(String uid, String kind);
	
	int updateCloth(ClothVO cloth);
	
	int removeCloth(Integer cid);
}
