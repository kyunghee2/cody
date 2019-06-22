package spring.biz.cloth.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.cloth.dao.ClothDAO;
import spring.biz.cloth.vo.ClothVO;

@Service("clothservice")
public class ClothServiceImpl implements ClothService {

	@Resource(name = "cmybatis")
	ClothDAO dao;

	@Autowired
	ApplicationContext context;

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

	public int addCloth(ClothVO cloth) {
		return dao.addCloth(cloth);
	}

	@Override
	public ClothVO getClothId(Integer clothid) {
		return dao.getClothId(clothid);
	}

	@Override
	public List<ClothVO> getClothes(String userid, String kind, String season) {
		return dao.getClothes(userid, kind, season);
	}

	@Override
	public int updateCloth(ClothVO vo) {
		return dao.updateCloth(vo);
	}

	@Override
	public int removeCloth(Integer clothid) {
		return dao.removeCloth(clothid);
	}

	@Override
	public int multiRemoveCloth(Map<String, Object> map) {
		return dao.multiRemoveCloth(map);
	}

	@Override
	public List<ClothVO> recommendCloth(String userid, String kind, String season) {
		return dao.recommendCloth(userid, kind, season);
	}
}
