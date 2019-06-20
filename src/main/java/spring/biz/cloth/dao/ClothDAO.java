package spring.biz.cloth.dao;

import java.util.List;

import spring.biz.cloth.vo.ClothVO;

public interface ClothDAO {

	int addCloth(ClothVO cloth);
	
	ClothVO getClothId(Integer clothid);
	 
	List<ClothVO> getClothList();
	
	List<ClothVO> getCloth(String userid);
	
	List<ClothVO> getClothKind(String userid, String kind);
	
<<<<<<< HEAD
	int updateCloth(ClothVO vo);
=======
	int updateCloth(String userid);
>>>>>>> branch 'master' of https://github.com/kyunghee2/cody.git
	
	int removeCloth(Integer clothid);
}
