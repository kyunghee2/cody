package spring.biz.cloth.service;

import java.util.List;

import spring.biz.cloth.vo.ClothVO;

public interface ClothService {
	
int addCloth(ClothVO cloth);
	
	ClothVO getClothId(Integer clothid);
	 
	List<ClothVO> getClothList();
<<<<<<< HEAD
	
	List<ClothVO> getCloth(String userid);
	
	List<ClothVO> getClothKind(String userid, String kind);
	
	int updateCloth(ClothVO vo);
	
=======
	List<ClothVO> getCloth(String userid);
	List<ClothVO> getClothKind(String userid, String kind);
	int updateCloth(String  userid);
>>>>>>> branch 'master' of https://github.com/kyunghee2/cody.git
	int removeCloth(Integer clothid);
	
}
