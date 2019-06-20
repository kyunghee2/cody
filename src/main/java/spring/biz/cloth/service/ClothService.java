package spring.biz.cloth.service;

import java.util.List;

import spring.biz.cloth.vo.ClothVO;

public interface ClothService {
	
	int addCloth(ClothVO cloth);
	List<ClothVO> getClothList();
	List<ClothVO> getCloth(String userid);
	List<ClothVO> getClothKind(String userid, String kind);
	int updateCloth(String  userid);
	int removeCloth(Integer clothid);
	
}
