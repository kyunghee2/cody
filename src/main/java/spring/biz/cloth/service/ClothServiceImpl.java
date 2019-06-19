package spring.biz.cloth.service;

import java.util.List;

import spring.biz.cloth.dao.ClothDAO;
import spring.biz.cloth.vo.ClothVO;

public class ClothServiceImpl implements ClothService{

	ClothDAO dao;
	
	public ClothServiceImpl() {
		
	}
	public ClothServiceImpl(ClothDAO dao) {
		this.dao = dao;
	}
	
	public ClothDAO getDao() {
		return dao;
	}
	
	public void setDao(ClothDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public int addCloth(ClothVO cloth) {
		return dao.addCloth(cloth);
	}

	@Override
	public List<ClothVO> getClothList() {
		return dao.getClothList();
	}

	@Override
	public List<ClothVO> getCloth(String uid, String kind) {
		return dao.getCloth(uid, kind);
	}

	@Override
	public int updateCloth(ClothVO cloth) {
		return dao.updateCloth(cloth);
	}

	@Override
	public int removeCloth(Integer cid) {
		return dao.removeCloth(cid);
	}

}
