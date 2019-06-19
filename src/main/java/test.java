import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.biz.cloth.service.ClothService;
import spring.biz.cloth.vo.ClothVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class test {

	@Autowired
	ClothService service;

	//@Test
	public void  add(){
		ClothVO vo = new ClothVO();
		vo.setUserid("test01");
		vo.setImgpath("c:/lib/");
		vo.setImgname("사진");
		vo.setSeason("2");
		vo.setKind("2");
		vo.setColor("black");
		int row = service.addCloth(vo);
		System.out.println("insert => "+row);
	}
	
	
	//@Test
	public void removecloth() {
		  int row = service.removeCloth(3);
		  System.out.println("removecloth => "+row);
	}
	
	//@Test
	public void getclothlist() {
		for(ClothVO vo : service.getClothList()) {
        	System.out.println(vo);
        }
	}
	
	//@Test
	public void getclothes() {
		for(ClothVO vo : service.getCloth("a")) {
			System.out.println(vo);
		}
	}
	
	@Test
	public void getclotheskind() {
		for(ClothVO vo : service.getClothKind("a", "1")) {
			System.out.println(vo);
		}
	}
	
	//@Test
	public void getlist() {
		for(ClothVO vo : service.getCloth("a")) {
			System.out.println(vo);
		}
	}	
	
}
