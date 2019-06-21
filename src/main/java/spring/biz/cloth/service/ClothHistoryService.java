package spring.biz.cloth.service;

import java.util.Date;
import java.util.List;
import spring.biz.cloth.vo.ClothHistoryVO;

public interface ClothHistoryService {

	int addClothHistory(ClothHistoryVO clothhistory); 
	List<ClothHistoryVO> getClothHistoryList();
	List<ClothHistoryVO> getClothDate(String userid, String kind );
}
