package spring.biz.cloth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.cloth.dao.ClothDAO;
import spring.biz.cloth.vo.ClothVO;

@Service("clothservice")
public class ClothServiceImpl implements ClothService{

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
<<<<<<< HEAD
	@Override
=======
	
>>>>>>> branch 'master' of https://github.com/kyunghee2/cody.git
	public int addCloth(ClothVO cloth) {
		return dao.addCloth(cloth);
	}
<<<<<<< HEAD
	@Override
	public ClothVO getClothId(Integer clothid) {
		return dao.getClothId(clothid);
	}
	@Override
=======

>>>>>>> branch 'master' of https://github.com/kyunghee2/cody.git
	public List<ClothVO> getClothList() {
		return dao.getClothList();
	}
<<<<<<< HEAD
	@Override
	public List<ClothVO> getCloth(String userid) {
		return dao.getCloth(userid);
=======

	public List<ClothVO> getCloth(String userid) {
		return dao.getCloth(userid);
	}
	
	public List<ClothVO> getClothKind(String userid, String kind) {
		return dao.getClothKind(userid, kind);
	}
	
	public int updateCloth(String userid) {
		return dao.updateCloth(userid);
>>>>>>> branch 'master' of https://github.com/kyunghee2/cody.git
	}
<<<<<<< HEAD
	@Override
	public int updateCloth(ClothVO vo) {
		return dao.updateCloth(vo);
=======

	public int removeCloth(Integer clothid) {
		return dao.removeCloth(clothid);
>>>>>>> branch 'master' of https://github.com/kyunghee2/cody.git
	}
<<<<<<< HEAD
	@Override
	public int removeCloth(Integer clothid) {
		return dao.removeCloth(clothid);
	}
	@Override
	public List<ClothVO> getClothKind(String userid, String kind) {
		return dao.getClothKind(userid, kind);
	}
=======
	

>>>>>>> branch 'master' of https://github.com/kyunghee2/cody.git
}
