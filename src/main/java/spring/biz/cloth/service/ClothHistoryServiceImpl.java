package spring.biz.cloth.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.cloth.dao.ClothHistoryDAO;
import spring.biz.cloth.vo.ClothHistoryVO;


@Service("clothhistoryservice")
public class ClothHistoryServiceImpl implements ClothHistoryService{

	@Resource(name="historymybatis")
	ClothHistoryDAO dao;
	
	@Autowired
	ApplicationContext context;
	
	public ClothHistoryServiceImpl() {}
	public ClothHistoryServiceImpl(ClothHistoryDAO dao) {
		super();
		this.dao = dao;
	}
	public ClothHistoryDAO getDao() {
		return dao;
	}
	public void setDao(ClothHistoryDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public int addClothHistory(ClothHistoryVO clothhistory) {
		return dao.addClothHistory(clothhistory);
	}

	@Override
	public List<ClothHistoryVO> getClothHistoryList() {
		return dao.getClothHistoryList();
	}
	@Override
	public List<ClothHistoryVO> getClothDate(String userid,String kind) {
		
		return dao.getClothDate(userid, kind);
	}

}
